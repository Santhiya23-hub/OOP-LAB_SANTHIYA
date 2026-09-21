class Shared{
int data;
boolean valueSet=false;
synchronized void produce(int value){
try{
while(valueSet)
wait();
} catch(InterruptedException e){}
data=value;
System.out.println("Produced:"+data);
valueSet=true;
notify();
}
synchronized void consume(){
try{
while(!valueSet)
wait();
} catch(InterruptedException e){}
System.out.println("Consumed:"+data);
valueSet=false;
notify();
}
}
class Producer extends Thread{
Shared s;
Producer(Shared s){
this.s=s;
}
public void run(){
for(int i=1;1<5;i++){
s.produce(i);
try{
Thread.sleep(500);} catch(Exception e){}
}
}
}
class Consumer extends Thread{
Shared s;
Consumer(Shared s){
this.s=s;
}
public void run(){
for(int i=1;i<=5;i++){
s.consume();
try{Thread.sleep(500);}catch(Exception e){}
}
}
}
public class InterThreadDemo{
public static void main(String args[]){
Shared s=new Shared();
Producer p=new Producer(s);
Consumer c=new Consumer(s);
p.start();
c.start();
}
}

