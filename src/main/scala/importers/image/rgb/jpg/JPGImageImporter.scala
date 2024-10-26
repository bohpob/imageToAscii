package importers.image.rgb.jpg

import importers.image.rgb.CommonImageImporter

import java.io.File

/**
 * A class representing an importer for JPG images. Extends RGBImageImporterFromFile.
 *
 * @param file The JPG file to be imported.
 */
class JPGImageImporter(override val file: File)
    extends CommonImageImporter(file, Seq(".jpeg", ".jpg")) {}
