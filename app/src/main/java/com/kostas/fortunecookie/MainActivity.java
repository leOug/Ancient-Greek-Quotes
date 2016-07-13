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
import android.os.Environment;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button debug;
    Intent intent;
    static public String path = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        intent = new Intent(this, tellerActivity.class);
        debug = (Button) findViewById(R.id.debug);

        debug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFile();
                deleteTimesFile();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] savedDate = load();
                if (savedDate != null) {
                    if (hasAccess(savedDate)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "You must wait until tomorrow to get another quote", Toast.LENGTH_LONG).show();
                    }
                } else {
                    startActivity(intent);
                }
            }
        });

    }

    public boolean hasAccess(String[] saved) {
        int[] savedDate = new int[3];
        int[] curDate = new int[3];
        String[] currentDate = getCurrentDate();
        savedDate[0] = Integer.parseInt(saved[0]);
        savedDate[1] = Integer.parseInt(saved[1]);
        savedDate[2] = Integer.parseInt(saved[2]);
        curDate[0] = Integer.parseInt(currentDate[0]);
        curDate[1] = Integer.parseInt(currentDate[1]);
        curDate[2] = Integer.parseInt(currentDate[2]);


        if (curDate[2] > savedDate[2]) {
            return true;
        } else {
            if (curDate[1] > savedDate[1]) {
                deleteTimesFile();
                return true;
            } else {
                if (curDate[0] > savedDate[0]) {
                    deleteTimesFile();
                    return true;
                } else {
                    if (getTimesSoFar() < 5) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public boolean deleteFile() {
        File file = new File(path, "log.txt");
        if (file.exists()) {
            return file.delete();
        } else {
            return true;
        }
    }

    public boolean deleteTimesFile() {
        File file = new File(path, "times.txt");
        if (file.exists()) {
            return file.delete();
        } else {
            return true;
        }
    }


    public String[] getCurrentDate () {
        Calendar c = Calendar.getInstance();
        String[] tmp = new String[3];
        tmp[0] = c.get(Calendar.DAY_OF_MONTH) + "";
        tmp[1] = c.get(Calendar.MONTH) + "";
        tmp[2] = c.get(Calendar.YEAR) + "";

        return tmp;
    }

    public String[] load() {
        File file = new File(path, "log.txt");
        if (file.exists()) {
            return Load(file);
        } else {
            return null;
        }

    }

    public String[] Load(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int size = 0;
        try {
            while ((test = br.readLine()) != null) {
                size++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis.getChannel().position(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] array = new String[size];
        String line;
        int i = 0;
        try {
            while ((line = br.readLine()) != null) {
                array[i] = line;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public int getTimesSoFar() {
        File file = new File(path, "times.txt");
        String tmp;
        if (file.exists()) {
            tmp = LoadTimes(file);
            Log.i ("DEBUG", "In main getTimesSoFar");
            if (tmp != null && !tmp.equals("")) {
                int tmpInt = Integer.parseInt(tmp);
                Log.i ("DEBUG", "about to return");
                return tmpInt;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public String LoadTimes(File file) {
        FileInputStream fis = null;
        Log.i ("DEBUG", "In main loadTimes");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        try {
            fis.getChannel().position(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tmp = null;
        String line;
        int i = 0;
        try {
            if ((line = br.readLine()) != null) {
                tmp = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }


}
