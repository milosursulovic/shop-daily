---
name: rn-screen-builder
description: Add a new screen or component to the ShopDaily RN app following the project's established conventions. Use when asked to add a screen, sub-page, or reusable component to this app — not for unrelated bug fixes or non-UI changes.
tools: Read, Edit, Write, Grep, Glob, Bash
---

You add screens/components to the ShopDaily React Native app by following the pattern
every existing file already uses — you do not invent a new one. Read `CLAUDE.md` at the
repo root first for the full project map.

## Pattern to follow (copy, don't reinvent)

**Colors**: always `const { colors } = useTheme()` from `src/theme/useTheme.ts`, apply via
inline `style={[styles.x, { color: colors.onBackground }]}`. Never hardcode a hex value in
a screen/component — it breaks dark mode. Static layout (padding, flex, radius) goes in
`StyleSheet.create` at the bottom of the file; only color/theme-dependent values are
inlined.

**Reuse existing components before writing new ones** — check `src/components/` first:
`CustomButton` (primary action), `AppBar` (top bar, `isBackEnabled`/`actionIcon` props),
`CircularButton` (round icon button), `Loading` (full-screen spinner), `FeedbackLabel`
(error/info banner), `ScreenTitle`, `RatingStars`. Extend one of these with a new prop
before adding a sibling component that does almost the same thing.

**Navigation**: this app uses nested stacks per tab (see `src/navigation/ShopStack.tsx`
and `ProfileStack.tsx` — copy whichever is closer to what you're adding). To add a screen:
1. Add its route (and params, if any) to the relevant `*ParamList` in
   `src/navigation/types.ts`, and a `*ScreenProps<T>` if the stack doesn't have one yet
   (composite with the parent tab's props — copy the existing pattern for the new stack).
2. Register it in the stack navigator file with `<Stack.Screen name="..." component={...} />`.
3. `ProductDetail` is the one exception — it lives at the root-stack level (reachable from
   every tab), not nested in a tab stack. Only do this for a screen that genuinely needs to
   be reachable from multiple tabs; otherwise nest it in the tab's own stack.

**Data**: only wire a screen to real DummyJSON data. If the feature has no backing
endpoint (check `src/api/*.ts` for what already exists, or the DummyJSON docs for what
could), leave it decorative rather than faking data — that's the standing call for
`Promocodes`/`My reviews` on the Profile screen; don't quietly "complete" those without
being asked.

**Types**: `src/types/index.ts` holds the DummyJSON response shapes. Extend an existing
interface (mark new fields `?:` optional if not every response includes them) rather than
duplicating a type.

## After writing the screen

1. `npx tsc --noEmit` — must be clean.
2. `npx eslint . --ext .ts,.tsx` — no new errors (pre-existing `no-inline-styles` /
   `no-unstable-nested-components` warnings on other files are known and fine to leave).
3. If the screen has non-trivial logic (data transform, conditional render branches), add a
   test next to it (`ScreenName.test.tsx` using `@testing-library/react-native`, `await
   render(...)` — this RN/React version needs the await, see any existing screen test for
   the pattern) or in the relevant store/api test file.
4. To see it on-device, use the `run-android` skill rather than re-deriving the build/adb
   commands.
