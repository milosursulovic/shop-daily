import { StyleSheet, Text, View } from 'react-native'
import { useAuthStore } from '../store/authStore'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { FeedbackLabel } from '../components/FeedbackLabel'

export function AddressScreen() {
  const { colors } = useTheme()
  const user = useAuthStore((s) => s.user)

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title="Shipping Address" isBackEnabled />
      <View style={styles.content}>
        {!user?.address ? (
          <FeedbackLabel type="info" message="No address on file" />
        ) : (
          <View style={[styles.card, { backgroundColor: colors.secondary }]}>
            <Text style={[styles.line, { color: colors.onBackground, fontWeight: '700' }]}>
              {user.address.address}
            </Text>
            <Text style={[styles.line, { color: colors.gray }]}>
              {user.address.city}, {user.address.state} {user.address.postalCode}
            </Text>
            <Text style={[styles.line, { color: colors.gray }]}>{user.address.country}</Text>
          </View>
        )}
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  content: { padding: 16 },
  card: { borderRadius: 14, padding: 16, gap: 4 },
  line: { fontSize: 14 },
})
