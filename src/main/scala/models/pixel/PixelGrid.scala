package models.pixel

/**
 * The PixelGrid case class represents a grid of pixels in an image.
 *
 * @param pixels A 2D array of generic type T, representing the pixels in the grid.
 *               Each element in the array corresponds to a pixel in the image.
 */
case class PixelGrid[T <: Pixel](pixels: Array[Array[T]])
