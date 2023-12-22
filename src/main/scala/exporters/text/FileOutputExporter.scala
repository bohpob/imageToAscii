package exporters.text

import java.io.{File, FileOutputStream}

/**
 * The `FileOutputExporter` class is a specific implementation of `StreamTextExporter` that exports text data to a specified file.
 *
 * @param file The `File` representing the target file for exporting text data.
 */
class FileOutputExporter(file: File)
    extends StreamTextExporter(new FileOutputStream(file)) {}
