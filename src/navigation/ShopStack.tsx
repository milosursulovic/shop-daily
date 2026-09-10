import { createNativeStackNavigator } from '@react-navigation/native-stack'
import type { ShopStackParamList } from './types'
import { ShopScreen } from '../screens/ShopScreen'
import { CategoryScreen } from '../screens/CategoryScreen'

const Stack = createNativeStackNavigator<ShopStackParamList>()

export function ShopStack() {
  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name="ShopCategories" component={ShopScreen} />
      <Stack.Screen name="Category" component={CategoryScreen} />
    </Stack.Navigator>
  )
}
