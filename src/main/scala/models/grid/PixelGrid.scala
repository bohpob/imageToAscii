package models.grid

import models.pixel.Pixel

/**
 * A grid implementation representing a 2D array of pixels of type T.
 *
 * @param grid A 2D array of pixels representing the grid.
 * @tparam T The type of pixels in the grid, constrained to a subtype of Pixel.
 */
case class PixelGrid[T <: Pixel](grid: Array[Array[T]]) extends Grid[T] {

  /**
   * Gets the height of the pixel grid.
   *
   * @return The number of rows in the 2D array.
   */
  override def getHeight: Int =
    grid.length

  /**
   * Gets the width of the pixel grid.
   *
   * @throws Exception if the grid is empty.
   * @return The number of columns in the first row of the 2D array.
   */
  override def getWidth: Int =
    if (grid.length == 0) 0 else grid.head.length

  /**
   * Gets the pixel at the specified coordinates.
   *
   * @param x The x-coordinate.
   * @param y The y-coordinate.
   * @throws Exception if the coordinates are out of bounds.
   * @return The pixel at the specified coordinates.
   */
  override def getPixel(y: Int, x: Int): T = {
    if (y < 0 || y >= getHeight || x < 0 || x >= getWidth)
      throw new Exception(
        s"Coordinates ($x, $y) are out of bounds for the pixel grid.")
    grid(y)(x)
  }

  /**
   * Converts the pixel grid to a 2D array.
   *
   * @return A 2D sequence representation of the pixel grid.
   */
  override def toArray: Array[Array[T]] = grid

  /**
   * Retrieves the array of pixels representing the entire row at the specified vertical position (y) in the pixel grid.
   *
   * @param y The vertical position (row) for which to retrieve the array of pixels.
   * @return An array representing the entire row of pixels at the specified vertical position.
   */
  override def apply(y: Int): Array[T] = grid(y)
}
