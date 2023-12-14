package models.pixel

/**
 * The RGBPixel case class represents a pixel in an image with RGB color values.
 *
 * @param red   The red color component of the pixel (0-255).
 * @param green The green color component of the pixel (0-255).
 * @param blue  The blue color component of the pixel (0-255).
 */
case class RGBPixel(red: Int, green: Int, blue: Int) extends Pixel {
  override def valid: Boolean =
    red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255
}
