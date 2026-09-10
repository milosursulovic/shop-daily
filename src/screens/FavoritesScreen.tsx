import Feather from 'react-native-vector-icons/Feather'
import { FlatList, Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { useFavoritesStore } from '../store/favoritesStore'
import { discountedPrice, formatPrice } from '../lib/utils'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { FeedbackLabel } from '../components/FeedbackLabel'
import { ScreenTitle } from '../components/ScreenTitle'
import type { MainTabScreenProps } from '../navigation/types'

export function FavoritesScreen({ navigation }: MainTabScreenProps<'Favorites'>) {
  const { colors } = useTheme()
  const favorites = useFavoritesStore((s) => s.favorites)
  const remove = useFavoritesStore((s) => s.remove)

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar actionIcon="search" />
      <ScreenTitle title="Favorites" />

      <FlatList
        data={favorites}
        keyExtractor={(item) => String(item.id)}
        contentContainerStyle={styles.list}
        ItemSeparatorComponent={() => <View style={{ height: 10 }} />}
        ListEmptyComponent={<FeedbackLabel type="info" message="There is no favorites" />}
        renderItem={({ item }) => (
          <TouchableOpacity
            style={[styles.item, { backgroundColor: colors.secondary }]}
            onPress={() => navigation.navigate('ProductDetail', { productId: item.id })}
          >
            <Image source={{ uri: item.thumbnail }} style={styles.image} />
            <View style={styles.info}>
              <Text style={[styles.title, { color: colors.onBackground }]} numberOfLines={1}>
                {item.title}
              </Text>
              <Text style={{ color: colors.primary, fontWeight: '700' }}>
                {formatPrice(discountedPrice(item.price, item.discountPercentage))}
              </Text>
            </View>
            <TouchableOpacity onPress={() => remove(item.id)}>
              <Feather name="x" size={18} color={colors.gray} />
            </TouchableOpacity>
          </TouchableOpacity>
        )}
      />
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  list: { paddingHorizontal: 16, flexGrow: 1 },
  item: { flexDirection: 'row', alignItems: 'center', borderRadius: 14, padding: 10, gap: 10 },
  image: { width: 50, height: 50, borderRadius: 8 },
  info: { flex: 1, gap: 4 },
  title: { fontSize: 14, fontWeight: '600' },
})
