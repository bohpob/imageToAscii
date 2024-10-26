package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage
import models.pixel.GrayscalePixel
import org.scalatest.FunSuite

class ScaleTests extends FunSuite {
  test("Scale filter should throw exception when factor is not supported") {
    val scale = new Scale(0.5)
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    assertThrows[Exception] {
      scale.filter(image)
    }
  }

  test("Scale filter should scale image by 0.25") {
    val scale = new Scale(0.25)
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected =
      new GrayscaleImage(PixelGrid(Array(Array(GrayscalePixel(0)))))

    val result = scale.filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
  }

  test("Scale filter should scale image by 4") {
    val scale = new Scale(4)
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(Array(
        Array(
          GrayscalePixel(0),
          GrayscalePixel(0),
          GrayscalePixel(255),
          GrayscalePixel(255)),
        Array(
          GrayscalePixel(0),
          GrayscalePixel(0),
          GrayscalePixel(255),
          GrayscalePixel(255)),
        Array(
          GrayscalePixel(128),
          GrayscalePixel(128),
          GrayscalePixel(64),
          GrayscalePixel(64)),
        Array(
          GrayscalePixel(128),
          GrayscalePixel(128),
          GrayscalePixel(64),
          GrayscalePixel(64))
      )))

    val result = scale.filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
    assert(
      result.getPixelGrid.grid(2) sameElements expected.getPixelGrid.grid(2))
    assert(
      result.getPixelGrid.grid(3) sameElements expected.getPixelGrid.grid(3))
  }

  test("Scale filter should scale image by 1") {
    val scale = new Scale(1)
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))

    val result = scale.filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }
}
