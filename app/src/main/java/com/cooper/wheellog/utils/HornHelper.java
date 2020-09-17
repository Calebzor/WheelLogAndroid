package com.cooper.wheellog.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import com.cooper.wheellog.R;

import static com.cooper.wheellog.utils.Constants.ACTION_REQUEST_KINGSONG_HORN;

public class HornHelper {

	private static boolean playing;

	private HornHelper() {
		// hiding constructor of static helper class
	}

	public static void horn(Context context) {
		int hornMode = SettingsUtil.getHornMode(context);
		if (hornMode == 1) {
			final Intent hornIntent = new Intent(ACTION_REQUEST_KINGSONG_HORN);
			context.sendBroadcast(hornIntent);
		}
		else if (hornMode == 2) {
			playBicycleBell(context);
		}
	}

	public static void playBicycleBell(Context context) {
		if (!playing) {
			MediaPlayer mp = MediaPlayer.create(context, R.raw.bicycle_bell);
			mp.start();
			playing = true;
			mp.setOnCompletionListener(mp1 -> {
				playing = false;
				mp1.release();
			});
		}
	}
}
