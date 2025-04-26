import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class music {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\pedro\\GUITAR HERO\\output\\I-LOVE-ROCK-'N'-ROLL.wav";
        File file = new File(filePath);

        try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Util.sleep(320000);
        } catch(UnsupportedAudioFileException e) {
            System.out.println("The audio file is not supported.");
        } catch(Exception e) {
            System.out.println("Error playing the audio file.");
        }
    }
}