package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage
import models.pixel.GrayscalePixel
import org.scalatest.FunSuite

class BrightnessTests extends FunSuite {
  test("BrightnessTest Normal") {
    val image = new GrayscaleImage(new PixelGrid[GrayscalePixel](
      Array(Array(GrayscalePixel(0), GrayscalePixel(245)),
        Array(GrayscalePixel(128), GrayscalePixel(64)))
    ))
    val brightness = new Brightness(10)
    val newImage = brightness.filter(image)
    assert(newImage.getPixel(0, 0).grayscale == 10)
    assert(newImage.getPixel(0, 1).grayscale == 255)
    assert(newImage.getPixel(1, 0).grayscale == 138)
    assert(newImage.getPixel(1, 1).grayscale == 74)
  }

  test("BrightnessTest Positive Overflow") {
    val image = new GrayscaleImage(new PixelGrid[GrayscalePixel](
      Array(Array(GrayscalePixel(0), GrayscalePixel(255)),
        Array(GrayscalePixel(128), GrayscalePixel(64)))
    ))
    val brightness = new Brightness(10)
    val newImage = brightness.filter(image)
    assert(newImage.getPixel(0, 0).grayscale == 10)
    assert(newImage.getPixel(0, 1).grayscale == 255)
    assert(newImage.getPixel(1, 0).grayscale == 138)
    assert(newImage.getPixel(1, 1).grayscale == 74)
  }

  test("BrightnessTest Negative Overflow") {
    val image = new GrayscaleImage(new PixelGrid[GrayscalePixel](
      Array(Array(GrayscalePixel(0), GrayscalePixel(255)),
        Array(GrayscalePixel(128), GrayscalePixel(64)))
    ))
    val brightness = new Brightness(-10)
    val newImage = brightness.filter(image)
    assert(newImage.getPixel(0, 0).grayscale == 0)
    assert(newImage.getPixel(0, 1).grayscale == 245)
    assert(newImage.getPixel(1, 0).grayscale == 118)
    assert(newImage.getPixel(1, 1).grayscale == 54)
  }

  test("BrightnessTest Zero") {
    val image = new GrayscaleImage(new PixelGrid[GrayscalePixel](
      Array(Array(GrayscalePixel(0), GrayscalePixel(255)),
        Array(GrayscalePixel(128), GrayscalePixel(64)))
    ))
    val brightness = new Brightness(0)
    val newImage = brightness.filter(image)
    assert(newImage.getPixel(0, 0).grayscale == 0)
    assert(newImage.getPixel(0, 1).grayscale == 255)
    assert(newImage.getPixel(1, 0).grayscale == 128)
    assert(newImage.getPixel(1, 1).grayscale == 64)
  }
}
