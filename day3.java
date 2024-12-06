import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
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
        // egrep -o "mul\\([0-9]+,[0-9]+\\)|do()" input | sed 's/mul(//g' | sed 's/)/ /g'
        ArrayList<String> fileData = getFileData("input.txt");
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for (int i = 0; i < fileData.size(); i++){
            String[] split = fileData.get(i).split(",");
            left.add(Integer.parseInt(split[0]));
            right.add(Integer.parseInt(split[1]));
        }
        int sum = 0;
        System.out.println(left);
        for(int j = 0; j < left.size(); j++){
            int num = left.get(j) * right.get(j);
            sum += num;
        }
        System.out.println(sum);
    }

    public static void part2(){
        //egrep -o "mul\\([0-9]+,[0-9]+\\)|do()|don't()" input | sed 's/mul(//g' | sed 's/)/ /g'
        ArrayList<String> fileData = getFileData("input.txt");
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        boolean can = true;
        for (int i = 0; i < fileData.size(); i++){
            if(fileData.get(i).equals("do")){
                can = true;
            } else if (fileData.get(i).equals("don't")) {
                can = false;
            }else {
                if (can){
                String[] split = fileData.get(i).split(",");
                left.add(Integer.parseInt(split[0]));
                right.add(Integer.parseInt(split[1]));
                }
            }
        }
        int sum = 0;
        System.out.println(left);
        for(int j = 0; j < left.size(); j++){
            int num = left.get(j) * right.get(j);
            sum += num;
        }
        System.out.println(sum);
    }
}
