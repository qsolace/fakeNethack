public class ScreenUpdate {
    //, Item item, Monster... monsters
    public static void newScreen(Room room, Player player, Item item, int numberOfMonsters, Monster... monster){
        String baseRoom = room.toString();
        String temp = addThing(baseRoom, room, player);
        for (int i=0; i < numberOfMonsters; i++) {
            if (!monster[i].isDead()) {
                temp = addThing(temp, room, monster[i]);
            }
        }
        clearScreen();
        player.addTurn(1);
        if(player.getTurn()%5==0){
            player.heal(1);
        }
        System.out.printf("\t%s\tLvL: %d\n", player.getName(), player.getLevel());
        System.out.printf("HP: %d/%d\tAC: %d\tXP: %d\tTurn: %d\n",player.getCurrentHp(), player.getMaxHp(), player.getArmorClass(), player.getExp(), player.getTurn());
        System.out.printf("To Hit: +%d\tDamage: %d\n", player.getToHit(), player.getDamage());
        for (int i =0; i<9;i++)
            System.out.println();
        System.out.println(temp);

    }

    public static void statementClearScreen(Room room, Player player, Item item, String statement, Monster... monster){
        String baseRoom = room.toString();
        String temp = addThing(baseRoom, room, player);
        for (int i=0; i < monster.length; i++) {
            if (!monster[i].isDead()) {
                temp = addThing(temp, room, monster[i]);
            }
        }
        player.addTurn(1);
        if(player.getTurn()%5==0){
            player.heal(1);
        }
        clearWithStatement(statement);
        System.out.printf("\t%s\tLvL: %d\n", player.getName(), player.getLevel());
        System.out.printf("HP: %d/%d\tAC: %d\tXP: %d\tTurn: %d\n",player.getCurrentHp(), player.getMaxHp(), player.getArmorClass(), player.getExp(), player.getTurn());
        System.out.printf("To Hit: +%d\tDamage: %d\n", player.getToHit(), player.getDamage());
        for (int i =0; i<9;i++)
            System.out.println();
        System.out.println(temp);

    }

    private static String addThing(String baseRoom, Room room, Player player){
        String temp = "";
        temp += baseRoom.substring(0,(player.getY()-1)*(room.getX()+1)+player.getX()-1);
        temp+="@";
        temp += baseRoom.substring((player.getY()-1)*(room.getX()+1)+player.getX());
        return temp;
    }
    private static String addThing(String baseRoom, Room room, Item item){
        String temp = "";
        temp += baseRoom.substring(0,(item.getY()-1)*(room.getX()+1)+item.getX()-1);
        temp+=item.returnAll();
        temp += baseRoom.substring((item.getY()-1)*(room.getX()+1)+item.getX());
        return temp;
    }
    private static String addThing(String baseRoom, Room room, Monster monster){
        String temp = "";
        temp += baseRoom.substring(0,(monster.getY()-1)*(room.getX()+1)+monster.getX()-1);
        temp+="=";
        temp += baseRoom.substring((monster.getY()-1)*(room.getX()+1)+monster.getX());
        return temp;
    }
    public static void clearScreen(){
        for (int i = 0; i<10; i++){
            System.out.println("\n");
        }
    }
    public static void clearWithStatement(String statement){
        for (int i =0; i<5; i++){
            System.out.println("\n");
        }
        System.out.println(statement);
        for (int i=0; i<5; i++){
            System.out.println("\n");
        }
    }
}
