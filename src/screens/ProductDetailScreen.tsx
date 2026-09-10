import { useEffect, useState } from 'react'
import Feather from 'react-native-vector-icons/Feather'
import {
  Dimensions,
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from 'react-native'
import { getProduct } from '../api/products'
import type { Product } from '../types'
import { discountedPrice, formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'
import { useCartStore } from '../store/cartStore'
import { useFavoritesStore } from '../store/favoritesStore'
import { AppBar } from '../components/AppBar'
import { CircularButton } from '../components/CircularButton'
import { CustomButton } from '../components/CustomButton'
import { Loading } from '../components/Loading'
import { RatingStars } from '../components/RatingStars'
import type { RootStackScreenProps } from '../navigation/types'

const { width } = Dimensions.get('window')

export function ProductDetailScreen({ route }: RootStackScreenProps<'ProductDetail'>) {
  const { colors } = useTheme()
  const { productId } = route.params
  const [product, setProduct] = useState<Product | null>(null)
  const [loading, setLoading] = useState(true)
  const [added, setAdded] = useState(false)
  const addItem = useCartStore((s) => s.addItem)
  const isFavorite = useFavoritesStore((s) => (product ? s.isFavorite(product.id) : false))
  const toggleFavorite = useFavoritesStore((s) => s.toggle)

  useEffect(() => {
    setLoading(true)
    setAdded(false)
    getProduct(productId)
      .then(setProduct)
      .finally(() => setLoading(false))
  }, [productId])

  if (loading) return <Loading />
  if (!product) return null

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title={product.title} isBackEnabled actionIcon="share-2" />
      <ScrollView>
        <FlatList
          data={product.images}
          keyExtractor={(item) => item}
          horizontal
          pagingEnabled
          showsHorizontalScrollIndicator={false}
          renderItem={({ item }) => (
            <Image source={{ uri: item }} style={[styles.pagerImage, { width }]} resizeMode="cover" />
          )}
        />

        <View style={styles.content}>
          <View style={styles.favoriteRow}>
            <CircularButton onPress={() => toggleFavorite(product)}>
              <Feather name="heart" size={18} color={isFavorite ? colors.primary : colors.gray} />
            </CircularButton>
          </View>

          <View style={styles.titleRow}>
            <Text style={[styles.title, { color: colors.onBackground }]}>{product.title}</Text>
            <View style={styles.priceBlock}>
              <Text style={[styles.price, { color: colors.primary }]}>
                {formatPrice(discountedPrice(product.price, product.discountPercentage))}
              </Text>
              {product.discountPercentage > 0 && (
                <Text style={[styles.strike, { color: colors.gray }]}>
                  {formatPrice(product.price)}
                </Text>
              )}
            </View>
          </View>
          <Text style={[styles.subtitle, { color: colors.gray }]}>
            {product.category} {product.brand ? `· ${product.brand}` : ''}
          </Text>
          <RatingStars rating={product.rating} />
          <Text style={[styles.description, { color: colors.onBackground }]}>
            {product.description}
          </Text>

          <CustomButton
            text={added ? 'ADDED ✓' : 'ADD TO CART'}
            onPress={() => {
              addItem(product, 1)
              setAdded(true)
            }}
            disabled={product.stock === 0}
            style={styles.addButton}
          />
        </View>
      </ScrollView>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  pagerImage: { height: 320 },
  content: { padding: 16, gap: 6 },
  favoriteRow: { flexDirection: 'row', justifyContent: 'flex-end', marginTop: -30 },
  titleRow: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'flex-start' },
  title: { fontSize: 20, fontWeight: '700', flex: 1, marginRight: 12 },
  priceBlock: { alignItems: 'flex-end' },
  price: { fontSize: 20, fontWeight: '700' },
  strike: { fontSize: 13, textDecorationLine: 'line-through' },
  subtitle: { fontSize: 13, textTransform: 'capitalize' },
  description: { fontSize: 14, lineHeight: 20, marginTop: 8 },
  addButton: { marginTop: 20 },
})
