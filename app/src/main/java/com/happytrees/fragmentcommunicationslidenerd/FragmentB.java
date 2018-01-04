package com.happytrees.fragmentcommunicationslidenerd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FragmentB extends Fragment {

    TextView text;
    String data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        if (savedInstanceState ==null) //means fragment created for the first time
        {
         //do nothing
        }
        else
        {
            data = savedInstanceState.getString("text");//retrieve data variable we saved in Bundle outstate object. result will be kept under data object
            TextView myText = (TextView) view.findViewById(R.id.textView);
            myText.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {//method that secures than Activity onCreate was finished
        super.onActivityCreated(savedInstanceState);
        text  = (TextView) getActivity().findViewById(R.id.textView);//getActivity()- returns the Activity this fragment is currently associated with.
    }

    //OVERRIDE onSaveInstanceState TO SAVE CHANGES IN COUNTER AFTER SWITCHING BETWEEN PORTRAIT AND LANDSCAPE MODE
    @Override
    public void onSaveInstanceState(Bundle outState) {//method called just before fragment is about to be destroyed
        super.onSaveInstanceState(outState);
        outState.putString("text",data);//store our text in data variable in Bundle outstate object which  passed to onCreate method activated  when activity/fragment recreated(Object then renamed to Bundle savedInstanceState) ."text" is key
    }

    public void changeText (String data) {
        this.data = data;
        text.setText(data);
    }
}
