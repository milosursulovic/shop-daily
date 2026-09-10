import Feather from 'react-native-vector-icons/Feather'
import { Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import type { Product } from '../types'
import { discountedPrice, formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'
import { useFavoritesStore } from '../store/favoritesStore'
import { RatingStars } from './RatingStars'
import { CircularButton } from './CircularButton'

interface Props {
  product: Product
  onPress: () => void
}

export function ProductCard({ product, onPress }: Props) {
  const { colors } = useTheme()
  const isFavorite = useFavoritesStore((s) => s.isFavorite(product.id))
  const toggleFavorite = useFavoritesStore((s) => s.toggle)

  return (
    <View>
      <TouchableOpacity
        onPress={onPress}
        activeOpacity={0.85}
        style={[styles.card, { backgroundColor: colors.secondary }]}
      >
        <Image source={{ uri: product.thumbnail }} style={styles.image} />
        <View style={styles.info}>
          <Text style={[styles.title, { color: colors.onBackground }]} numberOfLines={1}>
            {product.title}
          </Text>
          <Text style={[styles.subtitle, { color: colors.gray }]} numberOfLines={1}>
            {product.category}
          </Text>
          <RatingStars rating={product.rating} />
          <Text style={[styles.price, { color: colors.primary }]}>
            {formatPrice(discountedPrice(product.price, product.discountPercentage))}
          </Text>
        </View>
      </TouchableOpacity>
      <CircularButton
        style={styles.favorite}
        onPress={() => toggleFavorite(product)}
        testID="favorite-button"
      >
        <Feather name="heart" size={18} color={isFavorite ? colors.primary : colors.gray} />
      </CircularButton>
    </View>
  )
}

const styles = StyleSheet.create({
  card: {
    flexDirection: 'row',
    height: 120,
    borderRadius: 20,
    overflow: 'hidden',
    elevation: 3,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 3 },
  },
  image: { width: 120, height: '100%' },
  info: { flex: 1, padding: 12, justifyContent: 'center', gap: 4 },
  title: { fontSize: 15, fontWeight: '600' },
  subtitle: { fontSize: 12, textTransform: 'capitalize' },
  price: { fontSize: 15, fontWeight: '700' },
  favorite: { position: 'absolute', bottom: 8, right: 8 },
})
