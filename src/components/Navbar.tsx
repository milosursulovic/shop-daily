import { useState } from 'react'
import { Link, useNavigate, useSearchParams } from 'react-router-dom'
import { useAuthStore } from '../store/authStore'
import { useCartStore, cartTotals } from '../store/cartStore'

export function Navbar() {
  const navigate = useNavigate()
  const [searchParams] = useSearchParams()
  const [q, setQ] = useState(searchParams.get('q') ?? '')
  const user = useAuthStore((s) => s.user)
  const logout = useAuthStore((s) => s.logout)
  const items = useCartStore((s) => s.items)
  const { totalQuantity } = cartTotals(items)

  function handleSearch(e: React.FormEvent) {
    e.preventDefault()
    navigate(q.trim() ? `/?q=${encodeURIComponent(q.trim())}` : '/')
  }

  return (
    <header className="border-b border-slate-200 bg-white">
      <div className="mx-auto flex max-w-6xl items-center gap-4 px-4 py-3">
        <Link to="/" className="text-lg font-bold text-indigo-600">
          DummyShop
        </Link>

        <form onSubmit={handleSearch} className="flex-1">
          <input
            type="search"
            value={q}
            onChange={(e) => setQ(e.target.value)}
            placeholder="Search products…"
            className="w-full max-w-md rounded-md border border-slate-300 px-3 py-1.5 text-sm focus:border-indigo-500 focus:outline-none"
          />
        </form>

        <nav className="flex items-center gap-3 text-sm">
          <Link to="/cart" className="relative text-slate-600 hover:text-indigo-600">
            Cart
            {totalQuantity > 0 && (
              <span className="absolute -right-3 -top-2 rounded-full bg-indigo-600 px-1.5 text-xs text-white">
                {totalQuantity}
              </span>
            )}
          </Link>
          {user ? (
            <>
              <Link to="/sell" className="text-slate-600 hover:text-indigo-600">
                Sell
              </Link>
              <Link to="/profile" className="flex items-center gap-2 text-slate-600 hover:text-indigo-600">
                <img src={user.image} alt="" className="h-6 w-6 rounded-full" />
                {user.username}
              </Link>
              <button
                type="button"
                onClick={() => {
                  logout()
                  navigate('/login')
                }}
                className="text-slate-500 hover:text-red-600"
              >
                Logout
              </button>
            </>
          ) : (
            <Link to="/login" className="font-medium text-indigo-600">
              Login
            </Link>
          )}
        </nav>
      </div>
    </header>
  )
}
