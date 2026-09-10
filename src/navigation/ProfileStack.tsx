import { createNativeStackNavigator } from '@react-navigation/native-stack'
import type { ProfileStackParamList } from './types'
import { ProfileScreen } from '../screens/ProfileScreen'
import { OrdersScreen } from '../screens/OrdersScreen'
import { AddressScreen } from '../screens/AddressScreen'
import { PaymentMethodsScreen } from '../screens/PaymentMethodsScreen'
import { SettingsScreen } from '../screens/SettingsScreen'

const Stack = createNativeStackNavigator<ProfileStackParamList>()

export function ProfileStack() {
  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name="ProfileHome" component={ProfileScreen} />
      <Stack.Screen name="Orders" component={OrdersScreen} />
      <Stack.Screen name="Address" component={AddressScreen} />
      <Stack.Screen name="PaymentMethods" component={PaymentMethodsScreen} />
      <Stack.Screen name="Settings" component={SettingsScreen} />
    </Stack.Navigator>
  )
}
