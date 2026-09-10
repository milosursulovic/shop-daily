import { discountedPrice, formatPrice } from './utils'

describe('formatPrice', () => {
  it('formats with two decimals and a dollar sign', () => {
    expect(formatPrice(9.5)).toBe('$9.50')
    expect(formatPrice(0)).toBe('$0.00')
  })
})

describe('discountedPrice', () => {
  it('applies a percentage discount', () => {
    expect(discountedPrice(100, 10)).toBe(90)
  })

  it('returns the original price when discount is 0', () => {
    expect(discountedPrice(50, 0)).toBe(50)
  })
})
