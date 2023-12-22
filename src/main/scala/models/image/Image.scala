package models.image

import models.grid.PixelGrid
import models.pixel.Pixel

/**
 * The `Image` trait is a generic trait representing an image.
 *
 * @tparam P The type parameter representing the pixel type of the image.
 */
trait Image[P <: Pixel] {

  /**
   * Gets the height of the image.
   *
   * @return The height of the image.
   */
  def getHeight: Int

  /**
   * Gets the width of the image.
   *
   * @return The width of the image.
   */
  def getWidth: Int

  /**
   * Gets the pixel at the specified coordinates in the image.
   *
   * @param y The y-coordinate.
   * @param x The x-coordinate.
   * @return The pixel of type `P` at the specified coordinates.
   */
  def getPixel(y: Int, x: Int): P

  /**
   * Gets the pixel grid associated with the image.
   *
   * @return The `PixelGrid` containing the pixels of the image.
   */
  def getPixelGrid: PixelGrid[P]

  /**
   * Gets the pixels of the image as a 2D array.
   *
   * @return A 2D array representation of the pixels in the image.
   */
  def getPixels: Array[Array[P]]

  /**
   * Applies a transformation function to each pixel in the image and returns a new image with the modified pixels.
   *
   * @param f The transformation function to be applied to each pixel.
   * @return A new image with pixels modified according to the specified transformation function.
   */
  def map(f: P => P): Image[P]
}
