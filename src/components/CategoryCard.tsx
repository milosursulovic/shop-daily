import { StyleSheet, Text, TouchableOpacity } from 'react-native'
import type { Category } from '../types'
import { useTheme } from '../theme/useTheme'

interface Props {
  category: Category
  onPress: () => void
}

export function CategoryCard({ category, onPress }: Props) {
  const { colors } = useTheme()

  return (
    <TouchableOpacity
      onPress={onPress}
      activeOpacity={0.85}
      style={[styles.card, { backgroundColor: colors.secondary }]}
    >
      <Text style={[styles.name, { color: colors.onSecondary }]}>{category.name}</Text>
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  card: {
    height: 100,
    borderRadius: 20,
    alignItems: 'center',
    justifyContent: 'center',
    elevation: 3,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 6,
    shadowOffset: { width: 0, height: 3 },
  },
  name: { fontSize: 16, fontWeight: '700', textTransform: 'capitalize' },
})
