package com.happytrees.fragmentcommunicationslidenerd;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(String data) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentB f2 = (FragmentB) manager.findFragmentById(R.id.fragment2);
        f2.changeText(data);
    }
}
//EVERY TIME USER CLICKED BUTTON DEFINED IN FRAGMENT A , NUMBER IN TEXTVIEW DEFINED IN FRAGMENT B WILL RISE BY ONE.THIS EXAMPLE SHOWS HOW FRAGMENT A COMMUNICATES WITH FRAGMENT B.
//FRAGMENTS WERE SET INTO MAINACTIVITY USING XML WAY.NOT JAVA ONE.
//FRAGMENTS CHANGES WERE SECURED TO BE THE SAME AFTER SWITCHING BETWEEN PORTRAIT AND LANDSCAPE MODE ,BY OVERRIDING onSaveInstanceState