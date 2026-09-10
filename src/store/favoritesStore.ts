import AsyncStorage from '@react-native-async-storage/async-storage'
import { create } from 'zustand'
import { createJSONStorage, persist } from 'zustand/middleware'
import type { Product } from '../types'

interface FavoritesState {
  favorites: Product[]
  isFavorite: (productId: number) => boolean
  toggle: (product: Product) => void
  remove: (productId: number) => void
}

export const useFavoritesStore = create<FavoritesState>()(
  persist(
    (set, get) => ({
      favorites: [],
      isFavorite: (productId) => get().favorites.some((p) => p.id === productId),
      toggle: (product) => {
        if (get().isFavorite(product.id)) {
          set({ favorites: get().favorites.filter((p) => p.id !== product.id) })
        } else {
          set({ favorites: [...get().favorites, product] })
        }
      },
      remove: (productId) =>
        set({ favorites: get().favorites.filter((p) => p.id !== productId) }),
    }),
    { name: 'shopdaily-favorites', storage: createJSONStorage(() => AsyncStorage) },
  ),
)
