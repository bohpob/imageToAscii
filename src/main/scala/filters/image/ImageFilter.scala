package filters.image

import filters.Filter
import models.image.Image

trait ImageFilter[P <: Image[_], T <: Image[_]] extends Filter[P, T] {}
