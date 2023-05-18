import java.io.*;
import java.util.*;
 class test {
    public static void main(String[] args) throws IOException{
    	//print hello world
        System.out.println("Hello world!");

        //input using scanner class
        System.out.println("Enter scanner input");
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();
        System.out.println("Through scanner, you have entered: "+inp);
        sc.close();
        
        //input using console class
        System.out.println("Enter console input");
        Console c=System.console();
        String inp2=c.readLine();
        System.out.println("Through console, you have entered: "+inp2);
        
        //input using Buffered reader and input stream reader
        System.out.println("Enter InputStreamReader and BufferedReader input");
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String inp3=r.readLine();
        System.out.println("Through InputStreamReader and BufferedReader, you have entered: "+inp3);
    }
}