import java.io.*;

public class test2 {
    public static void main(String[] args)throws IOException{
        File save = new File("C:\\Users\\ryan_\\IdeaProjects\\fakeNethack\\src\\saveTest");


        Player taarna = new Player();
        Room room1 = new Room();
        Item item = new Item();


        Monster [] monsters;
        monsters = new Monster[]{new Monster(), new Monster(), new Monster(), new Monster(),new Monster(),
                new Monster(), new Monster(), new Monster(), new Monster(), new Monster()};
        fileInteraction.load(save, taarna, room1, item, monsters);
        System.out.println(room1.getX()+" "+room1.getY());
        for (int i =0; i<monsters.length;i++){
            System.out.println(monsters[i].getX()+" "+monsters[i].getY());
        }
        //ScreenUpdate.newScreen(room1, taarna, item, monsters);
        System.out.println(room1.getX());
        System.out.println(taarna.getName());
        System.out.println(monsters[1].getHp());
        System.out.println(item.returnAll());
    }
}
