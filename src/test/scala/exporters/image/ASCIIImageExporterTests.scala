package exporters.image

import exporters.text.StreamTextExporter
import models.grid.PixelGrid
import models.image.ASCIIImage
import models.pixel.ASCIIPixel
import org.scalatest.FunSuite

import java.io.{File, FileOutputStream}
import scala.io.Source

class ASCIIImageExporterTests extends FunSuite {
  test("ASCIIImageExporterTest") {
    val file = new File("src/test/scala/exporters/image/res/test1.txt")
    val asciiImageExporter =
      new ASCIIImageExporter(new StreamTextExporter(new FileOutputStream(file)))
    assert(asciiImageExporter != null)

    val pixelGrid = new PixelGrid[ASCIIPixel](
      Array(
        Array(ASCIIPixel(' '), ASCIIPixel('.'), ASCIIPixel('#')),
        Array(ASCIIPixel('#'), ASCIIPixel(' '), ASCIIPixel('.')),
        Array(ASCIIPixel('.'), ASCIIPixel('#'), ASCIIPixel(' '))
      )
    )
    val asciiImage = new ASCIIImage(pixelGrid)

    asciiImageExporter.exportData(asciiImage)
    assert(file.exists())
    val source = Source.fromFile(file)
    val lines = try source.mkString
    finally source.close()
    assert(lines == " .#\n# .\n.# \n")
    file.deleteOnExit()
  }

  test("ASCIIImageExporter Empty Image Test") {
    val file = new File("src/test/scala/exporters/image/res/test_empty.txt")
    val asciiImageExporter =
      new ASCIIImageExporter(new StreamTextExporter(new FileOutputStream(file)))
    assert(asciiImageExporter != null)

    val pixelGrid = new PixelGrid[ASCIIPixel](Array(Array()))
    val asciiImage = new ASCIIImage(pixelGrid)

    asciiImageExporter.exportData(asciiImage)
    assert(file.exists())
    val source = Source.fromFile(file)
    val lines = try source.mkString
    finally source.close()
    assert(lines.trim.isEmpty)
    file.deleteOnExit()
  }

  test("ASCIIImageExporter Single Pixel Image Test") {
    val file =
      new File("src/test/scala/exporters/image/res/test_single_pixel.txt")
    val asciiImageExporter =
      new ASCIIImageExporter(new StreamTextExporter(new FileOutputStream(file)))
    assert(asciiImageExporter != null)

    val pixelGrid = new PixelGrid[ASCIIPixel](Array(Array(ASCIIPixel('#'))))
    val asciiImage = new ASCIIImage(pixelGrid)

    asciiImageExporter.exportData(asciiImage)
    assert(file.exists())
    val source = Source.fromFile(file)
    val lines = try source.mkString
    finally source.close()
    assert(lines == "#\n")
    file.deleteOnExit()
  }
}
