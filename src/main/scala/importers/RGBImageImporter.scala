package importers

import models.pixel.RGBPixel

/**
 * The RGBImageImporter trait extends the ImageImporter trait, specializing in importing RGB image data.
 * It is designed to work specifically with images composed of RGB pixels.
 * */
trait RGBImageImporter extends ImageImporter[RGBPixel] {}
