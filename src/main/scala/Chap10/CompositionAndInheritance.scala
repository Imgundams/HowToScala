package Chap10

class CompositionAndInheritance {
  // We create a library here

  object TwoDLayoutLibrary {

    //   def elem(s:String) : Element

//    val column1 = elem("hello") above elem("***")
//    val column2 = elem("***") above elem("world")
//    column1 beside column2
  }

  abstract class Element {
    def contents: Array[String]
  }

  // Defining Parameterless Methods


}
