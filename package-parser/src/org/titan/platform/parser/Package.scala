package org.titan.platform.parser

import scala.xml.Node

class Package (node :Node){
	
	val name = (node \\"package" \ "@name").text
	val label = (node \\"package" \ "@label").text
	val component = (node \\"package" \ "@component").text
	
	val properties = (node \\"property") map(new Property(_)) toArray
	
	override def toString() = {
		label+" - "+"["+name+"]"
	}
}
