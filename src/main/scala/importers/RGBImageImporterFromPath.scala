package importers

import models.image.{Image, RGBImage}
import models.pixel.{PixelGrid, RGBPixel}

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

/**
 *  RGBImageImporterFromPath specializes in importing RGB images from a specified file path.
 *
 *  @param path The path to the file from which the RGB image is imported.
 * */
class RGBImageImporterFromPath(val path: String) extends RGBImageImporter {

  /**
   * Imports RGB image data from the specified file path.
   *
   * @return The image object containing RGBPixel data representing the imported image.
   * */
  override def importData(): Image[RGBPixel] = {
    val image = readFile(new File(path))

    val pixels = readPixels(image)

    val pixelGrid = PixelGrid[RGBPixel](pixels)

    RGBImage(pixelGrid)
  }

  /**
   * Reads an image file from the specified File.
   *
   * @param file The File object representing the image file.
   * @return A BufferedImage containing the image data.
   */
  private def readFile(file: File): BufferedImage =
    ImageIO.read(file)

  /**
   * Reads RGB pixels from a BufferedImage.
   *
   * @param image The BufferedImage from which to read RGB pixels.
   * @return A 2D array of RGBPixel representing the RGB values of the image.
   */
  private def readPixels(image: BufferedImage): Array[Array[RGBPixel]] = {
    val height = image.getHeight
    val width = image.getWidth
    val pixels = Array.ofDim[RGBPixel](height, width)

    for (y <- 0 until height)
      for (x <- 0 until width) {
        val color = new Color(image.getRGB(x, y))
        val rgbPixel = RGBPixel(color.getRed, color.getGreen, color.getBlue)
        pixels(y)(x) = rgbPixel
      }
    pixels
  }
}
