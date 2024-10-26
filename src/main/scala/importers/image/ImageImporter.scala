package importers.image

import importers.Importer
import models.image.Image

/**
 * The ImageImporter trait is a generic importer for images of type T, where T represents any subtype of the Image[_] trait.
 * It extends the Importer trait, defining a common interface for importing images of different types.
 *
 * @tparam T The specific type of image to be imported, which must be a subtype of Image[_].
 * */
trait ImageImporter[T <: Image[_]] extends Importer[T] {}
