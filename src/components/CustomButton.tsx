import type { ReactNode } from 'react'
import { ActivityIndicator, StyleSheet, Text, TouchableOpacity, type ViewStyle } from 'react-native'
import { useTheme } from '../theme/useTheme'

interface Props {
  text: string
  onPress: () => void
  style?: ViewStyle
  disabled?: boolean
  loading?: boolean
  icon?: ReactNode
}

export function CustomButton({ text, onPress, style, disabled, loading, icon }: Props) {
  const { colors } = useTheme()

  return (
    <TouchableOpacity
      onPress={onPress}
      disabled={disabled || loading}
      activeOpacity={0.8}
      style={[
        styles.button,
        { backgroundColor: colors.primary, opacity: disabled ? 0.5 : 1 },
        style,
      ]}
    >
      {loading ? (
        <ActivityIndicator color={colors.onPrimary} />
      ) : (
        <>
          {icon}
          <Text style={[styles.text, { color: colors.onPrimary }]}>{text}</Text>
        </>
      )}
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  button: {
    borderRadius: 30,
    paddingVertical: 14,
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'row',
    gap: 8,
  },
  text: {
    fontSize: 14,
    fontWeight: '600',
  },
})
