package exporters.text

/**
 * The `StdOutputExporter` class is a specific implementation of `StreamTextExporter` that exports text data
 * to the standard output stream (System.out).
 *
 * This class inherits the functionality of `StreamTextExporter` and is specialized for exporting text data to the console.
 */
class StdOutputExporter extends StreamTextExporter(System.out) {}
