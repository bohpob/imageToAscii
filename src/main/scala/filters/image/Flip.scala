package filters.image

import filters.FlipAxis
import models.grid.PixelGrid
import models.image.GrayscaleImage

/**
 * Flip filter
 * @param axis FlipAxis
 */
class Flip(axis: FlipAxis.Value) extends GrayscaleImageFilter {

  /**
   * Flip the image on the given axis
   * @param item Image to flip
   * @return New flipped image
   */
  override def filter(item: GrayscaleImage): GrayscaleImage =
    if (FlipAxis.XAxis == axis)
      new GrayscaleImage(PixelGrid(item.getPixelGrid.grid.reverse))
    else
      new GrayscaleImage(
        PixelGrid(item.getPixelGrid.grid.map(row => row.reverse)))

  /**
   * Returns the axis to flip by
   * @return FlipAxis
   */
  def getAxis: FlipAxis.Value = axis
}
