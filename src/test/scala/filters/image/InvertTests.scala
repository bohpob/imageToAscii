package filters.image

import models.grid.PixelGrid
import models.image.GrayscaleImage
import models.pixel.GrayscalePixel
import org.scalatest.FunSuite

class InvertTests extends FunSuite {
  test("Invert filter") {
    val invert = new Invert()
    val image = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(0), GrayscalePixel(255)),
      Array(GrayscalePixel(128), GrayscalePixel(64))
    )))
    val expected = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(255), GrayscalePixel(0)),
      Array(GrayscalePixel(127), GrayscalePixel(191))
    )))

    val result = invert.filter(image)
    assert(result.getPixelGrid.grid(0) sameElements expected.getPixelGrid.grid(0))
    assert(result.getPixelGrid.grid(1) sameElements expected.getPixelGrid.grid(1))
  }
}
