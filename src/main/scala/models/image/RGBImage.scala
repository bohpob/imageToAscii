package models.image

import models.pixel.{PixelGrid, RGBPixel}

/**
 * RGBImage is a class representing an image composed of RGB pixels.
 *
 * @param pixelGrid The PixelGrid contains the RGB pixels of the image.
 * */
case class RGBImage(pixelGrid: PixelGrid[RGBPixel]) extends Image[RGBPixel]
