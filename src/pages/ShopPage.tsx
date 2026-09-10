import { useEffect, useState } from 'react'
import { useParams, useSearchParams } from 'react-router-dom'
import { getCategories, listProducts } from '../api/products'
import type { Category, Product } from '../types'
import { ProductCard } from '../components/ProductCard'
import { CategorySidebar } from '../components/CategorySidebar'
import { Pagination } from '../components/Pagination'

const PAGE_SIZE = 12

export function ShopPage() {
  const { slug } = useParams()
  const [searchParams, setSearchParams] = useSearchParams()
  const [categories, setCategories] = useState<Category[]>([])
  const [products, setProducts] = useState<Product[]>([])
  const [total, setTotal] = useState(0)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  const q = searchParams.get('q') ?? ''
  const sortBy = (searchParams.get('sortBy') ?? '') as '' | 'price' | 'rating' | 'title'
  const order = (searchParams.get('order') ?? 'asc') as 'asc' | 'desc'
  const page = Number(searchParams.get('page') ?? '1')

  useEffect(() => {
    getCategories().then(setCategories).catch(() => setCategories([]))
  }, [])

  useEffect(() => {
    setLoading(true)
    setError(null)
    listProducts({
      q: q || undefined,
      category: slug,
      sortBy: sortBy || undefined,
      order: sortBy ? order : undefined,
      limit: PAGE_SIZE,
      skip: (page - 1) * PAGE_SIZE,
    })
      .then((res) => {
        setProducts(res.products)
        setTotal(res.total)
      })
      .catch((err) => setError(err instanceof Error ? err.message : 'Failed to load'))
      .finally(() => setLoading(false))
  }, [q, slug, sortBy, order, page])

  function updateParam(key: string, value: string) {
    const next = new URLSearchParams(searchParams)
    if (value) next.set(key, value)
    else next.delete(key)
    next.delete('page')
    setSearchParams(next)
  }

  const totalPages = Math.max(1, Math.ceil(total / PAGE_SIZE))
  const heading = q ? `Search: "${q}"` : slug ? slug.replace(/-/g, ' ') : 'All products'

  return (
    <div className="mx-auto flex max-w-6xl gap-6 px-4 py-6">
      <CategorySidebar categories={categories} />

      <div className="flex-1">
        <div className="mb-4 flex items-center justify-between">
          <h1 className="text-xl font-semibold capitalize text-slate-900">{heading}</h1>
          <select
            value={sortBy}
            onChange={(e) => updateParam('sortBy', e.target.value)}
            className="rounded-md border border-slate-300 px-2 py-1.5 text-sm"
          >
            <option value="">Sort: default</option>
            <option value="price">Price ↑</option>
            <option value="rating">Rating ↑</option>
            <option value="title">Title A-Z</option>
          </select>
          {sortBy && (
            <select
              value={order}
              onChange={(e) => updateParam('order', e.target.value)}
              className="rounded-md border border-slate-300 px-2 py-1.5 text-sm"
            >
              <option value="asc">Asc</option>
              <option value="desc">Desc</option>
            </select>
          )}
        </div>

        {loading && <p className="text-sm text-slate-500">Loading…</p>}
        {error && <p className="text-sm text-red-600">{error}</p>}
        {!loading && !error && products.length === 0 && (
          <p className="text-sm text-slate-500">No products found.</p>
        )}

        <div className="grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-3">
          {products.map((p) => (
            <ProductCard key={p.id} product={p} />
          ))}
        </div>

        <Pagination
          page={page}
          totalPages={totalPages}
          onChange={(p) => updateParam('page', String(p))}
        />
      </div>
    </div>
  )
}
