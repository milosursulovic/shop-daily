import { useState } from 'react'
import { addProduct, deleteProduct, updateProduct } from '../api/products'
import type { Product } from '../types'
import { formatPrice } from '../lib/utils'

const emptyForm = { title: '', price: '', category: '', stock: '' }

export function SellPage() {
  const [listings, setListings] = useState<Product[]>([])
  const [form, setForm] = useState(emptyForm)
  const [editingId, setEditingId] = useState<number | null>(null)
  const [saving, setSaving] = useState(false)

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault()
    setSaving(true)
    const payload = {
      title: form.title,
      price: Number(form.price),
      category: form.category,
      stock: Number(form.stock),
    }
    try {
      if (editingId) {
        const updated = await updateProduct(editingId, payload)
        setListings((prev) =>
          prev.map((p) => (p.id === editingId ? { ...p, ...updated } : p)),
        )
      } else {
        const created = await addProduct(payload)
        setListings((prev) => [{ ...created, id: created.id ?? Date.now() }, ...prev])
      }
      setForm(emptyForm)
      setEditingId(null)
    } finally {
      setSaving(false)
    }
  }

  function startEdit(product: Product) {
    setEditingId(product.id)
    setForm({
      title: product.title,
      price: String(product.price),
      category: product.category,
      stock: String(product.stock),
    })
  }

  async function handleDelete(id: number) {
    await deleteProduct(id)
    setListings((prev) => prev.filter((p) => p.id !== id))
    if (editingId === id) {
      setEditingId(null)
      setForm(emptyForm)
    }
  }

  return (
    <div className="mx-auto max-w-3xl px-4 py-8">
      <h1 className="mb-1 text-xl font-semibold text-slate-900">My listings</h1>
      <p className="mb-6 text-sm text-slate-500">
        Demonstrates DummyJSON's simulated <code>POST/PUT/DELETE /products</code> — changes
        are local-only, the API doesn't persist them server-side.
      </p>

      <form
        onSubmit={handleSubmit}
        className="mb-8 grid grid-cols-1 gap-3 rounded-md border border-slate-200 p-4 sm:grid-cols-2"
      >
        <input
          required
          placeholder="Title"
          value={form.title}
          onChange={(e) => setForm({ ...form, title: e.target.value })}
          className="rounded-md border border-slate-300 px-3 py-1.5"
        />
        <input
          required
          placeholder="Category"
          value={form.category}
          onChange={(e) => setForm({ ...form, category: e.target.value })}
          className="rounded-md border border-slate-300 px-3 py-1.5"
        />
        <input
          required
          type="number"
          placeholder="Price"
          value={form.price}
          onChange={(e) => setForm({ ...form, price: e.target.value })}
          className="rounded-md border border-slate-300 px-3 py-1.5"
        />
        <input
          required
          type="number"
          placeholder="Stock"
          value={form.stock}
          onChange={(e) => setForm({ ...form, stock: e.target.value })}
          className="rounded-md border border-slate-300 px-3 py-1.5"
        />
        <div className="sm:col-span-2 flex gap-3">
          <button
            type="submit"
            disabled={saving}
            className="rounded-md bg-indigo-600 px-4 py-2 text-sm font-medium text-white hover:bg-indigo-700 disabled:opacity-60"
          >
            {editingId ? 'Update listing' : 'Add listing'}
          </button>
          {editingId && (
            <button
              type="button"
              onClick={() => {
                setEditingId(null)
                setForm(emptyForm)
              }}
              className="rounded-md border border-slate-300 px-4 py-2 text-sm"
            >
              Cancel edit
            </button>
          )}
        </div>
      </form>

      {listings.length === 0 && (
        <p className="text-sm text-slate-500">No listings yet — add one above.</p>
      )}
      <div className="flex flex-col gap-2">
        {listings.map((p) => (
          <div
            key={p.id}
            className="flex items-center justify-between rounded-md border border-slate-200 p-3"
          >
            <div>
              <p className="font-medium text-slate-800">{p.title}</p>
              <p className="text-sm text-slate-500 capitalize">
                {p.category} · {formatPrice(p.price)} · stock {p.stock}
              </p>
            </div>
            <div className="flex gap-3 text-sm">
              <button type="button" onClick={() => startEdit(p)} className="text-indigo-600">
                Edit
              </button>
              <button
                type="button"
                onClick={() => handleDelete(p.id)}
                className="text-red-600"
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}
