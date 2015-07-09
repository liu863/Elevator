import java.lang.Thread;

public class Test {
    public static void main(String[] ris) {
        double time = 20.55;
        System.out.println("sleep!!!!");
        
        try{
            Thread.currentThread().sleep((int)(time * 100));
        } catch (InterruptedException e) {
        }
        
        System.out.println("wake up!!!!");
    }
}