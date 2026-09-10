import type { Category, Product, ProductListResponse } from '../types'
import { apiFetch } from './client'

export interface ProductQuery {
  limit?: number
  skip?: number
  q?: string
  sortBy?: 'title' | 'price' | 'rating'
  order?: 'asc' | 'desc'
  category?: string
}

function buildQuery(params: Record<string, string | number | undefined>) {
  const search = new URLSearchParams()
  for (const [key, value] of Object.entries(params)) {
    if (value !== undefined && value !== '') search.set(key, String(value))
  }
  const qs = search.toString()
  return qs ? `?${qs}` : ''
}

export function listProducts(query: ProductQuery = {}) {
  const { q, category, ...rest } = query
  if (q) {
    return apiFetch<ProductListResponse>(`/products/search${buildQuery({ q, ...rest })}`)
  }
  if (category) {
    return apiFetch<ProductListResponse>(
      `/products/category/${category}${buildQuery(rest)}`,
    )
  }
  return apiFetch<ProductListResponse>(`/products${buildQuery(rest)}`)
}

export function getProduct(id: number) {
  return apiFetch<Product>(`/products/${id}`)
}

export function getCategories() {
  return apiFetch<Category[]>('/products/categories')
}

export function addProduct(data: Partial<Product>) {
  return apiFetch<Product>('/products/add', {
    method: 'POST',
    body: JSON.stringify(data),
  })
}

export function updateProduct(id: number, data: Partial<Product>) {
  return apiFetch<Product>(`/products/${id}`, {
    method: 'PUT',
    body: JSON.stringify(data),
  })
}

export function deleteProduct(id: number) {
  return apiFetch<Product & { isDeleted: boolean }>(`/products/${id}`, {
    method: 'DELETE',
  })
}
