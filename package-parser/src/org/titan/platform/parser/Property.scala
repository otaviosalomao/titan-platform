package org.titan.platform.parser

import scala.xml.Node

class Property(node : Node, val packageRef: Package){

	val name = (node \\"property" \ "@name").text
	val defaultValue = (node \\"property" \ "@default").text
	val label = (node \\"property" \ "@label").text
	val help = (node \\"property" \ "@help").text
}
