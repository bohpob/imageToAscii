package transformation

import models.grid.PixelGrid
import models.image.{ASCIIImage, GrayscaleImage}
import models.pixel.{ASCIIPixel, GrayscalePixel}
import org.scalatest.FunSuite

class DefaultLinearTransformationTests extends FunSuite {
  test("DefaultLinearTransformation transform test") {
    val transformation = new DefaultLinearTransformation()
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
            Array(ASCIIPixel(' '), ASCIIPixel('@')),
            Array(ASCIIPixel('@'), ASCIIPixel(' '))
          ))).toString) {
      transformation.transform(grayscaleImage).toString
    }
  }

  test("DefaultLinearTransformation transform on min intensity image") {
    val transformation = new DefaultLinearTransformation()
    val minIntensityImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(0), GrayscalePixel(0)),
          Array(GrayscalePixel(0), GrayscalePixel(0))
        )
      )
    )

    assertResult(
      new ASCIIImage(
        PixelGrid(
          Array(
            Array(ASCIIPixel(' '), ASCIIPixel(' ')),
            Array(ASCIIPixel(' '), ASCIIPixel(' '))
          )
        )
      ).toString
    ) {
      transformation.transform(minIntensityImage).toString
    }
  }

  test("DefaultLinearTransformation transform on max intensity image") {
    val transformation = new DefaultLinearTransformation()
    val maxIntensityImage = new GrayscaleImage(
      PixelGrid(
        Array(
          Array(GrayscalePixel(255), GrayscalePixel(255)),
          Array(GrayscalePixel(255), GrayscalePixel(255))
        )
      )
    )

    assertResult(
      new ASCIIImage(
        PixelGrid(
          Array(
            Array(ASCIIPixel('@'), ASCIIPixel('@')),
            Array(ASCIIPixel('@'), ASCIIPixel('@'))
          )
        )
      ).toString
    ) {
      transformation.transform(maxIntensityImage).toString
    }
  }
}
