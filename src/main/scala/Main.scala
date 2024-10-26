package Main

import filters.image.GrayscaleFilter
import ui.CommandParser

object Main extends App {
  try {
    val commandParser = new CommandParser()
    val (imageImporter, filters, transformation, exporters) =
      commandParser.parse(args.toList)

    val image = imageImporter.importData()
    var grayscaleImage = new GrayscaleFilter().filter(image)

    for (filter <- filters)
      grayscaleImage = filter.filter(grayscaleImage)

    val art = transformation.transform(grayscaleImage)

    for (exporter <- exporters)
      exporter.exportData(art)
  } catch {
    case e: Exception => println(e.getMessage)
  }
}
