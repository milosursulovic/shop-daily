import { Image, StyleSheet, Text, TouchableOpacity } from 'react-native'
import type { Product } from '../types'
import { discountedPrice, formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'

interface Props {
  product: Product
  onPress: () => void
}

export function HomeProductCard({ product, onPress }: Props) {
  const { colors } = useTheme()

  return (
    <TouchableOpacity
      onPress={onPress}
      activeOpacity={0.85}
      style={[styles.card, { backgroundColor: colors.secondary }]}
    >
      <Image source={{ uri: product.thumbnail }} style={styles.image} />
      <Text style={[styles.title, { color: colors.onBackground }]} numberOfLines={1}>
        {product.title}
      </Text>
      <Text style={[styles.price, { color: colors.primary }]}>
        {formatPrice(discountedPrice(product.price, product.discountPercentage))}
      </Text>
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  card: {
    width: 140,
    borderRadius: 16,
    padding: 8,
    elevation: 3,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 3 },
  },
  image: { width: '100%', height: 110, borderRadius: 12, marginBottom: 8 },
  title: { fontSize: 13, fontWeight: '600' },
  price: { fontSize: 13, fontWeight: '700', marginTop: 2 },
})
