import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        part1();
        part2();
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
    public static void part1(){
        ArrayList<String> fileData = getFileData("Day2Input.txt");
        int safe = 0;
        for(int i = 0; i < fileData.size(); i++){
            ArrayList<Integer> nums = new ArrayList<>();
            String[] split = fileData.get(i).split(" ");
            for (int j = 0; j < split.length; j++){
                nums.add(Integer.parseInt(split[j]));
            }
            boolean inc = true;
            if (nums.get(0) > nums.get(1)){
                inc = false;
            }
            if (inc){
                boolean good = true;
                for(int j = 0; j < nums.size()-1; j++){
                    if(!(nums.get(j) < nums.get(j+1)
                            && 1 <= nums.get(j+1) - nums.get(j)
                            && nums.get(j+1) - nums.get(j) <= 3)){
                        good = false;
                    }
                }
                if (good){
                    safe ++;
                }
            }else{
                boolean good = true;
                for(int k = 0; k < nums.size()-1; k++){
                    if(!(nums.get(k+1) < nums.get(k)
                            && 1 <= nums.get(k) - nums.get(k+1)
                            && nums.get(k) - nums.get(k+1) <= 3)){
                        good = false;
                    }
                }
                if (good){
                    safe ++;
                }
            }
        }
        System.out.println(safe);
    }
    public static void part2(){
        ArrayList<String> fileData = getFileData("Day2Input.txt");
        int safe = 0;
        for(int i = 0; i < fileData.size(); i++){
            ArrayList<Integer> nums = new ArrayList<>();
            String[] split = fileData.get(i).split(" ");
            for (int j = 0; j < split.length; j++){
                nums.add(Integer.parseInt(split[j]));
            }
            boolean inc = true;
            int placeholder = nums.remove(0);
            if (nums.get(0) > nums.get(1)){
                inc = false;
            }else{
                nums.add(0,placeholder);
            }
            if (inc){
                boolean removed = false;
                boolean good = true;
                for(int j = 0; j < nums.size()-1; j++){
                    if(!(nums.get(j) < nums.get(j+1)
                            && 1 <= nums.get(j+1) - nums.get(j)
                            && nums.get(j+1) - nums.get(j) <= 3)){
                        if (!removed){
                            nums.remove(j);
                            removed = true;
                            j--;
                        }else {
                            good = false;
                            System.out.println("inc");
                        }
                    }
                }
                if (good){
                    safe ++;
                    System.out.println("goodinc");
                }
            }else{
                boolean removed = false;
                boolean good = true;
                for(int k = 0; k < nums.size()-1; k++){
                    if(!(nums.get(k+1) < nums.get(k)
                            && 1 <= nums.get(k) - nums.get(k+1)
                            && nums.get(k) - nums.get(k+1) <= 3)){
                        if (!removed){
                            nums.remove(k);
                            removed = true;
                            k--;
                        }else {
                            good = false;
                            System.out.println("dec");
                        }
                    }
                }
                if (good){
                    safe ++;
                    System.out.println("gooddec");
                }
            }
        }
        System.out.println(safe);
    }
}
