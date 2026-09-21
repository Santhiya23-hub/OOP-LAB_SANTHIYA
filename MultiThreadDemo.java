      import java.util.Random;

class NumberThread extends Thread{
  public void run(){
    int n = new Random().nextInt(10)+1;
    System.out.println("Random Number:"+n);
    
    if(n%2==0)
      new SquareThread(n).start();
    else
      new CubeThread(n).start();
  }
}

class SquareThread extends Thread{
  int n;
  SquareThread(int n){
    this.n=n;
  }
  
  public void run(){
    System.out.println("Square:"+(n*n));
  }
}

class CubeThread extends Thread{
  int n;
  CubeThread(int n){
    this.n=n;
  }
  
  public void run(){
    System.out.println("Cube:"+(n*n*n));
  }
}

public class MultiThreadDemo{
  public static void main(String[]args){
    new NumberThread().start();
  }
}
