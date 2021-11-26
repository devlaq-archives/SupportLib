package supportlib;

import supportlib.struct.*;
import supportlib.util.*;

public interface Application extends Disposable{

    /** Returns a list of all the application listeners used. */
    Seq<ApplicationListener> getListeners();

    /** Adds a new application listener. */
    default void addListener(ApplicationListener listener){
        synchronized(getListeners()){
            getListeners().add(listener);
        }
    }

    /** Removes an application listener. */
    default void removeListener(ApplicationListener listener){
        synchronized(getListeners()){
            getListeners().remove(listener);
        }
    }

    /** Call this before update() in each backend. */
    default void defaultUpdate(){
        Core.settings.autosave();
        Time.updateGlobal();
    }

    /** @return what {@link ApplicationType} this application has, e.g. Android or Desktop */
    ApplicationType getType();

    /** @return the Java heap memory use in bytes. */
    default long getJavaHeap(){
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /** Posts a runnable on the main loop thread.*/
    void post(Runnable runnable);

    /**
     * Schedule an exit from the application. On android, this will cause a call to pause() and dispose() some time in the future,
     * it will not immediately finish your application.
     * On iOS this should be avoided in production as it breaks Apples guidelines.
     */
    void exit();

    /** Disposes of core resources. */
    @Override
    default void dispose(){
        //flush any changes to settings upon dispose
        if(Core.settings != null){
            Core.settings.autosave();
        }
    }

    /** Enumeration of possible {@link Application} types */
    enum ApplicationType{
        android, desktop, headless, web, iOS
    }
}
