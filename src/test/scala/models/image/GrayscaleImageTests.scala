package models.image

import models.grid.PixelGrid
import models.pixel.GrayscalePixel
import org.scalatest.FunSuite

class GrayscaleImageTests extends FunSuite {
  test("Map function on a single-pixel GrayscaleImage") {
    val singlePixelImage =
      new GrayscaleImage(PixelGrid(Array(Array(GrayscalePixel(0)))))
    val result = singlePixelImage.map(_ => GrayscalePixel(1))
    assert(result.getHeight == 1)
    assert(result.getWidth == 1)
    assert(result.getPixel(0, 0) == GrayscalePixel(1))
  }

  test("Map function on a 2x2 GrayscaleImage") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(0)),
          Array(GrayscalePixel(0), GrayscalePixel(0)))
      )
    )
    val result = image.map(_ => GrayscalePixel(2))
    assert(result.getHeight == 2)
    assert(result.getWidth == 2)
    assert(result.getPixel(0, 0) == GrayscalePixel(2))
    assert(result.getPixel(0, 1) == GrayscalePixel(2))
    assert(result.getPixel(1, 0) == GrayscalePixel(2))
    assert(result.getPixel(1, 1) == GrayscalePixel(2))
  }

  test("Map function on an empty GrayscaleImage") {
    val emptyImage =
      new GrayscaleImage(PixelGrid(Array.ofDim[GrayscalePixel](0, 0)))
    val result = emptyImage.map(_ => GrayscalePixel(5))
    assert(result.getHeight == 0)
    assert(result.getWidth == 0)
  }

}
