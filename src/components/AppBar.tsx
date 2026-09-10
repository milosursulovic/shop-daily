import Feather from 'react-native-vector-icons/Feather'
import { useNavigation } from '@react-navigation/native'
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { useTheme } from '../theme/useTheme'

interface Props {
  title?: string
  isBackEnabled?: boolean
  actionIcon?: 'search' | 'share-2'
  onActionPress?: () => void
}

export function AppBar({ title = '', isBackEnabled = false, actionIcon, onActionPress }: Props) {
  const { colors } = useTheme()
  const navigation = useNavigation()

  return (
    <View style={[styles.bar, { backgroundColor: colors.background }]}>
      <View style={styles.side}>
        {isBackEnabled && (
          <TouchableOpacity onPress={() => navigation.goBack()}>
            <Feather name="chevron-left" size={28} color={colors.onBackground} />
          </TouchableOpacity>
        )}
      </View>
      <Text style={[styles.title, { color: colors.onBackground }]} numberOfLines={1}>
        {title}
      </Text>
      <View style={[styles.side, styles.sideRight]}>
        {actionIcon && (
          <TouchableOpacity onPress={onActionPress}>
            <Feather name={actionIcon} size={22} color={colors.onBackground} />
          </TouchableOpacity>
        )}
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  bar: {
    height: 52,
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: 12,
  },
  side: { width: 40 },
  sideRight: { alignItems: 'flex-end' },
  title: { flex: 1, textAlign: 'center', fontSize: 18, fontWeight: '600' },
})
