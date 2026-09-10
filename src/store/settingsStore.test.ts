import { useSettingsStore } from './settingsStore'

beforeEach(() => {
  useSettingsStore.setState({ themeOverride: 'system' })
})

describe('settingsStore', () => {
  it('defaults to system', () => {
    expect(useSettingsStore.getState().themeOverride).toBe('system')
  })

  it('setThemeOverride updates the value', () => {
    useSettingsStore.getState().setThemeOverride('dark')
    expect(useSettingsStore.getState().themeOverride).toBe('dark')
  })
})
