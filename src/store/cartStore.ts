import { create } from 'zustand'
import { persist } from 'zustand/middleware'
import type { Product } from '../types'

export interface LocalCartItem {
  productId: number
  title: string
  price: number
  discountPercentage: number
  thumbnail: string
  stock: number
  quantity: number
}

interface CartState {
  items: LocalCartItem[]
  addItem: (product: Product, quantity?: number) => void
  setQuantity: (productId: number, quantity: number) => void
  removeItem: (productId: number) => void
  clear: () => void
}

export const useCartStore = create<CartState>()(
  persist(
    (set, get) => ({
      items: [],
      addItem: (product, quantity = 1) => {
        const existing = get().items.find((i) => i.productId === product.id)
        if (existing) {
          set({
            items: get().items.map((i) =>
              i.productId === product.id
                ? { ...i, quantity: Math.min(i.quantity + quantity, product.stock) }
                : i,
            ),
          })
          return
        }
        set({
          items: [
            ...get().items,
            {
              productId: product.id,
              title: product.title,
              price: product.price,
              discountPercentage: product.discountPercentage,
              thumbnail: product.thumbnail,
              stock: product.stock,
              quantity: Math.min(quantity, product.stock),
            },
          ],
        })
      },
      setQuantity: (productId, quantity) => {
        if (quantity <= 0) {
          set({ items: get().items.filter((i) => i.productId !== productId) })
          return
        }
        set({
          items: get().items.map((i) =>
            i.productId === productId ? { ...i, quantity } : i,
          ),
        })
      },
      removeItem: (productId) =>
        set({ items: get().items.filter((i) => i.productId !== productId) }),
      clear: () => set({ items: [] }),
    }),
    { name: 'dummyjson-cart' },
  ),
)

export function cartTotals(items: LocalCartItem[]) {
  const totalQuantity = items.reduce((sum, i) => sum + i.quantity, 0)
  const subtotal = items.reduce((sum, i) => sum + i.price * i.quantity, 0)
  const discounted = items.reduce(
    (sum, i) => sum + i.price * i.quantity * (1 - i.discountPercentage / 100),
    0,
  )
  return { totalQuantity, subtotal, discounted }
}
