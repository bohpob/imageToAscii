package ui

import filters.FlipAxis
import importers.image.rgb.gif.GIFImageImporter
import importers.image.rgb.jpg.JPGImageImporter
import importers.image.rgb.png.PNGImageImporter
import org.scalatest.FunSuite
import transformation._
import filters.image.{Brightness, Flip, Invert, Rotate, Scale}
import org.mockito.MockitoSugar

class CommandParserTests extends FunSuite with MockitoSugar {

  test("No arguments") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List())
    }
  }

  test("No image file specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image"))
    }
  }

  test("Image not defined") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--invert"))
    }
  }

  test("Image already defined") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "image.png", "--image-random"))
    }
  }

  test("PNG image") {
    val commandParser = new CommandParser()
    val (imageImporter, _, _, _) =
      commandParser.parse(List("--image", "img.png"))
    assert(imageImporter.isInstanceOf[PNGImageImporter])
  }

  test("JPG image") {
    val commandParser = new CommandParser()
    val (imageImporter, _, _, _) =
      commandParser.parse(List("--image", "cat.jpg"))
    assert(imageImporter.isInstanceOf[JPGImageImporter])
  }

  test("GIF image") {
    val commandParser = new CommandParser()
    val (imageImporter, _, _, _) =
      commandParser.parse(List("--image", "giphy.gif"))
    assert(imageImporter.isInstanceOf[GIFImageImporter])
  }

  test("Flip Axis not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--flip"))
    }
  }

  test("Flip Axis not valid") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--flip", "z"))
    }
  }

  test("Flip Axis x") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--flip", "x"))
    assert(filters_.head.isInstanceOf[Flip])
    assert(filters_.head.asInstanceOf[Flip].getAxis == FlipAxis.XAxis)
  }

  test("Flip Axis X") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--flip", "X"))
    assert(filters_.head.isInstanceOf[Flip])
    assert(filters_.head.asInstanceOf[Flip].getAxis == FlipAxis.XAxis)
  }

  test("Flip Axis y") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--flip", "y"))
    assert(filters_.head.isInstanceOf[Flip])
    assert(filters_.head.asInstanceOf[Flip].getAxis == FlipAxis.YAxis)
  }

  test("Flip Axis Y") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--flip", "Y"))
    assert(filters_.head.isInstanceOf[Flip])
    assert(filters_.head.asInstanceOf[Flip].getAxis == FlipAxis.YAxis)
  }

  test("Invert") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--invert"))
    assert(filters_.head.isInstanceOf[Invert])
  }

  test("Brightness value not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--brightness"))
    }
  }

  test("Brightness value not valid") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--brightness", "a"))
    }
  }

  test("Brightness") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--brightness", "10"))
    assert(filters_.head.isInstanceOf[Brightness])
    assert(filters_.head.asInstanceOf[Brightness].getBrightness == 10)
  }

  test("Scale filter value not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--scale"))
    }
  }

  test("Scale filter value not valid") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--scale", "a"))
    }
  }

  test("Scale filter 0.25") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--scale", "0.25"))
    assert(filters_.head.isInstanceOf[Scale])
    assert(filters_.head.asInstanceOf[Scale].getScale == 0.25)
  }

  test("Scale filter 1") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--scale", "1"))
    assert(filters_.head.isInstanceOf[Scale])
    assert(filters_.head.asInstanceOf[Scale].getScale == 1)
  }

  test("Scale filter 4") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--scale", "4"))
    assert(filters_.head.isInstanceOf[Scale])
    assert(filters_.head.asInstanceOf[Scale].getScale == 4)
  }

  test("Rotate filter value not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--rotate"))
    }
  }

  test("Rotate filter value not valid") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--rotate", "a"))
    }
  }

  test("Rotate filter 90") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "90"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 90)
  }

  test("Rotate filter 180") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "180"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 180)
  }

  test("Rotate filter 270") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "270"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 270)
  }

  test("Rotate filter 360") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "360"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 360)
  }

  test("Rotate filter 0") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "0"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 0)
  }

  test("Rotate filter -90") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "-90"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == -90)
  }

  test("Rotate filter -180") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "-180"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == -180)
  }

  test("Rotate filter -270") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "-270"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == -270)
  }

  test("Rotate filter -360") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--rotate", "-360"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == -360)
  }

  test("Transformation table not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--table"))
    }
  }

  test("Transformation table name unknown") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--table", "a"))
    }
  }

  test("Default linear transformation table") {
    val commandParser = new CommandParser()
    val (_, _, transformation, _) = commandParser.parse(
      List("--image", "img.png", "--table", "linear_default"))
    assert(transformation.isInstanceOf[DefaultLinearTransformation])
  }

  test("Default non linear transformation table") {
    val commandParser = new CommandParser()
    val (_, _, transformation, _) = commandParser.parse(
      List("--image", "img.png", "--table", "non_linear_default"))
    assert(transformation.isInstanceOf[DefaultNonLinearTransformation])
  }

  test("Custom linear transformation table not specified") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--custom-table"))
    }
  }

  test("Custom linear transformation table empty") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(List("--image", "img.png", "--custom-table", ""))
    }
  }

  test("Custom linear transformation table") {
    val commandParser = new CommandParser()
    val (_, _, transformation, _) = commandParser.parse(
      List("--image", "img.png", "--custom-table", "./!:ab"))
    assert(transformation.isInstanceOf[CustomTableLinearTransformation])
    assert(
      transformation
        .asInstanceOf[CustomTableLinearTransformation]
        .getTable == "./!:ab")
  }

  test("Multiple filters: invert and flip") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) =
      commandParser.parse(List("--image", "img.png", "--invert", "--flip", "x"))
    assert(filters_.head.isInstanceOf[Invert])
    assert(filters_.tail.head.isInstanceOf[Flip])
  }

  test("Multiple filters: flip, invert and rotate") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) = commandParser.parse(
      List("--image", "img.png", "--flip", "x", "--invert", "--rotate", "90"))
    assert(filters_.head.isInstanceOf[Flip])
    assert(filters_.tail.head.isInstanceOf[Invert])
    assert(filters_.tail.tail.head.isInstanceOf[Rotate])
    assert(filters_.tail.tail.head.asInstanceOf[Rotate].getAngle == 90)
  }

  test("Multiple filters: rotate, flip and invert") {
    val commandParser = new CommandParser()
    val (_, filters_, _, _) = commandParser.parse(
      List("--image", "img.png", "--rotate", "90", "--flip", "x", "--invert"))
    assert(filters_.head.isInstanceOf[Rotate])
    assert(filters_.tail.head.isInstanceOf[Flip])
    assert(filters_.tail.tail.head.isInstanceOf[Invert])
    assert(filters_.head.asInstanceOf[Rotate].getAngle == 90)
  }

  test("Multiple filters: rotate, invert and flip. Missing rotate angle") {
    val commandParser = new CommandParser()
    assertThrows[Exception] {
      commandParser.parse(
        List("--image", "img.png", "--rotate", "--invert", "--flip", "x"))
    }
  }

}
