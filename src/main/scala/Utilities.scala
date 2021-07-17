import java.util
import java.util.{HashMap, InputMismatchException}
import java.util.Scanner

class Utilities {

  val sc = new Scanner(System.in)
  def parser(string: String, hm: HashMap[String,Double]): Unit ={

    def helper(xs: List[String], index:Int, string: String): String = {
      if(index==xs.length) string
      else helper(xs,index+1,string.concat(xs(index)+ " "))
    }

    val s = string.trim.split(" ").toList
    val amount = s.last.toDouble
    val titleList = s.reverse.tail.reverse
    val title = helper(titleList,0,new String)
    hm.put(title, amount)

  }

  def getImportantExpenses(hm: HashMap[String,Double] ):Unit = {
    println("Enter the important expenses in the format shown below, type DONE to proceed after entering the values")
    println("<Expense name> <Expense>")
    var a = sc.nextLine()
    try{
      while (a != "DONE") {
        a = sc.nextLine()
        parser(a, hm);
      }
      if (a != "DONE") parser(sc.nextLine(), hm);
    }
    catch {
      case e:NumberFormatException => println("Skipped")
      case e:InputMismatchException => println("Wrong Format")
    }
  }

  def getUnimportantExpenses(hm: HashMap[String,Double] ):Unit = {
    println("Enter the unimportant expenses in the format shown below, type DONE to proceed after entering the values")
    println("<Expense name> <Expense>")
    var a = sc.nextLine()
    try{
      while (a != "DONE") {
        a = sc.nextLine()
        parser(a, hm);
      }
      if (a != "DONE") parser(sc.nextLine(), hm);
    }
    catch {
      case e:NumberFormatException => println("Skipped")
      case e:InputMismatchException => println("Wrong Format")
    }
  }

}
