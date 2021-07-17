import java.util
import java.util.{HashMap, InputMismatchException, Scanner}
import scala.util.control.Breaks._

class UserService {
  val calculator = new Calculator;
  var importantExpenses = new util.HashMap[String,Double]()

  def displayDetails(user: User):String ={
    "Name: "+user.name+"\n"+"Income: "+user.monthlyIncome+"\n"+"Expense: "+user.monthlyExpense + "\n" + user.importantExpenses
  }
  def getUserDetails():User ={
    val sc = new Scanner(System.in);
    println("Enter your Full name");
    val name = sc.nextLine();
    println("Enter your monthly income");
    val income = sc.nextDouble();
    println("Enter your monthly expense");
    val expense = sc.nextDouble();
    val left = calculator.percentageLeft(income,expense)
    println(s"Percentage of fund left: $left%")
    val used = calculator.percentageUsed(income,expense)
    println(s"Percentage of fund used: $used%")
    println("Enter the important expenses in the format shown below, hit enter to proceed after entering the values")
    println("<Expense name> <Expense>")
    var a = sc.nextLine()
    try{
      while (a != "DONE") {
        a = sc.nextLine()
        calculator.parser(a, importantExpenses);
      }
      if (a != "DONE") calculator.parser(sc.nextLine(), importantExpenses);
    }
    catch {
      case e:NumberFormatException => println("Skipped")
      case e:InputMismatchException => println("Wrong Format")
    }



    println("Enter the percentage that you want to cut down your expenses by");
    val percent = sc.nextDouble();
    User(name,income,expense,percent,importantExpenses);
  }
}
