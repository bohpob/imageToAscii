package importers.image.rgb

import models.grid.PixelGrid
import models.image.RGBImage
import models.pixel.RGBPixel

import java.awt.Color
import scala.util.Random

/**
 * A class that generates a random RGBImage.
 */
class RGBImageRandomizer extends RGBImageImporter {

  /**
   * Generates a random RGBImage.
   *
   * @return A random RGBImage.
   */
  override def importData(): RGBImage = {
    val width = Random.nextInt(500) + 100
    val height = Random.nextInt(500) + 100

    val pixels: Array[Array[RGBPixel]] = Array.ofDim[RGBPixel](height, width)

    for (y <- 0 until height)
      for (x <- 0 until width) {
        val pixel = new Color(
          Random.nextInt(256),
          Random.nextInt(256),
          Random.nextInt(256))
        pixels(y)(x) = RGBPixel(pixel.getRed, pixel.getGreen, pixel.getBlue)
      }

    new RGBImage(PixelGrid(pixels))
  }
}
