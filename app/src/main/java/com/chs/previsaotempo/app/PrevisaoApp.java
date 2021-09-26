package com.chs.previsaotempo.app;

import androidx.multidex.MultiDexApplication;

public class PrevisaoApp extends MultiDexApplication {
    private static PrevisaoApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static PrevisaoApp getInstance(){
        return instance;
    }
}
