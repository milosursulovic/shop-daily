import type { AuthUser } from '../types'
import { apiFetch } from './client'

export function login(username: string, password: string) {
  return apiFetch<AuthUser>('/auth/login', {
    method: 'POST',
    body: JSON.stringify({ username, password, expiresInMins: 60 }),
  })
}
