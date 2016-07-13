package com.mygdx.genexotrudnypacjent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mygdx.genexotrudnypacjent.R;
import com.mygdx.genexotrudnypacjent.model.UserData;
import com.mygdx.genexotrudnypacjent.util.SoundHelper;
import com.mygdx.livex.PodiumGame;

/**
 * Created by Radek on 28.02.2016.
 */
public class PodiumActivity extends AppCompatActivity {
    UserData mUserData;
    SoundHelper mSoundHelper;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSoundHelper = SoundHelper.getInstance(this);
        mSoundHelper.load(R.raw.brawo);

        setContentView(R.layout.podium_activity);

        if(getIntent()!=null) {
            mUserData = (UserData) getIntent().getSerializableExtra("user_data");
            //	Log.d("user data", mUserData.toString());
        }


        findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(PodiumActivity.this, ZapraszamyActivity.class);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startIntent);
            }
        });

    }



    private void onQuizEnd() {
        Intent intent = new Intent(this, SendingDataActivity.class);
        intent.putExtra("user_data", mUserData);
        finish();
        startActivity(intent);
    }
}