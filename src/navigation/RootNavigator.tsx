import { createNativeStackNavigator } from '@react-navigation/native-stack'
import type { RootStackParamList } from './types'
import { useAuthStore } from '../store/authStore'
import { LoginScreen } from '../screens/LoginScreen'
import { MainTabs } from './MainTabs'
import { ProductDetailScreen } from '../screens/ProductDetailScreen'

const Stack = createNativeStackNavigator<RootStackParamList>()

export function RootNavigator() {
  const accessToken = useAuthStore((s) => s.accessToken)

  return (
    <Stack.Navigator screenOptions={{ headerShown: false }}>
      {accessToken ? (
        <>
          <Stack.Screen name="MainTabs" component={MainTabs} />
          <Stack.Screen
            name="ProductDetail"
            component={ProductDetailScreen}
            options={{ animation: 'slide_from_bottom' }}
          />
        </>
      ) : (
        <Stack.Screen name="Login" component={LoginScreen} />
      )}
    </Stack.Navigator>
  )
}
