import { StyleSheet, Text, View } from 'react-native'
import { useTheme } from '../theme/useTheme'

export function RatingStars({ rating }: { rating: number }) {
  const { colors } = useTheme()
  const rounded = Math.round(rating)

  return (
    <View style={styles.row}>
      <Text style={{ color: colors.star, fontSize: 13 }}>
        {'★'.repeat(rounded)}
        {'☆'.repeat(5 - rounded)}
      </Text>
      <Text style={[styles.value, { color: colors.gray }]}>{rating.toFixed(1)}</Text>
    </View>
  )
}

const styles = StyleSheet.create({
  row: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  value: { fontSize: 12 },
})
