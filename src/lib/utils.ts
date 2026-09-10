export function formatPrice(value: number) {
  return `$${value.toFixed(2)}`
}

export function discountedPrice(price: number, discountPercentage: number) {
  return price * (1 - discountPercentage / 100)
}
