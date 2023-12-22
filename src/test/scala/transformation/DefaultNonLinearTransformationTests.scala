package transformation

import models.grid.PixelGrid
import models.image.{ASCIIImage, GrayscaleImage}
import models.pixel.{ASCIIPixel, GrayscalePixel}
import org.scalatest.FunSuite

class DefaultNonLinearTransformationTests extends FunSuite {
  test("DefaultNonLinearTransformation intensity test") {
    val defaultNonLinearTransformation = new DefaultNonLinearTransformation()
    assertResult(Array(50, 100, 150, 175, 190, 210, 230, 240, 250, 255)) {
      defaultNonLinearTransformation.intensity
    }
  }

  test("DefaultNonLinearTransformation transform on min intensity image") {
    val transformation = new DefaultNonLinearTransformation()
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

  test("DefaultNonLinearTransformation transform on max intensity image") {
    val transformation = new DefaultNonLinearTransformation()
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
