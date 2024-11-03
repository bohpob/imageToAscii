# imageToAscii

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them.

This project uses sbt for building and running. Make sure you have sbt version 1.7.1 and Java version 8 - 17 installed.

### Download dependencies and compile the project:
```
sbt compile
```
### Run tests:
```
sbt test
```
### Run the application with parameters:
```
sbt "run --image test-image.jpg --output-file ../outputs/output.txt"
```
```
sbt "run --image "../images/test-image.jpg" --rotate +90 --scale 0.25 --invert --output-console"
```
More examples can be found in the tests.
