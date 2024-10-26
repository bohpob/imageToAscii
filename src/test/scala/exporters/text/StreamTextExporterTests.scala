package exporters.text

import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, File, FileOutputStream}
import scala.io.Source

class StreamTextExporterTests extends FunSuite {
  test("Export to file") {
    val file = new File("src/test/scala/exporters/image/res/test4.txt")
    val exporter = new StreamTextExporter(new FileOutputStream(file))
    exporter.exportData("test")
    exporter.close()

    assert(file.exists())

    val source = Source.fromFile(file)
    val lines = try source.mkString
    finally source.close()
    assert(lines == "test")

    file.deleteOnExit()
  }

  test("Stream Already Closed") {
    val file = new File("src/test/scala/exporters/image/res/test5.txt")
    val exporter = new StreamTextExporter(new FileOutputStream(file))
    exporter.exportData("test")
    exporter.close()
    assertThrows[Exception] {
      exporter.exportData("test")
    }
    file.deleteOnExit()
  }

  test("Export empty text to console") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.exportData("")

    assert(stream.toString == "")

  }

  test("Export text to console") {
    val stream = new ByteArrayOutputStream()
    val exporter = new StreamTextExporter(stream)

    exporter.exportData("text")

    assert(stream.toString == "text")

  }
}
