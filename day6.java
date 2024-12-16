import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day6 {
    static boolean up = true;
    static boolean down = false;
    static boolean left = false;
    static boolean right = false;
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("Input.txt");
        String[][] array = new String[fileData.size()][fileData.get(0).length()];
        for (int i = 0; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).length(); j++){
                array[i][j] = fileData.get(i).substring(j,j+1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (up && check(array, i, j) == 1 && array[i][j].equals("^")) {
                    array[i][j] = "X";
                    array[i - 1][j] = "^";
                    i = 0;
                    j = 0;
                    count++;
                }
                if (right && check(array, i, j) == 1 && array[i][j].equals("^")) {
                    array[i][j] = "X";
                    array[i][j + 1] = "^";
                    i = 0;
                    j = 0;
                    count++;
                }
                if (down && check(array, i, j) == 1 && array[i][j].equals("^")) {
                    array[i][j] = "X";
                    array[i + 1][j] = "^";
                    i = 0;
                    j = 0;
                    count++;
                }
                if (left && check(array, i, j) == 1 && array[i][j].equals("^")) {
                    array[i][j] = "X";
                    array[i][j - 1] = "^";
                    i = 0;
                    j = 0;
                    count++;
                }
                if (check(array, i, j) == 0) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
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

    public static int check(String[][] arr,int row, int col){
        if (up){
            if (row-1 >= 0 && arr[row-1][col].equals(".")){
                return 1;
            }else if (row-1 >= 0 && arr[row-1][col].equals("#")){
                System.out.println("cant up");
                changeDir();
                return 2;
            }
        }
        if (down){
            if (row+1 < arr.length && arr[row+1][col].equals(".")){
                return 1;
            }else if (row+1 < arr.length && arr[row+1][col].equals("#")){
                changeDir();
                return 2;
            }
        }
        if (left){
            if (col-1 >= 0 && arr[row][col-1].equals(".")){
                return 1;
            }else if (col-1 >= 0 && arr[row][col-1].equals("#")){
                changeDir();
                return 2;
            }
        }
        if (right){
            if (col+1 >= arr[0].length && arr[row][col+1].equals(".")){
                return 1;
            }else if (col+1 >= arr[0].length && arr[row][col+1].equals("#")){
                changeDir();
                return 2;
            }
        }
        return 0;
    }
    public static void changeDir(){
        if (up){
            up = false;
            right = true;
        }
        if (right){
            right = false;
            down = true;
        }
        if (down){
            down = false;
            left = true;
        }
        if (left){
            left = false;
            up = true;
        }
    }
}