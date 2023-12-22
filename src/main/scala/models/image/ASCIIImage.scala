package models.image

import models.grid.PixelGrid
import models.pixel.ASCIIPixel

/**
 * The `ASCIIImage` class represents an image composed of ASCII pixels.
 *
 * @param pixelGrid The `PixelGrid` containing the ASCII pixels of the image.
 */
class ASCIIImage(pixelGrid: PixelGrid[ASCIIPixel])
    extends GenericImage[ASCIIPixel](pixelGrid) {

  /**
   * Applies a transformation function to each ASCII pixel in the image and returns a new ASCIIImage with the modified pixels.
   *
   * This method overrides the `map` method in the parent class `GenericImage`, providing specific implementation for ASCII images.
   *
   * @param f The transformation function to be applied to each ASCII pixel.
   * @return A new `ASCIIImage` with pixels modified according to the specified transformation function.
   */
  override def map(f: ASCIIPixel => ASCIIPixel): ASCIIImage = {
    val newMatrix = pixelGrid.grid.map { row =>
      row.map { pixel =>
        f(pixel)
      }
    }
    new ASCIIImage(PixelGrid(newMatrix))
  }

  override def toString: String = {
    var ascii_string = ""

    for (y <- getPixelGrid.toArray.indices) {
      for (x <- getPixelGrid.toArray(y).indices)
        ascii_string += getPixel(y, x)
      ascii_string += "\n"
    }

    ascii_string
  }
}
