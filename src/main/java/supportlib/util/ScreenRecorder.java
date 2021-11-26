package supportlib.util;

import supportlib.*;

import java.lang.reflect.*;

/** Wrapper for GifRecorder utility that attempts to dynamically resolve the class. */
public class ScreenRecorder{
    private static Runnable record;

    static{
        try{
            Class<?> recorderClass = Class.forName("supportlib.gif.GifRecorder");
            Object recorder = recorderClass.getConstructor().newInstance();
            Reflect.set(recorder, "exportDirectory", Core.files.local("../../gifs"));
            Method r = recorderClass.getMethod("update");
            Object[] args = {};
            record = () -> {
                try{
                    r.invoke(recorder, args);
                }catch(Throwable ignored){}
            };
        }catch(Throwable ignored){
        }
    }

    public static void record(){
        if(record == null) return;
        record.run();
    }
}
