package transformation

import models.image.{ASCIIImage, GrayscaleImage}

/**
 * An abstract class for a transformation that converts a grayscale image to an ASCII image.
 */
abstract class GrayscaleToASCIITransformation
    extends Transformation[GrayscaleImage, ASCIIImage] {}
