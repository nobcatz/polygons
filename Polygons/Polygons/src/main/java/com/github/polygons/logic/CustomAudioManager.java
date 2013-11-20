package com.github.polygons.logic;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by Marta on 19/11/2013.
 */
public class CustomAudioManager {

    private Context context;
    private MediaPlayer backgroundMusic;

    private SoundPool poolSounds;
    private HashMap<Integer, Integer> mapSounds;

    private AudioManager audioManager;
    private static CustomAudioManager instance = null;

    public static CustomAudioManager getInstance(Context context, int idBackgroundMusic) {
        instance = new CustomAudioManager();
        instance.initSounds(context, idBackgroundMusic);
        return instance;
    }

    public static CustomAudioManager getInstancia() {
        synchronized (CustomAudioManager.class) {
            if (instance == null) {
                instance = new CustomAudioManager();
            }
            return instance;
        }
    }

    private CustomAudioManager() {
    }

    public void initSounds(Context context, int idBackgroundMusic) {
        this.context = context;
        poolSounds = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        mapSounds = new HashMap<Integer, Integer>();
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        backgroundMusic = MediaPlayer.create(context, idBackgroundMusic);
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(1, 1);
    }

    public void playBackgroundMusic() {
        try {
            if (!backgroundMusic.isPlaying()) {
                try {
                    backgroundMusic.prepare();
                } catch (Exception e) {
                }
                backgroundMusic.start();
            }
        } catch (Exception e) {
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic.isPlaying()) {
            backgroundMusic.stop();
        }
    }

}
