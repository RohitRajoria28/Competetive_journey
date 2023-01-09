import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;

public class code {
        public static void main(String[] args) {
            try {
                System.setIn(new FileInputStream("input.txt"));
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            } catch (Exception e) {
                System.err.println("Error");
            }
     
            Scanner scn=new Scanner(System.in);
            //  int L=scn.nextInt();
            // int R=scn.nextInt();
            System.out.println(15^45^20^2^34^35^5^44^32^30); 
            
        } 
        public static void print(){
            System.out.println("I AM STATIC");
        }
        
}

 
