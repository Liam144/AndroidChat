package edu.udistrital.android.androidchat.lib;

import android.util.Log;

/*
 * Created by Karol on 14/06/2016.
 */
public class GreenRobotEventBus implements EventBus {
    de.greenrobot.event.EventBus eventBus;

    private static class SingletonHolder{
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public GreenRobotEventBus(){
        eventBus = de.greenrobot.event.EventBus.getDefault();
    }

    public void register(Object subscriber){
        eventBus.register(subscriber);
    }


    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }


    public void post(Object event) {
        eventBus.post(event);
    }
}
