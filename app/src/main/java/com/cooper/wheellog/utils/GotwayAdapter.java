package com.cooper.wheellog.utils;

import com.cooper.wheellog.WheelData;

import timber.log.Timber;

public class GotwayAdapter implements IWheelAdapter {
    private static GotwayAdapter INSTANCE;

    @Override
    public boolean decode(byte[] data) {
        return WheelData.getInstance().decodeGotway(data);
    }

    @Override
    public void updatePedalsMode(int pedalsMode) {
        WheelData.getInstance().updatePedalsMode(pedalsMode);
    }

    @Override
    public void updateLightMode(int lightMode) {

    }

    @Override
    public void updateMaxSpeed(int wheelMaxSpeed) {

    }

    public static GotwayAdapter getInstance() {
        Timber.i("Get instance");
        if (INSTANCE == null) {
            Timber.i("New instance");
            INSTANCE = new GotwayAdapter();
        }
        return INSTANCE;
    }
}
