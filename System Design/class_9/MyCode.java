import java.io.*;
import java.util.*;
import java.util.Iterator;

public class oops {
    public static void main(String[] args) {
         
        ArrayList<point> list=new ArrayList<>();
        list.add(new point(1,2));
        list.add(new point(2,1));
        list.add(new point(3,0));
        list.add(new point(3,0));
        list.add(new point(1,5));
        list.add(new point(1,5));
        list.add(new point(5,1));

         

        HashMap<point,Integer> map=new HashMap<>();

        for(point p: list){
            
            
                map.put(p,map.getOrDefault(p,0)+1);
             
        }

        System.out.println(map);


    }
  public static class point{
    public int x;
    public int y;
    point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
       return ("["+this.x+" "+ this.y+"]");
    }

    public int hashCode(){
        return this.x+this.y;
    }

    public boolean equals(Object oo){
        point o=(point)oo;
        if(this.x==o.x && this.y==o.y) return true;
        else return false;
    }

  }
}

 