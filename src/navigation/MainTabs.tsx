import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import type { MainTabParamList } from './types'
import { TabBar } from './TabBar'
import { HomeScreen } from '../screens/HomeScreen'
import { ShopStack } from './ShopStack'
import { ProfileStack } from './ProfileStack'
import { BagScreen } from '../screens/BagScreen'
import { FavoritesScreen } from '../screens/FavoritesScreen'

const Tab = createBottomTabNavigator<MainTabParamList>()

export function MainTabs() {
  return (
    <Tab.Navigator
      screenOptions={{ headerShown: false }}
      tabBar={(props) => <TabBar {...props} />}
    >
      <Tab.Screen name="Home" component={HomeScreen} />
      <Tab.Screen name="Shop" component={ShopStack} />
      <Tab.Screen name="Bag" component={BagScreen} />
      <Tab.Screen name="Favorites" component={FavoritesScreen} />
      <Tab.Screen name="Profile" component={ProfileStack} />
    </Tab.Navigator>
  )
}
