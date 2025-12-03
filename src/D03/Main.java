package D03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/D03/fullFile.txt";
        String filePath2 = "src/D03/testFile.txt";
        LoadCharges firstCharge = new LoadCharges(true);
        LoadCharges secondCharge = new LoadCharges(false);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                firstCharge.loadTheCharge(line);
                secondCharge.loadTheCharge(line);
            }
            System.out.println("First charge:\t" + firstCharge.getSumOfCharges());
            System.out.println("Second charge:\t" + secondCharge.getSumOfCharges());
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }
    }
}
