import java.lang.Thread;

public class Elevator {
    
    private String name;
    private int maxload;
    private int curload;
    private int minlevel;
    private int maxlevel;
    private int curlevel;
    private int speed;    //second per level
    
    public Elevator(String name, int minlevel, int maxlevel, int maxload) {
        this.name = name;
        this.maxload = maxload;
        this.minlevel = minlevel;
        this.maxlevel = maxlevel;
        speed = 1;
        curlevel = 0;
        curload = 0;
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
    
    public int getCurload() {
        return curload;
    }
    
    private void levelWait(int load) {
        System.out.println(name + " open");
        try {
            Thread.currentThread().sleep((int)(load * 1000));
        } catch (InterruptedException e) {
        }
        System.out.println(name + " close");
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
    
    public int goTo(int deslevel, int load, boolean call) {
        if (deslevel > maxlevel || deslevel < minlevel) {
            System.out.println(name + " Wrong level!");
            return -1;
        }
        if (load > (maxload - curload)) {
            System.out.println(name + " Overload!");
            return -1;
        }
        if (!call) {
            curload += load;
        }
        if (curlevel < deslevel) {
            while (curlevel < deslevel) {
                upOne();
                System.out.println(name + " upOne " + curlevel);
            }
        }
        else if (curlevel > deslevel) {
            while (curlevel > deslevel) {
                downOne();
                System.out.println(name + " downOne " + curlevel);
            }
        }
        levelWait(load);
        curload -= load;
        return 1;
    }
    
    public static void main(String[] ris) {
        Elevator e = new Elevator("elevator1", -1, 10, 10);
        System.out.println("Elevator started!!");
        long start = System.currentTimeMillis();
        e.goTo(0, 3, true);
        e.goTo(8, 3, false);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + " seconds used");
    } 
}
