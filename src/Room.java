/*
Ryan S
Room Class
    Size (x and y)  /
    Store to file   /
    toString        /
    Read from File  x, y
    Overlap
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Room {
    private int x;
    private int y;
    public int offset =0;
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setAll(int x, int y){
        this.x =x;
        this.y=y;
    }


    public String toString(){
        String room ="";
        for (int i = 0; i<x;i++){
            room += "-";
        }
        room+="\n";
        for (int i=0; i<y-2;i++){
            room+="|";
            for (int j=0; j<x-2;j++){
                room+=".";
            }
            room+="|";
            room+="\n";
        }
        for (int i =0; i<x;i++){
            room+="-";
        }
        return room;
    }


    public boolean intercept(int x, int y){
        if ((x != this.x && !(x <= 1))&&(y != this.y && !(y <= 1))){
            return false;
        }
        return true;
    }
    public void readFromFile(File saveFile) throws IOException{
        Scanner read = new Scanner(saveFile);
        int NewX;
        int NewY;
        NewX = read.nextInt();
        //System.out.println("ROOM_X: \t"+NewX);
        NewY = read.nextInt();
        //System.out.println("ROOM_Y: \t"+NewY);

        String restOfFile ="";
        while (read.hasNextLine()){
            restOfFile+=read.nextLine();
            restOfFile+="\n";

        }
        read.close();
        FileWriter print = new FileWriter(saveFile);
        //System.out.println("ROOM:\t"+restOfFile);
        print.append(restOfFile);
        print.close();
        setAll(NewX,NewY);
    }
    public void printToFile(File printFile)throws IOException{
        FileWriter print = new FileWriter(printFile, true);
        print.write(x+" "+y+" ");
        print.close();
    }
}

