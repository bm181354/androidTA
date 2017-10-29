package com.example.sse.customlistview_sse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

//Step-By-Step, Fragment Transactions

    private
    ListView lvEpisodes;     //Reference to the listview GUI component
    ListAdapter lvAdapter;   //Reference to the Adapter used to populate the listview.

    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEpisodes = (ListView)findViewById(R.id.lvEpisodes);
        lvAdapter = new MyCustomAdapter(this.getBaseContext());  //instead of passing the boring default string adapter, let's pass our own, see class MyCustomAdapter below!
        lvEpisodes.setAdapter(lvAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);   //get rid of default behavior.

        // Inflate the menu; this adds items to the action bar
        getMenuInflater().inflate(R.menu.my_test_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu1) {

            Intent intent = new Intent("android.intent.action.VIEW",
                    Uri.parse("http://shop.startrek.com/info.php"));
            startActivity(intent);
            /* ADD code here*/

            return true;
        }

        if (id == R.id.menu2) {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:18007827875"));
            startActivity(intent);

            return true;
        }

        if (id == R.id.menu3) {
            Toast.makeText(getBaseContext(), "Ring ring, Hi Mom.", Toast.LENGTH_LONG).show();

            /* ADD code here*/
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:18007827875"));
            intent.putExtra("sms_body","ouch");
            startActivity(intent);

            return true;
        }
        if (id == R.id.menu4) {


            try {
            /* ADD code here*/
                Log.i("PackageName: ", getPackageName());

                /*

                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/raw/spock_livelong.mp3");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //File file = new File(getApplicationContext().getFilesDir().getAbsolutePath() +"res/raw/spock_livelong.mp3");
                intent.setType("audio/mp3");
                intent.setData(uri);
                startActivity(intent);


                */

                mediaPlayer = MediaPlayer.create(this,R.raw.spock_livelong);
                mediaPlayer.start();


                Toast.makeText(getBaseContext(), " Audio is being played", Toast.LENGTH_SHORT).show();

            }catch( Exception err) {

                err.printStackTrace();
                return true;
            }
        }
        if (id == R.id.menu5) {
            /* ADD code here*/

            Intent intent = new Intent(this,VideoActivity.class);
            startActivity(intent);
            return true;

        }


            return super.onOptionsItemSelected(item);  //if none of the above are true, do the default and return a boolean.
    }


    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();

    }
}

//***************************************************************//
//create a  class that extends BaseAdapter
//Hit Alt-Ins to easily implement required BaseAdapter methods.
//***************************************************************//
//
//class m2 extends BaseAdapter{
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
//}

//STEP 1: Create references to needed resources for the ListView Object.  String Arrays, Images, etc.

class MyCustomAdapter extends BaseAdapter {

    private
     String episodes[];             //Keeping it simple.  Using Parallel arrays is the introductory way to store the List data.
     String  episodeDescriptions[];  //the "better" way is to encapsulate the list items into an object, then create an arraylist of objects.
//     int episodeImages[];         //this approach is fine for now.
     ArrayList<Integer> episodeImages;  //Well, we can use one arrayList too...  Just mixing it up, Arrays or Templated ArrayLists, you choose.
     int [] rating = {1,2,3,4,1,2,4}; // dummy rating

//    ArrayList<String> episodes;
//    ArrayList<String> episodeDescriptions;

