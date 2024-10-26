package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage

/**
 * Rotate image by given angle
 * @param angle Angle in degrees
 */
class Rotate(var angle: Int) extends GrayscaleImageFilter {

  /**
   * Rotate image by given angle
   * @param image Image to rotate
   * @return Rotated image
   */
  override def filter(image: GrayscaleImage): GrayscaleImage = {
    angle = angle % 360

    if (angle % 90 != 0)
      throw new Exception("Rotation degree must be a multiply of 90")

    if (angle < 0)
      angle += 360

    var resultImage = image

    val count = Math.abs(angle) / 90

    for (_ <- 0 until count)
      resultImage = rotateClockwise(resultImage)

    resultImage
  }

  /**
   * Rotate image clockwise
   * @param image Image to rotate
   * @return Rotated image
   */
  private def rotateClockwise(image: GrayscaleImage): GrayscaleImage = {
    var transposedArray = image.getPixelGrid.grid.transpose
    transposedArray = transposedArray.map(row => row.reverse)
    new GrayscaleImage(PixelGrid(transposedArray))
  }

  /**
   * Get angle
   * @return Angle
   */
  def getAngle: Int = angle
}
