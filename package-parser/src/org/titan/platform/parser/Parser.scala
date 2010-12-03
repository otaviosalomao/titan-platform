package org.titan.platform.parser

import scala.xml._

class Parser(path :String){
	
	val data = XML.loadFile(path);
	
	def parse():Array[Package] = {
  		return (data.child \\ "package") map(new Package(_)) toArray
	}
	
	def dependantNode(depends :String) :Package = {
			Console.println(depends)
			var dNodes =  data \\"package" filter(_\"@name" == depends)
			if(dNodes.length > 0){
				return new Package(dNodes(0))
		}
		return null
	}

}
