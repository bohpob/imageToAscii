package filters.image

import models.image.GrayscaleImage
import models.pixel.GrayscalePixel

/**
 * A filter that changes the brightness of an image.
 * @param value The value to change the brightness by.
 */
class Brightness(value: Int) extends GrayscaleImageFilter {

  /**
   * Changes the brightness of an image.
   * @param item Image to change
   * @return New image with changed brightness.
   */
  override def filter(item: GrayscaleImage): GrayscaleImage =
    item.map(brightness)

  /**
   * Changes the brightness of a pixel.
   * @param pixel Pixel to change
   * @return New pixel with changed brightness.
   */
  private def brightness(pixel: GrayscalePixel): GrayscalePixel =
    GrayscalePixel(Math.min(Math.max(0, pixel.grayscale + value), 255))

  /**
   * Returns the value of the brightness.
   * @return The value of the brightness.
   */
  def getBrightness: Int = value
}