    Button btnRandom;
    Context context;   //Creating a reference to our context object, so we only have to get it once.  Context enables access to application specific resources.
                       // Eg, spawning & receiving intents, locating the various managers.

//STEP 2: Override the Constructor, be sure to:
    // grab the context, the callback gets it as a parm.
    // load the strings and images into object references.
    public MyCustomAdapter(Context aContext) {
//initializing our data in the constructor.
        context = aContext;  //saving the context we'll need it again.

        episodes =aContext.getResources().getStringArray(R.array.episodes);  //retrieving list of episodes predefined in strings-array "episodes" in strings.xml
        episodeDescriptions = aContext.getResources().getStringArray(R.array.episode_descriptions);

//This is how you would do it if you were using an ArrayList, leaving code here for reference, though we could use it instead of the above.
//        episodes = (ArrayList<String>) Arrays.asList(aContext.getResources().getStringArray(R.array.episodes));  //retrieving list of episodes predefined in strings-array "episodes" in strings.xml
//        episodeDescriptions = (ArrayList<String>) Arrays.asList(aContext.getResources().getStringArray(R.array.episode_descriptions));  //Also casting to a friendly ArrayList.


        episodeImages = new ArrayList<Integer>();   //Could also use helper function "getDrawables(..)" below to auto-extract drawable resources, but keeping things as simple as possible.
        episodeImages.add(R.drawable.st_spocks_brain);
        episodeImages.add(R.drawable.st_arena__kirk_gorn);
        episodeImages.add(R.drawable.st_this_side_of_paradise__spock_in_love);
        episodeImages.add(R.drawable.st_mirror_mirror__evil_spock_and_good_kirk);
        episodeImages.add(R.drawable.st_platos_stepchildren__kirk_spock);
        episodeImages.add(R.drawable.st_the_naked_time__sulu_sword);
        episodeImages.add(R.drawable.st_the_trouble_with_tribbles__kirk_tribbles);




        // creating a Sharefpreferences to store file -- similiar to coredata

    }

//STEP 3: Override and implement getCount(..), ListView uses this to determine how many rows to render.
    @Override
    public int getCount() {
//        return episodes.size(); //all of the arrays are same length, so return length of any... ick!  But ok for now. :)
        return episodes.length;   //all of the arrays are same length, so return length of any... ick!  But ok for now. :)
                                  //Q: How else could we have done this (better)? ________________
    }

//STEP 4: Override getItem/getItemId, we aren't using these, but we must override anyway.
    @Override
    public Object getItem(int position) {
//        return episodes.get(position);  //In Case you want to use an ArrayList
        return episodes[position];        //really should be returning entire set of row data, but it's up to us, and we aren't using this call.
    }

    @Override
    public long getItemId(int position) {
        return position;  //Another call we aren't using, but have to do something since we had to implement (base is abstract).
    }

//THIS IS WHERE THE ACTION HAPPENS.  getView(..) is how each row gets rendered.
//STEP 5: Easy as A-B-C
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {  //convertView is Row (it may be null), parent is the layout that has the row Views.

//STEP 5a: Inflate the listview row based on the xml.
        View row;  //this will refer to the row to be inflated or displayed if it's already been displayed. (listview_row.xml)
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        row = inflater.inflate(R.layout.listview_row, parent, false);  //

// Let's optimize a bit by checking to see if we need to inflate, or if it's already been inflated...
        if (convertView == null){  //indicates this is the first time we are creating this row.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_row, parent, false);
        }
        else
        {
            row = convertView;
        }

//STEP 5b: Now that we have a valid row instance, we need to get references to the views within that row and fill with the appropriate text and images.
        ImageView imgEpisode = (ImageView) row.findViewById(R.id.imgEpisode);  //Q: Notice we prefixed findViewByID with row, why?  A: Row, is the container.
        TextView tvEpisodeTitle = (TextView) row.findViewById(R.id.tvEpisodeTitle);
        TextView tvEpisodeDescription = (TextView) row.findViewById(R.id.tvEpisodeDescription);
        RatingBar rbEpisode = (RatingBar) row.findViewById(R.id.rbEpisode);


        tvEpisodeTitle.setText(episodes[position]);
        tvEpisodeDescription.setText(episodeDescriptions[position]);
        imgEpisode.setImageResource(episodeImages.get(position).intValue());

        btnRandom = (Button) row.findViewById(R.id.btnRandom);
        final String randomMsg = ((Integer)position).toString() +": "+ episodeDescriptions[position];

        // set rating here
        //rbEpisode.setRating(rating[position]);

        float v = 3.2f;

        SharedPreferences sp1 = context.getSharedPreferences("ratings1",Context.MODE_PRIVATE);

        String rate_string = sp1.getString(position+"","2");
        float rate = Float.valueOf(rate_string);


        Log.i("Position","Position is "+position+" got Rating "+rate_string);
        //Log.i("ERROR",rate_string);
        rbEpisode.setRating(rate);


 //MARK:- DONE
        rbEpisode.setOnRatingBarChangeListener(

                //MARK:- getting automatically trigger for some reason
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                        // b is true when user triggers the action
                        //MARK:- when system does it, b is false
                        if (b) {
                            SharedPreferences sp = context.getSharedPreferences("ratings1", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sp.edit();

                            editor.putString(position + "", v + "");
                            editor.commit();

                            Log.i("Position", "Position is " + position + " New Rating!!!! ==" + v);
                        }

                    }



                }


        );

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Position",position+"");
                // 0 to 7 element
                switch (position){


                    case 0:
                        Toast.makeText(context, "0", Toast.LENGTH_SHORT).show();
                        Intent viewIntent = new Intent("android.intent.action.VIEW",
                                Uri.parse("http://memory-alpha.wikia.com/wiki/Spock's_Brain_(episode)"));
                        viewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent);
                        break;


