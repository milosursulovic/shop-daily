import { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import { getProduct } from '../api/products'
import type { Product } from '../types'
import { discountedPrice, formatPrice } from '../lib/utils'
import { RatingStars } from '../components/RatingStars'
import { useCartStore } from '../store/cartStore'

export function ProductDetailPage() {
  const { id } = useParams()
  const [product, setProduct] = useState<Product | null>(null)
  const [activeImage, setActiveImage] = useState(0)
  const [quantity, setQuantity] = useState(1)
  const [loading, setLoading] = useState(true)
  const addItem = useCartStore((s) => s.addItem)
  const [added, setAdded] = useState(false)

  useEffect(() => {
    if (!id) return
    setLoading(true)
    setActiveImage(0)
    setQuantity(1)
    setAdded(false)
    getProduct(Number(id))
      .then(setProduct)
      .finally(() => setLoading(false))
  }, [id])

  if (loading) return <p className="px-4 py-8 text-center text-sm text-slate-500">Loading…</p>
  if (!product)
    return <p className="px-4 py-8 text-center text-sm text-slate-500">Product not found.</p>

  return (
    <div className="mx-auto max-w-5xl px-4 py-8">
      <Link to="/" className="text-sm text-indigo-600">
        ← Back to shop
      </Link>

      <div className="mt-4 grid grid-cols-1 gap-8 md:grid-cols-2">
        <div>
          <img
            src={product.images[activeImage] ?? product.thumbnail}
            alt={product.title}
            className="w-full rounded-lg border border-slate-200 object-cover"
          />
          <div className="mt-3 flex gap-2 overflow-x-auto">
            {product.images.map((img, i) => (
              <button
                key={img}
                type="button"
                onClick={() => setActiveImage(i)}
                className={`h-16 w-16 shrink-0 overflow-hidden rounded-md border ${
                  i === activeImage ? 'border-indigo-500' : 'border-slate-200'
                }`}
              >
                <img src={img} alt="" className="h-full w-full object-cover" />
              </button>
            ))}
          </div>
        </div>

        <div>
          <span className="text-xs uppercase tracking-wide text-slate-400">
            {product.category} {product.brand ? `· ${product.brand}` : ''}
          </span>
          <h1 className="mt-1 text-2xl font-bold text-slate-900">{product.title}</h1>
          <RatingStars rating={product.rating} />
          <p className="mt-3 text-sm text-slate-600">{product.description}</p>

          <div className="mt-4 flex items-baseline gap-3">
            <span className="text-2xl font-bold text-slate-900">
              {formatPrice(discountedPrice(product.price, product.discountPercentage))}
            </span>
            {product.discountPercentage > 0 && (
              <>
                <span className="text-slate-400 line-through">{formatPrice(product.price)}</span>
                <span className="rounded bg-emerald-100 px-2 py-0.5 text-xs font-medium text-emerald-700">
                  -{product.discountPercentage.toFixed(0)}%
                </span>
              </>
            )}
          </div>

          <p className="mt-2 text-sm text-slate-500">
            {product.stock > 0 ? `${product.stock} in stock` : 'Out of stock'} ·{' '}
            {product.availabilityStatus}
          </p>

          <div className="mt-4 flex items-center gap-3">
            <input
              type="number"
              min={1}
              max={product.stock}
              value={quantity}
              onChange={(e) => setQuantity(Math.max(1, Number(e.target.value)))}
              className="w-20 rounded-md border border-slate-300 px-2 py-1.5"
            />
            <button
              type="button"
              disabled={product.stock === 0}
              onClick={() => {
                addItem(product, quantity)
                setAdded(true)
              }}
              className="rounded-md bg-indigo-600 px-4 py-2 font-medium text-white hover:bg-indigo-700 disabled:opacity-50"
            >
              Add to cart
            </button>
            {added && <span className="text-sm text-emerald-600">Added ✓</span>}
          </div>

          <dl className="mt-6 grid grid-cols-1 gap-2 text-sm text-slate-600">
            <div className="flex justify-between border-b border-slate-100 py-1">
              <dt>Warranty</dt>
              <dd>{product.warrantyInformation}</dd>
            </div>
            <div className="flex justify-between border-b border-slate-100 py-1">
              <dt>Shipping</dt>
              <dd>{product.shippingInformation}</dd>
            </div>
            <div className="flex justify-between border-b border-slate-100 py-1">
              <dt>Return policy</dt>
              <dd>{product.returnPolicy}</dd>
            </div>
          </dl>
        </div>
      </div>

      <div className="mt-10">
        <h2 className="mb-3 text-lg font-semibold text-slate-900">Reviews</h2>
        {product.reviews.length === 0 && (
          <p className="text-sm text-slate-500">No reviews yet.</p>
        )}
        <div className="grid grid-cols-1 gap-3 sm:grid-cols-2">
          {product.reviews.map((r) => (
            <div
              key={`${r.reviewerEmail}-${r.date}`}
              className="rounded-md border border-slate-200 p-3"
            >
              <div className="flex items-center justify-between">
                <span className="font-medium text-slate-800">{r.reviewerName}</span>
                <RatingStars rating={r.rating} />
              </div>
              <p className="mt-1 text-sm text-slate-600">{r.comment}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  )
}
