package com.happytrees.fragmentcommunicationslidenerd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentA extends Fragment implements View.OnClickListener {
    Button button;
    int counter = 0;
    Communicator comm;//interface variable

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState ==null) //means fragment created for the first time
        {
            counter =0;
        }
        else
        {
            counter = savedInstanceState.getInt("counter",0);//retrieve counter variable we saved in Bundle outstate object.If no value was retrieved then default value 0 will be chosen and kept under variable counter
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {//method that secures than Activity onCreate was finished
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
        button  = (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    //OVERRIDE onSaveInstanceState TO SAVE CHANGES IN COUNTER AFTER SWITCHING BETWEEN PORTRAIT AND LANDSCAPE MODE
    @Override
    public void onSaveInstanceState(Bundle outState) {//method called just before fragment is about to be destroyed
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);//store our counter variable in Bundle outstate object which  passed to onCreate method activated  when activity/fragment recreated(Object then renamed to Bundle savedInstanceState) ."counter" is key
    }

    @Override
    public void onClick(View v) {
        counter++;//rises counter by one every time button was clicked
        comm.respond("The button was clicked " + counter + " times");
    }
}
