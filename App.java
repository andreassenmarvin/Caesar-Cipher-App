import java.io.BufferedReader;
import java.io.Console;
import java.util.Scanner;

public class App {
    private String text;
    private int key;

    public static void main (String[] args){

        boolean loopRunning = true;

        while(loopRunning){
            System.out.println("Have fun interacting with the app");
            System.out.println("Enter either of the options to proceed");
            System.out.print("1. Encrypt text:");
            System.out.println("2. Decrypt text:");
            Scanner newScanner = new Scanner(System.in);
            int option = newScanner.nextInt();

            if (option == 1){
                System.out.println("Let's encrypt your text");
                newScanner.nextLine();
                System.out.println("Enter Text:");
                String text = newScanner.nextLine();

                System.out.println("Enter decryption key between 1 to 25:");
                Integer key = Integer.parseInt(newScanner.nextLine());

                Encrypt newEncryption = new Encrypt(text, key);
                System.out.print("Enter either of the options to proceed: ");

                if(!newEncryption.isString()){
                    System.out.println("Invalid Entry");
                }

                if (!newEncryption.isInRange()){
                    System.out.println("Key Range is between 1 and 25");
                }

                String encryptedText = newEncryption.forward();
                System.out.println(String.format("Your encrypted text is: %s", encryptedText));

            }
            else if (choice == 2){
                System.out.println("Let's decrypt your text");
                newScanner.nextLine();
                System.out.println("Enter Text:");
                String text = newScanner.nextLine();
                System.out.println("Enter any key between 1 to 25:");
                Integer key = Integer.parseInt(newScanner.nextLine());

                Encrypt newEncryption = new Encrypt(text, key);

                if(!newEncryption.isString()){
                    System.out.println("Invalid Entry");
                }

                if (!newEncryption.isInRange()){
                    System.out.println("Key Range is between 1 and 25");
                }

                String encryptedText = newEncryption.forward();

                Decrypt newDecryption = new Decrypt(encryptedText, key);

                String deryptedText = newDecryption.backward();
                System.out.println(String.format("Your decrypted text is: %s", deryptedText));
            }

            else if (choice == 3){
                System.out.println("Exit");
                loopRunning=false;
            }else if (option > 3 || option < 3){
                System.out.println("Choose a valid choice");
            }
            else {
                System.out.println("Error occured!");
            }
        }


    }



}
