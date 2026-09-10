import type { User } from '../types'
import { apiFetch } from './client'

export function getUser(id: number) {
  return apiFetch<User>(`/users/${id}`)
}

export function updateUser(id: number, data: Partial<User>) {
  return apiFetch<User>(`/users/${id}`, {
    method: 'PATCH',
    body: JSON.stringify(data),
  })
}
