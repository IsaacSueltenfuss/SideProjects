import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Encryption {
    private static String cipher = "";
    private static String requisites = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*() ";

    public static void main(String[] args) {
        prepareCipher();
        Scanner kb = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\nWelcome to the Encryption/Decryption Tool!\nPlease execute one of the following:\n1) Load A Customized Cipher\n2) Encrypt a Message\n3) Decrypt a Message\n4) Exit the Program\n");
            try {
                int status = kb.nextInt();
                if(kb.hasNextLine()) {
                    kb.nextLine();
                }

                switch (status) {
                    case 1:
                        System.out.print("Please enter your chosen cipher: ");
                        System.out.println("\nCustom cipher " + loadCipher(kb.nextLine()) + " has been loaded.");
                        break;
                    case 2:
                        System.out.print("Please enter your message: ");
                        System.out.println("\nEncrypted Message = '" + encrypt(kb.nextLine()) + "'");
                        break;
                    case 3:
                        System.out.print("Please enter your coded message: ");
                        System.out.println("\nDecrypted Message = '" + decrypt(kb.nextLine()) + "'");
                        break;
                    default:
                        running = false;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        kb.close();
    }

    // Randomizes the order of the key so as to accurately encrypt messages
    private static void prepareCipher() {
        List<String> output = Arrays.asList(requisites.split(""));
        Collections.shuffle(output);
        cipher = String.join("", output);
    }

    // Users can load a customized key to encrypt or decrypt select messages
    private static String loadCipher(String input) {
        cipher = input;
        return cipher;
    }

    // Encrypts a message by converting each of an input's letters to the key and then to the requisites variable
    private static String encrypt(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(requisites.charAt(cipher.indexOf(input.charAt(i))));
        }
        return output.toString();
    }

    // Decrypts a message by converting each of an input's letters from the requisites to the key
    private static String decrypt(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int initialIndex = requisites.indexOf(input.charAt(i));
            output.append(cipher.charAt(initialIndex));
        }
        return output.toString();
    }
}