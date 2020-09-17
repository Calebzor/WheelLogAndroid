package com.cooper.wheellog;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;

import static com.cooper.wheellog.utils.HornHelper.horn;

public class SettingsContentObserver extends ContentObserver {

	public static final int STREAM = AudioManager.STREAM_MUSIC;

	int previousVolume;
	Context context;

	public SettingsContentObserver(Context c, Handler handler) {
		super(handler);
		context = c;

		AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		previousVolume = audio.getStreamVolume(STREAM);
	}

	@Override
	public void onChange(boolean selfChange) {
		super.onChange(selfChange);

		AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		int currentVolume = audio.getStreamVolume(STREAM);

		int delta = previousVolume - currentVolume;

		if (delta > 0) {
			Log.d("T", "Decreased");
			previousVolume = currentVolume;
			horn(context);
		}
		else if (delta < 0) {
			Log.d("T", "Increased");
			previousVolume = currentVolume;
		}
	}
}