import { apiFetch } from './client'
import { useAuthStore } from '../store/authStore'

function jsonResponse(status: number, body: unknown) {
  return {
    ok: status >= 200 && status < 300,
    status,
    statusText: 'Error',
    json: async () => body,
  } as Response
}

beforeEach(() => {
  useAuthStore.setState({ user: null, accessToken: null, refreshToken: null })
  globalThis.fetch = jest.fn()
})

describe('apiFetch', () => {
  it('returns parsed json on success', async () => {
    ;(globalThis.fetch as jest.Mock).mockResolvedValueOnce(jsonResponse(200, { hello: 'world' }))
    const result = await apiFetch<{ hello: string }>('/ping')
    expect(result).toEqual({ hello: 'world' })
  })

  it('throws with the server message on a non-401 error', async () => {
    ;(globalThis.fetch as jest.Mock).mockResolvedValueOnce(
      jsonResponse(500, { message: 'boom' }),
    )
    await expect(apiFetch('/broken')).rejects.toThrow('boom')
  })

  it('refreshes the token on 401 and retries once', async () => {
    useAuthStore.setState({ accessToken: 'old-token', refreshToken: 'refresh-token' })
    const fetchMock = globalThis.fetch as jest.Mock
    fetchMock
      .mockResolvedValueOnce(jsonResponse(401, { message: 'expired' })) // initial auth call
      .mockResolvedValueOnce(
        jsonResponse(200, { accessToken: 'new-token', refreshToken: 'new-refresh' }),
      ) // /auth/refresh
      .mockResolvedValueOnce(jsonResponse(200, { data: 'ok' })) // retried call

    const result = await apiFetch<{ data: string }>('/me', { auth: true })

    expect(result).toEqual({ data: 'ok' })
    expect(fetchMock).toHaveBeenCalledTimes(3)
    expect(useAuthStore.getState().accessToken).toBe('new-token')

    const retriedCall = fetchMock.mock.calls[2]
    expect(retriedCall[1].headers.Authorization).toBe('Bearer new-token')
  })

  it('logs out and surfaces the original 401 when refresh fails', async () => {
    useAuthStore.setState({ accessToken: 'old-token', refreshToken: 'refresh-token' })
    const fetchMock = globalThis.fetch as jest.Mock
    fetchMock
      .mockResolvedValueOnce(jsonResponse(401, { message: 'expired' })) // initial auth call
      .mockResolvedValueOnce(jsonResponse(401, { message: 'invalid refresh' })) // /auth/refresh fails

    await expect(apiFetch('/me', { auth: true })).rejects.toThrow('expired')
    expect(useAuthStore.getState().accessToken).toBeNull()
  })
})
