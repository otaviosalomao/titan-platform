package org.titan.platform.parser

import scala.xml.Node

class Package (node :Node){
	
	val name = (node \\"package" \ "@name").text
	val label = (node \\"package" \ "@label").text
	val component = (node \\"package" \ "@component").text
	
	val properties = new Array[Property]( (node \\"property").length )
	
	var index = 0
	for(val entry <- node \\"property") {
		 	properties(index) = new Property(entry)
		 	index = index+1
  	}
	
}
