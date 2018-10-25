package personal.amolkhot.mywardrobe.ui.screens;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import personal.amolkhot.mywardrobe.MyApplication;
import personal.amolkhot.mywardrobe.R;
import personal.amolkhot.mywardrobe.framework.Framework;
import personal.amolkhot.mywardrobe.framework.datacontroller.database.tables.User;

public class IntroActivity extends AppCompatActivity{

    private static String TAG="IntroActivity";
    private Framework framework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        framework = Framework.getInstance();
        setClickListener();
        ((TextView)findViewById(R.id.user_text)).setTypeface(framework.getFont("tempus_sans_itc"));
    }

    void setClickListener(){
        findViewById(R.id.intro_screen_parent_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"OnClick() | Intro Screen Click");
                createUser();
//                Intent intent = new Intent(IntroActivity.this,HomeActivity.class);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(IntroActivity.this).toBundle());
//                } else {
//                    startActivity(intent);
//                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }

    private void createUser(){
        Log.i(TAG,"createUser()");
        new CreateUserTask().execute("Amol");
    }
    private void userCreated(){
        Log.i(TAG,"userCreated()");
        loadUsersFromDatabase();
    }
    private void loadUsersFromDatabase(){
        Log.i(TAG,"loadUsersFromDatabase()");
        new LoadUserDataTask().execute();
    }
    private void loadUsersToUI(List<User> users){
        Log.i(TAG,"loadUsersToUI() | SIZE : " + users.size());
    }
    private class LoadUserDataTask extends AsyncTask<Void,Void,List<User>>{

        @Override
        protected List<User> doInBackground(Void... params) {
            return framework.getDatabase().getUserHandlerRef().getAllUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            loadUsersToUI(users);
        }
    }
    private class CreateUserTask extends AsyncTask<String,Void,Void>{
        @Override
        protected Void doInBackground(String... userName) {
            framework.getDatabase().getUserHandlerRef().insert(new User(userName[0]));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            userCreated();
        }
    }
}
