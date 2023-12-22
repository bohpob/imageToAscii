package models.image

import models.grid.PixelGrid
import models.pixel.GrayscalePixel

/**
 * The `GrayscaleImage` class represents an image composed of grayscale pixels.
 *
 * @param pixelGrid The `PixelGrid` containing the grayscale pixels of the image.
 */
class GrayscaleImage(pixelGrid: PixelGrid[GrayscalePixel])
    extends GenericImage[GrayscalePixel](pixelGrid) {

  /**
   * Applies a transformation function to each grayscale pixel in the image and returns a new GrayscaleImage with the modified pixels.
   *
   * This method overrides the `map` method in the parent class `GenericImage`, providing specific implementation for grayscale images.
   *
   * @param f The transformation function to be applied to each grayscale pixel.
   * @return A new `GrayscaleImage` with pixels modified according to the specified transformation function.
   */
  override def map(f: GrayscalePixel => GrayscalePixel): GrayscaleImage = {
    val newMatrix = pixelGrid.grid.map { row =>
      row.map { pixel =>
        f(pixel)
      }
    }
    new GrayscaleImage(PixelGrid(newMatrix))
  }
}
