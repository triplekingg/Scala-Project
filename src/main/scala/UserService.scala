import java.io.{BufferedWriter, File, FileWriter}
import java.util
import java.util.Scanner


class UserService {
  val calculator = new Calculator;
  val utilities = new Utilities;
  var importantExpenses = new util.HashMap[String,Double]()
  var unimportantExpenses = new util.HashMap[String,Double]()
  var suggestedImportantExpenses = new util.HashMap[String,Double]()
  var suggestedUnimportantExpenses = new util.HashMap[String,Double]()

  def displayDetails(user: User):String ={
    val result = "Name: "+user.name+"\n"+"Income: "+user.monthlyIncome+"\n"+"Expense: "+user.monthlyExpense + "\n"+"Important Expenses: " + user.importantExpenses + "\n"+"Suggested Important Expenses: " + user.revisedImportantExpenses + "\n"+ "Unimportant Expenses: "+user.unimportantExpenses + "\n" + "Suggested Unimportant Expenses: "+user.revisedUnimportantExpenses
    result
  }
//  def writeFile(filename: String, s: String): Unit = {
//    val file = new File(filename)
//    val bw = new BufferedWriter(new FileWriter(file))
//    bw.write(s)
//    bw.close()
//  }
  def getUserDetails():User ={
//    val sc = new Scanner((new File("test")));
    val sc = new Scanner(System.in);
//    while (sc.hasNextLine()){
//
//    }
    println("Enter your Full name");
    val name = sc.nextLine();
    println("Enter your monthly income");
    val income = sc.nextDouble();
    utilities.getImportantExpenses(importantExpenses)
    utilities.getUnimportantExpenses(unimportantExpenses)

    val totalImportantExpenses = calculator.totalExpenses(importantExpenses)
    val totalUnimportantExpenses = calculator.totalExpenses(unimportantExpenses)
    val expense = totalImportantExpenses + totalUnimportantExpenses

    val left = calculator.percentageLeft(income,expense)
    println(s"Percentage of fund left: $left%")
    val used = calculator.percentageUsed(income,expense)
    println(s"Percentage of fund used: $used%")

    suggestedImportantExpenses.putAll(importantExpenses)
    suggestedUnimportantExpenses.putAll(unimportantExpenses)
    println("Enter the percentage that you want to cut down your expenses by");
    val percent = sc.nextDouble();
    calculator.revisedCharges(suggestedImportantExpenses,suggestedUnimportantExpenses,percent)
    User(name,income,expense,percent,importantExpenses,unimportantExpenses,suggestedImportantExpenses,suggestedUnimportantExpenses);
  }
}
