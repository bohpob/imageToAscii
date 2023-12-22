package importers.image.rgb.png

import importers.image.rgb.CommonImageImporter

import java.io.File

/**
 * A class representing an importer for PNG images. Extends RGBImageImporterFromFile.
 *
 * @param file The PNG file to be imported.
 */
class PNGImageImporter(override val file: File)
    extends CommonImageImporter(file, Seq(".png")) {}
