package com.kostas.fortunecookie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class tellerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teller);

        Intent intent = getIntent();
        String fortune = intent.getStringExtra(MainActivity.EXTRA);
        System.out.println(fortune);
        TextView txt = new TextView(this);
        txt.setTextSize(30);
        txt.setGravity(Gravity.CENTER_HORIZONTAL);
        txt.setText(fortune);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(txt);
    }

    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
