package transformation

/**
 * Trait for transformation
 * @tparam T Type of input
 * @tparam P Type of output
 */
trait Transformation[T, P] {

  /**
   * Transforms an item of type T into an item of type P.
   * @param item The item to transform.
   * @return The transformed item.
   */
  def transform(item: T): P
}
