import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Task_1 {
    private static boolean Ship_menu = true;


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String[] cabins = new String[13];


        initialise(cabins);


        while (Ship_menu) {
            System.out.println("........Enter your Selection........");
            System.out.println("Enter an ‘A’ to add a customer to a cabin");
            System.out.println("Enter a ‘V’ to view all cabins");
            System.out.println("Enter 'E' to Display Empty cabins");
            System.out.println("Enter 'D' to Delete customer from cabin");
            System.out.println("Enter 'F' to Find cabin from customer name");
            System.out.println("Enter 'S' to Store program data into file");
            System.out.println("Enter 'L' to Load program data from file");
            System.out.println("Enter 'O' to View passengersOrdered alphabetically by name");

            String selection = input.next();
            selection = selection.toUpperCase(Locale.ROOT);

            switch (selection) {
                case "A":
                    addcustomer(cabins);
                    break;

                case "V":
                    viewallcabins(cabins);
                    break;

                case "E":
                    emptycabins(cabins);
                    break;

                case "D":
                    delcuscabin(cabins);
                    break;

                case "F":
                    findpassenger(cabins);
                    break;

                case "S":
                    storefile(cabins);
                    break;

                case "L":
                    loadprogdata(cabins);
                    break;

                case "O":
                    ordername(cabins);
                    break;

                default:
                    System.out.println("...Invalid Input...");
                    break;

            }
            boolean choice = true;

            while (choice) {
                try {
                    System.out.println("Please Enter 1 Continue or 2 Exit: ");
                    int com = input.nextInt();

                    if (com == 1) {
                        Ship_menu = true;
                        choice = false;
                    } else if (com == 2) {
                        Ship_menu = false;
                        choice = false;
                       /* if (com.equals("1") ) {
                            S_menu = true;
                            choice = false;
                        } else if (com.equals("2")){
                            S_menu = false;
                            choice = false;*/
                    } else {
                        System.out.println("...Invalid Input...");
                    }
                } catch (Exception e) {
                    System.out.println("...Invalid Input...");
                    System.out.println("");
                    break;
                }
            }
        }


    }

    private static void initialise(String cabinsRef[]) {
        for (int x = 0; x < 13; x++) cabinsRef[x] = "empty";
        System.out.println("initilise ");
    }

    private static void addcustomer(String[] cabins) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Cabin Number 1 to 12: ");
            int CabinNum = input.nextInt();

            if (CabinNum < 13 && CabinNum > 0) {

                System.out.println("Please Enter Name for Cabin Number  " + CabinNum + ": ");
                String cabinName = input.next();
                cabins[CabinNum] = cabinName;
            } else {
                System.out.println("...Invalid number (1-12)...");
            }
        }catch (Exception e) {
            System.out.println("...Invalid Input...");
            System.out.println("");
        }

    }

    private static void viewallcabins(String[] cabins){
        for (int x=1; x< cabins.length; x++){
            if(cabins[x].equals("empty")){
                System.out.println("Cabin number " + x + " is Empty");
            }else{

                System.out.println("Cabin " + x +" Occupied by " + cabins[x]);




            }

        }
    }

    private static void emptycabins(String[] cabins){
        for (int x=1; x<cabins.length; x++){
            if (cabins[x].equals("empty")){
                System.out.println("Cabin " + x + " is empty");
            }
        }

    }

    private static void delcuscabin(String[] cabins){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the Cabin number to remove : ");
            int roomNumber=input.nextInt();
            cabins[roomNumber] = "empty";
            System.out.println("...Removed Successfully... ");

        }catch (Exception e) {
            System.out.println("...Invalid Input...");
            System.out.println("");
        }

    }

    private static void findpassenger(String[] cabins){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the passenger Name: ");
            String cus_name = input.next();

            for(int i=0; i<cabins.length; i++){
                if(cabins[i].equals(cus_name)){
                    System.out.println(cus_name + " is in Cabin Number " + i);
                }
            }
        }catch (Exception e) {
            System.out.println("...Invalid Input...");
            System.out.println("");
        }

    }

    private static void storefile(String[] cabins)throws FileNotFoundException {
        File infofile = new File("file1.txt");
        PrintStream writer = new PrintStream(infofile);

        for (String temp : cabins){
            writer.println(temp);
        }

        System.out.println("Successfully Saved...");
        writer.close();

    }

   private static void loadprogdata(String[] cabins) throws IOException {
        int i=1;
        try {
            File inputFile = new File("file1.txt");
            Scanner rf = new Scanner(inputFile);
            String fileLine;
            while (rf.hasNext()){
                fileLine = rf.nextLine();

                System.out.println( fileLine);

            }rf.close();
        }catch(IOException e){
            System.out.println("xx");
        }
    }

    private static void ordername(String[] cabins){
        String []cabinArray = new String[cabins.length];
        for(int i = 0; i < cabins.length; i++){
            cabinArray[i] = cabins[i];
        }


        int n = cabinArray.length;
        for (int x = 0; x < n - 1; x++)
        {
            for(int y = 0; y <= n - 2; y++)
            {
                if (cabinArray[y].compareToIgnoreCase(cabinArray[y + 1]) > 0)
                {
                    String temp = cabinArray[y];
                    cabinArray[y] = cabinArray[y + 1];
                    cabinArray[y + 1] = temp;
                }
            }
        }

        for(String temp:cabinArray){
            if(!temp.equals("empty")) {
                System.out.println(temp);
            }
        }




}

}