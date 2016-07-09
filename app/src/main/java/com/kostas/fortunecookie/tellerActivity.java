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

    TextView anc_quote;
    TextView gr_quote;
    TextView philosopher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teller);

        anc_quote = (TextView) findViewById(R.id.anc_quote);
        gr_quote = (TextView) findViewById(R.id.gr_quote);
        philosopher = (TextView) findViewById(R.id.phil);



        String anc, gr, phil;
        Intent intent = getIntent();
        anc = intent.getStringExtra("anc");
        gr = intent.getStringExtra("gr");
        phil = intent.getStringExtra("phil");

        anc_quote.setText(anc);
        gr_quote.setText(gr);
        philosopher.setText("~" + phil);

    }

    public void returnToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
