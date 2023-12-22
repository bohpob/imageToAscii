package models.pixel

/**
 * A class representing a pixel in ASCII image.
 *
 * @param char The ASCII character representing the pixel.
 */
case class ASCIIPixel(char: Char) extends Pixel {

  /**
   * Checks if the ASCII character is within the printable ASCII range.
   *
   * In ASCII, printable characters have decimal values between 32 and 126 inclusive.
   *
   * @return True if the character is printable, false otherwise.
   */
  override def valid: Boolean = char >= 32 && char <= 126

  override def toString: String = char.toString
}
