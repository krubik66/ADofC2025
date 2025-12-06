package D04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/D04/fullFile.txt";
        String filePath2 = "src/D04/testFile.txt";
        String filePath3 = "src/D04/smolFile.txt";
        HayBales firstStorage = new HayBales(true);
        HayBales secondStorage = new HayBales(false);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                firstStorage.loadStorageLine(line);
                secondStorage.loadStorageLine(line);
            }
            firstStorage.checkThePositions();
            secondStorage.checkThePositions();
            System.out.println("First charge:\t" + firstStorage.getSumOfMovables());
            System.out.println("Second charge:\t" + secondStorage.getSumOfMovables());
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }
    }
}
