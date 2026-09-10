import { useEffect, useState } from 'react'
import { FlatList, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { deleteCart, getUserCarts } from '../api/carts'
import { useAuthStore } from '../store/authStore'
import type { Cart } from '../types'
import { formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { FeedbackLabel } from '../components/FeedbackLabel'
import { Loading } from '../components/Loading'

export function OrdersScreen() {
  const { colors } = useTheme()
  const user = useAuthStore((s) => s.user)
  const [orders, setOrders] = useState<Cart[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    if (!user) return
    getUserCarts(user.id)
      .then((res) => setOrders(res.carts))
      .finally(() => setLoading(false))
  }, [user])

  async function handleCancel(cartId: number) {
    await deleteCart(cartId)
    setOrders((prev) => prev.filter((o) => o.id !== cartId))
  }

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title="My Orders" isBackEnabled />
      {loading ? (
        <Loading />
      ) : (
        <FlatList
          data={orders}
          keyExtractor={(item) => String(item.id)}
          contentContainerStyle={styles.list}
          ItemSeparatorComponent={() => <View style={styles.separator} />}
          ListEmptyComponent={<FeedbackLabel type="info" message="No past orders yet" />}
          renderItem={({ item }) => (
            <View style={[styles.card, { backgroundColor: colors.secondary }]}>
              <View>
                <Text style={[styles.orderTitle, { color: colors.onBackground }]}>
                  Order #{item.id}
                </Text>
                <Text style={{ color: colors.gray, fontSize: 12 }}>
                  {item.totalProducts} products · {item.totalQuantity} items
                </Text>
              </View>
              <View style={styles.right}>
                <Text style={{ color: colors.primary, fontWeight: '700' }}>
                  {formatPrice(item.discountedTotal)}
                </Text>
                <TouchableOpacity onPress={() => handleCancel(item.id)}>
                  <Text style={{ color: colors.error, fontSize: 12 }}>Cancel</Text>
                </TouchableOpacity>
              </View>
            </View>
          )}
        />
      )}
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  list: { padding: 16 },
  separator: { height: 10 },
  card: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    borderRadius: 14,
    padding: 14,
  },
  orderTitle: { fontSize: 15, fontWeight: '700' },
  right: { alignItems: 'flex-end', gap: 4 },
})
