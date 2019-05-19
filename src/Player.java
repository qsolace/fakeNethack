import java.io.*;
import java.util.Scanner;
import java.util.Random;
/*
Taarna 3 987
8 19 25
14
5 6
7 7
14 17
24 82 18 8 10
 */
public class Player {
    private int startingHp, currentHp, maxHp;
    private int armorClass;
    private int startingToHit, toHit;
    private int damage, startingDamage;
    private int x, y;
    private int damageDealt, damageTaken, hitsMade, kills, healingDone;
    private int level, exp;
    private String name;
    public File saveFile;
    private int turn;


    //accessors for everything.
    public int getCurrentHp() {
        return currentHp;
    }

    public int getStartingHp() {
        return startingHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getStartingToHit() {
        return startingToHit;
    }

    public int getToHit() {
        return toHit;
    }

    public int getDamage() {
        return damage;
    }

    public int getStartingDamage() {
        return startingDamage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getKills() {
        return kills;
    }

    public int getHitsMade() {
        return hitsMade;
    }

    public String getName() {
        return name;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getHealingDone() {
        return healingDone;
    }

    public int getTurn() {
        return turn;
    }
    public void addTurn(int addition){
        turn += addition;
    }

    //get into the mutators. Not everything will have, and some will have more than one, each for different purposes.
    public void takeDamage(int damageDealt)throws IOException{//ex: this is for when a monstah deals damage. Not only does it decrease HP, it increase damage taken
        currentHp-=damageDealt;
        damageTaken+=damageDealt;
        //System.out.printf("Took %d damage. Current HP: %d", damageDealt, currentHp);
        if (currentHp<=0){
            death(saveFile);
        }

    }
    public void dealDamage(int damageDealt, Monster attacked){
        attacked.setHp(attacked.getHp()-damageDealt);
        if (attacked.getHp()<1){
            kills++;
            attacked.death(this);
        }
        this.damageDealt+=damageDealt;
    }

    public void setCurrentHp(int newHp){
        currentHp=newHp;
    }
    public void setMaxHp(int newMax){maxHp=newMax;}
    public void setLevel(int newLvL){level=newLvL;}
    public void setX(int x) {
        this.x = x;
    }
    public void changeX(int xChange){
        x += xChange;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void changeY(int yChange){
        y+=yChange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void addExp(int addedExp){
        exp+=addedExp;
    }

    public void heal(int healingDone){
        currentHp+=healingDone;
        int healAmnt = healingDone;
        if (currentHp>maxHp) {
            healAmnt-=currentHp-maxHp;
            currentHp = maxHp;
        }
        this.healingDone+=healAmnt;
        //System.out.println(healAmnt+" "+this.healingDone);
    }

    public void printToFile(File saveFile)throws IOException{
        FileWriter print = new FileWriter(saveFile);

        print.write(name+" "+level+" "+exp+" ");
        print.write(startingHp+" "+currentHp+ " "+maxHp+" ");
        print.write(armorClass+" ");
        print.write(startingToHit+" "+toHit+" ");
        print.write(damage+" "+startingDamage+" ");
        print.write(x+" "+y+" ");
        print.write(damageDealt+" "+damageTaken+" "+hitsMade+" "+kills+" "+healingDone+" ");
        print.close();
    }

    public void defaultSet(String name){
        startingHp=8; currentHp=8; maxHp=8;
        armorClass=13;
        startingToHit=5; toHit=5;
        damage=7; startingDamage=7;
        x=2; y=2;
        damageDealt=0; damageTaken=0; hitsMade=0; kills=0; healingDone=0;
        level=1; exp=0;
        this.name= name;
    }

    public void loadFromFile(File savedFile)throws IOException{
        Scanner read = new Scanner (savedFile);//Taarna 1 0 8 8 8 13 5 5 7 7 2 2 0 0 0 0 0
        name = read.next();
        level = read.nextInt();
        exp=read.nextInt();
        startingHp =read.nextInt();
        currentHp = read.nextInt();
        maxHp=read.nextInt();
        armorClass =read.nextInt();
        startingToHit = read.nextInt();
        toHit=read.nextInt();
        damage =read.nextInt();
        startingDamage = read.nextInt();
        x=read.nextInt();
        y =read.nextInt();
        damageDealt = read.nextInt();
        damageTaken=read.nextInt();
        hitsMade =read.nextInt();
        kills = read.nextInt();
        healingDone = read.nextInt();
        saveFile=savedFile;

        String restOfFile ="";
        while (read.hasNextLine()){
            restOfFile+=read.nextLine();
            restOfFile+="\n";
        }
        read.close();
        PrintWriter print = new PrintWriter(savedFile);
        //System.out.println("PLAYER: \t"+restOfFile);
        print.print(restOfFile.trim());
        print.close();
    }
    public void death(File saveFile)throws IOException{
        ScreenUpdate.clearScreen();
        System.out.printf("\u001B[31mUnfortunately, %s's luck has run out. You shall live on in legends for centuries.\u001B[0m\n\nYou dealt %d damage\nYou took %d damage\nYou healed for %d hit points\nYour enemies were smitten %d times\nYou vanquished %d enemies\n" +
                "You reached Level %d, collecting %d exp.\n\nWell fought, %s.\n\n\n\n\u001B[37mYour progress has been reset.\u001B[0m", name, damageDealt, damageTaken, healingDone, hitsMade, kills, level, exp, name);
        PrintWriter print = new PrintWriter(saveFile);
        print.println(name+" 1  0");
        print.println(startingHp+" "+startingHp+ " "+startingHp);
        print.println("13");
        print.println(startingToHit+" "+startingToHit);
        print.println(startingDamage+" "+startingDamage);
        print.println("1 1");
        print.println("0 0 0 0 0");
        print.close();
        System.exit(100);
    }

    public void attack(Monster attackee){
        Random random = new Random();
        int attackRoll = random.nextInt(20)+1+toHit;
        if (attackRoll>=attackee.getArmorClass()){
            int damageToBeDealt = damage+(random.nextInt(damage)-(damage/2));
            dealDamage(damageToBeDealt, attackee);
            isLevelUp();
            hitsMade+=1;
        }
    }

    public void moveX(int changeX, Room room, Monster... monsters){
        int tempX = x+changeX;
        boolean attack = false;
        if (!room.intercept(tempX, y)){
            for (int i =0; i<monsters.length; i++) {
                if (monsters[i].monsterAt(tempX, y)) {
                    attack(monsters[i]);
                    attack=true;
                    break;
                }
            }
            if(!attack){
                x = tempX;
            }
        }

    }
    public void moveY(int changeY, Room room, Monster... monsters){
        int tempY = y+changeY;
        boolean attack = false;
        if (!room.intercept(x, tempY)){
            for (int i =0; i<monsters.length; i++) {
                if (monsters[i].monsterAt(x, tempY)) {
                    attack(monsters[i]);
                    attack=true;
                    break;
                }
            }
            if(!attack){
                y = tempY;
            }
        }

    }
    private void isLevelUp(){
        switch (this.level){
            case 1:
                if (exp>=300)
                    levelUp();
            case 2:
                if (exp>=600)
                    levelUp();
            case 3:
                if (exp>=1200)
                    levelUp();
            case 4:
                if (exp>=1800)
                    levelUp();
            case 5:
                if (exp>=2700)
                    levelUp();
            case 6:
                if (exp>=3600)
                    levelUp();
            case 7:
                if (exp>=4800)
                    levelUp();
            case 8:
                if (exp>=6000)
                    levelUp();

                break;

        }
    }
    private void levelUp(){
        level+=1;
        toHit = (15+level)/3;
        damage+=7;
        maxHp= level*5;
        currentHp+=2;
        armorClass=(52+level)/4;
    }




}
