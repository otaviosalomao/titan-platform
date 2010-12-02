package org.titan.platform.parser

import scala.xml._

object Parser{
	

	
	def parse(path :String):Array[Package] = {
	
		val data = XML.loadFile(path);
		val nodes = data.child \\"package"
		var packages = new Array[Package](nodes.length)
		var index = 0
		for(val entry <- nodes) {
		 	packages(index) = new Package(entry)
		 	index = index+1
  		}
  		
  		return packages
	}
	
	def main(args: Array[String]) {
      val packages = Parser.parse(args(0))
      
      for(val p <- packages){
      	Console.println(p.name+ " "+ p.label)
      	 for(val pr <- p.properties){
      	 	Console.println("------"+pr.name+ " "+ pr.label+" "+pr.default+" "+pr.help)
      	 }
      }	
    }

}
