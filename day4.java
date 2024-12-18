import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("input.txt");
        String[][] xmas = new String[fileData.size()][fileData.get(0).length()];
        for(int i = 0; i < fileData.size(); i++){
            for(int j = 0; j < fileData.get(0).length(); j++){
                xmas[i][j]=fileData.get(i).substring(j,j+1);
            }
        }
        int count = 0;
        for (int i = 0; i < xmas.length; i++){
            for(int j = 0; j < xmas[i].length; j++){
                //down down
                try{
                    if (downRight(xmas,i,j) && downLeft(xmas,i,j+2)){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //down up
                try{
                    if (downRight(xmas,i,j) && upRight(xmas,i+2,j)){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //up up
                try{
                    if (upRight(xmas,i,j) && upLeft(xmas,i,j+2)){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //up down
                try{
                    if (upLeft(xmas,i,j) && downLeft(xmas,i-2,j)){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
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

    public static void part1(){
        ArrayList<String> fileData = getFileData("input.txt");
        String[][] xmas = new String[fileData.size()][fileData.get(0).length()];
        for(int i = 0; i < fileData.size(); i++){
            for(int j = 0; j < fileData.get(0).length(); j++){
                xmas[i][j]=fileData.get(i).substring(j,j+1);
            }
        }
        int count = 0;
        for (int i = 0; i < xmas.length; i++){
            for(int j = 0; j < xmas[i].length; j++){
                //right
                try {
                    if (xmas[i][j].equals("X")
                            && xmas[i][j+1].equals("M")
                            && xmas[i][j+2].equals("A")
                            && xmas[i][j+3].equals("S"))
                        count ++;
                }
                catch (ArrayIndexOutOfBoundsException a) { }



                //left
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i][j-1].equals("M")
                            && xmas[i][j-2].equals("A")
                            && xmas[i][j-3].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //up
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i-1][j].equals("M")
                            && xmas[i-2][j].equals("A")
                            && xmas[i-3][j].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //down
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i+1][j].equals("M")
                            && xmas[i+2][j].equals("A")
                            && xmas[i+3][j].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //diag down right
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i+1][j+1].equals("M")
                            && xmas[i+2][j+2].equals("A")
                            && xmas[i+3][j+3].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //diag down left
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i+1][j-1].equals("M")
                            && xmas[i+2][j-2].equals("A")
                            && xmas[i+3][j-3].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //diag up right
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i-1][j+1].equals("M")
                            && xmas[i-2][j+2].equals("A")
                            && xmas[i-3][j+3].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
                //diag up left
                try{
                    if (xmas[i][j].equals("X")
                            && xmas[i-1][j-1].equals("M")
                            && xmas[i-2][j-2].equals("A")
                            && xmas[i-3][j-3].equals("S")){
                        count ++;
                    }
                }
                catch (ArrayIndexOutOfBoundsException a) { }
            }
        }
        System.out.println(count);
    }
    private static boolean downRight(String[][] xmas, int i, int j){
        try{
            if (xmas[i][j].equals("M")
                    && xmas[i+1][j+1].equals("A")
                    && xmas[i+2][j+2].equals("S")){
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException a) { }
        return false;
    }
    private static boolean downLeft(String[][] xmas, int i, int j){
        try{
            if (xmas[i][j].equals("M")
                    && xmas[i+1][j-1].equals("A")
                    && xmas[i+2][j-2].equals("S")){
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException a) { }
        return false;
    }
    private static boolean upRight(String[][] xmas, int i, int j){
        try{
            if (xmas[i][j].equals("M")
                    && xmas[i-1][j+1].equals("A")
                    && xmas[i-2][j+2].equals("S")){
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException a) { }
        return false;
    }
    private static boolean upLeft(String[][] xmas, int i, int j){
        try{
            if (xmas[i][j].equals("M")
                    && xmas[i-1][j-1].equals("A")
                    && xmas[i-2][j-2].equals("S")){
                return true;
            }
        }
        catch (ArrayIndexOutOfBoundsException a) { }
        return false;
    }
}





