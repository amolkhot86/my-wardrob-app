package personal.amolkhot.mywardrobe.framework.controllers;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by amol.khot on 24-Oct-18.
 */

public class CustomFonts {
    HashMap<String,Typeface> fontlist = new HashMap<>();
    public CustomFonts(Context context){
        fontlist.put("tempus_sans_itc",Typeface.createFromAsset(context.getAssets(),  "fonts/tempus_sans_itc.ttf"));
    }
    public Typeface getFont(String fontname){
        if(fontlist.containsKey(fontname))
            return fontlist.get(fontname);
        else
            return null;
    }
}
