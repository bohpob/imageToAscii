package importers.image.rgb

import org.scalatest.FunSuite

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class CommonImageImporterTests extends FunSuite {
  test("CommonImageImporter import test file not exists") {
    val file = new java.io.File("lena.png")
    assertThrows[Exception] {
      new CommonImageImporter(file, Seq(".png")).importData()
    }
  }

  test("Importing valid RGB image should succeed") {
    val testFile = new File("src/test/scala/importers/image/rgb/res/chess.jpg")
    val importer = new CommonImageImporter(testFile, Seq(".jpg"))

    val rgbImage = importer.importData()
    assert(rgbImage != null)
    assert(rgbImage.getPixelGrid.getHeight == 853)
    assert(rgbImage.getPixelGrid.getWidth == 1280)
  }

  test("CommonImageImporter import test") {
    val imageWidth = 2
    val imageHeight = 2
    val bufferedImage =
      new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB)

    bufferedImage.setRGB(0, 0, 0xFFFFFF)
    bufferedImage.setRGB(1, 0, 0xFF0000)
    bufferedImage.setRGB(0, 1, 0x00FF00)
    bufferedImage.setRGB(1, 1, 0x0000FF)

    // Save the image to a file (optional)
    val outputImageFile = new File("temp.png")
    ImageIO.write(bufferedImage, "png", outputImageFile)

    val image =
      new CommonImageImporter(outputImageFile, Seq(".png")).importData()
    assert(image != null)
    assert(image.getWidth == 2)
    assert(image.getHeight == 2)

    val pixels = image.getPixelGrid
    assert(pixels != null)

    assert(pixels(0).head.getValue == (255, 255, 255))
    assert(pixels(0)(1).getValue == (255, 0, 0))
    assert(pixels(1).head.getValue == (0, 255, 0))
    assert(pixels(1)(1).getValue == (0, 0, 255))

    // Delete the file
    outputImageFile.delete()
  }

  test("CommonImageImporter import test unsupported format") {
    val file = new java.io.File("src/test/scala/resources/space.webp")
    assertThrows[Exception] {
      new CommonImageImporter(file, Seq("...")).importData()
    }
  }
}
