package exporters

/**
 * The `Exporter` trait defines an interface for exporting data of type `T`.
 *
 * @tparam T The type parameter representing the data type to be exported.
 */
trait Exporter[T] {

  /**
   * Exports the specified data item of type `T`.
   *
   * This method provides a generic interface for exporting data and should be implemented by concrete exporter classes.
   *
   * @param item The data item to be exported.
   */
  def exportData(item: T): Unit
}
