import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Plateau {
    private int topRightX;
    private int topRightY;
    private List<Rover> rovers = new ArrayList<>();

    //change string to number
    public Plateau(int topRightX, int topRightY) {
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    //get limits of x to be used in the "move" function at Rover class
    public int getXlimit() {
        return topRightX;
    }

    //get limits of y to be used in the "move" function at Rover class
    public int getYlimit() {
        return topRightY;
    }

    //add rovers to the plateau
    public void addRover(Rover rover) {
        this.rovers.add(rover);
    }

    //get rovers position from the plateau
    public List<String> getRoverPositions(){
        return rovers.stream()
                .map (rover -> rover.toString())
                .collect(Collectors.toList());
    }
}
