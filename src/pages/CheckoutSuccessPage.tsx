import { Link, useLocation } from 'react-router-dom'

export function CheckoutSuccessPage() {
  const location = useLocation()
  const cartId = (location.state as { cartId?: number } | null)?.cartId

  return (
    <div className="mx-auto max-w-lg px-4 py-20 text-center">
      <div className="mb-4 text-5xl">✅</div>
      <h1 className="text-2xl font-bold text-slate-900">Order placed!</h1>
      <p className="mt-2 text-slate-500">
        {cartId ? `Order #${cartId} was submitted to DummyJSON's /carts/add endpoint.` : ''}
      </p>
      <div className="mt-6 flex justify-center gap-4">
        <Link to="/" className="text-indigo-600">
          Continue shopping
        </Link>
        <Link to="/profile" className="text-indigo-600">
          View order history
        </Link>
      </div>
    </div>
  )
}
