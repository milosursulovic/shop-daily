import { fireEvent, render, screen, waitFor } from '@testing-library/react-native'
import { LoginScreen } from './LoginScreen'
import { useAuthStore } from '../store/authStore'
import { login } from '../api/auth'
import { getUser } from '../api/users'
import type { AuthUser, User } from '../types'

jest.mock('../api/auth')
jest.mock('../api/users')

const mockLogin = login as jest.MockedFunction<typeof login>
const mockGetUser = getUser as jest.MockedFunction<typeof getUser>

const baseUser: User = {
  id: 1,
  username: 'emilys',
  email: 'emily@example.com',
  firstName: 'Emily',
  lastName: 'Johnson',
  gender: 'female',
  image: 'https://example.com/avatar.jpg',
  address: { address: '', city: '', state: '', postalCode: '', country: '' },
  phone: '',
}

beforeEach(() => {
  useAuthStore.setState({ user: null, accessToken: null, refreshToken: null })
  mockLogin.mockReset()
  mockGetUser.mockReset()
})

describe('LoginScreen', () => {
  it('renders username and password fields prefilled with the test account', async () => {
    await render(<LoginScreen />)
    expect(screen.getByDisplayValue('emilys')).toBeTruthy()
    expect(screen.getByDisplayValue('emilyspass')).toBeTruthy()
  })

  it('logs in and stores the full user session on success', async () => {
    mockLogin.mockResolvedValueOnce({
      ...baseUser,
      accessToken: 'access-token',
      refreshToken: 'refresh-token',
    } as AuthUser)
    mockGetUser.mockResolvedValueOnce(baseUser)

    await render(<LoginScreen />)
    await fireEvent.press(screen.getByText('LOGIN'))

    await waitFor(() => {
      expect(useAuthStore.getState().accessToken).toBe('access-token')
    })
    expect(mockGetUser).toHaveBeenCalledWith(1)
    expect(useAuthStore.getState().user?.username).toBe('emilys')
  })

  it('shows an error message when login fails', async () => {
    mockLogin.mockRejectedValueOnce(new Error('Invalid credentials'))

    await render(<LoginScreen />)
    await fireEvent.press(screen.getByText('LOGIN'))

    expect(await screen.findByText('Invalid credentials')).toBeTruthy()
    expect(useAuthStore.getState().accessToken).toBeNull()
  })
})
