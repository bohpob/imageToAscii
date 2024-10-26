package models.image

import models.grid.PixelGrid
import models.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBImageTests extends FunSuite {
  test("Map function on a single-pixel RGBImage") {
    val singlePixelImage =
      new RGBImage(PixelGrid(Array(Array(RGBPixel(255, 0, 0)))))
    val result = singlePixelImage.map(pixel => RGBPixel(0, 255, 0))
    assert(result.getHeight == 1)
    assert(result.getWidth == 1)
    assert(result.getPixel(0, 0) == RGBPixel(0, 255, 0))
  }

  test("Map function on a 2x2 RGBImage") {
    val image = new RGBImage(
      PixelGrid(
        Array(
          Array(RGBPixel(255, 0, 0), RGBPixel(255, 0, 0)),
          Array(RGBPixel(255, 0, 0), RGBPixel(255, 0, 0)))
      )
    )
    val result = image.map(_ => RGBPixel(0, 255, 0))
    assert(result.getHeight == 2)
    assert(result.getWidth == 2)
    assert(result.getPixel(0, 0) == RGBPixel(0, 255, 0))
    assert(result.getPixel(0, 1) == RGBPixel(0, 255, 0))
    assert(result.getPixel(1, 0) == RGBPixel(0, 255, 0))
    assert(result.getPixel(1, 1) == RGBPixel(0, 255, 0))
  }

  test("Map function on an empty RGBImage") {
    val emptyImage = new RGBImage(PixelGrid(Array.ofDim[RGBPixel](0, 0)))
    val result = emptyImage.map(_ => RGBPixel(255, 255, 255))
    assert(result.getHeight == 0)
    assert(result.getWidth == 0)
  }
}
