import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //read the input local file
        Scanner input = new Scanner(new File("src/input.txt"));
        String instructions = "";
        while (input.hasNext()) {
            instructions += input.nextLine() + "\n";
        }

        //get every line separated
        List<String> instructionsList = new ArrayList<>(Arrays.asList(instructions.split("\\n")));

        //extract x and y plateau coordinates from first line
        List<String> limitPlateau = new ArrayList<>(Arrays.asList((instructionsList.get(0)).split("\\s")));
        int limitPlateauX = Integer.parseInt(limitPlateau.get(0));
        int limitPlateauY = Integer.parseInt(limitPlateau.get(1));

        //create plateau
        Plateau plateau = new Plateau(limitPlateauX, limitPlateauY);

        //remove first element in the instructions array to obtain just instructions for rovers
        instructionsList.remove(0);

        //check if number of lines is even, which means we have at least two instructions (init and movement for each rover)
        if (instructionsList.size()%2 == 0) {

            //start a loop to create each rover and execute its movement instructions
            for (int index = 0; index < instructionsList.size(); index += 2) {
                String initRover = instructionsList.get(index);
                String roverMoves = instructionsList.get(index+1);

                //extract x, y and orientation for each rover
                List<String> initPosition = new ArrayList<>(Arrays.asList(initRover.split("\\s")));
                Integer initPositionX = Integer.parseInt(initPosition.get(0));
                Integer initPositionY = Integer.parseInt(initPosition.get(1));
                String orientation = initPosition.get(2);

                //create rover object and add it to a list of rovers in plateau object
                Rover rover = new Rover(initPositionX, initPositionY, orientation);
                plateau.addRover(rover);

                //extract movement and orientation instructions
                List<String> movements = new ArrayList<>(Arrays.asList(roverMoves.split("")));

                //execute movement and orientation instructions
                for (int i = 0; i < movements.size(); i++) {
                    String instruction = movements.get(i);
                    switch (instruction) {
                        case "L":
                            rover.rotate("L");
                            break;
                        case "R":
                            rover.rotate("R");
                            break;
                        case "M":
                            rover.move(plateau);
                            break;
                    }
                }
            }
        } else {
            System.out.println("incorrect data format or wrong coordinates syntax");
        }
        System.out.println(plateau.getRoverPositions());

        //write results to a new text file
        try {
            WriteFile data = new WriteFile("src/output.txt", true);
            data.writeToFile(plateau.getRoverPositions());
            System.out.println("Results sent to output file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
