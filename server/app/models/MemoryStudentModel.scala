package models

case class Student(name: String, username: String)

object MemoryStudentModel {
  def readData(): Unit = {
    val source = scala.io.Source.fromFile("data/StudentData.csv")
    val students = (for (line <- source.getLines()) yield {
      val parts = line.split(", ")
      val username = parts(2).split("@").head
      val name = parts(0)
      Student(name, username)
    }).toList
    source.close()
  }
}