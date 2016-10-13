/** 
 * A SoundDevice is an abstraction of the physical device
 * which generates sound on the current machine.
 */
import javax.sound.sampled.*;
import java.io.*;
public class SoundDevice {

    /**
     * Sampling rate used.
     */ 
    public static final int SAMPLING_RATE = 44100;

    private SourceDataLine line;
    private AudioFormat format = new AudioFormat(SAMPLING_RATE, 16, 1, true, false);

    /**
     * Constructs and starts the device.
     */
    public SoundDevice() {
        try {
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
        } catch (Exception e) {throw new RuntimeException(e);}
    }//constructor

    /**
     * Returns the SourceDataLine on which to write music data.
     */
    public SourceDataLine getLine() {
        return line;
    }//getLine

    /**
     * Returns the AudioFormat used.
     */
    public AudioFormat getFormat() {
       return format;
    }//getFormat
}//SoundDevice
