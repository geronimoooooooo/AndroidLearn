package and.androidlearn;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;


/**
 * Handles everything about the first Boss.
 */
public class Boss1 extends Activity {

    TextView tv_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss1);

        tv_question = (TextView)findViewById(R.id.tv_question);
        try {
            tv_question.setText(readJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_boss1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Reads a json file and fills the JSONObject.
     * @return
     *
     */
    public String readJson() throws JSONException {
        String json="";

        InputStream is = null;
        try {
            is = getResources().getAssets().open("file.json");
        } catch (IOException ex){
            ex.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = sb.toString();

        JSONObject jobj = new JSONObject();

        try {
             jobj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jObject = new JSONObject(json.trim());
        Iterator<?> keys = jObject.keys();
        System.out.println("Gets the only and single key for json: "+jObject.keys().next());

        while( keys.hasNext() ){
            String key = (String)keys.next();
            System.out.println("key::::::::::::::::::::::::::::"+key);
        }



       // System.out.println("Text: "+json);
        try {
            System.out.println(jobj.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

}
