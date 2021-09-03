import java.io.BufferedReader;
import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Have fun interacting with our app!");
        boolean programmeLoop = true;

        while(programmeLoop){
            System.out.println("------------------------------------------------------");
            System.out.println("Enter one of the options below to proceed");
            System.out.println("A. Encrypt And Decrypt Text");
            System.out.println("B. Encrypt And Decrypt File");
            System.out.println("C. Exit");
            try{


                String choice = myObj.readLine();
                System.out.println(choice);

                if(choice.equals("A")){

                    System.out.print("Please enter your text");
                    String originalMessage = myObj.readLine();

                    System.out.print("Please enter  Key between 1 and 25");
                    int shiftKey = Integer.parseInt(myObj.readLine());

                    if(shiftKey>0 && shiftKey<26){
                        Caesar msgCaesar = new Caesar(originalMessage,shiftKey);
                        EncryptClass msgEncrypt = new EncryptClass();
                        Decrypt msgDecrypt =new Decrypt();

                        msgEncrypt.EncryptMessage(msgCaesar.getMessage(), msgCaesar.getShiftKey());
                        msgDecrypt.decryptMessage(msgEncrypt.getEncryptedMessage(),msgCaesar.getShiftKey() );

                        System.out.println("Input Message :"+ originalMessage);
                        System.out.println("Encrypted Message :"+msgEncrypt.getEncryptedMessage() );

                        System.out.println("Decrypted Message :"+msgDecrypt.getDecryptedMessage() );
                    }else{
                        System.out.println(" Key Must be between 1 and 25");

                    }
                }else if(choice.equals("B")){
                    System.out.println("Enter File Path.Example D://data.txt");
                    String filePath = myObj.readLine();
                    System.out.print("PLease enter  Key between 1 and 25");
                    int shiftKey = Integer.parseInt(myObj.readLine());



                    File file = new File(filePath);
                    myObj reader = new myObj(new FileReader(file));
                    String line;



                    if(shiftKey>0 && shiftKey<26){


                        while((line = reader.readLine()) != null) {
                            Caesar msgCaesar = new Caesar(line,shiftKey);
                            EncryptClass msgEncrypt = new EncryptClass();
                            Decrypt msgDecrypt =new Decrypt();

                            msgEncrypt.EncryptMessage(msgCaesar.getMessage(), msgCaesar.getShiftKey());
                            msgDecrypt.decryptMessage(msgEncrypt.getEncryptedMessage(),msgCaesar.getShiftKey() );

                            System.out.println("FILE ORIGINAL CONTENT: " + line);
                            System.out.println("Encrypted Message :"+msgEncrypt.getEncryptedMessage() );

                            System.out.println("Decrypted Message :"+msgDecrypt.getDecryptedMessage() );
                        }
                    }else{
                        System.out.println(" Key Must be between 1 and 25");
                    }

                }else if(choice.equals("C")) {
                    System.out.println("Successful Exit");
                    programmeLoop = false;
                }else {
                    System.out.println("Invalid Choice please try again");
                }



            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}