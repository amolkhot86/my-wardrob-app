package personal.amolkhot.mywardrobe.framework;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import personal.amolkhot.mywardrobe.framework.controllers.CustomFonts;
import personal.amolkhot.mywardrobe.framework.datacontroller.database.WardrobDb;

/**
 * Created by amol.khot on 24-Oct-18.
 */

public class Framework {

    private static String TAG = "Framework";
    private Context mycontext;
    static Framework instance;
    private CustomFonts customFonts;
    private WardrobDb wardrobDb;

    private Framework(){ }
    private Framework(Context context){
        Log.i(TAG,"Creating new Instance of Framework");
        mycontext=context;
        customFonts = new CustomFonts(context);
        wardrobDb = Room.databaseBuilder(context,WardrobDb.class,"myWardrobDb.db").build();
    }

    public static void Initialize(Context context){
        Log.i(TAG,"Initialize()");
        if(instance == null){ instance=new Framework(context);}
    }
    public static void ReInitialize(Context context){
        Log.i(TAG,"ReInitialize()");
        instance = new Framework(context);
    }
    public static Framework getInstance(){return instance;}

    public Typeface getFont(String fontname){ return customFonts.getFont(fontname); }
    public WardrobDb getDatabase(){return wardrobDb;}
}
