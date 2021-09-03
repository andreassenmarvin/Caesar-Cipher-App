import java.util.Scanner;

public class App {
    private String text;
    private int key;

    public static void main (String[] args) {
        boolean loopRunning = true;

        while(loopRunning) {
            System.out.println("---------------------------------------------");
            System.out.println("WELCOME TO CAESAR CYPHER APP; HAVE FUN!");
            System.out.println("---------------------------------------------");
            System.out.println("Enter either of the options below to proceed:");
            System.out.println("1. Encrypt text.");
            System.out.println("2. Decrypt text.");
            System.out.println("Enter 0 to exit:");
            System.out.println("0. Exit.");
            System.out.println("---------------------------------------------");
            Scanner newScanner = new Scanner(System.in);
            int option = newScanner.nextInt();


            if (option == 1) {
                System.out.println("Let's encrypt your text.");
                newScanner.nextLine();
                System.out.println("Enter Text:");
                String text = newScanner.nextLine();
                System.out.println("-------------------------------------------");
                System.out.println("Enter decryption key between 1 to 25:");
                Integer key = Integer.parseInt(newScanner.nextLine());

                Encrypt newEncryption = new Encrypt(text, key);

                if(!newEncryption.isString()) {
                    System.out.println("Invalid Entry");
                }

                if (!newEncryption.isInRange()) {
                    System.out.println("Your key is out of range.Please try again.");
                }

                else {
                    String encryptedText = newEncryption.forward();
                    System.out.println(String.format("Your encrypted text is: %s", encryptedText + "."));
                }

            }
            else if (option == 2) {
                System.out.println("Let's decrypt your text.");
                newScanner.nextLine();
                System.out.println("Enter Text:");
                String text = newScanner.nextLine();
                System.out.println("-------------------------------------------");
                System.out.println("Enter any key between 1 to 25:");
                Integer key = Integer.parseInt(newScanner.nextLine());

                Encrypt newEncryption = new Encrypt(text, key);

                if(!newEncryption.isString()) {
                    System.out.println("Invalid Entry");
                }

                if (!newEncryption.isInRange()) {
                    System.out.println("Your key is out of range.Please try again.");
                }

                else {
                    String encryptedText = newEncryption.forward();
                    Decrypt newDecryption = new Decrypt(encryptedText, key);
                    String deryptedText = newDecryption.backward();
                    System.out.println(String.format("Your decrypted text is: %s", deryptedText + "."));
                }
            }

            else if (option == 0) {
                System.out.println("Exit");
                loopRunning=false;
            }

            else if (option > 3 || option < 3) {
                System.out.println("Choose a valid choice");
            }

            else {
                System.out.println("Error occured!");
            }
        }


    }


}
