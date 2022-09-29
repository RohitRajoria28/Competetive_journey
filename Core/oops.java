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
        
        RedShapeDecorator red=new ShapeDecorator(new circle());
         
    }

    public interface shape{
        public void draw(){};
    }

    public class circle implements shape{
        public void draw(){
            System.out.print("I am circle");
        } 
    }

    public class rectangle implements shape{
        public void draw(){
            System.out.print("I am rectangle");
        } 
    }

    public class ShapeDecorator implements shape{
        private shape decorator;

       void  ShapeDecorator(shape decorator){
            this.decorator=decorator;
        }

        void draw(){
            decorator.draw();
        }
    }
    public class BlackShapeDecorator extends ShapeDecorator{

        BlackShapeDecorator(shape decorator){
            super(decorator);
        }

        public void draw(){
            decorator.draw();
            ShapeDecoratorDraw(decorator);
        }
        void ShapeDecoratorDraw(shape decorator){
            System.out.print("BORDER LINE : Black");
        }
    }

    public class RedShapeDecorator extends ShapeDecorator{

        RedShapeDecorator(shape decorator){
            super(decorator);
        }

        public void draw(){
            decorator.draw();
            ShapeDecoratorDraw(decorator);
        }
        void ShapeDecoratorDraw(shape decorator){
            System.out.print("BORDER LINE : RED");
        }
    }

  
}

 