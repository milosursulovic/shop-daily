import { useState } from 'react'
import Feather from 'react-native-vector-icons/Feather'
import {
  FlatList,
  Image,
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from 'react-native'
import { addCart } from '../api/carts'
import { cartTotals, useCartStore, type LocalCartItem } from '../store/cartStore'
import { useAuthStore } from '../store/authStore'
import { discountedPrice, formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { CustomButton } from '../components/CustomButton'
import { FeedbackLabel } from '../components/FeedbackLabel'
import { ScreenTitle } from '../components/ScreenTitle'

function BagProduct({ item }: { item: LocalCartItem }) {
  const { colors } = useTheme()
  const setQuantity = useCartStore((s) => s.setQuantity)
  const removeItem = useCartStore((s) => s.removeItem)

  return (
    <View style={[styles.item, { backgroundColor: colors.secondary }]}>
      <Image source={{ uri: item.thumbnail }} style={styles.itemImage} />
      <View style={styles.itemInfo}>
        <Text style={[styles.itemTitle, { color: colors.onBackground }]} numberOfLines={1}>
          {item.title}
        </Text>
        <Text style={{ color: colors.primary, fontWeight: '700' }}>
          {formatPrice(discountedPrice(item.price, item.discountPercentage))}
        </Text>
      </View>
      <View style={styles.qtyControls}>
        <TouchableOpacity onPress={() => setQuantity(item.productId, item.quantity - 1)}>
          <Image source={require('../assets/icons/ic_minus.png')} style={styles.qtyIcon} />
        </TouchableOpacity>
        <Text style={{ color: colors.onBackground }}>{item.quantity}</Text>
        <TouchableOpacity onPress={() => setQuantity(item.productId, item.quantity + 1)}>
          <Image source={require('../assets/icons/ic_plus.png')} style={styles.qtyIcon} />
        </TouchableOpacity>
      </View>
      <TouchableOpacity onPress={() => removeItem(item.productId)}>
        <Feather name="trash-2" size={18} color={colors.error} />
      </TouchableOpacity>
    </View>
  )
}

export function BagScreen() {
  const { colors } = useTheme()
  const user = useAuthStore((s) => s.user)
  const items = useCartStore((s) => s.items)
  const clear = useCartStore((s) => s.clear)
  const { discounted } = cartTotals(items)
  const [checkingOut, setCheckingOut] = useState(false)
  const [error, setError] = useState<string | null>(null)
  const [success, setSuccess] = useState(false)

  async function handleCheckout() {
    if (!user || items.length === 0) return
    setCheckingOut(true)
    setError(null)
    try {
      await addCart(
        user.id,
        items.map((i) => ({ id: i.productId, quantity: i.quantity })),
      )
      clear()
      setSuccess(true)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Checkout failed')
    } finally {
      setCheckingOut(false)
    }
  }

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar actionIcon="search" />
      <ScreenTitle title="My Bag" />

      {success && <FeedbackLabel type="info" message="Order placed! Check your order history." />}

      <FlatList
        data={items}
        keyExtractor={(item) => String(item.productId)}
        contentContainerStyle={styles.list}
        ItemSeparatorComponent={() => <View style={{ height: 10 }} />}
        ListEmptyComponent={<FeedbackLabel type="info" message="No added products to cart yet" />}
        renderItem={({ item }) => <BagProduct item={item} />}
      />

      <View style={styles.footer}>
        <View style={styles.promoRow}>
          <TextInput
            placeholder="Enter your promo code"
            placeholderTextColor={colors.gray}
            style={[styles.promoInput, { backgroundColor: colors.secondary, color: colors.onBackground }]}
          />
        </View>
        <View style={styles.totalRow}>
          <Text style={{ color: colors.gray }}>Total amount:</Text>
          <Text style={{ color: colors.onBackground, fontWeight: '700' }}>
            {formatPrice(discounted)}
          </Text>
        </View>
        {error && <FeedbackLabel type="error" message={error} />}
        <CustomButton
          text="CHECK OUT"
          onPress={handleCheckout}
          loading={checkingOut}
          disabled={items.length === 0}
        />
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  list: { paddingHorizontal: 16, flexGrow: 1 },
  item: { flexDirection: 'row', alignItems: 'center', borderRadius: 14, padding: 10, gap: 10 },
  itemImage: { width: 50, height: 50, borderRadius: 8 },
  itemInfo: { flex: 1, gap: 4 },
  itemTitle: { fontSize: 14, fontWeight: '600' },
  qtyControls: { flexDirection: 'row', alignItems: 'center', gap: 8 },
  qtyIcon: { width: 18, height: 18 },
  footer: { padding: 16, gap: 14 },
  promoRow: { flexDirection: 'row' },
  promoInput: { flex: 1, borderRadius: 14, paddingHorizontal: 16, paddingVertical: 12 },
  totalRow: { flexDirection: 'row', justifyContent: 'space-between' },
})
