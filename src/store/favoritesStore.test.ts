import { useFavoritesStore } from './favoritesStore'
import type { Product } from '../types'

function makeProduct(overrides: Partial<Product> = {}): Product {
  return {
    id: 1,
    title: 'Test Product',
    description: '',
    category: 'test',
    price: 20,
    discountPercentage: 0,
    rating: 4.5,
    stock: 5,
    availabilityStatus: 'In Stock',
    reviews: [],
    images: [],
    thumbnail: 'https://example.com/thumb.jpg',
    ...overrides,
  }
}

beforeEach(() => {
  useFavoritesStore.setState({ favorites: [] })
})

describe('favoritesStore', () => {
  it('toggle adds a product not yet favorited', () => {
    useFavoritesStore.getState().toggle(makeProduct())
    expect(useFavoritesStore.getState().isFavorite(1)).toBe(true)
  })

  it('toggle removes a product already favorited', () => {
    const product = makeProduct()
    useFavoritesStore.getState().toggle(product)
    useFavoritesStore.getState().toggle(product)
    expect(useFavoritesStore.getState().isFavorite(1)).toBe(false)
    expect(useFavoritesStore.getState().favorites).toEqual([])
  })

  it('remove drops the matching product by id', () => {
    useFavoritesStore.getState().toggle(makeProduct({ id: 1 }))
    useFavoritesStore.getState().toggle(makeProduct({ id: 2 }))
    useFavoritesStore.getState().remove(1)
    expect(useFavoritesStore.getState().favorites.map((p) => p.id)).toEqual([2])
  })
})
