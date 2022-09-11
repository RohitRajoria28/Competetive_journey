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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println( 191919);
        



    }


    public class List<Integer> implements Iterable<Integer>{
        Node head,tail;

        void add(int val){
            Node node=new Node(val);

            if(head==null){
                head=tail=node;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }

        public Iterator<Integer> Iterator(){
            return new ListIterator(head);
        }

    }

    public class ListIterator implements Iterator<Integer>{
        
        Node head;

        ListIterator(Node head){
            this.head=head;
        }

        boolean hasNext(Node node){
            return node.next!=null;
        }

        public Integer next(Node node){
            int val=-1;
            if(node!=null){
                int val=node.data;

                if(node.next!=null){
                    node=node.next;
                }
            }

            return val;
        }


    }

    public class Node{
        int data;
        Node next;

        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        void Node(int data){
            this.data=data;
        }

    } 


}

 