import { useAuthStore } from './authStore'
import type { User } from '../types'

function makeUser(overrides: Partial<User> = {}): User {
  return {
    id: 1,
    username: 'emilys',
    email: 'emily@example.com',
    firstName: 'Emily',
    lastName: 'Johnson',
    gender: 'female',
    image: 'https://example.com/avatar.jpg',
    address: { address: '', city: '', state: '', postalCode: '', country: '' },
    phone: '',
    ...overrides,
  }
}

beforeEach(() => {
  useAuthStore.setState({ user: null, accessToken: null, refreshToken: null })
})

describe('authStore', () => {
  it('setSession stores user and tokens', () => {
    useAuthStore.getState().setSession(makeUser(), 'access-1', 'refresh-1')
    const state = useAuthStore.getState()
    expect(state.user?.username).toBe('emilys')
    expect(state.accessToken).toBe('access-1')
    expect(state.refreshToken).toBe('refresh-1')
  })

  it('setTokens updates only the tokens', () => {
    useAuthStore.getState().setSession(makeUser(), 'access-1', 'refresh-1')
    useAuthStore.getState().setTokens('access-2', 'refresh-2')
    const state = useAuthStore.getState()
    expect(state.accessToken).toBe('access-2')
    expect(state.refreshToken).toBe('refresh-2')
    expect(state.user?.username).toBe('emilys')
  })

  it('logout clears user and tokens', () => {
    useAuthStore.getState().setSession(makeUser(), 'access-1', 'refresh-1')
    useAuthStore.getState().logout()
    const state = useAuthStore.getState()
    expect(state.user).toBeNull()
    expect(state.accessToken).toBeNull()
    expect(state.refreshToken).toBeNull()
  })
})
