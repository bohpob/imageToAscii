package models.pixel

import org.scalatest.FunSuite

class GrayscalePixelTests extends FunSuite {
  test("GrayscalePixel.grayscale") {
    val pixel = GrayscalePixel(42)
    assert(pixel.grayscale == 42)
  }

  test("GrayscalePixel valid should return true for valid values") {
    val pixel = GrayscalePixel(128)
    assert(pixel.valid)
  }

  test("GrayscalePixel valid should return false for negative intensity value") {
    val pixel = GrayscalePixel(-1)
    assert(!pixel.valid)
  }

  test(
    "GrayscalePixel valid should return false for intensity value exceeding 255") {
    val pixel = GrayscalePixel(256)
    assert(!pixel.valid)
  }
}
