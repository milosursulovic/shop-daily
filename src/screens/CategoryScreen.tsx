import { useEffect, useState } from 'react'
import { FlatList, StyleSheet, View } from 'react-native'
import { listProductsByCategory } from '../api/products'
import type { Product } from '../types'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { ProductCard } from '../components/ProductCard'
import { Loading } from '../components/Loading'
import type { ShopStackScreenProps } from '../navigation/types'

export function CategoryScreen({ route, navigation }: ShopStackScreenProps<'Category'>) {
  const { colors } = useTheme()
  const { slug, name } = route.params
  const [products, setProducts] = useState<Product[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    listProductsByCategory(slug)
      .then((res) => setProducts(res.products))
      .finally(() => setLoading(false))
  }, [slug])

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title={name} isBackEnabled />
      {loading ? (
        <Loading />
      ) : (
        <FlatList
          data={products}
          keyExtractor={(item) => String(item.id)}
          contentContainerStyle={styles.list}
          ItemSeparatorComponent={() => <View style={{ height: 12 }} />}
          renderItem={({ item }) => (
            <ProductCard
              product={item}
              onPress={() => navigation.navigate('ProductDetail', { productId: item.id })}
            />
          )}
        />
      )}
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  list: { padding: 16 },
})
