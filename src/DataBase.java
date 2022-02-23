import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {

    private static File file = new File("src/resources/danske-postnumre-byer.csv");
    private static Scanner fileScanner;


    private static void setupScanner(){
        try{
            fileScanner = new Scanner(file);
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file");
        }
    }

    public static ArrayList<PostInfo> getPostalCodes(){

        setupScanner();

        ArrayList<PostInfo> postalNumbers = new ArrayList<>();

        fileScanner.nextLine();
        while (fileScanner.hasNextLine()){

            String[] elements = fileScanner.nextLine().split(";");

            int postalCode = Integer.parseInt(elements[0]);
            String townName = elements[1];

            postalNumbers.add(new PostInfo(postalCode, townName));

        }
        return postalNumbers;

    }


}
