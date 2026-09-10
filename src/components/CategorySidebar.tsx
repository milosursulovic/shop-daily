import { NavLink } from 'react-router-dom'
import type { Category } from '../types'

interface Props {
  categories: Category[]
}

export function CategorySidebar({ categories }: Props) {
  return (
    <aside className="w-48 shrink-0">
      <h3 className="mb-2 text-sm font-semibold uppercase tracking-wide text-slate-400">
        Categories
      </h3>
      <nav className="flex flex-col gap-1">
        <NavLink
          to="/"
          end
          className={({ isActive }) =>
            `rounded-md px-2 py-1.5 text-sm capitalize ${
              isActive ? 'bg-indigo-50 text-indigo-700' : 'text-slate-600 hover:bg-slate-100'
            }`
          }
        >
          All products
        </NavLink>
        {categories.map((c) => (
          <NavLink
            key={c.slug}
            to={`/category/${c.slug}`}
            className={({ isActive }) =>
              `rounded-md px-2 py-1.5 text-sm capitalize ${
                isActive ? 'bg-indigo-50 text-indigo-700' : 'text-slate-600 hover:bg-slate-100'
              }`
            }
          >
            {c.name}
          </NavLink>
        ))}
      </nav>
    </aside>
  )
}
