package filters.image

import models.grid.PixelGrid
import models.image.{GrayscaleImage, RGBImage}
import models.pixel.{GrayscalePixel, RGBPixel}
import org.scalatest.FunSuite

class GrayscaleFilterTests extends FunSuite {
  test("GrayscaleFilter should convert an RGB image to a grayscale image") {
    val rgbImage = new RGBImage(
      PixelGrid(
        Array(
          Array(RGBPixel(255, 0, 0), RGBPixel(0, 255, 0)),
          Array(RGBPixel(0, 0, 255), RGBPixel(255, 255, 255))
        )))

    val grayscaleImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(76), GrayscalePixel(150)),
          Array(GrayscalePixel(28), GrayscalePixel(255))
        )))

    val result = new GrayscaleFilter().filter(rgbImage)
    assert(
      result.getPixelGrid.grid(0) sameElements grayscaleImage.getPixelGrid.grid(
        0))
    assert(
      result.getPixelGrid.grid(1) sameElements grayscaleImage.getPixelGrid.grid(
        1))
  }
}
