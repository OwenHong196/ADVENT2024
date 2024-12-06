import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("input.txt");
        String[][] xmas = new String[fileData.size()][fileData.get(0).length()];
        for (int i = 0; i < xmas.length; i++){
            for(int j = 0; j < xmas[i].length; j++){
                if(j < xmas.length - 4){
                    if(xmas[i][j].equals("X")){

                    }
                }
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
