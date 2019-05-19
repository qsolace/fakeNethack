import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class test {
    public static void main(String[] args)throws Exception{
        Item sword = new Item();
        Room room1 = new Room();
//        Room room2 = new Room();
        File save = new File ("C:\\Users\\ryan_\\IdeaProjects\\fakeNethack\\src\\saveTest");

        sword.setColor(0);
        sword.setDisplayCharacter("+");
        sword.setX(1);
        sword.setY(5);
//        sword.readFromFile(save);
//        System.out.println(sword.returnAll());
//        System.out.println("Hello");
//        sword.setColor(sword.getColorInt()+1);
//        sword.printToFile(save);
        room1.setAll(16, 8);
//        System.out.println(room1.toString());
        Player taarna = new Player();
//        taarna.defaultSet();
//        taarna.printToFile(save);
//        taarna.loadFromFile(save);
//        taarna.dealDamage(19);
        Random random = new Random();
        taarna.loadFromFile(save);
        taarna.setY(7);
        taarna.setX(2);
        Monster [] monsters;
        monsters = new Monster[]{new Monster(), new Monster()};
        for (int i =0; i<monsters.length; i++){
            monsters[i].initiate(taarna, room1);
        }
        int taarnaOldLevel=0;
        for (int i=0; i<51;i++) {
            if(taarna.getLevel()==taarnaOldLevel){}
               // ScreenUpdate.newScreen(room1,taarna, sword, monsters);
            else {
                ScreenUpdate.statementClearScreen(room1, taarna, sword, "Welcome to Level "+taarna.getLevel(), monsters);
                taarnaOldLevel = taarna.getLevel();
            }
            Input.inputTest(room1, taarna, monsters);
            for(int j =0; j<monsters.length;j++) {
                monsters[j].rangedAction(taarna, room1);
            }
        }
        taarna.death(save);
//        PrintWriter print = new PrintWriter(save);l

//        print.print("Taarna 3 987\n" +
//                "8 19 25\n" +
//                "14\n" +
//                "5 6\n" +
//                "7 7\n" +
//                "14 17\n" +
//                "24 82 18 8 10");
//        print.close();
    }
}
