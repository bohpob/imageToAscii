package filters.image

import filters.Filter
import models.image.Image

/**
 * A trait representing a generic image filter.
 *
 * @tparam P The type of the input image (e.g., GrayscaleImage, RGBImage).
 * @tparam T The type of the output image (e.g., GrayscaleImage, RGBImage).
 */
trait ImageFilter[P <: Image[_], T <: Image[_]] extends Filter[P, T] {}
