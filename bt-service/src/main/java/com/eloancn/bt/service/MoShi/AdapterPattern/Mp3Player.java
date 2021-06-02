package com.eloancn.bt.service.MoShi.AdapterPattern;

public class Mp3Player implements AdvancedMediaPlayer {
    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
    }
    @Override
    public void playMp4(String fileName) {
        //  什么也不做
    }
}
