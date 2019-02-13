
class Building{
	public static void method() {
		System.out.println("Building method");
	}
	static void method(int i) {
		System.out.println("Output"+i);
	}
}

public class Construct extends Building{
public static void method() {
		System.out.println("Construct method");
	}

	public static  void main(String args[]) 
	{
		Construct c=new Construct();
		Building b=new Building();
		Construct.method();
		Construct.method(9);
		Building.method();
		c.method1();
	}
	 void method1() {
		 super.method();
		System.out.println("Construct method1 ");
	}

}
