import java.util.*;

class Circle extends CircleArea{
	public static void main(String args[]){
		int r;
		System.out.println("Enter radius: ");
		Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();
        sc.close();
		r=Integer.parseInt(inp);
		area(r);
		perimeter(r);
	}
}