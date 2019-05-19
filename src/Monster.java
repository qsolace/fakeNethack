import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Monster {
    private int Hp, armorClass;
    private int toHit, damage;
    private int x=-1, y=-1;
    private boolean isDead;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getHp() {
        return Hp;
    }

    public int getToHit() {
        return toHit;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isDead() {
        return isDead;
    }


    public void setHp(int hp) {
        Hp = hp;
    }

    public void moveTowards(Player thePlayer, Room theRoom, Monster...monsters){
        int tempX = this.x;
        int tempY = this.y;
        if (x!=0) {
            if (this.x - thePlayer.getX() > 1 && !theRoom.intercept(x - 1, y)) {
                tempX -= 1;
                if (this.sameSpace(monsters)){
                    this.x++;
                }
            } else if (this.x - thePlayer.getX() < -1 && !theRoom.intercept(x + 1, y)) {
                tempX += 1;
                if (this.sameSpace(monsters)){
                    this.x--;
                }
            }

            if (this.y - thePlayer.getY() > 1 && !theRoom.intercept(x, y - 1)) {
                tempY -= 1;
                if (this.sameSpace(monsters)){
                    this.y++;
                }
            } else if (this.y - thePlayer.getX() < -1 && !theRoom.intercept(x, y + 1)) {
                tempY += 1;
                if (this.sameSpace(monsters)){
                    this.y--;
                }
            }
        }
//        if (tempX!=thePlayer.getX()&&tempY!=thePlayer.getY()){
            this.x=tempX;
            this.y=tempY;
//        }
    }
    public void moveAway(Player player, Room room, Monster... monsters){
        if (x!=0) {
            if (player.getX() - this.x <= -1 && !room.intercept(x + 1, y)) {
                this.x += 1;
                if (this.sameSpace(monsters)){
                    this.x--;
                }
            } else if (player.getX() - this.x>= 1 && !room.intercept(x - 1, y)) {
                this.x -= 1;
                if (this.sameSpace(monsters)){
                    this.x++;
                }
            }

            if (player.getY() - this.y<= -1 && !room.intercept(x , y+1)) {
                this.y += 1;
                if(this.sameSpace(monsters)){
                    this.y--;
                }
            } else if (player.getY() - this.y>= 1 && !room.intercept(x , y-1)) {
                this.y -= 1;
                if(this.sameSpace(monsters)){
                    y++;
                }
            }
        }
    }

    public void attackPlayer(Player player)throws IOException {
        Random random = new Random();
        int tempAC = random.nextInt(20)+1+toHit;
        //System.out.println("\u001B[35m"+tempAC+"\u001B[0m");
        if (tempAC>=player.getArmorClass()){
            int tempDmg =damage+(random.nextInt(damage)-(damage/3));
            //System.out.println("\u001B[34m"+tempDmg+"\u001B[0m");
            player.takeDamage(tempDmg);

        }
    }
    public void attackPlayerRanged(Player player)throws IOException{
        Random random = new Random();
        int tempAC = random.nextInt(20)+1+toHit;
        System.out.println("\u001B[35m"+tempAC+"\u001B[0m");
        if (tempAC>=player.getArmorClass()){
          //  int tempDmg =damage-(random.nextInt(damage)-(damage/3));
            int tempDmg = damage-2;
            System.out.println("\u001B[34m"+tempDmg+"\u001B[0m");
            player.takeDamage(tempDmg);

        }
    }

    public void death(Player player){
        Hp = -1;
        armorClass = 0;
        x =0;
        y=0;
        toHit =0;
        damage =0;
        isDead = true;
        player.setExp(player.getExp()+150);
        player.heal(2);
    }
    public void initiate(Player player, Room room){
        Random random =new Random();
        Hp = (player.getStartingHp()+player.getMaxHp()/5);
        armorClass = player.getArmorClass()-1;
        toHit = player.getToHit()-1;
        damage = player.getLevel()+2;
        isDead = false;
        do {
            x = random.nextInt(room.getX()+1);
            y = random.nextInt(room.getY()+1);
        }while(room.intercept(x,y));

    }
    public void meleeAction(Player player, Room room)throws IOException{
        if (x!=0) {
            moveTowards(player, room);
            if (Math.abs(x - player.getX()) <= 1 && Math.abs(y - player.getY()) <= 1) {
                attackPlayer(player);
            }
        }
    }

    public void rangedAction(Player player, Room room)throws IOException{
        if (x!=0) {
            Random random = new Random();
            if (Math.abs(player.getX() - x) > 4 || Math.abs(player.getY() - y) > 4) {
                moveTowards(player, room);
            } else if (random.nextInt(3) == 1) {
                moveAway(player, room);
            }
            if (Math.abs(player.getX() - x) <= 4 && Math.abs(player.getY() - y) <= 4&&!(random.nextInt(5)==1))
                attackPlayerRanged(player);
        }
    }
    public boolean monsterAt(int x, int y){
        if (x==this.x&& y==this.y){
            return true;
        }
        else
            return false;
    }
    public boolean sameSpace(Monster...monsters){
        for (int i=0; i < monsters.length; i++){
            if (monsters[i].getX()==x&&monsters[i].getY()==y){
                return true;
            }
        }
        return false;
    }
    public void printToFile(File file)throws IOException{
        FileWriter print = new FileWriter(file,true);
        int deathInt=0;
        if (isDead){
            deathInt =1;
        }

        print.append(Hp+" "+armorClass+" "+toHit+" "+damage+" "+x+" "+y+" "+ deathInt+" ");
        print.close();
    }
    public void readFromFile(File file)throws IOException{

        Scanner read = new Scanner (file);
        Hp =read.nextInt();
        //System.out.println(read.next());
        armorClass =read.nextInt();
        toHit=read.nextInt();
        damage =read.nextInt();
        x=read.nextInt();
        y =read.nextInt();
        int deathInt = read.nextInt();
        if (deathInt==0){
            isDead=false;
        }
        else
            isDead=true;

        String restOfFile ="";
        while (read.hasNextLine()){
            restOfFile+=read.nextLine();
            restOfFile+="\n";
        }
        read.close();
        PrintWriter print = new PrintWriter(file);
        //System.out.println("MONSTER: \t"+restOfFile);
        print.print(restOfFile.trim());
        print.close();
    }

}
