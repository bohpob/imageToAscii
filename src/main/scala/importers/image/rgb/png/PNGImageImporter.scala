package importers.image.rgb.png

import importers.image.rgb.RGBImageImporterFromFile

/**
 * A class representing an importer for PNG images. Extends RGBImageImporterFromFile.
 *
 * @param filepath The path to the PNG file to be imported.
 */
class PNGImageImporter(override val filepath: String)
    extends RGBImageImporterFromFile(filepath) {}
