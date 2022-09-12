import java.io.*;
import java.util.*;
import java.util.Iterator;

public class oops {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
       System.out.println(n+":  ROHIT U DID FINE BRO ");
    }
  
}

 