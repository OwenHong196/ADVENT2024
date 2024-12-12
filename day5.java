import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day5 {
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static void part1() {
        ArrayList<String> fileData = getFileData("Input.txt");
        int sum = 0;
        for (int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> nums = new ArrayList<>() {
            };
            if (!fileData.get(i).contains("|")) {
                String[] split = fileData.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    nums.add(Integer.parseInt(split[j]));
                }
            }
            if (nums.size() > 0) {
                boolean check = true;
                boolean exists = false;
                for (int k = 0; k < nums.size() - 1; k++) {
                    for (int j = 0; j < fileData.size(); j++) {
                        if (fileData.get(j).equals(nums.get(k) + "|" + nums.get(k + 1))) {
                            exists = true;
                        } else if (fileData.get(j).equals(nums.get(k + 1) + "|" + nums.get(k))) {
                            exists = true;
                            check = false;
                        }
                    }
                }
                if (!exists || check) {
                    sum += nums.get(nums.size() / 2);
                }
            }
        }
        System.out.println(sum);
    }

    public static void part2() {
        ArrayList<String> fileData = getFileData("Input.txt");
        int sum = 0;
        for (int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> nums = new ArrayList<>() {
            };
            if (!fileData.get(i).contains("|")) {
                String[] split = fileData.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    nums.add(Integer.parseInt(split[j]));
                }
            }
            if (nums.size() > 0) {
                boolean check = false;
                for (int k = 0; k < nums.size() - 1; k++) {
                    for (int j = 0; j < fileData.size(); j++) {
                       if (fileData.get(j).equals(nums.get(k + 1) + "|" + nums.get(k))) {
                            int x = nums.remove(k+1);
                            nums.add(k,x);
                            k = 0;
                            check = true;
                       }
                    }
                }
                if (check) {
                    sum += nums.get(nums.size() / 2);
                }
            }
        }
        System.out.println(sum);
    }
}