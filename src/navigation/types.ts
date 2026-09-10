import type { NativeStackScreenProps } from '@react-navigation/native-stack'
import type { BottomTabScreenProps } from '@react-navigation/bottom-tabs'
import type { CompositeScreenProps } from '@react-navigation/native'

export type RootStackParamList = {
  Login: undefined
  MainTabs: undefined
  ProductDetail: { productId: number }
}

export type MainTabParamList = {
  Home: undefined
  Shop: undefined
  Bag: undefined
  Favorites: undefined
  Profile: undefined
}

export type ShopStackParamList = {
  ShopCategories: undefined
  Category: { slug: string; name: string }
}

export type ProfileStackParamList = {
  ProfileHome: undefined
  Orders: undefined
  Address: undefined
  PaymentMethods: undefined
  Settings: undefined
}

export type RootStackScreenProps<T extends keyof RootStackParamList> =
  NativeStackScreenProps<RootStackParamList, T>

export type MainTabScreenProps<T extends keyof MainTabParamList> = CompositeScreenProps<
  BottomTabScreenProps<MainTabParamList, T>,
  RootStackScreenProps<keyof RootStackParamList>
>

export type ShopStackScreenProps<T extends keyof ShopStackParamList> = CompositeScreenProps<
  NativeStackScreenProps<ShopStackParamList, T>,
  MainTabScreenProps<'Shop'>
>

export type ProfileStackScreenProps<T extends keyof ProfileStackParamList> = CompositeScreenProps<
  NativeStackScreenProps<ProfileStackParamList, T>,
  MainTabScreenProps<'Profile'>
>
