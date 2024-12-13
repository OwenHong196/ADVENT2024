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
        boolean up = true;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if(array[i][j].equals("^")){
                    if (check(up,down,left,right,array,i,j)){
                        array
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
    public static boolean check(boolean up, boolean down, boolean left, boolean right, String[][] arr,int row, int col){
        if (up){
            if (row-1 >= 0 && arr[row-1][col].equals(".")){
                return true;
            }
        }
        if (down){
            if (row+1 < arr.length && arr[row+1][col].equals(".")){
                return true;
            }
        }
        if (left){
            if (col-1 >= 0 && arr[row][col-1].equals(".")){
                return true;
            }
        }
        if (right){
            if (col+1 >= arr[0].length && arr[row][col+1].equals(".")){
                return true;
            }
        }
        return false;
    }
}