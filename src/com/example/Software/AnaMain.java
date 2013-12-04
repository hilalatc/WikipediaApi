package com.example.Software;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
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
            parseXML(stringarray[0]);
            image.setImageResource(R.drawable.einstein);
        }else if (val1==1){
            parseXML(stringarray[1]);
            image.setImageResource(R.drawable.celcius);
        }else if (val1==2){
            parseXML(stringarray[2]);
            image.setImageResource(R.drawable.abel);
        }else if (val1==3){
            parseXML(stringarray[3]);
            image.setImageResource(R.drawable.galilei);
        }else if (val1==4){
            parseXML(stringarray[4]);
            image.setImageResource(R.drawable.darwin);
        }else if (val1==5){
            parseXML(stringarray[5]);
            image.setImageResource(R.drawable.edison);
        }else if (val1==6){
            parseXML(stringarray[6]);
            image.setImageResource(R.drawable.socrates);
        }else if (val1==7){
            parseXML(stringarray[7]);
            image.setImageResource(R.drawable.thales);
        }else if (val1==8){
            parseXML(stringarray[8]);
            image.setImageResource(R.drawable.einstein);
        }else if (val1==9){
            parseXML(stringarray[9]);
            image.setImageResource(R.drawable.einstein);
        }

        textGoster();
    }
    public void parseXML(String title) {

        String gelenurl = "http://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Cuser%7Ccontent&rvlimit=10&titles="+title;

        try {
            String xml = getXmlResponse(gelenurl);

            DocumentBuilderFactory dFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));

            Document document = dBuilder.parse(is);
            // api query revisions yada rev gibi elemanları ismiyle bu şekilde alabilirsin
            //ben burda rev'i denedim
            NodeList information = document
                    .getElementsByTagName("rev");




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    // url den xml i string olarak çeken fonksiyon
    public String getXmlResponse(String _url) {

        String xml = null;

        try {
            HttpPost httpPost = new HttpPost(_url);
            HttpParams httpParameters = new BasicHttpParams();

            int timeoutConnection = 7000;
            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

            int timeoutSocket = 7000;
            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            BasicHttpResponse httpResponse = (BasicHttpResponse) httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity);


        } catch (Exception e) {
            return "SERVER_ERROR";
        }

        return xml;
    }
    public void textGoster(){
        String key2,value2;
        String name="";
        HashMap<String, String> m=new HashMap<String,String>();
        for (int k=0;k<List.size();k++){
            m = List.get(k);//it will get the first HashMap Stored in array list

            String strArr[] = new String[m.size()];
            int i=0;
            boolean exists = m.containsKey("name");
            boolean exists1 = m.containsKey("birth_date");
            boolean exists2 = m.containsKey("death_date");
            boolean exists3 = m.containsKey("residence");
            boolean exists4= m.containsKey("citizenship");
            boolean exists5= m.containsKey("ethnicity");
            boolean exists6= m.containsKey("thesis_title");
            boolean exists7= m.containsKey("thesis_year");
            boolean exists8= m.containsKey("caption");
            if (exists==true){
                tvname.append("NAME      "+m.get("name")+"\n");
            } else if (exists1==true){
                tvname.append("BIRTH DATE "+m.get("birth_date")+"\n");
            } else if (exists2==true){
                tvname.append("DEATH DATE "+m.get("death_date")+"\n");
            } else if (exists3==true){
                tvname.append("RESIDENCE "+m.get("residence")+"\n");
            } else if (exists4==true){
                tvname.append("CITIZENSHIP "+m.get("citizenship")+"\n");
            } else if (exists5==true){
                tvname.append("ETHNICITY "+m.get("ethnicity")+"\n");
            }  else if (exists6==true){
                tvname.append("THESISI "+m.get("thesis_title")+"\n");
            } else if (exists7==true){
                tvname.append(" "+m.get("thesis_year")+"\n");
            } else if (exists8==true){
                tvname.append("CAPTION "+m.get("caption")+"\n");
            }

        }

    }
}
