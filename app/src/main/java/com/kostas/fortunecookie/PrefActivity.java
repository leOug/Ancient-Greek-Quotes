package com.kostas.fortunecookie;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PrefActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PrefFragment pref = new PrefFragment();
        FragmentManager frag = getFragmentManager();
        FragmentTransaction trans= frag.beginTransaction();
        trans.replace(android.R.id.content, pref);
        trans.commit();
    }
}
