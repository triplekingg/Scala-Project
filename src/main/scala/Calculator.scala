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



  def revisedCharges(important: HashMap[String,Double], unimportant: HashMap[String,Double], percent: Double, expense:Double): Unit = {
    def hashMapHelper(hm: HashMap[String,Double], decreasePercent:Double):Unit = {
      hm.forEach((k, _) => {
        hm.put(k,hm.get(k) - (decreasePercent*hm.get(k)))
      })
    }
    val importantDecreasePercent = (0.30*percent)/100
    val unImportantDecreasePercent = (0.70*percent)/100
    hashMapHelper(important, importantDecreasePercent)
    hashMapHelper(unimportant, unImportantDecreasePercent)
  }
}
