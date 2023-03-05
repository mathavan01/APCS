import java.util.*;
public class Sound
{
    private int[] samples;
    public Sound(int[] samples){
        this.samples = samples;
    }
    public int limitAmplitude(int limit){
        int numChanged = 0;
        for (int i : samples){
            if (Math.abs(i) > limit){
                if (i >= 0){
                    i = limit;
                    numChanged++;
                } else {
                    i = -limit;
                    numChanged++;
                }
            }
        }
        return numChanged;
    }
    public void trimSilenceFromBeginning(){
        int leadingZeros = 0;
        while (samples[leadingZeros] == 0){
            leadingZeros++;
        }
        
        int[] noZeros = new int[samples.length - leadingZeros];
        for (int i = leadingZeros; i < samples.length; i++){
            noZeros[i - leadingZeros] = samples[i];
        }
        
        samples = noZeros;
    }
    public String toString(){
        return Arrays.toString(samples);
    }
}