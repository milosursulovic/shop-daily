import { fireEvent, render, screen } from '@testing-library/react-native'
import { ProductCard } from './ProductCard'
import { useFavoritesStore } from '../store/favoritesStore'
import type { Product } from '../types'

const product: Product = {
  id: 1,
  title: 'Red Nail Polish',
  description: '',
  category: 'beauty',
  price: 10,
  discountPercentage: 20,
  rating: 4.3,
  stock: 5,
  availabilityStatus: 'In Stock',
  reviews: [],
  images: [],
  thumbnail: 'https://example.com/thumb.jpg',
}

beforeEach(() => {
  useFavoritesStore.setState({ favorites: [] })
})

describe('ProductCard', () => {
  it('renders title and discounted price', async () => {
    await render(<ProductCard product={product} onPress={() => {}} />)
    expect(screen.getByText('Red Nail Polish')).toBeTruthy()
    expect(screen.getByText('$8.00')).toBeTruthy()
  })

  it('calls onPress when the card is tapped', async () => {
    const onPress = jest.fn()
    await render(<ProductCard product={product} onPress={onPress} />)
    fireEvent.press(screen.getByText('Red Nail Polish'))
    expect(onPress).toHaveBeenCalledTimes(1)
  })

  it('toggles favorite state when the heart button is tapped', async () => {
    await render(<ProductCard product={product} onPress={() => {}} />)
    expect(useFavoritesStore.getState().isFavorite(1)).toBe(false)

    await fireEvent.press(screen.getByTestId('favorite-button'))
    expect(useFavoritesStore.getState().isFavorite(1)).toBe(true)

    await fireEvent.press(screen.getByTestId('favorite-button'))
    expect(useFavoritesStore.getState().isFavorite(1)).toBe(false)
  })
})
