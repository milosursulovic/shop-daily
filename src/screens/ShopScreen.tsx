import { useEffect, useState } from 'react'
import { FlatList, StyleSheet, View } from 'react-native'
import { getCategories } from '../api/products'
import type { Category } from '../types'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { CategoryCard } from '../components/CategoryCard'
import { Loading } from '../components/Loading'
import type { ShopStackScreenProps } from '../navigation/types'

export function ShopScreen({ navigation }: ShopStackScreenProps<'ShopCategories'>) {
  const { colors } = useTheme()
  const [categories, setCategories] = useState<Category[]>([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    getCategories()
      .then(setCategories)
      .finally(() => setLoading(false))
  }, [])

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title="Categories" actionIcon="search" />
      {loading ? (
        <Loading />
      ) : (
        <FlatList
          data={categories}
          keyExtractor={(item) => item.slug}
          numColumns={2}
          columnWrapperStyle={styles.row}
          contentContainerStyle={styles.list}
          renderItem={({ item }) => (
            <View style={styles.cell}>
              <CategoryCard
                category={item}
                onPress={() => navigation.navigate('Category', { slug: item.slug, name: item.name })}
              />
            </View>
          )}
        />
      )}
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  list: { padding: 16, gap: 12 },
  row: { gap: 12 },
  cell: { flex: 1 },
})
