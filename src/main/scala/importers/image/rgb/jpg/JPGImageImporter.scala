package importers.image.rgb.jpg

import importers.image.rgb.RGBImageImporterFromFile

/**
 * A class representing an importer for JPG images. Extends RGBImageImporterFromFile.
 *
 * @param filepath The path to the JPG file to be imported.
 */
class JPGImageImporter(override val filepath: String)
    extends RGBImageImporterFromFile(filepath) {}
