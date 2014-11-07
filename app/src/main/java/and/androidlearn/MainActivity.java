package and.androidlearn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    /**
     * This are some buttons.
     */
    Button button_boss1, button_boss2;
    TextView tv_intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_boss1 = (Button)findViewById(R.id.button_boss1);
        button_boss2 = (Button)findViewById(R.id.button_boss2);
        tv_intro =(TextView)findViewById(R.id.tv_intro);

        button_boss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_intro.setText(R.string.button_Boss1);

                Boss1 boss1 = new Boss1();
                Intent intent = new Intent(getApplicationContext() ,Boss1.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}