import Feather from 'react-native-vector-icons/Feather'
import { FlatList, Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { useAuthStore } from '../store/authStore'
import { useTheme } from '../theme/useTheme'
import { AppBar } from '../components/AppBar'
import { ScreenTitle } from '../components/ScreenTitle'
import type { ProfileStackParamList, ProfileStackScreenProps } from '../navigation/types'

interface ProfileItem {
  title: string
  subtitle: string
  route?: keyof ProfileStackParamList
}

const profileItems: ProfileItem[] = [
  { title: 'My orders', subtitle: 'View your order history', route: 'Orders' },
  { title: 'Shipping addresses', subtitle: 'Manage delivery addresses', route: 'Address' },
  { title: 'Payment methods', subtitle: 'Manage saved cards', route: 'PaymentMethods' },
  { title: 'Promocodes', subtitle: 'You have special promocodes' },
  { title: 'My reviews', subtitle: 'Reviews for items you bought' },
  { title: 'Settings', subtitle: 'Notifications, theme', route: 'Settings' },
]

export function ProfileScreen({ navigation }: ProfileStackScreenProps<'ProfileHome'>) {
  const { colors } = useTheme()
  const user = useAuthStore((s) => s.user)
  const logout = useAuthStore((s) => s.logout)

  return (
    <View style={[styles.container, { backgroundColor: colors.background }]}>
      <AppBar actionIcon="search" />
      <ScreenTitle title="My Profile" />

      <View style={styles.header}>
        <Image
          source={
            user?.image
              ? { uri: user.image }
              : require('../assets/images/profile_avatar.png')
          }
          style={styles.avatar}
        />
        <View>
          <Text style={[styles.name, { color: colors.onBackground }]}>
            {user?.firstName} {user?.lastName}
          </Text>
          <Text style={{ color: colors.gray }}>{user?.email}</Text>
        </View>
      </View>

      <FlatList
        data={profileItems}
        keyExtractor={(item) => item.title}
        contentContainerStyle={styles.list}
        renderItem={({ item }) => (
          <TouchableOpacity
            style={styles.item}
            disabled={!item.route}
            onPress={() => item.route && navigation.navigate(item.route)}
          >
            <View>
              <Text style={[styles.itemTitle, { color: colors.onBackground }]}>{item.title}</Text>
              <Text style={[styles.itemSubtitle, { color: colors.gray }]}>{item.subtitle}</Text>
            </View>
            {item.route && <Feather name="chevron-right" size={20} color={colors.gray} />}
          </TouchableOpacity>
        )}
        ListFooterComponent={
          <TouchableOpacity style={styles.item} onPress={logout}>
            <Text style={[styles.itemTitle, { color: colors.error }]}>Logout</Text>
            <Feather name="log-out" size={18} color={colors.error} />
          </TouchableOpacity>
        }
      />
    </View>
  )
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  header: { flexDirection: 'row', alignItems: 'center', paddingHorizontal: 16, gap: 12, marginBottom: 8 },
  avatar: { width: 56, height: 56, borderRadius: 28 },
  name: { fontSize: 17, fontWeight: '700' },
  list: { paddingHorizontal: 16, paddingTop: 8 },
  item: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingVertical: 14,
    borderBottomWidth: StyleSheet.hairlineWidth,
    borderBottomColor: '#00000022',
  },
  itemTitle: { fontSize: 15, fontWeight: '600' },
  itemSubtitle: { fontSize: 12, marginTop: 2 },
})
