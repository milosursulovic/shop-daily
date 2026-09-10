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

export function updateCart(cartId: number, products: { id: number; quantity: number }[]) {
  return apiFetch<Cart>(`/carts/${cartId}`, {
    method: 'PUT',
    body: JSON.stringify({ merge: false, products }),
  })
}

export function deleteCart(cartId: number) {
  return apiFetch<Cart & { isDeleted: boolean }>(`/carts/${cartId}`, {
    method: 'DELETE',
  })
}
