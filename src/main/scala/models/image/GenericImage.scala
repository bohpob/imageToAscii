package models.image

import models.grid.PixelGrid
import models.pixel.Pixel

/**
 * The abstract class `GenericImage` serves as a base class for image representations, parameterized by a specific type of pixel `P`.
 *
 * @param pixelGrid The underlying `PixelGrid` containing the pixels of the image.
 * @tparam P The type of pixels in the image, constrained to a subtype of `Pixel`.
 */
abstract class GenericImage[P <: Pixel](pixelGrid: PixelGrid[P])
    extends Image[P] {

  /**
   * Gets the height of the generic image.
   *
   * @return The height of the image, delegated to the height of the underlying pixel grid.
   */
  override def getHeight: Int = pixelGrid.getHeight

  /**
   * Gets the width of the generic image.
   *
   * @return The width of the image, delegated to the width of the underlying pixel grid.
   */
  override def getWidth: Int = pixelGrid.getWidth

  /**
   * Gets the pixel at the specified coordinates in the generic image.
   *
   * @param y The y-coordinate.
   * @param x The x-coordinate.
   * @return The pixel of type `P` at the specified coordinates, delegated to the pixel grid.
   */
  override def getPixel(y: Int, x: Int): P = pixelGrid.getPixel(y, x)

  /**
   * Gets the underlying pixel grid of the generic image.
   *
   * @return The `PixelGrid` containing the pixels of the image.
   */
  override def getPixelGrid: PixelGrid[P] = pixelGrid

  /**
   * Gets the pixels of the generic image as a 2D array.
   *
   * @return A 2D array representation of the pixels in the image.
   */
  override def getPixels: Array[Array[P]] = pixelGrid.toArray
}
