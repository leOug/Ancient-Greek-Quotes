package com.kostas.fortunecookie;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int position;

    public final static String EXTRA = "com.kostas.fortunecookie.MESSAGE";

    final private String[] sayingAnc = {
            "Πάντων χρημάτων μέτρον έστιν άνθρωπος, των μεν όντων ως έστιν, των δε ουκ όντων ως ουκ εστίν.",
            "Ζώον δίπουν άπτερον",
            "Άνθρωπος: ο αναθρών ά όπωπε.",
            "Τι εστιν ό μίαν έχον φωνήν τετράπουν και δίπουν και τρίπουν γίνεται;",
            "Φύσει γαρ άνθρωπος, ό βούλεται, τούτο και οίεται.",
            "Πολέμιον ανθρώποις αυτοί εαυτοίς."
    };

    final private String[] sayingGr = {

    };

    final private String[] sayingEng = {

    };

    final private String[] philosopherGr = {
            "Πρωταγόρας",
            "Πλάτων",
            "Πλάτων",
            "Το αίνιγμα της Σφίγγας",
            "Ιούλιος Καίσαρ",
            "Ανάχαρσις"

    };

    final private String[] getPhilosopherEng = {
            "Protagoras",
            "Plato",
            "Plato",
            "Sphinx's riddle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Length", "is" + sayingAnc.length);
    }


    public String getQuote(String type) {
        String tmp;
        position = (int) (Math.random() * sayingAnc.length);
        if (type.equals("anc")) {
            tmp = sayingAnc[position];
        } else if (type.equals("gr")){
            tmp = sayingGr[position];
        } else if (type.equals("eng")){
            tmp = sayingEng[position];
        } else {
            return null;
        }
        return tmp;
    }

    public String getPhilosopher(String type) {
        String tmp;
        if (type.equals("anc")) {
            tmp = philosopherGr[position];
        } else {
            return null;
        }

        return tmp;
    }

    public void showQuote(View view){
        String anc, gr, eng;
        Intent intent = new Intent(this,tellerActivity.class);
        anc = getQuote("anc");
        //gr = getQuote("gr");
        //eng = getQuote("eng");

        intent.putExtra(EXTRA, anc);
        startActivity(intent);
    }
}
