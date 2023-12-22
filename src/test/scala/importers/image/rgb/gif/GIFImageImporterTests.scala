package importers.image.rgb.gif

import org.scalatest.FunSuite

import java.io.File

class GIFImageImporterTests extends FunSuite {
  test("GIFImageImporter with valid format") {
    val validFile = new File("image.gif")
    val importer = new GIFImageImporter(validFile)
    assert(importer.file == validFile)
  }

  test("GIFImageImporter with invalid format") {
    val invalidFile = new File("image.jpg")
    val exception = intercept[Exception] {
      new GIFImageImporter(invalidFile)
    }
    assert(exception.getMessage.contains("Invalid file format"))
  }
}
