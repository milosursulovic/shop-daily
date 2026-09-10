import { Link } from 'react-router-dom'
import type { Product } from '../types'
import { discountedPrice, formatPrice } from '../lib/utils'
import { RatingStars } from './RatingStars'
import { useCartStore } from '../store/cartStore'

interface Props {
  product: Product
}

export function ProductCard({ product }: Props) {
  const addItem = useCartStore((s) => s.addItem)
  const hasDiscount = product.discountPercentage > 0

  return (
    <div className="flex flex-col rounded-lg border border-slate-200 bg-white p-4 shadow-sm transition hover:shadow-md">
      <Link to={`/products/${product.id}`} className="flex flex-1 flex-col">
        <img
          src={product.thumbnail}
          alt={product.title}
          className="mb-3 h-40 w-full rounded-md object-cover"
        />
        <span className="text-xs uppercase tracking-wide text-slate-400">
          {product.category}
        </span>
        <h3 className="mb-1 line-clamp-2 font-medium text-slate-900">{product.title}</h3>
        <RatingStars rating={product.rating} />
      </Link>
      <div className="mt-3 flex items-center justify-between">
        <div>
          {hasDiscount ? (
            <div className="flex items-baseline gap-2">
              <span className="font-semibold text-slate-900">
                {formatPrice(discountedPrice(product.price, product.discountPercentage))}
              </span>
              <span className="text-xs text-slate-400 line-through">
                {formatPrice(product.price)}
              </span>
            </div>
          ) : (
            <span className="font-semibold text-slate-900">{formatPrice(product.price)}</span>
          )}
        </div>
        <button
          type="button"
          onClick={() => addItem(product, 1)}
          disabled={product.stock === 0}
          className="rounded-md bg-indigo-600 px-3 py-1.5 text-sm font-medium text-white transition hover:bg-indigo-700 disabled:cursor-not-allowed disabled:bg-slate-300"
        >
          {product.stock === 0 ? 'Out of stock' : 'Add'}
        </button>
      </div>
    </div>
  )
}
