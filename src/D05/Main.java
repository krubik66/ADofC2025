package D05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/D05/fullFile.txt";
        String filePath2 = "src/D05/testFile.txt";
        LoadFood firstCharge = new LoadFood(true);
        LoadFood secondCharge = new LoadFood(false);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                firstCharge.loadTheCharge(line);
                secondCharge.loadTheCharge(line);
            }
            System.out.println("First charge:\t" + firstCharge.getSumOfFresh());
            System.out.println("Second charge:\t" + secondCharge.getSumOfFresh());
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }
    }
}
