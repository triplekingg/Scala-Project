import java.util.HashMap
case class User(name:String,
                monthlyIncome:Double,
                monthlyExpense:Double,
                percentage:Double,
                importantExpenses:HashMap[String,Double],
                unimportantExpenses:HashMap[String,Double]
               ) {
}


