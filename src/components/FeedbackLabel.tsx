import { StyleSheet, Text, View } from 'react-native'
import { useTheme } from '../theme/useTheme'

interface Props {
  type: 'error' | 'info'
  message: string
}

export function FeedbackLabel({ type, message }: Props) {
  const { colors } = useTheme()
  const color = type === 'error' ? colors.error : colors.gray

  return (
    <View style={[styles.container, { borderColor: color }]}>
      <Text style={[styles.text, { color }]}>{message}</Text>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    borderWidth: 1,
    borderRadius: 10,
    padding: 12,
  },
  text: { fontSize: 13, textAlign: 'center' },
})
