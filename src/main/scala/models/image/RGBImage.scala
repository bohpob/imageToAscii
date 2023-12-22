package models.image

import models.grid.PixelGrid
import models.pixel.RGBPixel

/**
 * RGBImage is a class representing an image composed of RGB pixels.
 *
 * @param pixelGrid The PixelGrid contains the RGB pixels of the image.
 * */
class RGBImage(pixelGrid: PixelGrid[RGBPixel])
    extends GenericImage[RGBPixel](pixelGrid) {

  /**
   * Applies a transformation function to each RGB pixel in the image and returns a new RGBImage with the modified pixels.
   *
   * This method overrides the `map` method in the parent class `GenericImage`, providing specific implementation for RGB images.
   *
   * @param f The transformation function to be applied to each RGB pixel.
   * @return A new `RGBImage` with pixels modified according to the specified transformation function.
   */
  override def map(f: RGBPixel => RGBPixel): RGBImage = {
    val newMatrix = pixelGrid.grid.map { row =>
      row.map { pixel =>
        f(pixel)
      }
    }
    new RGBImage(PixelGrid(newMatrix))
  }
}
