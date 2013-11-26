package com.example.Software;

import android.app.Activity;
import android.content.Intent;
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

        tvname=(TextView)findViewById(R.id.textView);
        image=(ImageView)findViewById(R.id.imageView);

        //Myactivityden position değerini alıyorum.
        Intent myLocalIntent2 = getIntent();
        Bundle myBundle = myLocalIntent2.getExtras();
        int val1 = myBundle.getInt("val1");

        if(val1==0){
            image.setImageResource(R.drawable.einstein);
        }else if (val1==1){
            image.setImageResource(R.drawable.celcius);
        }else if (val1==2){
            image.setImageResource(R.drawable.abel);
        }else if (val1==3){
            image.setImageResource(R.drawable.galilei);
        }else if (val1==4){
            image.setImageResource(R.drawable.darwin);
        }else if (val1==5){
            image.setImageResource(R.drawable.edison);
        }else if (val1==6){
            image.setImageResource(R.drawable.socrates);
        }else if (val1==7){
            image.setImageResource(R.drawable.thales);
        }else if (val1==8){
            image.setImageResource(R.drawable.einstein);
        }else if (val1==9){
            image.setImageResource(R.drawable.einstein);
        }



    }
}
