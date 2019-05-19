import java.util.Scanner;
import java.io.*;

public class Input {
    private static char inputFinal;
    private static String trueInput;
    public static void inputTest(Room room, Player player, Monster... monsters)throws IOException{

        boolean validInput = true;
        do{
            Scanner scanConsole = new Scanner(System.in);
            trueInput = scanConsole.next();
            switch (trueInput.charAt(0)) {
                case 'h':
                    player.moveX(-1, room, monsters);
                    validInput = true;
                    break;
                case 'j':
                    player.moveY(1, room, monsters);
                    validInput = true;
                    break;
                case 'k':
                    player.moveY(-1, room, monsters);
                    validInput = true;
                    break;
                case 'l':
                    player.moveX(1, room, monsters);
                    validInput = true;
                    break;
                case';':
                    validInput=true;
                    break;
                case's':
                    validInput=true;
                    mainRuntime.end();
                default:
                    validInput = false;
                    break;
            }
        }while(!validInput);
    }
}
