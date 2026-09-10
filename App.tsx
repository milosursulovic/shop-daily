import { NavigationContainer } from '@react-navigation/native'
import { StatusBar } from 'react-native'
import { SafeAreaProvider } from 'react-native-safe-area-context'
import { RootNavigator } from './src/navigation/RootNavigator'
import { useTheme } from './src/theme/useTheme'

function App() {
  const { isDark } = useTheme()

  return (
    <SafeAreaProvider>
      <StatusBar barStyle={isDark ? 'light-content' : 'dark-content'} />
      <NavigationContainer>
        <RootNavigator />
      </NavigationContainer>
    </SafeAreaProvider>
  )
}

export default App
