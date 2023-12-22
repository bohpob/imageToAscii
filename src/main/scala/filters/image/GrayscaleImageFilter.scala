package filters.image

import models.image.GrayscaleImage

/**
 * A trait representing an image filter specifically designed for grayscale images.
 * It extends the generic `ImageFilter` trait with the types `GrayscaleImage` for input
 * and output images.
 */
trait GrayscaleImageFilter extends ImageFilter[GrayscaleImage, GrayscaleImage] {}
