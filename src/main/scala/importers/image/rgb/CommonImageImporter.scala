package importers.image.rgb

import models.grid.PixelGrid
import models.image.RGBImage
import models.pixel.RGBPixel

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

/**
 * RGBImageImporterFromPath specializes in importing RGB images from a specified file path.
 *
 * @param file The file to be imported.
 * */
class CommonImageImporter(val file: File, validExtensions: Seq[String])
    extends RGBImageImporter {
  if (!validExtensions.exists(file.getName.endsWith))
    throw new Exception(
      s"Invalid file format. Expected one of: ${validExtensions.mkString(", ")}")

  /**
   * Imports RGB image data from the specified file path.
   *
   * @return The RGBImage object containing RGBPixel data representing the imported image.
   * */
  override def importData(): RGBImage =
    try {
      val image = readFile(file)

      if (image.isEmpty)
        throw new Exception("Empty image")

      val pixels = readPixels(image.get)

      val pixelGrid = new PixelGrid[RGBPixel](pixels)

      new RGBImage(pixelGrid)
    } catch {
      case e: Exception => throw new Exception("Couldn't import")
    }

  /**
   * Reads RGB pixels from a BufferedImage.
   *
   * @param image The BufferedImage from which to read RGB pixels.
   * @return A 2D array of RGBPixel representing the RGB values of the image.
   */
  private def readPixels(image: BufferedImage): Array[Array[RGBPixel]] = {
    val height = image.getHeight
    val width = image.getWidth

    val pixels: Array[Array[RGBPixel]] = Array.ofDim[RGBPixel](height, width)

    for (y <- 0 until height)
      for (x <- 0 until width) {
        val color = new Color(image.getRGB(x, y))

        pixels(y)(x) = RGBPixel(color.getRed, color.getGreen, color.getBlue)
      }

    pixels
  }
}
