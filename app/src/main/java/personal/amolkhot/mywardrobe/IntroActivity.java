package personal.amolkhot.mywardrobe;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity{

    private static String TAG="IntroActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setClickListener();
        ((TextView)findViewById(R.id.continue_text)).setTypeface(((MyApplication)getApplication()).getFont_Tempus_Sans_ITC());
    }

    void setClickListener(){
        findViewById(R.id.intro_screen_parent_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"OnClick() | Intro Screen Click");
                Intent intent = new Intent(IntroActivity.this,HomeActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(IntroActivity.this).toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
