import java.util.IntSummaryStatistics;
import java.util.Random;

/**
 * Created by joellof on 2016-10-06.
 */
public class MusicUtils {

    public static double[] sine(double freq, double duration) {

        int n = (int) (duration * SoundDevice.SAMPLING_RATE);
        double[] a = new double[n];
        double dx = 2 * Math.PI * freq / SoundDevice.SAMPLING_RATE;
        for (int i = 0; i < n; i = i + 1) {
            a[i] = Math.sin(i * dx);
        }
        return a;
    }//sine

    public static double[] pluck(double freq, double duration) {

        Random r = new Random();
        int n = (int) (duration * SoundDevice.SAMPLING_RATE);
        double[] a = new double[n];
        int p = (int) (SoundDevice.SAMPLING_RATE / freq);
        for (int i = 0; i < p; i++) {
            a[i] = 2 * r.nextDouble() - 1;
        }
        double k = 0.498;
        for (int i = p; i < a.length; i++) {
            a[i] = (a[i - p] + a[i - p + 1]) * k;
        }
        return a;
    }

    public static double[] note(int pitch, double duration) {

        int k = pitch;
        double d = 440 * Math.pow(2, (1.0 * k / 12));
        return MusicUtils.pluck(d, duration);
    }

    public static double[] average(double[] t1, double[] t2) {

        double[] a = new double[t1.length];
        for (int i = 0; i < t1.length; i++) {
            a[i] = (t1[i] + t2[i]) / 2;
        }
        return a;
    }
    public static double[] harmonic(int pitch, double duration){

        int k = pitch;
        int oktav = 12;
        double[] a = note(k, duration);
        double[] b = note(k-oktav, duration);
        double[] c = note(k+oktav, duration);
        double[] d = average(b,c);
        return average(a,d);

    }

}


