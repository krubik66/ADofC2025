package D02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/D02/fullFile.txt";
        String filePath2 = "src/D02/testFile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                IDIdentificator apprise = new IDIdentificator(line, false);
                IDIdentificator appriseAll = new IDIdentificator(line, true);
                System.out.println("Magical number should be:\t" + apprise.getSumOfId());
                System.out.println("Or maybe:\t\t\t\t\t" + appriseAll.getSumOfId());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath2);
            e.printStackTrace();
        }
    }
}
