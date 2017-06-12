import java.io.*;
import sun.audio.*;


public class JavaAudioPlaySoundExample
{
  public void main(String[] args) throws Exception
  {
    // open the sound file as a Java input stream
//    InputStream in = new FileInputStream(getResource("/Noises/set.wav"));
    InputStream in = new FileInputStream("C:/Users/jason/Documents/NetBeansProjects/Menu/src/Noises/mitochondria.wav");

    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  }
}