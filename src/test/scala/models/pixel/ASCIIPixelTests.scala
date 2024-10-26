package models.pixel

import org.scalatest.FunSuite

class ASCIIPixelTests extends FunSuite {
  test("ASCIIPixel valid should return true for printable characters") {
    val pixel = ASCIIPixel('A')
    assert(pixel.valid)
  }

  test(
    "ASCIIPixel valid should return false for non-printable characters (above range)") {
    val pixel = ASCIIPixel('€')
    assert(!pixel.valid)
  }

  test("ASCIIPixel toString should return the character as a string") {
    val pixel = ASCIIPixel('X')
    assert(pixel.toString == "X")
  }
}
