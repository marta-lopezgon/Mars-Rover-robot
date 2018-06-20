import java.util.LinkedHashMap;
import java.util.Map;

public class Rover {
    private int xPosition; //= x at input
    private int yPosition; //= y at input
    private String orientation; //= N/S/E/O at input

    //change x and y string to number
    public Rover(int xPosition, int yPosition, String orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }

    //rotate left or right
    public void rotate(String direction) {
        if (direction.equals("L")) {
            switch (this.orientation) {
                case "N":
                    this.orientation = "W";
                    break;
                case "E":
                    this.orientation = "N";
                    break;
                case "S":
                    this.orientation = "E";
                    break;
                case "W":
                    this.orientation = "S";
                    break;
            }

        } else if (direction.equals("R")) {
            switch (this.orientation) {
                case "N":
                    this.orientation = "E";
                    break;
                case "E":
                    this.orientation = "S";
                    break;
                case "S":
                    this.orientation = "W";
                    break;
                case "W":
                    this.orientation = "N";
                    break;
            }
        } else {
            System.out.println("Incorrect Orientation parameter: " + direction);
        }
    }

    //move forward without going out of the plateau using functions from the Plateau class
    public void move(Plateau plateau) {
        int xlimit = plateau.getXlimit();
        int ylimit = plateau.getYlimit();

        if (this.orientation.equals("N") && this.yPosition < ylimit) {
            this.yPosition += 1;
        } else if (this.orientation.equals("S") && this.yPosition > 0) {
            this.yPosition -= 1;
        } else if (this.orientation.equals("E") && this.xPosition < xlimit) {
            this.xPosition += 1;
        } else if (this.orientation.equals("W") && this.xPosition > 0) {
            this.xPosition -= 1;
        } else {
            System.out.println("Out of plateau limits");
        }
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public String getOrientation() {
        return orientation;
    }

    //show current position
    public String toString() {
        return xPosition + " " + yPosition + " " + orientation;
    }

    //show current position in a different format
    public Map<String, Object> getPosition() {
        Map<String, Object> position = new LinkedHashMap<>();
        position.put("X", getxPosition());
        position.put("Y", getyPosition());
        position.put("orientation", getOrientation());

        return position;
    }
}
