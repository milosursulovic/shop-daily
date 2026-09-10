import type { BottomTabBarProps } from '@react-navigation/bottom-tabs'
import { Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { useTheme } from '../theme/useTheme'

const icons = {
  Home: {
    selectedLight: require('../assets/icons/home_selected_light.png'),
    unselectedLight: require('../assets/icons/home_unselected_light.png'),
    selectedDark: require('../assets/icons/home_selected_dark.png'),
    unselectedDark: require('../assets/icons/home_unselected_dark.png'),
  },
  Shop: {
    selectedLight: require('../assets/icons/shop_selected_light.png'),
    unselectedLight: require('../assets/icons/shop_unselected_light.png'),
    selectedDark: require('../assets/icons/shop_selected_dark.png'),
    unselectedDark: require('../assets/icons/shop_unselected_dark.png'),
  },
  Bag: {
    selectedLight: require('../assets/icons/bag_selected_light.png'),
    unselectedLight: require('../assets/icons/bag_unselected_light.png'),
    selectedDark: require('../assets/icons/bag_selected_dark.png'),
    unselectedDark: require('../assets/icons/bag_unselected_dark.png'),
  },
  Favorites: {
    selectedLight: require('../assets/icons/favorites_selected_light.png'),
    unselectedLight: require('../assets/icons/favorites_unselected_light.png'),
    selectedDark: require('../assets/icons/favorites_selected_dark.png'),
    unselectedDark: require('../assets/icons/favorites_unselected_dark.png'),
  },
  Profile: {
    selectedLight: require('../assets/icons/profile_selected_light.png'),
    unselectedLight: require('../assets/icons/profile_unselected_light.png'),
    selectedDark: require('../assets/icons/profile_selected_dark.png'),
    unselectedDark: require('../assets/icons/profile_unselected_dark.png'),
  },
} as const

export function TabBar({ state, navigation }: BottomTabBarProps) {
  const { colors, isDark } = useTheme()

  return (
    <View style={{ backgroundColor: colors.background }}>
      <View style={[styles.bar, { backgroundColor: colors.secondary }]}>
        {state.routes.map((route, index) => {
          const label = route.name as keyof typeof icons
          const isFocused = state.index === index
          const iconSet = icons[label]
          const source = isFocused
            ? isDark
              ? iconSet.selectedDark
              : iconSet.selectedLight
            : isDark
              ? iconSet.unselectedDark
              : iconSet.unselectedLight

          return (
            <TouchableOpacity
              key={route.key}
              onPress={() => {
                const event = navigation.emit({
                  type: 'tabPress',
                  target: route.key,
                  canPreventDefault: true,
                })
                if (!isFocused && !event.defaultPrevented) navigation.navigate(route.name)
              }}
              style={styles.tab}
            >
              <Image source={source} style={styles.icon} resizeMode="contain" />
              <Text style={[styles.label, { color: isFocused ? colors.primary : colors.gray }]}>
                {label}
              </Text>
            </TouchableOpacity>
          )
        })}
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  bar: {
    flexDirection: 'row',
    justifyContent: 'space-evenly',
    paddingTop: 8,
    paddingBottom: 20,
    borderTopLeftRadius: 20,
    borderTopRightRadius: 20,
    elevation: 8,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 8,
    shadowOffset: { width: 0, height: -3 },
  },
  tab: { alignItems: 'center', gap: 2 },
  icon: { width: 26, height: 26 },
  label: { fontSize: 11, fontWeight: '600' },
})
