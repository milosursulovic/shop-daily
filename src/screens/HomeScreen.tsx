import { useEffect, useState } from 'react'
import {
  FlatList,
  Image,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from 'react-native'
import { listProducts } from '../api/products'
import type { Product } from '../types'
import { useTheme } from '../theme/useTheme'
import { HomeProductCard } from '../components/HomeProductCard'
import { Loading } from '../components/Loading'
import type { MainTabScreenProps } from '../navigation/types'

function ProductRow({
  title,
  subtitle,
  products,
  loading,
  onProductPress,
}: {
  title: string
  subtitle: string
  products: Product[]
  loading: boolean
  onProductPress: (id: number) => void
}) {
  const { colors } = useTheme()

  return (
    <View style={styles.section}>
      <View style={styles.sectionHeader}>
        <View>
          <Text style={[styles.sectionTitle, { color: colors.onBackground }]}>{title}</Text>
          <Text style={[styles.sectionSubtitle, { color: colors.gray }]}>{subtitle}</Text>
        </View>
        <Text style={{ color: colors.onBackground, fontWeight: '600' }}>View all</Text>
      </View>
      {loading ? (
        <Loading />
      ) : (
        <FlatList
          horizontal
          data={products}
          keyExtractor={(item) => String(item.id)}
          showsHorizontalScrollIndicator={false}
          contentContainerStyle={styles.rowList}
          renderItem={({ item }) => (
            <HomeProductCard product={item} onPress={() => onProductPress(item.id)} />
          )}
        />
      )}
    </View>
  )
}

export function HomeScreen({ navigation }: MainTabScreenProps<'Home'>) {
  const { colors } = useTheme()
  const [newProducts, setNewProducts] = useState<Product[]>([])
  const [saleProducts, setSaleProducts] = useState<Product[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    listProducts({ limit: 8 })
      .then((res) => {
        setNewProducts(res.products)
        setSaleProducts([...res.products].reverse())
      })
      .finally(() => setLoading(false))
  }, [])

  function openProduct(productId: number) {
    navigation.navigate('ProductDetail', { productId })
  }

  return (
    <ScrollView style={{ backgroundColor: colors.background }}>
      <View style={styles.hero}>
        <Image source={require('../assets/images/main_page_top_image.png')} style={styles.heroImage} />
        <Text style={styles.heroText}>Fashion{'\n'}Sale</Text>
      </View>

      <ProductRow
        title="New"
        subtitle="You've never seen it before!"
        products={newProducts}
        loading={loading}
        onProductPress={openProduct}
      />
      <ProductRow
        title="Sale"
        subtitle="Super summer sale"
        products={saleProducts}
        loading={loading}
        onProductPress={openProduct}
      />
    </ScrollView>
  )
}

const styles = StyleSheet.create({
  hero: { height: 220, justifyContent: 'flex-end' },
  heroImage: { position: 'absolute', width: '100%', height: '100%' },
  heroText: {
    color: '#FFFFFF',
    fontSize: 40,
    fontWeight: '800',
    padding: 16,
  },
  section: { marginTop: 16 },
  sectionHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 16,
    marginBottom: 10,
  },
  sectionTitle: { fontSize: 20, fontWeight: '700' },
  sectionSubtitle: { fontSize: 12 },
  rowList: { paddingHorizontal: 16, gap: 12 },
})
