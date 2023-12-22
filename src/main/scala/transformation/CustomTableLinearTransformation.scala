package transformation

import models.grid.PixelGrid
import models.image.{ASCIIImage, GrayscaleImage}
import models.pixel.ASCIIPixel

/**
 * Custom linear transformation. The table is a string of characters.
 *
 * @param table The table of characters.
 */
class CustomTableLinearTransformation(table: String)
    extends GrayscaleToASCIITransformation {

  /**
   * Transforms a grayscale image into an ASCII art.
   * @param image The grayscale image.
   * @return The ASCII art.
   */
  override def transform(image: GrayscaleImage): ASCIIImage = {

    val symbols_count = table.length

    if (symbols_count == 0)
      throw new IllegalArgumentException(
        "The table must contain at least one character.")

    val ascii_pixels: Array[Array[ASCIIPixel]] =
      Array.ofDim[ASCIIPixel](image.getHeight, image.getWidth)

    for (y <- 0 until image.getHeight)
      for (x <- 0 until image.getWidth) {
        val grayscaleValue = image.getPixel(y, x).grayscale
        val symbolIndex = (grayscaleValue * (symbols_count - 1) / 255)
        ascii_pixels(y)(x) = ASCIIPixel(table.charAt(symbolIndex))
      }

    new ASCIIImage(PixelGrid(ascii_pixels))
  }

  /**
   * Returns the transformation table.
   * @return The transformation table.
   */
  def getTable: String = table
}
