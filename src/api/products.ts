import type { Category, Product, ProductListResponse } from '../types'
import { apiFetch } from './client'

export interface ProductQuery {
  limit?: number
  skip?: number
  q?: string
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
  const { q, ...rest } = query
  if (q) {
    return apiFetch<ProductListResponse>(`/products/search${buildQuery({ q, ...rest })}`)
  }
  return apiFetch<ProductListResponse>(
    `/products${buildQuery(rest as Record<string, string | number | undefined>)}`,
  )
}

export function listProductsByCategory(slug: string, query: ProductQuery = {}) {
  return apiFetch<ProductListResponse>(
    `/products/category/${slug}${buildQuery(query as Record<string, string | number | undefined>)}`,
  )
}

export function getProduct(id: number) {
  return apiFetch<Product>(`/products/${id}`)
}

export function getCategories() {
  return apiFetch<Category[]>('/products/categories')
}
