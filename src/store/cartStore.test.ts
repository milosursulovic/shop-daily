import { cartTotals, useCartStore } from './cartStore'
import type { Product } from '../types'

function makeProduct(overrides: Partial<Product> = {}): Product {
  return {
    id: 1,
    title: 'Test Product',
    description: '',
    category: 'test',
    price: 20,
    discountPercentage: 10,
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
  useCartStore.setState({ items: [] })
})

describe('cartStore', () => {
  it('adds a new item to the cart', () => {
    useCartStore.getState().addItem(makeProduct(), 2)
    expect(useCartStore.getState().items).toEqual([
      expect.objectContaining({ productId: 1, quantity: 2 }),
    ])
  })

  it('merges quantity when the same product is added again', () => {
    const product = makeProduct({ stock: 10 })
    useCartStore.getState().addItem(product, 2)
    useCartStore.getState().addItem(product, 3)
    expect(useCartStore.getState().items[0].quantity).toBe(5)
  })

  it('caps quantity at available stock', () => {
    const product = makeProduct({ stock: 3 })
    useCartStore.getState().addItem(product, 2)
    useCartStore.getState().addItem(product, 5)
    expect(useCartStore.getState().items[0].quantity).toBe(3)
  })

  it('removes the item when quantity is set to 0', () => {
    useCartStore.getState().addItem(makeProduct(), 1)
    useCartStore.getState().setQuantity(1, 0)
    expect(useCartStore.getState().items).toEqual([])
  })

  it('removeItem drops the matching product', () => {
    useCartStore.getState().addItem(makeProduct({ id: 1 }), 1)
    useCartStore.getState().addItem(makeProduct({ id: 2 }), 1)
    useCartStore.getState().removeItem(1)
    expect(useCartStore.getState().items.map((i) => i.productId)).toEqual([2])
  })

  it('clear empties the cart', () => {
    useCartStore.getState().addItem(makeProduct(), 1)
    useCartStore.getState().clear()
    expect(useCartStore.getState().items).toEqual([])
  })
})

describe('cartTotals', () => {
  it('sums quantity and applies per-item discount', () => {
    const totals = cartTotals([
      { productId: 1, title: 'A', price: 100, discountPercentage: 10, thumbnail: '', stock: 5, quantity: 2 },
      { productId: 2, title: 'B', price: 50, discountPercentage: 0, thumbnail: '', stock: 5, quantity: 1 },
    ])
    expect(totals.totalQuantity).toBe(3)
    expect(totals.discounted).toBeCloseTo(2 * 100 * 0.9 + 50)
  })

  it('returns zero totals for an empty cart', () => {
    expect(cartTotals([])).toEqual({ totalQuantity: 0, discounted: 0 })
  })
})
