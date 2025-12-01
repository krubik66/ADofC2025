package D01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Safe safe = new Safe(50);
        Safe safe0x434C49434B = new Safe(50);
        String filePath = "src/D01/mythicalFile.txt";
        String filePath2 = "src/D01/smallFile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                safe.move(line);
                safe0x434C49434B.move0x434C49434B(line);
                System.out.print(safe0x434C49434B.showProgress(line));
            }
            System.out.println("Magical number should be: " + safe.giveNumbers());
            System.out.println("Or maybe: " + safe0x434C49434B.giveNumbers());
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }
    }
}
