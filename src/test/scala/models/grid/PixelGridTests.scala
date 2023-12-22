package models.grid

import models.pixel.{GrayscalePixel, Pixel, RGBPixel}
import org.scalatest.FunSuite

class PixelGridTests extends FunSuite {
  test("PixelMatrixTest") {
    val pixelMatrix = PixelGrid(
      Array(
        Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
        Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6))
      ))
    assert(pixelMatrix.getWidth == 3)
    assert(pixelMatrix.getHeight == 2)
    assert(pixelMatrix(0).head == GrayscalePixel(1))
    assert(pixelMatrix(0)(1) == GrayscalePixel(2))
    assert(pixelMatrix(0)(2) == GrayscalePixel(3))
    assert(pixelMatrix(1).head == GrayscalePixel(4))
    assert(pixelMatrix(1)(1) == GrayscalePixel(5))
    assert(pixelMatrix(1)(2) == GrayscalePixel(6))
  }

  test("PixelMatrix apply test") {
    val pixelMatrix = PixelGrid(
      Array(
        Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
        Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6))
      ))
    assert(
      pixelMatrix(0) === Array(
        GrayscalePixel(1),
        GrayscalePixel(2),
        GrayscalePixel(3)))
    assert(
      pixelMatrix(1) === Array(
        GrayscalePixel(4),
        GrayscalePixel(5),
        GrayscalePixel(6)))
  }

  test("PixelMatrix getWidth test") {
    val pixelMatrix = PixelGrid(
      Array(
        Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
        Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6))
      ))
    assert(pixelMatrix.getWidth === 3)
  }

  test("PixelMatrix getHeight test") {
    val pixelMatrix = PixelGrid(
      Array(
        Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
        Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6))
      ))
    assert(pixelMatrix.getHeight === 2)
  }

  test("PixelMatrix single column") {
    val singleColumnMatrix = PixelGrid(
      Array(
        Array(GrayscalePixel(1)),
        Array(GrayscalePixel(2)),
        Array(GrayscalePixel(3))))
    assert(singleColumnMatrix.getWidth == 1)
    assert(singleColumnMatrix.getHeight == 3)
  }

  test("PixelMatrix single row") {
    val singleRowMatrix = PixelGrid(
      Array(Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3))))
    assert(singleRowMatrix.getWidth == 3)
    assert(singleRowMatrix.getHeight == 1)
  }

  test("PixelMatrix empty array") {
    val emptyMatrix = PixelGrid(Array.ofDim[GrayscalePixel](0, 0))
    assert(emptyMatrix.getWidth == 0)
    assert(emptyMatrix.getHeight == 0)
  }
}
