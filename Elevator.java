import java.lang.Thread;

public class Elevator {
    
    private int minlevel;
    private int maxlevel;
    private int curlevel;
    private int speed;    //second per level
    private int waittime; //second to open an close door
    
    public Elevator(int minlevel, int maxlevel, int speed, int waittime) {
        this.minlevel = minlevel;
        this.maxlevel = maxlevel;
        this.speed = speed;
        this.waittime = waittime;
        curlevel = 0;
    }
    
    public int getMinlevel() {
        return minlevel;
    }
    
    public int getMaxlevel() {
        return maxlevel;
    }
    
    public int getCurlevel() {
        return curlevel;
    }
    
    private void levelWait() {
        System.out.println("open");
        try {
            Thread.currentThread().sleep((int)(waittime * 1000));
        } catch (InterruptedException e) {
        }
        System.out.println("close");
    }
    
    private void upOne() {
        try {
            Thread.currentThread().sleep((int)(speed * 1000));
        } catch (InterruptedException e) {
        }
        curlevel++;
    }
    
    private void downOne() {
        try {
            Thread.currentThread().sleep((int)(speed * 1000));
        } catch (InterruptedException e) {
        }
        curlevel--;
    }
    
    public int goTo(int deslevel) {
        if (deslevel > maxlevel || deslevel < minlevel) {
            return -1;
        }
        if (curlevel < deslevel) {
            while (curlevel < deslevel) {
                upOne();
                System.out.println("upOne " + curlevel);
            }
        }
        else if (curlevel > deslevel) {
            while (curlevel > deslevel) {
                downOne();
                System.out.println("downOne " + curlevel);
            }
        }
        levelWait();
        return 1;
    }
    
    public static void main(String[] ris) {
        Elevator e = new Elevator(-1, 10, 1, 2);
        System.out.println("Elevator started!!");
        long start = System.currentTimeMillis();
        e.goTo(0);
        e.goTo(8);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + " seconds used");
    } 
}
