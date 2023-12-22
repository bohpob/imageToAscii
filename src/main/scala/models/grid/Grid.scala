package models.grid

/**
 * A trait representing a grid of elements of type T.
 * The grid has a defined height and width, and each position (x, y) on the grid contains a pixel of type T.
 *
 * @tparam T The type of elements in the grid.
 */
trait Grid[T] {
  val grid: Array[Array[T]]

  /**
   * Gets the height of the grid.
   *
   * @return The height of the grid.
   */
  def getHeight: Int

  /**
   * Gets the width of the grid.
   *
   * @return The width of the grid.
   */
  def getWidth: Int

  /**
   * Gets the element at the specified position (y, x) on the grid.
   *
   * @param x The x-coordinate of the position.
   * @param y The y-coordinate of the position.
   * @return The element of type T at the specified position.
   */
  def getPixel(y: Int, x: Int): T

  /**
   * Converts the pixel grid to a 2D array.
   *
   * @return A 2D array representation of the pixel grid.
   */
  def toArray: Array[Array[T]]

  /**
   * Retrieves the array of pixels representing the entire row at the specified vertical position (y) in the pixel grid.
   *
   * @param y The vertical position (row) for which to retrieve the array of pixels.
   * @return An array representing the entire row of pixels at the specified vertical position.
   */
  def apply(y: Int): Array[T]
}
