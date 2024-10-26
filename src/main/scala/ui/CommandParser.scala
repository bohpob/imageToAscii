package ui

import exporters.image.ASCIIImageExporter
import exporters.text.StreamTextExporter
import filters.image.{Brightness, Flip, Invert, Rotate, Scale}
import models.image.{GrayscaleImage, RGBImage}
import importers.image.rgb.gif.GIFImageImporter
import importers.image.rgb.jpg.JPGImageImporter
import importers.image.rgb.png.PNGImageImporter
import importers.image.rgb.RGBImageRandomizer
import importers.image.ImageImporter

import java.io.{File, FileOutputStream, OutputStream}
import filters.{Filter, FlipAxis}
import transformation._

import scala.annotation.tailrec

/**
 * CommandParser is a class that parses the command line arguments and returns the corresponding objects.
 */
class CommandParser {

  /**
   * Parses the command line arguments and returns the corresponding objects.
   * @param commands List of command line arguments
   * @return Tuple containing the image importer, the list of filters, the transformation and the list of exporters
   */
  def parse(commands: List[String]): (
    ImageImporter[RGBImage],
    List[Filter[GrayscaleImage, GrayscaleImage]],
    GrayscaleToASCIITransformation,
    List[ASCIIImageExporter]) = {

    var imageImporter: ImageImporter[RGBImage] = new RGBImageRandomizer()
    var filters: List[Filter[GrayscaleImage, GrayscaleImage]] = List()
    var transformation: GrayscaleToASCIITransformation =
      new DefaultLinearTransformation()
    var exporters: List[ASCIIImageExporter] = List()

    var isImageDefined = false

    if (commands.isEmpty)
      throw new Exception("No command specified")

    /**
     * Parses the command line arguments and returns the corresponding objects.
     * @param commands List of command line arguments
     * @return Tuple containing the image importer, the list of filters, the transformation and the list of exporters
     */
    @tailrec
    def parseCommand(commands: List[String]): (
      ImageImporter[RGBImage],
      List[Filter[GrayscaleImage, GrayscaleImage]],
      GrayscaleToASCIITransformation,
      List[ASCIIImageExporter]
    ) =
      commands match {
        case Nil =>
          (imageImporter, filters.reverse, transformation, exporters.reverse)
        case "--image" :: image :: tail =>
          if (isImageDefined)
            throw new Exception("Image already defined")
          isImageDefined = true
          addImageImporter(image)
          parseCommand(tail)
        case "--image-random" :: tail =>
          if (isImageDefined)
            throw new Exception("Image already defined")
          isImageDefined = true
          parseCommand(tail)
        case "--output-file" :: file :: tail =>
          try addOutput(new FileOutputStream(new File(file)))
          catch {
            case _: Exception => throw new Exception("Cannot open output file")
          }
          parseCommand(tail)
        case "--output-console" :: tail =>
          addOutput(System.out)
          parseCommand(tail)
        case "--invert" :: tail =>
          addInvertFilter()
          parseCommand(tail)
        case "--brightness" :: value :: tail =>
          try addBrightnessFilter(value.toInt)
          catch {
            case _: Exception => throw new Exception("Invalid brightness value")
          }
          parseCommand(tail)
        case "--scale" :: factor :: tail =>
          try addScaleFilter(factor.toDouble)
          catch {
            case _: Exception => throw new Exception("Invalid scale factor")
          }
          parseCommand(tail)
        case "--flip" :: axis :: tail =>
          addFlipFilter(axis)
          parseCommand(tail)
        case "--rotate" :: angle :: tail =>
          try addRotateFilter(angle.toInt)
          catch {
            case _: Exception => throw new Exception("Invalid angle")
          }
          parseCommand(tail)
        case "--table" :: table :: tail =>
          addTransformation(table)
          parseCommand(tail)
        case "--custom-table" :: table :: tail =>
          addCustomTransformation(table)
          parseCommand(tail)
        case _ => throw new Exception("Invalid command")
      }

    /**
     * Adds the image importer.
     * @param image Path to the image
     */
    def addImageImporter(image: String): Unit = {
      val file = new File(image)
      val extension = file.getName.split('.').last
      imageImporter = extension match {
        case "jpg" | "jpeg" => new JPGImageImporter(file)
        case "png"          => new PNGImageImporter(file)
        case "gif"          => new GIFImageImporter(file)
        case _              => throw new Exception("Invalid image format")
      }
    }

    /**
     * Adds the new exporter to the list of exporters.
     * @param outputStream Output stream to write to
     */
    def addOutput(outputStream: OutputStream): Unit =
      exporters = new ASCIIImageExporter(new StreamTextExporter(outputStream)) :: exporters

    /**
     * Adds the new Invert filter to the list of filters.
     */
    def addInvertFilter(): Unit =
      filters = new Invert() :: filters

    /**
     * Adds the new Brightness with specified value filter to the list of filters.
     * @param value The value to change the brightness by.
     */
    def addBrightnessFilter(value: Int): Unit =
      filters = new Brightness(value) :: filters

    /**
     * Adds the new Scale with specified factor filter to the list of filters.
     * @param factor The scale factor.
     */
    def addScaleFilter(factor: Double): Unit =
      filters = new Scale(factor) :: filters

    /**
     * Adds the new Flip filter with specified axis to the list of filters.
     * @param axis The axis to flip by.
     */
    def addFlipFilter(axis: String): Unit =
      if (axis.toLowerCase() == "x")
        filters = new Flip(FlipAxis.XAxis) :: filters
      else if (axis.toLowerCase() == "y")
        filters = new Flip(FlipAxis.YAxis) :: filters
      else
        throw new Exception("Invalid axis")

    /**
     * Adds the new Rotate filter with specified angle to the list of filters.
     * @param angle The angle to rotate by.
     */
    def addRotateFilter(angle: Int): Unit =
      filters = new Rotate(angle) :: filters

    /**
     * Adds the new transformation from pre-defined transformations to the list of transformations.
     * @param name The name of the transformation table.
     */
    def addTransformation(name: String): Unit =
      if (name == "linear_default")
        transformation = new DefaultLinearTransformation()
      else if (name == "non_linear_default")
        transformation = new DefaultNonLinearTransformation()
      else
        throw new Exception("Invalid table name")

    /**
     * Adds the new custom transformation with custom transformation table to the list of transformations.
     * @param table The transformation table.
     */
    def addCustomTransformation(table: String): Unit = {
      if (table.isEmpty)
        throw new Exception("Invalid table length")

      transformation = new CustomTableLinearTransformation(table)
    }

    try {
      val res = parseCommand(commands)
      if (!isImageDefined)
        throw new Exception("Image not defined")
      res
    } catch {
      case e: Exception => throw e
    }

  }
}
