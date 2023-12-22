package filters

/**
 * A trait representing a generic filter, which transforms an input item of type T
 * into an output item of type P.
 *
 * @tparam T The type of the input item.
 * @tparam P The type of the output item.
 */
trait Filter[T, P] {

  /**
   * Applies the filter to an input item and produces a modified output item.
   *
   * @param item The input item to which the filter will be applied.
   * @return A new item resulting from the application of the filter.
   */
  def filter(item: T): P
}
