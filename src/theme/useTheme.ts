import { useColorScheme } from 'react-native'
import { darkColors, lightColors } from './colors'

export function useTheme() {
  const scheme = useColorScheme()
  const colors = scheme === 'dark' ? darkColors : lightColors
  return { colors, isDark: scheme === 'dark' }
}
