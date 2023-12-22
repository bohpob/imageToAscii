package filters

trait Filter[T, P] {
  def filter(item: T): P
}
