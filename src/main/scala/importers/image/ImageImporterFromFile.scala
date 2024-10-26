package importers.image

import models.image.Image

import java.awt.image.BufferedImage
import java.io.{File, IOException}
import javax.imageio.ImageIO

/**
 * A trait representing an image importer that reads data from a file and imports it as a BufferedImage.
 */
trait ImageImporterFromFile[T <: Image[_]] extends ImageImporter[T] {

  /**
   * Reads a BufferedImage from the specified file.
   *
   * @param file The File object representing the image file.
   * @return The imported BufferedImage.
   * @throws Exception If there is an error reading the image file.
   */
  protected def readFile(file: File): Option[BufferedImage] =
    try {
      val image = ImageIO.read(file)

      if (image == null)
        throw new Exception("Failed to import image data.")

      Some(image)
    } catch {
      case ioe: IOException =>
        throw new Exception(s"Failed to read image from file: ${file.getPath}", ioe)
      case iae: IllegalArgumentException =>
        throw new Exception("Failed to import image data.", iae)
      case e: Exception =>
        throw new Exception("Couldn't import", e)
    }
}
