package exporters.text

import java.io.OutputStream

/**
 * The `StreamTextExporter` class is an implementation of the `TextExporter` trait for exporting text data to an `OutputStream`.
 *
 * @param outputStream The output stream to which the text data will be exported.
 */
class StreamTextExporter(outputStream: OutputStream) extends TextExporter {
  private var closed = false

  /**
   * Exports the specified text data to the underlying output stream.
   *
   * This method writes the text to the output stream using UTF-8 encoding and flushes the stream.
   *
   * @param text The text data to be exported.
   * @throws Exception if the stream is already closed.
   */
  protected def exportToStream(text: String): Unit = {

    if (closed)
      throw new Exception("The stream is already closed")

    outputStream.write(text.getBytes("UTF-8"))
    outputStream.flush()
  }

  /**
   * Closes the output stream associated with this exporter.
   *
   * If the stream is already closed, this method has no effect.
   */
  def close(): Unit = {
    if (closed)
      return

    outputStream.close()
    closed = true
  }

  /**
   * Overrides the exportData method in the TextExporter trait to delegate the export operation to exportToStream.
   *
   * @param item The text data to be exported.
   */
  override def exportData(item: String): Unit = exportToStream(item)
}
