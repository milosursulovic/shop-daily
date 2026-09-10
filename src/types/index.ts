export interface ProductReview {
  rating: number
  comment: string
  date: string
  reviewerName: string
  reviewerEmail: string
}

export interface Product {
  id: number
  title: string
  description: string
  category: string
  price: number
  discountPercentage: number
  rating: number
  stock: number
  brand?: string
  availabilityStatus: string
  reviews: ProductReview[]
  images: string[]
  thumbnail: string
}

export interface ProductListResponse {
  products: Product[]
  total: number
  skip: number
  limit: number
}

export interface Category {
  slug: string
  name: string
  url: string
}

export interface CartProduct {
  id: number
  title: string
  price: number
  quantity: number
  total: number
  discountPercentage: number
  discountedTotal: number
  thumbnail: string
}

export interface Cart {
  id: number
  products: CartProduct[]
  total: number
  discountedTotal: number
  userId: number
  totalProducts: number
  totalQuantity: number
}

export interface CartListResponse {
  carts: Cart[]
  total: number
  skip: number
  limit: number
}

export interface User {
  id: number
  username: string
  email: string
  firstName: string
  lastName: string
  gender: string
  image: string
  address: {
    address: string
    city: string
    state: string
    postalCode: string
    country: string
  }
  phone: string
  bank?: {
    cardNumber: string
    cardType: string
    cardExpire: string
  }
}

export interface AuthUser extends User {
  accessToken: string
  refreshToken: string
}
