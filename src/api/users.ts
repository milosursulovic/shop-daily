import type { User } from '../types'
import { apiFetch } from './client'

export function getUser(id: number) {
  return apiFetch<User>(`/users/${id}`)
}
