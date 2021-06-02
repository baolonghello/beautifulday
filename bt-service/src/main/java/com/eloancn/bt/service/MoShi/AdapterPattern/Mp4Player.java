package com.eloancn.bt.service.MoShi.AdapterPattern;

public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp3(String fileName) {
        //  什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
