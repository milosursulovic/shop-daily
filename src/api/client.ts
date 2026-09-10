import { useAuthStore } from '../store/authStore'

const BASE_URL = 'https://dummyjson.com'

interface RequestOptions extends Omit<RequestInit, 'headers'> {
  auth?: boolean
  skipRetry?: boolean
  headers?: Record<string, string>
}

async function refreshAccessToken(): Promise<string | null> {
  const refreshToken = useAuthStore.getState().refreshToken
  if (!refreshToken) return null

  const res = await fetch(`${BASE_URL}/auth/refresh`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ refreshToken, expiresInMins: 60 }),
  })

  if (!res.ok) {
    useAuthStore.getState().logout()
    return null
  }

  const data = await res.json()
  useAuthStore.getState().setTokens(data.accessToken, data.refreshToken)
  return data.accessToken as string
}

export async function apiFetch<T>(path: string, options: RequestOptions = {}): Promise<T> {
  const { auth = false, skipRetry = false, headers, ...rest } = options
  const accessToken = useAuthStore.getState().accessToken

  const finalHeaders: Record<string, string> = {
    'Content-Type': 'application/json',
    ...headers,
    ...(auth && accessToken ? { Authorization: `Bearer ${accessToken}` } : {}),
  }

  const res = await fetch(`${BASE_URL}${path}`, { ...rest, headers: finalHeaders })

  if (res.status === 401 && auth && !skipRetry) {
    const newToken = await refreshAccessToken()
    if (newToken) {
      return apiFetch<T>(path, { ...options, skipRetry: true })
    }
  }

  if (!res.ok) {
    const body = await res.json().catch(() => ({ message: res.statusText }))
    throw new Error(body.message ?? `Request failed: ${res.status}`)
  }

  return res.json() as Promise<T>
}
