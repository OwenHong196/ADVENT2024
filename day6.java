import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Input.txt");
        String[][] array = new String[fileData.size()][fileData.get(0).length()];
        for (int i = 0; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).length(); j++){
                array[i][j] = fileData.get(i).substring(j,j+1);
            }
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}