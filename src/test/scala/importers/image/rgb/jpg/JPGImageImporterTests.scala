package importers.image.rgb.jpg

import importers.image.rgb.jpg.JPGImageImporter
import org.scalatest.FunSuite

import java.io.File

class JPGImageImporterTests extends FunSuite {
  test("JPGImageImporter with valid format .jpg") {
    val validFile = new File("image.jpg")
    val importer = new JPGImageImporter(validFile)
    assert(importer.file == validFile)
  }

  test("JPGImageImporter with valid format .jpeg") {
    val validFile = new File("image.jpeg")
    val importer = new JPGImageImporter(validFile)
    assert(importer.file == validFile)
  }

  test("JPGImageImporter with invalid format") {
    val invalidFile = new File("image.gif")
    val exception = intercept[Exception] {
      new JPGImageImporter(invalidFile)
    }
    assert(exception.getMessage.contains("Invalid file format"))
  }
}
