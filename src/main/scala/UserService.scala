import java.util
import java.util.{HashMap, InputMismatchException, Scanner}
import scala.util.control.Breaks._

class UserService {
  val calculator = new Calculator;
  val utilities = new Utilities;
  var importantExpenses = new util.HashMap[String,Double]()
  var unimportantExpenses = new util.HashMap[String,Double]()
  var suggestedImportantExpenses = new util.HashMap[String,Double]()
  var suggestedUnimportantExpenses = new util.HashMap[String,Double]()

  def displayDetails(user: User):String ={
    "Name: "+user.name+"\n"+"Income: "+user.monthlyIncome+"\n"+"Expense: "+user.monthlyExpense + "\n" + user.importantExpenses + "\n" + user.revisedImportantExpenses + "\n" + user.revisedUnimportantExpenses
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
    utilities.getImportantExpenses(importantExpenses)
    utilities.getUnimportantExpenses(unimportantExpenses)
    suggestedImportantExpenses.putAll(importantExpenses)
    suggestedUnimportantExpenses.putAll(unimportantExpenses)
    println("Enter the percentage that you want to cut down your expenses by");
    val percent = sc.nextDouble();
    calculator.revisedCharges(suggestedImportantExpenses,suggestedUnimportantExpenses,percent,expense)
    User(name,income,expense,percent,importantExpenses,unimportantExpenses,suggestedImportantExpenses,suggestedUnimportantExpenses);
  }
}
