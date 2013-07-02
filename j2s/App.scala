case class SomeDataOne(var number: Int, var name: String)
case class SomeDataTwo(number: Int, name: String)

object MyApp extends App {
  println("Hello World")
  
  val data = SomeDataOne(17, "foo")
  val updatedData = data.number = data.number + 1
  println(data)
  
  val data2 = SomeDataTwo(17, "foo")
  val updatedData2 = data2.copy(number = data2.number + 1)
  println(updatedData2)
  
  def factorial(i: Int, j: Int){
    if(i<10){
      println(j)
      factorial(i+1, j*i)
    }
  }
  factorial(1,1)
  
  val names = Seq("blaz", "luka", "andraz")
  val updatedNames = names.filter(_.length < 5).map(name => "osebek " + name)
  updatedNames foreach println
}
