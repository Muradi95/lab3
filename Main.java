import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(args[0]));
        double bpm = Double.parseDouble(args[1]);
        System.out.print(bpm);
        int a = 0;
        double b = 0;
        SoundDevice device = new SoundDevice();
        Song song = new Song(50);


        while(sc.hasNext()){
            if(sc.hasNextInt())
                a = sc.nextInt();
            if(sc.hasNextDouble())
                b = sc.nextDouble();


            song.add(MusicUtils.harmonic(a,(b*bpm)/60));

        }
        song.play(device);
        song.save(device.getFormat(),new File("komp1.wav"));
    }//main

}//Main



