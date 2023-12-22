package importers.image.rgb

import importers.image.ImageImporterFromFile
import models.image.RGBImage

/**
 * A trait representing an importer for RGB images from a file.
 * Extends the ImageImporterFromFile trait with RGBImage as the specified type.
 */
trait RGBImageImporter extends ImageImporterFromFile[RGBImage] {}
