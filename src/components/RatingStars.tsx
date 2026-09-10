interface Props {
  rating: number
}

export function RatingStars({ rating }: Props) {
  const rounded = Math.round(rating)
  return (
    <span className="inline-flex items-center gap-1 text-amber-500 text-sm">
      <span aria-hidden="true">{'★'.repeat(rounded)}{'☆'.repeat(5 - rounded)}</span>
      <span className="text-slate-500">{rating.toFixed(2)}</span>
    </span>
  )
}
