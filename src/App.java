import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final Scanner SCAN = new Scanner(System.in);
    private static ArrayList<PostInfo> postInfos = DataBase.getPostalCodes();


    public static void run(){

        int choice = 0;
        while (choice != 4){

            System.out.println("================================================");
            System.out.println("           THE POSTALCODE INFO APP              ");
            System.out.println("================================================");
            System.out.println("1. Get postalcode from a town name");
            System.out.println("2. Get town from postalcode");
            System.out.println("3. View all postalcodes and corresponding towns");
            System.out.println("4. Exit");

            choice = validateUserIntInput(1, 4);

            switch (choice){
                case 1:
                    getPostalCodeMenu();
                    break;
                case 2:
                    getTownNameMenu();
                    break;
                case 3:
                    viewAllPostalcodes();
                    break;
                case 4:
                    System.out.println("Thank you for using this program :)");
                    break;
            }
        }
    }

    private static void getTownNameMenu(){
        System.out.println("Insert a postal code");

        int postalCode = validateUserIntInput(0, 9999);

        System.out.println(getTownFromPostalCode(postalCode));
        System.out.println();
    }

    private static void getPostalCodeMenu(){
        System.out.println("Insert a Town name");

        String townName = SCAN.nextLine();

        System.out.println(getPostalCodeFromTownName(townName.toLowerCase()));
        System.out.println();
    }

    private static PostInfo getTownFromPostalCode(int postalCode){

        for (PostInfo postinfo : postInfos) {

            if (postalCode == postinfo.getPostalCode()){
                return postinfo;
            }
        }
        System.out.println("No town corresponse to that postalcode");
        return null;
    }

    private static PostInfo getPostalCodeFromTownName(String townName){

        for (PostInfo postinfo : postInfos) {

            if (townName.equals(postinfo.getTownName().toLowerCase())){
                return postinfo;
            }
        }
        System.out.println("No postalcode corresponse to that town");
        return null;
    }

    private static void viewAllPostalcodes(){

        for (PostInfo postinfo : postInfos) {
            System.out.println(postinfo);
        }
    }

    public static int validateUserIntInput(int minValue, int maxValue) {
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = SCAN.nextInt();
                if (returnNum >= minValue && returnNum <= maxValue) {
                    SCAN.nextLine();
                    run = false;
                } else {
                    System.out.println("The number has to be between " + (minValue) + " and " + (maxValue));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                SCAN.next();
            }
        }
        return returnNum;
    }

}
