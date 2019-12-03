package jsonparsers.coordinates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WorkerCoordinates {

    static public void getCoordinates(String nameFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nameFile));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.replace("(", "");
            line = line.replace(")", "");
            String[] newLine = line.split(",");
            System.out.println(newLine[0] + "\t"
                    + newLine[1].replace(".", ",") + "\t"
                    + newLine[2].replace(".", ",") + "\t"
                    + newLine[3].replace(".", ",") + "\t"
                    + newLine[4].replace(".", ",") + "\t"
                    + newLine[5].replace(".", ",") + "\t"
                    + newLine[6].replace(".", ","));

        }

    }

    public static void main(String[] args) throws IOException {
        getCoordinates("C:\\Users\\User\\Desktop\\работа с gephi\\coordinates1.csv");
    }

}
