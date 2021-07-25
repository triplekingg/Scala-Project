import java.io.{BufferedWriter, File, FileWriter}
import java.util
import java.util.{HashMap, Scanner}


class UserService {
  val calculator = new Calculator;
  val utilities = new Utilities;
  var importantExpenses = new util.HashMap[String,Double]()
  var unimportantExpenses = new util.HashMap[String,Double]()
  var suggestedImportantExpenses = new util.HashMap[String,Double]()
  var suggestedUnimportantExpenses = new util.HashMap[String,Double]()
  var suggestedTotalExpenses:Double = 0

  def displayDetails(user: User):String ={
    "Name: "+user.name+"\n"+"Income: "+user.monthlyIncome+"\n"+"Expense: "+user.monthlyExpense + "\n"+"Important Expenses: \n" +
      utilities.displayHashmap(user.importantExpenses) + "\n"+"Suggested Important Expenses: \n" +
      utilities.displayHashmap(user.revisedImportantExpenses) + "\n"+ "Unimportant Expenses: \n"+utilities.displayHashmap(user.unimportantExpenses) +
      "\n" + "Suggested Unimportant Expenses: \n"+utilities.displayHashmap(user.revisedUnimportantExpenses) + s"\n Your new total expense will be amounted to $suggestedTotalExpenses"
  }

  def getUserDetails():User ={

    val sc = new Scanner(System.in);

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
    suggestedTotalExpenses = calculator.totalExpenses(suggestedImportantExpenses) + calculator.totalExpenses(suggestedUnimportantExpenses)
    User(name,income,expense,percent,importantExpenses,unimportantExpenses,suggestedImportantExpenses,suggestedUnimportantExpenses, suggestedTotalExpenses);
  }
}
