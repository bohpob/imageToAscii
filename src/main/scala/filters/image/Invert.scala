package filters.image

import models.image.GrayscaleImage
import models.pixel.GrayscalePixel

/**
 * Inverts the colors of an image.
 */
class Invert extends GrayscaleImageFilter {

  /**
   * Inverts the intensity of an image.
   * @param item Input item
   *  @return New image with inverted intensity
   */
  override def filter(item: GrayscaleImage): GrayscaleImage =
    item.map(invert)

  /**
   * Inverts the intensity of a pixel.
   * @param pixel Input pixel
   * @return New pixel with inverted intensity
   */
  private def invert(pixel: GrayscalePixel): GrayscalePixel =
    GrayscalePixel(Math.max(0, (255 - pixel.grayscale) % 256))
}
