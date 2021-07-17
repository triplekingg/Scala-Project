import java.util.HashMap
class Calculator {
  def percentageLeft(income: Double, expense:Double):Double = {
    val percentage = 100 - ((expense/income)*100)
    BigDecimal(percentage).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }
  def percentageUsed(income: Double, expense:Double):Double = {
    val percentage =((expense/income)*100)
    BigDecimal(percentage).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

}
