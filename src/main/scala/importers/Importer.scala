package importers

/**
 * The Importer trait represents a generic data importer.
 * It provides a common interface for classes that handle the import of data, producing a result of type T.
 *
 * @tparam T The type parameter represents the result type of the data import.
 * */
trait Importer[T] {

  /**
   * The specific implementation of this method should handle the details of data import.
   *
   * @return The imported data of type T.
   * */
  def importData(): T
}
