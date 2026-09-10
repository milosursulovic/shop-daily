import { StyleSheet, Text } from 'react-native'
import { useTheme } from '../theme/useTheme'

export function ScreenTitle({ title }: { title: string }) {
  const { colors } = useTheme()
  return <Text style={[styles.title, { color: colors.onBackground }]}>{title}</Text>
}

const styles = StyleSheet.create({
  title: { fontSize: 26, fontWeight: '700', paddingHorizontal: 16, paddingVertical: 12 },
})
