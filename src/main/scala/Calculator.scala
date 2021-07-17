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
}
