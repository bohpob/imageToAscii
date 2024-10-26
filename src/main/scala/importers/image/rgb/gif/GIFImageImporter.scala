package importers.image.rgb.gif

import importers.image.rgb.CommonImageImporter

import java.io.File

/**
 * A class representing an importer for GIF images. Extends RGBImageImporterFromFile.
 *
 * @param file The GIF file to be imported.
 */
class GIFImageImporter(override val file: File)
    extends CommonImageImporter(file, Seq(".gif")) {}