                    case 1:
                        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();

                        Intent viewIntent1 = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/Arena_(Star_Trek:_The_Original_Series)"));
                        viewIntent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent1);
                        break;

                    case 2:
                        Toast.makeText( context, "2", Toast.LENGTH_SHORT).show();

                        Intent viewIntent2 = new Intent("android.intent.action.VIEW",
                                Uri.parse("https://en.wikipedia.org/wiki/This_Side_of_Paradise_(Star_Trek:_The_Original_Series)"));
                        viewIntent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent2);
                        break;

                    case 3:
                        Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();

                        Intent viewIntent3 = new Intent("android.intent.action.VIEW",
                                Uri.parse("http://memory-alpha.wikia.com/wiki/Mirror,_Mirror_(episode)"));
                        viewIntent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent3);
                        break;

                    case 4:
                        Toast.makeText(context, "4", Toast.LENGTH_SHORT).show();

                        Intent viewIntent4 = new Intent("android.intent.action.VIEW",
                                Uri.parse("http://memory-alpha.wikia.com/wiki/Plato's_Stepchildren_(episode)"));
                        viewIntent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent4);
                        break;

                    case 5:
                        Toast.makeText(context, "5", Toast.LENGTH_SHORT).show();

                        Intent viewIntent5 = new Intent("android.intent.action.VIEW",
                                Uri.parse("http://memory-alpha.wikia.com/wiki/The_Naked_Time_(episode)"));
                        viewIntent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent5);
                        break;

                    case 6:
                        Toast.makeText(context, "6", Toast.LENGTH_SHORT).show();

                        Intent viewIntent6 = new Intent("android.intent.action.VIEW",
                                Uri.parse("http://memory-alpha.wikia.com/wiki/The_Trouble_with_Tribbles_(episode)"));
                        viewIntent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(viewIntent6);
                        break;
                    default:
                        Toast.makeText(context, "Out of bound", Toast.LENGTH_SHORT).show();

                }



            }
        });

//STEP 5c: That's it, the row has been inflated and filled with data, return it.
        return row;  //once the row is fully constructed, return it.  Hey whatif we had buttons, can we target onClick Events within the rows, yep!
//return convertView;

    }

    ///Helper method to get the drawables...///
    ///this might prove useful later...///

//    public ArrayList<Drawable> getDrawables() {
//        Field[] drawablesFields =com.example.sse.customlistview_sse.R.drawable.class.getFields();
//        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
//
//        String fieldName;
//        for (Field field : drawablesFields) {
//            try {
//                fieldName = field.getName();
//                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);
//                if (fieldName.startsWith("animals_"))  //only add drawable resources that have our prefix.
//                    drawables.add(context.getResources().getDrawable(field.getInt(null)));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}