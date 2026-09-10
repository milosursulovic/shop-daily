import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { useSettingsStore, type ThemeOverride } from '../store/settingsStore'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'

const options: { label: string; value: ThemeOverride }[] = [
  { label: 'System', value: 'system' },
  { label: 'Light', value: 'light' },
  { label: 'Dark', value: 'dark' },
]

export function SettingsScreen() {
  const { colors } = useTheme()
  const themeOverride = useSettingsStore((s) => s.themeOverride)
  const setThemeOverride = useSettingsStore((s) => s.setThemeOverride)

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar title="Settings" isBackEnabled />
      <View style={styles.content}>
        <Text style={[styles.label, { color: colors.onBackground }]}>Theme</Text>
        <View style={[styles.segmented, { backgroundColor: colors.secondary }]}>
          {options.map((option) => {
            const active = option.value === themeOverride
            return (
              <TouchableOpacity
                key={option.value}
                onPress={() => setThemeOverride(option.value)}
                style={[styles.segment, active && { backgroundColor: colors.primary }]}
              >
                <Text style={{ color: active ? colors.onPrimary : colors.onBackground, fontWeight: '600' }}>
                  {option.label}
                </Text>
              </TouchableOpacity>
            )
          })}
        </View>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  content: { padding: 16 },
  label: { fontSize: 13, fontWeight: '600', marginBottom: 8 },
  segmented: { flexDirection: 'row', borderRadius: 12, padding: 4, gap: 4 },
  segment: { flex: 1, alignItems: 'center', paddingVertical: 10, borderRadius: 9 },
})
