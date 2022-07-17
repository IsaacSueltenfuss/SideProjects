import java.io.File;
import java.io.IOException;
import java.util.*;

public class Cora {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("D:/Programming/Personal/SideProjects/2022/cora.dat"));

        int numberOfTimes = file.nextInt();
        file.nextLine();

        for (; numberOfTimes > 0; numberOfTimes--) {
            String word = file.nextLine().trim();

            if (word.charAt(0) < word.charAt(1)) {
                for (int letter = word.charAt(0); letter <= word.charAt(1); letter++) {
                    for (int repetitions = letter - word.charAt(0); repetitions >= 0; repetitions--) {
                        System.out.print((char) letter);
                    }
                    System.out.print((letter == word.charAt(1) ? "\n\n" : "\n"));
                } 
            }

            else if (word.charAt(1) < word.charAt(0)) {
                for (int letter = word.charAt(0); letter >= word.charAt(1); letter--) {
                    for (int repetitions = letter - word.charAt(1); repetitions >= 0; repetitions--) {
                        System.out.print((char) letter);
                    }
                    System.out.print((letter == word.charAt(1) ? "\n\n" : "\n"));
                }
            }

            else {
                System.out.print(word.charAt(0));
            }
        }
    }
}
