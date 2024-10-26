package filters.image

import filters.FlipAxis
import models.grid.PixelGrid
import models.pixel.GrayscalePixel
import models.image.GrayscaleImage
import org.scalatest.FunSuite

class FlipTests extends FunSuite {
  test("Flip XAxis") {
    val image = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
      Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6)),
      Array(GrayscalePixel(7), GrayscalePixel(8), GrayscalePixel(9)))))
    val flippedImage = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(7), GrayscalePixel(8), GrayscalePixel(9)),
      Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6)),
      Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)))))
    val flip = new Flip(FlipAxis.XAxis)
    val flipped = flip.filter(image)
    assert(flipped.getPixelGrid.grid(0) sameElements flippedImage.getPixelGrid.grid(0))
    assert(flipped.getPixelGrid.grid(1) sameElements flippedImage.getPixelGrid.grid(1))
    assert(flipped.getPixelGrid.grid(2) sameElements flippedImage.getPixelGrid.grid(2))
  }

  test("Flip YAxis") {
    val image = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(1), GrayscalePixel(2), GrayscalePixel(3)),
      Array(GrayscalePixel(4), GrayscalePixel(5), GrayscalePixel(6)),
      Array(GrayscalePixel(7), GrayscalePixel(8), GrayscalePixel(9)))))

    val flippedImage = new GrayscaleImage(PixelGrid(Array(
      Array(GrayscalePixel(3), GrayscalePixel(2), GrayscalePixel(1)),
      Array(GrayscalePixel(6), GrayscalePixel(5), GrayscalePixel(4)),
      Array(GrayscalePixel(9), GrayscalePixel(8), GrayscalePixel(7)))))

    val flip = new Flip(FlipAxis.YAxis)
    val flipped = flip.filter(image)
    assert(flipped.getPixelGrid.grid(0) sameElements flippedImage.getPixelGrid.grid(0))
    assert(flipped.getPixelGrid.grid(1) sameElements flippedImage.getPixelGrid.grid(1))
    assert(flipped.getPixelGrid.grid(2) sameElements flippedImage.getPixelGrid.grid(2))
  }
}
