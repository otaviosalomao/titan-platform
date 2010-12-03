package org.titan.platform.parser

import scala.xml._

object Parser{
	

	
	def parse(path :String):Array[Package] = {
	
		val data = XML.loadFile(path);
  		return (data.child \\ "package") map(new Package(_)) toArray
	}
	
	def main(args: Array[String]) {
      val packages = Parser.parse(args(0))
      
      
      for(val p <- packages){
      	Console.println(p)
      	 for(val pr <- p.properties){
      	 	Console.println("------"+pr.name+ " "+ pr.label+" "+pr.defaultValue+" "+pr.help)
      	 }
      }	
    }

}
