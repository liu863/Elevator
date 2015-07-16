

public class Elevatora {
    
    private Elevator[] ea;
    private int elevatornum;
    
    public Elevatora(int num, int maxlevel, int minlevel, int maxload) {
        elevatornum = num;
        ea = new Elevator[elevatornum];
        for (int i = 0; i < elevatornum; i++) {
            ea[i] = new Elevator("elevator" + i, maxlevel, minlevel, maxload);
        }
    }
    
    public void runElevator() {
        //ri gou
    }
    
    public static void main(String[] ris) {
        Elevatora ela = new Elevatora(2, 10, 0, 10);
        ela.runElevator();
    }
}