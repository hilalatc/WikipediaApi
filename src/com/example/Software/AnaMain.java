package com.example.Software;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Hilal
 * Date: 24.10.2013
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class AnaMain extends Activity {
    TextView tvname;
    ImageView image;

    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> List;

    String stringarray[]={"Albert%20Einstein","Anders%20Celsius","Niels%20Henrik%20Abel",
            "Galileo%20Galilei","Charles%20Darwin","Thomas%20Edison",
            "Socrates","Thales"};
    public static final String KEY_NAME = "name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anamain);
    }
}
