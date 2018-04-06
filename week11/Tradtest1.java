import java.lang.*;

// interface Runnable {
//     void run();
// }

class MyTaskStupid implements Runnable {
 /* Say hello, but think for a while between each time. */
    public void run(){
        for(int i = 1; i < 5000;i++){
            if(i % 1000 == 0){
                System.out.printf( "Hello for the %d-th time!\n" ,i/1000);
            }
        }
    }
}

class Main{
    public static void main(String[] args){
        Runnable task = new MyTaskStupid();
        Thread worker1 = new Thread(task);
        Thread worker2 = new Thread(task);
        worker1.start();  // Will make a call to task.run()
        worker2.start();
    }
}

class MyThread extends Thread {

    @Override
    public void run(){
        for(int i = 1; i < 5000;i++){
            if(i % 1000 == 0){
                System.out.printf( "Hello for the %d-th time!\n" ,i/1000);
            }
        }
    }
}
class Main2{
    public static void main(String[] args){
        Thread worker = new MyThread();
        worker.start();
    }
}
