package exporters.image

import exporters.Exporter
import exporters.text.TextExporter
import models.image.ASCIIImage

/**
 * The `ASCIIImageExporter` class is an implementation of the `Exporter` trait for exporting ASCIIImage data.
 *
 * @param textExporter The `TextExporter` responsible for handling the actual export of text data.
 */
class ASCIIImageExporter(textExporter: TextExporter)
    extends Exporter[ASCIIImage] {

  /**
   * Exports the data of type `ASCIIImage` using the provided `TextExporter`.
   *
   * This class acts as a bridge, converting ASCIIImage data into its textual representation using the specified `TextExporter`.
   *
   * @param item The ASCIIImage data to be exported.
   */
  override def exportData(item: ASCIIImage): Unit =
    textExporter.exportData(item.toString)
}
