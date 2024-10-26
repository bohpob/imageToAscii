package models.image

import models.grid.PixelGrid
import models.pixel.ASCIIPixel
import org.scalatest.FunSuite

class ASCIIImageTests extends FunSuite {
  test("Map function should apply transformation to each ASCII pixel") {
    val pixelGrid = PixelGrid(Array.fill(3, 4)(ASCIIPixel(' ')))
    val image = new ASCIIImage(pixelGrid)

    val transformedImage = image.map(pixel => ASCIIPixel('X'))

    val expectedPixels = Array.fill(3, 4)(ASCIIPixel('X'))
    assert(transformedImage.getPixelGrid.toArray === expectedPixels)
  }

  test("ToString should return a string representation of the ASCIIImage") {
    val pixelGrid = PixelGrid(Array.fill(3, 4)(ASCIIPixel(' ')))
    val image = new ASCIIImage(pixelGrid)

    val stringRepresentation = image.toString

    val expectedString =
      "    \n" +
        "    \n" +
        "    \n"

    assert(stringRepresentation === expectedString)
  }

  test("ToString should correctly represent a modified ASCIIImage") {
    val pixelGrid = PixelGrid(Array.fill(2, 3)(ASCIIPixel(' ')))
    val image = new ASCIIImage(pixelGrid)

    val transformedImage = image.map(pixel => ASCIIPixel('@'))
    val stringRepresentation = transformedImage.toString

    val expectedString =
      "@@@\n" +
        "@@@\n"

    assert(stringRepresentation === expectedString)
  }

  test("Map function on a single-pixel ASCIIImage") {
    val singlePixelImage =
      new ASCIIImage(PixelGrid(Array(Array(ASCIIPixel('a')))))
    val result = singlePixelImage.map(_ => ASCIIPixel('b'))
    assert(result.getHeight == 1)
    assert(result.getWidth == 1)
    assert(result.getPixel(0, 0) == ASCIIPixel('b'))
  }

  test("Map function on a 2x2 ASCIIImage") {
    val image = new ASCIIImage(
      PixelGrid(
        Array(
          Array(ASCIIPixel('a'), ASCIIPixel('b')),
          Array(ASCIIPixel('c'), ASCIIPixel('d')))
      )
    )
    val result = image.map(_ => ASCIIPixel('x'))
    assert(result.getHeight == 2)
    assert(result.getWidth == 2)
    assert(result.getPixel(0, 0) == ASCIIPixel('x'))
    assert(result.getPixel(0, 1) == ASCIIPixel('x'))
    assert(result.getPixel(1, 0) == ASCIIPixel('x'))
    assert(result.getPixel(1, 1) == ASCIIPixel('x'))
  }

  test("Map function on a single-column ASCIIImage") {
    val singleColumnImage = new ASCIIImage(
      PixelGrid(
        Array(
          Array(ASCIIPixel('a')),
          Array(ASCIIPixel('b')),
          Array(ASCIIPixel('c')))))
    val transformedImage = singleColumnImage.map(pixel => ASCIIPixel('X'))
    assert(transformedImage.getWidth == 1)
    assert(transformedImage.getHeight == 3)
    assert(transformedImage.getPixel(0, 0) == ASCIIPixel('X'))
    assert(transformedImage.getPixel(1, 0) == ASCIIPixel('X'))
    assert(transformedImage.getPixel(2, 0) == ASCIIPixel('X'))
  }

  test("ToString on a single-column ASCIIImage") {
    val singleColumnImage = new ASCIIImage(
      PixelGrid(
        Array(
          Array(ASCIIPixel('a')),
          Array(ASCIIPixel('b')),
          Array(ASCIIPixel('c')))))
    val stringRepresentation = singleColumnImage.toString
    val expectedString =
      "a\n" +
        "b\n" +
        "c\n"
    assert(stringRepresentation === expectedString)
  }

  test("ToString on an empty ASCIIImage") {
    val emptyImage = new ASCIIImage(PixelGrid(Array.ofDim[ASCIIPixel](0, 0)))
    val stringRepresentation = emptyImage.toString
    assert(stringRepresentation.isEmpty)
  }
}
