import { useState } from 'react'
import {
  Image,
  KeyboardAvoidingView,
  Platform,
  StyleSheet,
  Text,
  TextInput,
  View,
} from 'react-native'
import { login } from '../api/auth'
import { getUser } from '../api/users'
import { useAuthStore } from '../store/authStore'
import { useTheme } from '../theme/useTheme'
import { CustomButton } from '../components/CustomButton'
import { FeedbackLabel } from '../components/FeedbackLabel'
import { ScreenTitle } from '../components/ScreenTitle'

export function LoginScreen() {
  const { colors } = useTheme()
  const setSession = useAuthStore((s) => s.setSession)
  const [username, setUsername] = useState('emilys')
  const [password, setPassword] = useState('emilyspass')
  const [error, setError] = useState<string | null>(null)
  const [loading, setLoading] = useState(false)

  async function handleLogin() {
    setLoading(true)
    setError(null)
    try {
      const res = await login(username, password)
      const fullUser = await getUser(res.id)
      setSession(fullUser, res.accessToken, res.refreshToken)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Login failed')
    } finally {
      setLoading(false)
    }
  }

  return (
    <KeyboardAvoidingView
      style={[styles.container, { backgroundColor: colors.background }]}
      behavior={Platform.OS === 'ios' ? 'padding' : undefined}
    >
      <ScreenTitle title="Login" />

      <View style={styles.form}>
        <TextInput
          value={username}
          onChangeText={setUsername}
          placeholder="Username"
          placeholderTextColor={colors.gray}
          autoCapitalize="none"
          style={[styles.input, { backgroundColor: colors.secondary, color: colors.onBackground }]}
        />
        <TextInput
          value={password}
          onChangeText={setPassword}
          placeholder="Password"
          placeholderTextColor={colors.gray}
          secureTextEntry
          style={[styles.input, { backgroundColor: colors.secondary, color: colors.onBackground }]}
        />
        <Text style={[styles.forgot, { color: colors.gray }]}>Forgot password?</Text>

        {error && <FeedbackLabel type="error" message={error} />}

        <CustomButton text="LOGIN" onPress={handleLogin} loading={loading} style={styles.loginButton} />
      </View>

      <View style={styles.social}>
        <Text style={{ color: colors.gray }}>Or login with social account</Text>
        <View style={styles.socialRow}>
          <Image source={require('../assets/icons/ic_google.png')} style={styles.socialIcon} />
          <Image source={require('../assets/icons/ic_facebook.png')} style={styles.socialIcon} />
        </View>
      </View>
    </KeyboardAvoidingView>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'space-between' },
  form: { paddingHorizontal: 24, gap: 16, marginTop: 40 },
  input: {
    borderRadius: 14,
    paddingHorizontal: 16,
    paddingVertical: 14,
    fontSize: 15,
  },
  forgot: { textAlign: 'right', fontSize: 13 },
  loginButton: { marginTop: 8 },
  social: { alignItems: 'center', paddingVertical: 32, gap: 12 },
  socialRow: { flexDirection: 'row', gap: 24 },
  socialIcon: { width: 44, height: 44 },
})
