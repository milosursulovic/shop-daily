import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { cartTotals, useCartStore } from '../store/cartStore'
import { useAuthStore } from '../store/authStore'
import { addCart } from '../api/carts'
import { discountedPrice, formatPrice } from '../lib/utils'

export function CartPage() {
  const navigate = useNavigate()
  const user = useAuthStore((s) => s.user)
  const items = useCartStore((s) => s.items)
  const setQuantity = useCartStore((s) => s.setQuantity)
  const removeItem = useCartStore((s) => s.removeItem)
  const clear = useCartStore((s) => s.clear)
  const { subtotal, discounted, totalQuantity } = cartTotals(items)
  const [checkingOut, setCheckingOut] = useState(false)
  const [error, setError] = useState<string | null>(null)

  async function handleCheckout() {
    if (!user || items.length === 0) return
    setCheckingOut(true)
    setError(null)
    try {
      const cart = await addCart(
        user.id,
        items.map((i) => ({ id: i.productId, quantity: i.quantity })),
      )
      clear()
      navigate('/checkout/success', { state: { cartId: cart.id } })
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Checkout failed')
    } finally {
      setCheckingOut(false)
    }
  }

  if (items.length === 0) {
    return (
      <div className="mx-auto max-w-2xl px-4 py-16 text-center">
        <p className="text-slate-500">Your cart is empty.</p>
        <Link to="/" className="mt-3 inline-block text-indigo-600">
          Continue shopping →
        </Link>
      </div>
    )
  }

  return (
    <div className="mx-auto max-w-3xl px-4 py-8">
      <h1 className="mb-4 text-xl font-semibold text-slate-900">Your cart</h1>

      <div className="flex flex-col gap-3">
        {items.map((item) => (
          <div
            key={item.productId}
            className="flex items-center gap-4 rounded-md border border-slate-200 p-3"
          >
            <img src={item.thumbnail} alt="" className="h-16 w-16 rounded-md object-cover" />
            <div className="flex-1">
              <p className="font-medium text-slate-800">{item.title}</p>
              <p className="text-sm text-slate-500">
                {formatPrice(discountedPrice(item.price, item.discountPercentage))} each
              </p>
            </div>
            <input
              type="number"
              min={1}
              max={item.stock}
              value={item.quantity}
              onChange={(e) => setQuantity(item.productId, Number(e.target.value))}
              className="w-16 rounded-md border border-slate-300 px-2 py-1"
            />
            <span className="w-20 text-right font-medium text-slate-800">
              {formatPrice(discountedPrice(item.price, item.discountPercentage) * item.quantity)}
            </span>
            <button
              type="button"
              onClick={() => removeItem(item.productId)}
              className="text-sm text-red-600 hover:underline"
            >
              Remove
            </button>
          </div>
        ))}
      </div>

      <div className="mt-6 flex flex-col items-end gap-1 border-t border-slate-200 pt-4">
        <p className="text-sm text-slate-500">
          {totalQuantity} items · subtotal {formatPrice(subtotal)}
        </p>
        <p className="text-xl font-bold text-slate-900">Total: {formatPrice(discounted)}</p>
        {error && <p className="text-sm text-red-600">{error}</p>}
        <button
          type="button"
          onClick={handleCheckout}
          disabled={checkingOut}
          className="mt-2 rounded-md bg-indigo-600 px-5 py-2.5 font-medium text-white hover:bg-indigo-700 disabled:opacity-60"
        >
          {checkingOut ? 'Placing order…' : 'Checkout'}
        </button>
      </div>
    </div>
  )
}
