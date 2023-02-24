import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class App {
    public static void main(String[] args) throws FileNotFoundException{

        Scanner input = new Scanner(System.in);//this Scanner object allows the user to input something
        ArrayList<String> list = new ArrayList<>();//ArrayList that holds every song starting with index 0.
        File file = new File("listSong/list.txt");//opens
        Scanner fileInput = new Scanner(file);//this Scanner object is reading the list.txt
        String temp;//this String variable is temporary placeholder for the files that will be added into the ArrayList.
        int numberSongs = 0;//counts how many songs there according from list.txt
        Gui gui = new Gui();//FIX THIS
        while(fileInput.hasNextLine()){//chech if there is a line to read
            temp = fileInput.nextLine();//reads the line and puts it into the String temp.
            list.add(temp);//The value of temp is added onto the ArrayList
            //temp = temp.substring(0, temp.length() - 4);//temp is shortened for printing
            //System.out.printf("%d) %s\n", numberSongs++, temp);//print for option
            numberSongs++;
        }
        System.out.printf("1) You wanna play a song\n2) Add song to library\n");//options in MAIN
       

        System.out.println();
        System.out.print("Option: ");
        int option = input.nextInt();//gives the control.
        switch(option){

            case 1: 
                int songNum;
                String secOption = "Y";
                while(!(secOption.equalsIgnoreCase("N"))){
                    for(int i = 0; i < numberSongs; i++){
                        String temps = list.get(i);
                        temps = temps.substring(0, temps.length() - 4);
                        System.out.printf("%d) %s\n", i+1, temps);//print for option
                    
                    }
                    System.out.println();
                    System.out.print("Option: ");
                    songNum = input.nextInt();
                    runMusic(songNum, list);
                    System.out.println();
                    input.nextLine();
                    System.out.print("Do you want to continue(Y/N): ");
                    secOption = input.nextLine();
                }
                break;


            case 2:
                System.out.println("Nothing here yet");
                break;
            default: 
                System.out.println("Invalid option");
        }
        System.out.println("GoodBye !!");

    }

    public static void runMusic(int x, ArrayList<String> y) {
        try{
            Scanner input = new Scanner(System.in);
            String option;
            String song = "Music/" ;
            song = song.concat( y.get(x-1));
            File file = new File(song);
            AudioInputStream AIS = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(AIS);

            System.out.print("p,s,r,q: ");
            option = input.nextLine();
            while(!(option.equalsIgnoreCase("Q"))){
                switch(option){
                    case "p":
                        clip.start();
                        break;
                    case "q":
                        clip.stop();
                        clip.close();
                        break;
                    case "s":
                        clip.stop();
                        break;
                    case "r":
                        clip.setMicrosecondPosition(0);
                        break;
                    default:
                        System.out.println("This is not an option");
                }
                System.out.print("p,s,r,q: ");//************************FIX THIS*********************************/
                option = input.nextLine();
                if(option.equalsIgnoreCase("q")){
                    clip.stop();
                    clip.close();
                }
            }
            
        }
        catch(IOException e){
            System.out.println("Something went wrong when executing");
        }
        catch(UnsupportedAudioFileException uafe){
            System.out.println("The audio file is unsupported for java");
        }
        catch(LineUnavailableException lue){
            System.out.println("LineUnavailableException");
        }
    }
}
