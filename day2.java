import java.io.File;
import java.io.FileNotFoundException;
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
        ArrayList<String> fileData = getFileData("input.txt");
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
        System.out.println(incP2()+decP2());
    }
    public static int incP2(){
        ArrayList<String> fileData = getFileData("input.txt");
        int safe = 0;
        for(int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            String[] split = fileData.get(i).split(" ");
            for (int j = 0; j < split.length; j++) {
                nums.add(Integer.parseInt(split[j]));
            }
            boolean removed = false;
            boolean good = true;
            for (int j = 0; j < nums.size() - 1; j++) {
                if (!(nums.get(j+1) > nums.get(j)
                        && 1 <= nums.get(j + 1) - nums.get(j)
                        && nums.get(j + 1) - nums.get(j) <= 3)) {
                    if (!removed) {
                        int x = nums.remove(j);
                        if (j+1 < nums.size() && !(nums.get(j+1) > nums.get(j)
                                && 1 <= nums.get(j + 1) - nums.get(j)
                                && nums.get(j + 1) - nums.get(j) <= 3)) {
                            nums.add(j,x);
                            nums.remove(j+1);
                        }
                        if (j == nums.size()-1 && !(nums.get(j-1) > nums.get(j)
                                && 1 <= nums.get(j) - nums.get(j-1)
                                && nums.get(j) - nums.get(j-1) <= 3)){
                            nums.remove(j);
                        }
                        removed = true;
                        j = -1;
                    } else {
                        good = false;
                        break;
                    }
                }
            }
            if (good) {
                safe++;
            }
        }
        return safe;
    }
    public static int decP2(){
        ArrayList<String> fileData = getFileData("input.txt");
        int safe = 0;
        for(int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            String[] split = fileData.get(i).split(" ");
            for (int j = 0; j < split.length; j++) {
                nums.add(Integer.parseInt(split[j]));
            }
            boolean removed = false;
            boolean good = true;
            for (int j = 0; j < nums.size() - 1; j++) {
                if (!(nums.get(j) > nums.get(j + 1)
                        && 1 <= nums.get(j) - nums.get(j + 1)
                        && nums.get(j) - nums.get(j + 1) <= 3)) {
                    if (!removed) {
                        int x = nums.remove(j);
                        if (j+1 < nums.size() && !(nums.get(j) > nums.get(j + 1)
                                && 1 <= nums.get(j) - nums.get(j + 1)
                                && nums.get(j) - nums.get(j + 1) <= 3)){
                            nums.add(j,x);
                            nums.remove(j+1);
                        }
                        if (j == nums.size()-1 && !(nums.get(j-1) < nums.get(j)
                                && 1 <= nums.get(j-1) - nums.get(j)
                                && nums.get(j-1) - nums.get(j) <= 3)){
                            nums.remove(j);
                        }
                        removed = true;
                        j = -1;
                    } else {
                        good = false;
                        break;
                    }
                }
            }
            if (good) {
                safe++;
            }
        }
        return safe;
    }
}
