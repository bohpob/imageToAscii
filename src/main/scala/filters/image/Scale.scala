package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage

/**
 * Scale filter
 * @param factor Scale factor
 */
class Scale(factor: Double) extends GrayscaleImageFilter {
  private val allowedFactors: Array[Double] = Array(0.25, 1, 4)

  /**
   * Scale image
   * @param image Image to scale
   * @return New scaled image
   */
  override def filter(image: GrayscaleImage): GrayscaleImage = {
    if (!allowedFactors.contains(factor))
      throw new Exception("Unsupported scale factor")

    var result = image

    if (factor == 0.25) {
      val removedColumns = image.getPixelGrid.grid.transpose
        .grouped(2)
        .map(_.head)
        .toArray
        .transpose
      val removedRows = removedColumns.grouped(2).map(_.head).toArray
      result = new GrayscaleImage(PixelGrid(removedRows))
    } else if (factor == 4) {
      val scaled = image.getPixelGrid.grid.flatMap { row =>
        Array.fill(2)(row.flatMap(col => Array.fill(2)(col)))
      }
      result = new GrayscaleImage(PixelGrid(scaled))
    }

    result
  }

  def getScale: Double = factor
}
