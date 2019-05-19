import java.util.Random;
import java.io.*;
import java.util.Scanner;
public class mainRuntime {
    private static Monster [] monsters;
    public static Player player = new Player();
    public static Room room = new Room();
    public static Item item = new Item();
    public static String saveFile;
    public static void main(String[] args)throws IOException{
        monsters = new Monster[]{new Monster(), new Monster(), new Monster(), new Monster(),new Monster(),
                new Monster(), new Monster(), new Monster(), new Monster(), new Monster()};
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Welcome! Do you have a save file that you want to continue from? > ");
        String continueYoN = scan.next().substring(0,1);

        if (continueYoN.equalsIgnoreCase("y")){
            System.out.print("\nPlease enter the complete file path to where the game is saved. > ");
            saveFile=scan.next();
            player.saveFile = new File(saveFile);
            loadStart(saveFile);
        }
        else{
            System.out.print("\nPlease enter the complete file path for where you want to save the game. > ");
            saveFile=scan.next();
            player.saveFile = new File(saveFile);
            System.out.print("Please enter your character's name. > ");
            String name = scan.next();
            startFirst(name);
        }

        System.out.println("\nCONTROLS:\n" +
                "\tH - move left\n" +
                "\tJ - move down\n" +
                "\tK - move up\n" +
                "\tL - move right\n" +
                "\tS - save and exit\n" +
                "Press enter after every move to confirm.");
        if (player.getTurn()<1){
            for (int i=0; i<2;i++){
                monsters[i].initiate(player, room);
            }
        }
        while (player.getLevel()==1){
            ScreenUpdate.newScreen(room, player, item, 2, monsters);
            Input.inputTest(room, player, monsters);

            for (int i=0; i<2; i++){
                monsters[i].meleeAction(player, room);
            }


        }
        if (player.getLevel()==2){
            for (int i =0; i<2;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==2){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<2; i++){
                    monsters[i].meleeAction(player, room);
                }
            }
        }
        if (player.getLevel()==3){
            for (int i =0; i<3;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==3){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<3; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        if (player.getLevel()==4){
            for (int i =0; i<3;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==4){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<2; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }
                for (int i =2; i<3;i++){
                    monsters[i].rangedAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        if (player.getLevel()==5){
            for (int i =0; i<4;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==5){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<3; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }
                for (int i =3; i<4;i++){
                    monsters[i].rangedAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        if (player.getLevel()==6){
            for (int i =0; i<5;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==5){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<3; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }
                for (int i =3; i<5;i++){
                    monsters[i].rangedAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        if (player.getLevel()==7){
            for (int i =0; i<7;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==5){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<5; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }
                for (int i =5; i<7;i++){
                    monsters[i].rangedAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        if (player.getLevel()==8){
            for (int i =0; i<9;i++){
                monsters[i].initiate(player, room);
            }
            while (player.getLevel()==5){
                ScreenUpdate.newScreen(room, player, item, 2, monsters);
                Input.inputTest(room, player, monsters);
                for (int i=0; i<6; i++){
                    monsters[i].meleeAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }
                for (int i =6; i<9;i++){
                    monsters[i].rangedAction(player, room);
                    if (monsters[i].isDead()&&random.nextInt(10)==1){
                        monsters[i].initiate(player, room);
                    }
                }

            }
        }
        System.out.printf("Congratulations, %s! Tyr smiles upon you!\n", player.getName());
        File file = new File(saveFile);
        player.death(file);











    }
    public static void startFirst(String name){
        Random random = new Random();

        monsters = new Monster[]{new Monster(), new Monster(), new Monster(), new Monster(),new Monster(),
                new Monster(), new Monster(), new Monster(), new Monster(), new Monster()};
        room.setAll(random.nextInt(20)+20, random.nextInt(15)+10);

        item.setX(4);
        item.setY(1);
        item.setDisplayCharacter("+");
        item.setColor(0);

        player.defaultSet(name);
    }
    public static void loadStart(String file)throws IOException{
        File store = new File (file);
        fileInteraction.load(store, player, room, item, monsters);
    }
    public static void end()throws IOException{
        File file = new File(saveFile);
        fileInteraction.save(file, player, room, item, monsters);
        System.exit(1);
    }
}
