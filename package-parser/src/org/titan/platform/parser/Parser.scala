package org.titan.platform.parser

import scala.xml._

object Parser{
	

	
	def parse(path :String):Array[Package] = {
	
		val data = XML.loadFile(path);
		val nodes = data.child \\"package"
		var packages = new Array[Package](nodes.length)
		var index = 0
		for(val entry <- nodes) {
			val name = (entry \\"package" \ "@name").text
		 	val label = (entry \\"package" \ "@label").text
		 	val component = (entry \\"package" \ "@component").text
		 	packages(index) = new Package(name, label, component)
		 	index = index+1
  		}
  		
  		return packages
	}
	
	def main(args: Array[String]) {
      val packages = Parser.parse(args(0))
      
      for(val p <- packages){
      	Console.println(p.name+ " "+ p.label)
      }	
    }

}
