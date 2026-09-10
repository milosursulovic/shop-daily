# ShopDaily

E-commerce demo app built with React Native (bare CLI) + TypeScript, backed by the [DummyJSON](https://dummyjson.com) API. React Native port of the original [Jetpack Compose Android app](https://github.com/milosursulovic/shop-daily) — same screens, navigation, color palette, font, and icon assets, ported to cross-platform React Native.

## Stack

- React Native CLI + TypeScript
- React Navigation (native-stack + bottom-tabs, custom tab bar)
- Zustand + AsyncStorage (auth, cart, favorites)
- react-native-vector-icons (Feather)

## Screens

Login → Home (New/Sale rows) · Shop (categories → category product list) · Product detail (image pager, add to cart, favorite) · Bag (cart, checkout) · Favorites · Profile (order history, logout).

## Getting started

```sh
npm install
npm start          # Metro
npm run android     # requires Android SDK + emulator/device
```

Test login: `emilys` / `emilyspass` (DummyJSON seed account).
