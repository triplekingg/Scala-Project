import java.util.Scanner
class Main {
  val userService = new UserService;
  def run():Unit={
      val user = userService.getUserDetails()
      userService.displayDetails(user)
  }



}

object test{
  def main(args: Array[String]): Unit = {
    val obj = new Main
    println(obj.run())
  }
}
