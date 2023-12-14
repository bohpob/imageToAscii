package importers

import models.image.Image
import models.pixel.RGBPixel

class RGBImageImporterFromPath extends RGBImageImporter {
  override def importData(): Image[RGBPixel] = ???
}
