package exporters.text

import org.scalatest.FunSuite

import java.io.File
import scala.io.Source

class FileOutputExporterTests extends FunSuite {
  test("FileOutputExporter testExport") {
    val file = new File("src/test/scala/exporters/image/res/test2.txt")
    val exporter = new FileOutputExporter(file)
    exporter.exportData("test")

    assert(file.exists())
    val source = Source.fromFile(file)
    val lines = try source.mkString
    finally source.close()
    assert(lines == "test")

    file.deleteOnExit()
  }

  test("FileOutputExporter Stream Already Closed") {
    val file = new File("src/test/scala/exporters/image/res/test3.txt")
    val exporter = new FileOutputExporter(file)
    exporter.exportData("test")
    exporter.close()
    assertThrows[Exception] {
      exporter.exportData("test")
    }
    file.deleteOnExit()
  }
}
