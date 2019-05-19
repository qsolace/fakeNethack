import java.io.*;
import java.util.Scanner;
public class fileInteraction {
    public static void save(File file, Player player, Room room, Item item, Monster... monsters)throws IOException{
        player.printToFile(file);
        room.printToFile(file);
        item.printToFile(file);
        for (int i=0; i<monsters.length;i++){
            monsters[i].printToFile(file);
        }
    }
    public static void load(File file, Player player, Room room, Item item, Monster...monsters)throws IOException{
        player.loadFromFile(file);
        room.readFromFile(file);
        item.readFromFile(file);
        Scanner fileReader = new Scanner(file);
        int i=0;
        while (fileReader.hasNextInt()&&i<monsters.length){

            monsters[i].readFromFile(file);
            i++;
        }
    }
}
