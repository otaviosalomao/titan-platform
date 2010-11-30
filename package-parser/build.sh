scalac -sourcepath src -d bin src/org/titan/platform/parser/Parser.scala
cd bin
jar -cfm ../package-parser.jar ../MANIFEST.MF *
