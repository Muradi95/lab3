import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        System.out.println(args[0]);
        Scanner sc = new Scanner(new File(args[0]));
        ArrayList<Integer> a = new ArrayList<Integer>();

        ArrayList<Double> b = new ArrayList<Double>();

        SoundDevice device = new SoundDevice();
        Song song = new Song(50);
        int i = 0;
        while(sc.hasNext()){
            if(sc.hasNextInt())
                a.add(sc.nextInt());
            if(sc.hasNextDouble())
                b.add(sc.nextDouble());
            song.add(MusicUtils.note(a.get(i),b.get(i)));
            i++;
        }
        song.add(MusicUtils.note(10,2));
        song.add(MusicUtils.harmonic(2,2));
        song.add(MusicUtils.average((MusicUtils.note(10,2)),(MusicUtils.note(2,2))));
        song.play(device);
        song.save(device.getFormat(),new File("komp1.wav"));
    }//main

}//Main



