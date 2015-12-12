package space;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

import processing.core.PApplet;

public class AudioManager {
	PApplet parent;
	public static Mixer mixer;
	public Clip clip_menu, clip_play, clip_buttonhover, clip_buttonclick, clip_fly, clip_shoot;
	public String[] soundPaths = { "../data/pc.aif", "../data/pc.aif", "../data/pc.aif", "../data/click.wav",
			"../data/pc.aif", "../data/pc.aif" };
	public Clip[] sounds = { clip_menu, clip_play, clip_buttonhover, clip_buttonclick, clip_fly, clip_shoot };

	public AudioManager(PApplet p) {
		parent = p;
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try {
			for (int i = 0; i < sounds.length; i++) {
				sounds[i] = (Clip) mixer.getLine(dataInfo);
			}
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		}
		try {
			for (int i = 0; i < sounds.length; i++) {
				sounds[i].open(AudioSystem.getAudioInputStream(AudioManager.class.getResource(soundPaths[i])));
			}
		} catch (LineUnavailableException lue) {
			lue.printStackTrace();
		} catch (UnsupportedAudioFileException uaf) {
			uaf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void playClick() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				sounds[3].start();
				try {
					Thread.sleep(100);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				sounds[3].stop();
			}
		});
	}
}
