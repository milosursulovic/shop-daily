import type { Cart, CartListResponse } from '../types'
import { apiFetch } from './client'

export function getUserCarts(userId: number) {
  return apiFetch<CartListResponse>(`/carts/user/${userId}`)
}

export function addCart(userId: number, products: { id: number; quantity: number }[]) {
  return apiFetch<Cart>('/carts/add', {
    method: 'POST',
    body: JSON.stringify({ userId, products }),
  })
}
