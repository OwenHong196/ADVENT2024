import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        int distance = 0;
        ArrayList<String> fileData = getFileData("Day2Input.txt");
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i = 0; i < fileData.size(); i++){
            String[] split = fileData.get(i).split(",");
            left.add(Integer.parseInt(split[0]));
            right.add(Integer.parseInt(split[1]));
            System.out.println("add?");
        }
        int sum = 0;
        System.out.println(left);
        for(int j = 0; j < left.size(); j++){
            int num = left.get(j) * right.get(j);
            sum += num;
        }
        System.out.println(sum);
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
