package com.example.bikenmaharjan.webscraptextdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // private variable deleration
    private TextView txt;
    private Button btnGet;
    private EditText editText;
    private TextView txt1;
    private String param;
    private ListView lvInfo;

    ArrayList productList;
    ArrayList productPrice;
    ArrayAdapter la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // getting all the reference sorted
        btnGet = (Button) findViewById(R.id.btnGet);
        editText = (EditText) findViewById(R.id.editText);
        txt = (TextView) findViewById(R.id.txtView);
        lvInfo = (ListView) findViewById(R.id.lvInfo);


        productList =  new ArrayList<String>();
        productPrice = new ArrayList<String>();


        btnGet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*   code for the main part of the scape  */
                        param = editText.getText().toString();
                        new doit().execute();



                    }
                }

        );


    }


    // TODO : import jsoup library
    public class doit extends AsyncTask<Void,Void,Void> {

        String words;

        Elements product_name;
        Elements product1;
        String product;

        // Background_thread
        @Override
        protected Void doInBackground(Void... voids) {

            try {

                Log.w("Print",param);


                Document doc = Jsoup.connect("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords="+param).get();

                for( int i =0 ; i < 11; i++){

                    Element li = doc.getElementById("result_"+i);


                    //li.price()
                    product1 = li.getElementsByClass("a-offscreen");


                    // converting into a string
                    product_name = li.getElementsByAttributeStarting("data-attribute");


                    // price of all
                    Elements li1 = doc.getElementsByClass("a-offscreen");
                    Log.i("ALL", " "+li1.text());


                    // price of one item
                    Elements liAll = li.getElementsByClass("a-offscreen");


                    Log.i("Single",product_name.text().toString() +" " + liAll.text());


                    // all the list
                    productList.add(product_name.text().toString());
                    productPrice.add(liAll.text().toString());

                }

                // getting the text from the stored data
                words = doc.text();




            }catch (IOException err){
                err.printStackTrace();
            }

            return null;
        }


        // updating UI-Thread
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            txt.setText(productPrice.get(0).toString());

            la = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, productList);
            lvInfo.setAdapter(la);

            /*   see this part as well */
            //txt1.setText(product1.text().toString());

            lvInfo.setOnItemClickListener(

                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            txt.setText(productPrice.get(i).toString());

                        }
                    }
            );

        }
    }

}
