import { useColorScheme } from 'react-native'
import { useSettingsStore } from '../store/settingsStore'
import { darkColors, lightColors } from './colors'

export function useTheme() {
  const systemScheme = useColorScheme()
  const themeOverride = useSettingsStore((s) => s.themeOverride)
  const isDark = themeOverride === 'system' ? systemScheme === 'dark' : themeOverride === 'dark'
  const colors = isDark ? darkColors : lightColors
  return { colors, isDark }
}
