package com.rahul.elevator.util;


import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    public static void playSound(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
           
            clip.start();
            
            Thread.sleep(500);  
            clip.drain();
            clip.close();
            audioIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}