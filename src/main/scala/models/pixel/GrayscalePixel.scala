package models.pixel

/**
 * A case class representing a grayscale pixel with a single intensity value.
 *
 * @param grayscale The intensity value of the grayscale pixel (0 to 255).
 */
case class GrayscalePixel(grayscale: Int) extends Pixel {

  /**
   * Checks if the grayscale pixel's intensity value is within valid range (0 to 255).
   *
   * @return True if the intensity value is within the valid range, false otherwise.
   */
  override def valid: Boolean = grayscale >= 0 && grayscale <= 255
}
