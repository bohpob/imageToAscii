package transformation

import models.grid.PixelGrid
import models.image.{ASCIIImage, GrayscaleImage}
import models.pixel.{ASCIIPixel, GrayscalePixel}
import org.scalatest.FunSuite

class CustomTableLinearTransformationTests extends FunSuite {
  test("CustomTableLinearTransformation transform test") {
    val customTableLinearTransformation =
      new CustomTableLinearTransformation(" .#")
    val grayscaleImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(255), GrayscalePixel(0))
        )))

    assertResult(
      new ASCIIImage(
        PixelGrid(
          Array(
            Array(ASCIIPixel(' '), ASCIIPixel('#')),
            Array(ASCIIPixel('#'), ASCIIPixel(' '))
          ))).toString) {
      customTableLinearTransformation.transform(grayscaleImage).toString
    }
  }

  test("CustomTableLinearTransformation empty table test") {
    val customTableLinearTransformation =
      new CustomTableLinearTransformation("")
    val grayscaleImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(255), GrayscalePixel(0))
        )))

    assertThrows[Exception] {
      customTableLinearTransformation.transform(grayscaleImage)
    }
  }

  test("CustomTableLinearTransformation single character table test") {
    val customTableLinearTransformation =
      new CustomTableLinearTransformation("#")
    val grayscaleImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(255)),
          Array(GrayscalePixel(255), GrayscalePixel(0))
        )
      )
    )

    assertResult(
      new ASCIIImage(
        PixelGrid(
          Array(
            Array(ASCIIPixel('#'), ASCIIPixel('#')),
            Array(ASCIIPixel('#'), ASCIIPixel('#'))
          )
        )
      ).toString
    ) {
      customTableLinearTransformation.transform(grayscaleImage).toString
    }
  }
}
