package filters.image

import filters.Filter
import models.grid.PixelGrid
import models.image.{GrayscaleImage, RGBImage}
import models.pixel.GrayscalePixel

/**
 * Filter that converts an RGB image to a grayscale image.
 */
class GrayscaleFilter extends Filter[RGBImage, GrayscaleImage] {

  /**
   * Converts an RGB image to a grayscale image.
   * @param image RGB image to be converted
   * @return Grayscale image converted from the RGB image
   */
  override def filter(image: RGBImage): GrayscaleImage = {

    val width = image.getWidth
    val height = image.getHeight

    val grayscale_pixels: Array[Array[GrayscalePixel]] =
      Array.ofDim[GrayscalePixel](height, width)

    for (y <- 0 until height)
      for (x <- 0 until width) {
        val pixel = image.getPixel(y, x)

        val red = pixel.red
        val green = pixel.green
        val blue = pixel.blue

        val grayscalePixel = 0.3 * red + 0.59 * green + 0.11 * blue
        grayscale_pixels(y)(x) = GrayscalePixel(grayscalePixel.toInt)
      }

    new GrayscaleImage(PixelGrid(grayscale_pixels))
  }
}
