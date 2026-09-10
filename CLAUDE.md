# ShopDaily

Bare React Native CLI + TypeScript e-commerce demo backed by [DummyJSON](https://dummyjson.com). React Native port of [milosursulovic/shop-daily](https://github.com/milosursulovic/shop-daily) (Kotlin/Jetpack Compose) — same screens, navigation shape, color palette, font, and icon assets, ported to cross-platform RN. `git remote origin` points at that repo.

## Stack

React Navigation (native-stack + bottom-tabs, custom tab bar) · Zustand + AsyncStorage (auth/cart/favorites/settings, all persisted) · react-native-vector-icons (Feather) · plain `fetch` (no axios).

## Structure

- `src/api/` — thin DummyJSON wrappers. `client.ts` has the shared `apiFetch` with 401 → `/auth/refresh` → retry-once logic; everything with `auth: true` goes through it.
- `src/store/` — zustand stores, each persisted to AsyncStorage under its own key (`shopdaily-auth`, `shopdaily-cart`, `shopdaily-favorites`, `shopdaily-settings`).
- `src/theme/` — `colors.ts` (light/dark palettes ported 1:1 from the Kotlin app's `Color.kt`), `useTheme()` (resolves `settingsStore.themeOverride` against `useColorScheme()`).
- `src/navigation/` — `RootNavigator` swaps Login ↔ MainTabs based on `authStore.accessToken`. `ShopStack` and `ProfileStack` are nested stacks inside their respective tabs (same pattern — copy one to add another). `ProductDetail` lives at the root-stack level so it's reachable from any tab.
- `src/screens/`, `src/components/` — one file per screen/component, `StyleSheet.create` at the bottom, colors always pulled from `useTheme()` (never hardcoded, for dark-mode correctness).
- `src/assets/` — icons and images copied verbatim from the reference Kotlin repo's `res/drawable`. Don't regenerate/redesign these — if a new one is needed, pull it from that repo the same way.

## Running

```sh
npm start                 # Metro
npm test                  # Jest
npx tsc --noEmit          # typecheck
npx eslint . --ext .ts,.tsx
```

Test login: `emilys` / `emilyspass` (DummyJSON seed account, prefilled on the login screen).

### Android build — known gotchas

- This machine's `~/.zshrc` sets `JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64/bin/java` (the **binary**, not the JDK root) and that JDK has no `javac` anyway. Gradle needs a real JDK. Always build with:
  ```sh
  export ANDROID_HOME=/home/misa/Android/Sdk
  export JAVA_HOME=/opt/android-studio/jbr
  cd android && ./gradlew assembleDebug
  ```
- `android/build.gradle` pins `buildToolsVersion = "36.0.0"` — that's what's actually installed locally (37.0.0 is not). If you bump `compileSdkVersion`, check installed build-tools first (`ls $ANDROID_HOME/build-tools`) rather than assuming a matching version exists.
- Full recipe (emulator boot, install, launch, screenshot) is in `.claude/skills/run-android/SKILL.md` — use it instead of rediscovering the flags.

## Conventions

- New screen → check `.claude/agents/rn-screen-builder.md` first; it encodes the theme/navigation/component-reuse pattern every existing screen follows.
- Prefer extending an existing store/screen/component over adding a new abstraction — this app is small on purpose.
- Only implement a feature against real DummyJSON data. The Profile menu (`My orders` / `Shipping addresses` / `Payment methods` / `Settings`) is wired to real endpoints (`/carts/user/{id}`, `user.address`, `user.bank`); `Promocodes` and `My reviews` are intentionally left decorative because DummyJSON has no data to back them — don't fake data for those.
