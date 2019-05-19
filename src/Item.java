import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Item {
    private int x;
    private int y;
    private String displayCharacter="k";
    private String color;
    private int colorInt;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDisplayCharacter() {
        return displayCharacter;
    }

    public String getColor() {
        return color;
    }

    public int getColorInt() {
        return colorInt;
    }

    public String returnAll(){
        return color+displayCharacter+"\u001B[0m";
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setColor(int colorNumber) {
        setColors(colorNumber);
    }

    public void setDisplayCharacter(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }


    public void printToFile(File printFile)throws IOException{
        FileWriter print = new FileWriter(printFile, true);
        print.append(x+" "+y+" "+colorInt+" "+displayCharacter+" ");
        print.close();
    }

    public void readFromFile(File saveFile) throws IOException{
        Scanner read = new Scanner(saveFile);
        x = read.nextInt();
        //System.out.println("X: \t"+x);
        y = read.nextInt();
        //System.out.println("Y:\t"+y);
        colorInt=read.nextInt();
        //System.out.println("COLOR: \t"+colorInt);
        setColors(colorInt);
        displayCharacter =read.next();
        //System.out.println("DISP:\t"+displayCharacter);
        String restOfFile ="";
        while (read.hasNext()){
            restOfFile+=read.next();
            restOfFile+=" ";

        }
        read.close();
        restOfFile.substring(1);
        PrintWriter print = new PrintWriter(saveFile);
        System.out.println("ITEM:\t"+restOfFile);
        print.println(restOfFile);
        print.close();
    }

    private void setColors(int colorNumber){
        switch (colorNumber){
            case 0://Black
                color="\u001B[30m";
                colorInt =0;
                break;
            case 1://Red
                color="\u001B[31m";
                colorInt =1;
                break;
            case 2://green
                color="\u001B[32m";
                colorInt =2;
                break;
            case 3://Yellow
                color="\u001B[33m";
                colorInt =3;
                break;
            case 4://Blue
                color="\u001B[34m";
                colorInt =4;
                break;
            case 5://Magenta
                color="\u001B[35m";
                colorInt =5;
                break;
            case 6://Cyan
                color="\u001B[36m";
                colorInt =6;
                break;
            case 7://White
                color="\u001B[37m";
                colorInt =7;
                break;
            case 8://"Bright Black"
                color="\u001B[90m";
                colorInt =8;
                break;
            default:
                colorInt =-1;
                break;
        }
    }
}
