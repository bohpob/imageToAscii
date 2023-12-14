package importers

import models.image.Image
import models.pixel.RGBPixel

class RGBImageRandomizer extends RGBImageImporter {
  override def importData(): Image[RGBPixel] = ???
}
