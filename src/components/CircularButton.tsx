import { StyleSheet, TouchableOpacity, type ViewStyle } from 'react-native'
import { useTheme } from '../theme/useTheme'

interface Props {
  children: React.ReactNode
  onPress: () => void
  style?: ViewStyle
}

export function CircularButton({ children, onPress, style }: Props) {
  const { colors } = useTheme()

  return (
    <TouchableOpacity
      onPress={onPress}
      activeOpacity={0.7}
      style={[styles.button, { backgroundColor: colors.secondary }, style]}
    >
      {children}
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  button: {
    width: 40,
    height: 40,
    borderRadius: 20,
    alignItems: 'center',
    justifyContent: 'center',
    elevation: 3,
    shadowColor: '#000',
    shadowOpacity: 0.15,
    shadowRadius: 4,
    shadowOffset: { width: 0, height: 2 },
  },
})
