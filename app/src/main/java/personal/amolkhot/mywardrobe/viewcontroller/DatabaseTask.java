package personal.amolkhot.mywardrobe.viewcontroller;

import android.app.Activity;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by amol.khot on 25-Oct-18.
 */

public class DatabaseTask extends AsyncTask<String,Integer,String>{

    WeakReference<Activity> mWeakActivity;

    public DatabaseTask(Activity activity){
        mWeakActivity = new WeakReference<Activity>(activity);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Activity activity = mWeakActivity.get();
        if(activity != null){

        }
    }
}
