import { ActivityIndicator, StyleSheet, View } from 'react-native'
import { useTheme } from '../theme/useTheme'

export function Loading() {
  const { colors } = useTheme()
  return (
    <View style={styles.container}>
      <ActivityIndicator size="large" color={colors.primary} />
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1, alignItems: 'center', justifyContent: 'center', padding: 40 },
})
