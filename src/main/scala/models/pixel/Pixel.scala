package models.pixel

/**
 * The Pixel trait is a generic trait representing a pixel in an image.
 * */
trait Pixel {

  /**
   * Checks the validity of the pixel.
   *
   * @return true if the pixel is considered valid, false otherwise.
   */
  def valid: Boolean
}
