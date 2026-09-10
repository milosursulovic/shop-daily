import Feather from 'react-native-vector-icons/Feather'
import { StyleSheet, Text, View } from 'react-native'
import { useAuthStore } from '../store/authStore'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { FeedbackLabel } from '../components/FeedbackLabel'

function maskCardNumber(cardNumber: string) {
  const last4 = cardNumber.slice(-4)
  return `•••• •••• •••• ${last4}`
}

export function PaymentMethodsScreen() {
  const { colors } = useTheme()
  const user = useAuthStore((s) => s.user)
  const bank = user?.bank

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title="Payment Methods" isBackEnabled />
      <View style={styles.content}>
        {!bank ? (
          <FeedbackLabel type="info" message="No payment methods on file" />
        ) : (
          <View style={[styles.card, { backgroundColor: colors.primary }]}>
            <Feather name="credit-card" size={28} color={colors.onPrimary} />
            <Text style={[styles.cardNumber, { color: colors.onPrimary }]}>
              {maskCardNumber(bank.cardNumber)}
            </Text>
            <View style={styles.cardFooter}>
              <Text style={{ color: colors.onPrimary }}>{bank.cardType}</Text>
              <Text style={{ color: colors.onPrimary }}>Exp {bank.cardExpire}</Text>
            </View>
          </View>
        )}
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  content: { padding: 16 },
  card: { borderRadius: 18, padding: 20, gap: 16 },
  cardNumber: { fontSize: 20, fontWeight: '700', letterSpacing: 2 },
  cardFooter: { flexDirection: 'row', justifyContent: 'space-between' },
})
