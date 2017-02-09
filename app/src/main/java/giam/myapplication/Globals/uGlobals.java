package giam.myapplication.Globals;

import android.app.Application;

public class uGlobals extends Application {
    private static uGlobals instance;

    public boolean  section_ini     = false;

    public static synchronized uGlobals getInstance(){
        if(instance==null){
            instance=new uGlobals();
        }
        return instance;
    }
}