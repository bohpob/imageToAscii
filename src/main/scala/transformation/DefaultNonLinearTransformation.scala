package transformation

import models.grid.PixelGrid
import models.image.{ASCIIImage, GrayscaleImage}
import models.pixel.ASCIIPixel

/**
 * Default non-linear transformation.
 */
class DefaultNonLinearTransformation extends GrayscaleToASCIITransformation {
  val table = " .:-=+*#%@"
  val intensity: Array[Int] =
    Array(50, 100, 150, 175, 190, 210, 230, 240, 250, 255)

  /**
   * Transforms a grayscale image into an ASCII art.
   * @param image The grayscale image to transform.
   * @return The transformed image.
   */
  override def transform(image: GrayscaleImage): ASCIIImage = {
    val ascii_pixels: Array[Array[ASCIIPixel]] =
      Array.ofDim[ASCIIPixel](image.getHeight, image.getWidth)

    for (y <- 0 until image.getHeight)
      for (x <- 0 until image.getWidth) {
        val grayscaleValue = image.getPixel(y, x).grayscale
        val symbolIndex = intensity.indexWhere(_ >= grayscaleValue)
        ascii_pixels(y)(x) = ASCIIPixel(table.charAt(symbolIndex))
      }

    new ASCIIImage(PixelGrid(ascii_pixels))
  }
}
