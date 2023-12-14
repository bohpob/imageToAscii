package importers

import models.image.Image
import models.pixel.Pixel

/**
 * The ImageImporter trait extends the Importer trait and specializes in importing images.
 *
 * @tparam T The type parameter represents the image's specific pixel type.
 * */
trait ImageImporter[T <: Pixel] extends Importer[Image[T]] {}
