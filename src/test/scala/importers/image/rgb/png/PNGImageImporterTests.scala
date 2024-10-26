package importers.image.rgb.png

import org.scalatest.FunSuite

import java.io.File

class PNGImageImporterTests extends FunSuite {
  test("PNGImageImporter with valid format") {
    val validFile = new File("image.png")
    val importer = new PNGImageImporter(validFile)
    assert(importer.file == validFile)
  }

  test("PNGImageImporter with invalid format") {
    val invalidFile = new File("image.gif")
    val exception = intercept[Exception] {
      new PNGImageImporter(invalidFile)
    }
    assert(exception.getMessage.contains("Invalid file format"))
  }
}
