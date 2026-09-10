import { useEffect, useState } from 'react'
import { useAuthStore } from '../store/authStore'
import { updateUser } from '../api/users'
import { deleteCart, getUserCarts } from '../api/carts'
import type { Cart } from '../types'
import { formatPrice } from '../lib/utils'

export function ProfilePage() {
  const user = useAuthStore((s) => s.user)
  const setUser = useAuthStore((s) => s.setUser)
  const [editing, setEditing] = useState(false)
  const [firstName, setFirstName] = useState(user?.firstName ?? '')
  const [lastName, setLastName] = useState(user?.lastName ?? '')
  const [phone, setPhone] = useState(user?.phone ?? '')
  const [saving, setSaving] = useState(false)

  const [orders, setOrders] = useState<Cart[]>([])
  const [ordersLoading, setOrdersLoading] = useState(true)

  useEffect(() => {
    if (!user) return
    getUserCarts(user.id)
      .then((res) => setOrders(res.carts))
      .finally(() => setOrdersLoading(false))
  }, [user])

  if (!user) return null

  async function handleSave(e: React.FormEvent) {
    e.preventDefault()
    setSaving(true)
    try {
      const updated = await updateUser(user!.id, { firstName, lastName, phone })
      setUser({ ...user!, ...updated })
      setEditing(false)
    } finally {
      setSaving(false)
    }
  }

  async function handleCancelOrder(cartId: number) {
    await deleteCart(cartId)
    setOrders((prev) => prev.filter((o) => o.id !== cartId))
  }

  return (
    <div className="mx-auto max-w-3xl px-4 py-8">
      <div className="flex items-center gap-4">
        <img src={user.image} alt="" className="h-16 w-16 rounded-full" />
        <div>
          <h1 className="text-xl font-semibold text-slate-900">
            {user.firstName} {user.lastName}
          </h1>
          <p className="text-sm text-slate-500">@{user.username}</p>
        </div>
        <button
          type="button"
          onClick={() => setEditing((v) => !v)}
          className="ml-auto rounded-md border border-slate-300 px-3 py-1.5 text-sm"
        >
          {editing ? 'Cancel' : 'Edit profile'}
        </button>
      </div>

      {editing ? (
        <form onSubmit={handleSave} className="mt-6 flex flex-col gap-3 rounded-md border border-slate-200 p-4">
          <label className="flex flex-col gap-1 text-sm">
            First name
            <input
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              className="rounded-md border border-slate-300 px-3 py-1.5"
            />
          </label>
          <label className="flex flex-col gap-1 text-sm">
            Last name
            <input
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              className="rounded-md border border-slate-300 px-3 py-1.5"
            />
          </label>
          <label className="flex flex-col gap-1 text-sm">
            Phone
            <input
              value={phone}
              onChange={(e) => setPhone(e.target.value)}
              className="rounded-md border border-slate-300 px-3 py-1.5"
            />
          </label>
          <button
            type="submit"
            disabled={saving}
            className="self-start rounded-md bg-indigo-600 px-4 py-2 text-sm font-medium text-white hover:bg-indigo-700 disabled:opacity-60"
          >
            {saving ? 'Saving…' : 'Save changes'}
          </button>
        </form>
      ) : (
        <dl className="mt-6 grid grid-cols-1 gap-2 text-sm text-slate-600 sm:grid-cols-2">
          <div>
            <dt className="text-slate-400">Email</dt>
            <dd>{user.email}</dd>
          </div>
          <div>
            <dt className="text-slate-400">Phone</dt>
            <dd>{user.phone}</dd>
          </div>
          <div>
            <dt className="text-slate-400">Address</dt>
            <dd>
              {user.address.address}, {user.address.city}, {user.address.country}
            </dd>
          </div>
          <div>
            <dt className="text-slate-400">Company</dt>
            <dd>
              {user.company.title} at {user.company.name}
            </dd>
          </div>
        </dl>
      )}

      <h2 className="mt-10 mb-3 text-lg font-semibold text-slate-900">Order history</h2>
      {ordersLoading && <p className="text-sm text-slate-500">Loading…</p>}
      {!ordersLoading && orders.length === 0 && (
        <p className="text-sm text-slate-500">No past orders.</p>
      )}
      <div className="flex flex-col gap-2">
        {orders.map((order) => (
          <div
            key={order.id}
            className="flex items-center justify-between rounded-md border border-slate-200 p-3"
          >
            <div>
              <p className="font-medium text-slate-800">Order #{order.id}</p>
              <p className="text-sm text-slate-500">
                {order.totalProducts} products · {order.totalQuantity} items
              </p>
            </div>
            <div className="flex items-center gap-3">
              <span className="font-semibold text-slate-900">
                {formatPrice(order.discountedTotal)}
              </span>
              <button
                type="button"
                onClick={() => handleCancelOrder(order.id)}
                className="text-sm text-red-600 hover:underline"
              >
                Cancel
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}
