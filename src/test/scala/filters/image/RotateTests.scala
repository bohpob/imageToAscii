package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage
import models.pixel.GrayscalePixel
import org.scalatest.FunSuite

class RotateTests extends FunSuite {
  test("Rotate angel must be a multiply of 90") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    assertThrows[Exception] {
      new Rotate(45).filter(image)
    }
  }

  test("Rotate image by 90 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(128), GrayscalePixel(0)),
          Array(GrayscalePixel(64), GrayscalePixel(255))
        )))

    val result = new Rotate(90).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by 180 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(64), GrayscalePixel(128)),
          Array(GrayscalePixel(255), GrayscalePixel(0))
        )))

    val result = new Rotate(180).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by 270 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(255), GrayscalePixel(64)),
          Array(GrayscalePixel(0), GrayscalePixel(128))
        )))

    val result = new Rotate(270).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by 360 degrees") {
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

    val result = new Rotate(360).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by -90 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(255), GrayscalePixel(64)),
          Array(GrayscalePixel(0), GrayscalePixel(128))
        )))

    val result = new Rotate(-90).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by -180 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(64), GrayscalePixel(128)),
          Array(GrayscalePixel(255), GrayscalePixel(0))
        )))

    val result = new Rotate(-180).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by -270 degrees") {
    val image = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(128), GrayscalePixel(64))
        )))
    val expected = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(128), GrayscalePixel(0)),
          Array(GrayscalePixel(64), GrayscalePixel(255))
        )))

    val result = new Rotate(-270).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }

  test("Rotate image by -360 degrees") {
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

    val result = new Rotate(-360).filter(image)
    assert(
      result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(
      result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }
}
