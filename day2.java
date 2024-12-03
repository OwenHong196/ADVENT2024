import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Day2Input.txt");
        int safe = 0;
        for(int i = 0; i < fileData.size(); i++){
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < fileData.size(); j++){
                String[] split = fileData.get(i).split(" ");
                line.add(Integer.parseInt(split[0]));
            }
            int[] nums = new int[line.size()];
            System.out.println(line);
            System.out.println(nums);
            for (int m = 0; m < line.size(); m++){
                nums[m] = line.get(m);
            }
            boolean good = true;
            for(int k = 1; k < line.size(); k++){
                if (!(nums[k-1] < nums[k]
                        && nums[k] - nums[k-1] <= 3
                        && nums[k] - nums[k-1] >= 1) ){
                    good = false;
                }
            }
            if (good){
                safe ++;
            }
            good = true;
            for(int l = 1; l < line.size(); l++){
                if (!(nums[l-1] > nums[l]
                        && nums[l-1] - nums[l] <= 3
                        && nums[l-1] - nums[l] >= 1) ){
                    good = false;
                }
            }
            if (good){
                safe ++;
            }
        }
        System.out.println(safe);
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
