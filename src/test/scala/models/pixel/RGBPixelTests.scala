package models.pixel

import org.scalatest.FunSuite

class RGBPixelTests extends FunSuite {
  test("RGBPixel.getValue") {
    val pixel = RGBPixel(1, 2, 3)
    assert(pixel.getValue == (1, 2, 3))
  }

  test("RGBPixel valid should return true for valid values") {
    val pixel = RGBPixel(128, 64, 192)
    assert(pixel.valid)
  }

  test("RGBPixel valid should return false for negative red value") {
    val pixel = RGBPixel(-1, 64, 192)
    assert(!pixel.valid)
  }

  test("RGBPixel valid should return false for red value exceeding 255") {
    val pixel = RGBPixel(256, 64, 192)
    assert(!pixel.valid)
  }

  test("RGBPixel valid should return false for negative green value") {
    val pixel = RGBPixel(128, -1, 192)
    assert(!pixel.valid)
  }

  test("RGBPixel valid should return false for green value exceeding 255") {
    val pixel = RGBPixel(128, 256, 192)
    assert(!pixel.valid)
  }

  test("RGBPixel valid should return false for negative blue value") {
    val pixel = RGBPixel(128, 64, -1)
    assert(!pixel.valid)
  }

  test("RGBPixel valid should return false for blue value exceeding 255") {
    val pixel = RGBPixel(128, 64, 256)
    assert(!pixel.valid)
  }
}
