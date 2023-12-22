package importers.image.rgb.gif

import importers.image.rgb.RGBImageImporterFromFile

/**
 * A class representing an importer for GIF images. Extends RGBImageImporterFromFile.
 *
 * @param filepath The path to the GIF file to be imported.
 */
class GIFImageImporter(override val filepath: String)
    extends RGBImageImporterFromFile(filepath) {}
