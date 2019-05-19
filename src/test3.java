import java.io.*;
public class test3 {
    public static void main (String[] args)throws IOException{
        File file = new File("C:\\Users\\ryan_\\IdeaProjects\\fakeNethack\\src\\saveTest");
//        PrintWriter print = new PrintWriter(file);
//        print.println("hi there!");
//        print.close();
//
//        printyThing(file);
        Player player = new Player();
       // player.defaultSet();





        Item sword = new Item();
        sword.setY(5);
        sword.setX(3);
        sword.setColor(3);
        sword.setDisplayCharacter("u");

        Room room = new Room();
        room.setAll(29, 18);

        Monster [] monsters;
        monsters = new Monster[]{new Monster(), new Monster(), new Monster(), new Monster(),new Monster(),
                new Monster(), new Monster(), new Monster(), new Monster(), new Monster()};
        for (int i=0; i<monsters.length;i++){
            monsters[i].initiate(player, room);
        }

        fileInteraction.save(file, player, room, sword, monsters);

    }
    private static void printyThing(File file)throws IOException{
        FileWriter print = new FileWriter(file,true);
        int i = 343;
        print.append(Integer.toString(i));
        print.close();
    }
}
