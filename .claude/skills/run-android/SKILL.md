---
name: run-android
description: Build, install, and launch the ShopDaily RN app on the local Pixel_9 emulator, with a working screenshot loop. Use whenever asked to run, test, or verify this app on Android — don't rediscover the JAVA_HOME/build-tools workarounds each time.
---

# Run ShopDaily on Android

This repo hit two real build blockers the first time around — both are already fixed in
the project, but the environment variables below are **not** persisted anywhere, so every
new shell needs them set explicitly.

## 1. Environment (every new shell)

```sh
export ANDROID_HOME=/home/misa/Android/Sdk
export JAVA_HOME=/opt/android-studio/jbr
```

Why: the machine's `~/.zshrc` sets `JAVA_HOME` to a JRE-only install with no `javac` —
Gradle will fail with "Toolchain installation ... does not provide the required
capabilities: [JAVA_COMPILER]" if you skip this override. Do not edit `~/.zshrc` — it's
the user's personal dotfile, out of scope for this repo.

## 2. Build

```sh
cd android && ./gradlew assembleDebug --console=plain
```

First build is slow (Gradle downloads + NDK install on first run); rerun after any native
config change (`android/build.gradle`, `android/app/build.gradle`). Pure JS/TS changes
don't need a rebuild — Metro hot-reloads them (step 5).

APK lands at `android/app/build/outputs/apk/debug/app-debug.apk`.

## 3. Emulator

```sh
$ANDROID_HOME/emulator/emulator -list-avds     # should show Pixel_9
$ANDROID_HOME/emulator/emulator -avd Pixel_9 -netdelay none -netspeed full &
```

Run in the background (`nohup ... > /tmp/emulator.log 2>&1 & disown`), then poll instead
of guessing a sleep duration:

```sh
until $ANDROID_HOME/platform-tools/adb shell getprop sys.boot_completed 2>/dev/null | grep -q 1; do sleep 3; done
```

Cold boot (no snapshot) takes ~1-2 minutes. A "Suggested minimum system RAM ... (available: ...)"
warning in the emulator log is benign — ignore it.

## 4. Install + launch

```sh
$ANDROID_HOME/platform-tools/adb install -r android/app/build/outputs/apk/debug/app-debug.apk
$ANDROID_HOME/platform-tools/adb shell am start -n com.ecommerce.shopdaily/.MainActivity
```

`-r` (reinstall) keeps AsyncStorage data — the app stays logged in across rebuilds unless
you explicitly `adb shell pm clear com.ecommerce.shopdaily` (this logs the user out; only
do it when actually testing the logged-out state).

## 5. Metro (for JS/TS-only changes, no rebuild needed)

```sh
npx react-native start &
$ANDROID_HOME/platform-tools/adb reverse tcp:8081 tcp:8081
```

## 6. Verify visually

```sh
sleep 5   # let the bundle finish loading after a fresh install/launch
$ANDROID_HOME/platform-tools/adb exec-out screencap -p > /tmp/shopdaily-screenshot.png
```

Then read the PNG back to actually look at it — a screenshot nobody looks at isn't
verification.

## Full loop, copy-paste

```sh
export ANDROID_HOME=/home/misa/Android/Sdk
export JAVA_HOME=/opt/android-studio/jbr
cd /home/misa/Projects/dummyjson/android && ./gradlew assembleDebug --console=plain
$ANDROID_HOME/platform-tools/adb install -r app/build/outputs/apk/debug/app-debug.apk
$ANDROID_HOME/platform-tools/adb shell am start -n com.ecommerce.shopdaily/.MainActivity
sleep 5
$ANDROID_HOME/platform-tools/adb exec-out screencap -p > /tmp/shopdaily-screenshot.png
```

(Assumes the Pixel_9 emulator is already booted — see step 3 if not.)
