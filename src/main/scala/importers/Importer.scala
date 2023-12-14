package importers

trait Importer[T] {
  def importData(): T
}
