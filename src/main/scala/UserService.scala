import java.util.Scanner

class UserService {

  def displayDetails(user: User):String ={
    "Name: "+user.name+"\n"+"Income: "+user.monthlyIncome+"\n"+"Expense: "+user.monthlyExpense
  }
  def getUserDetails():User ={
    val sc = new Scanner(System.in);
    println("Enter your name");
    val name = sc.nextLine();
    println("Enter your monthly income");
    val income = sc.nextDouble();
    println("Enter your monthly expense");
    val expense = sc.nextDouble();
    println("Enter the percentage that you want to cut down your expenses by");
    val percent = sc.nextDouble();
    val user = new User(name,income,expense,percent);
    user
  }

}
