package and.androidlearn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Bosses extends Activity {

    /**
     * This are some buttons.
     */
    private Button button_boss1, button_boss2;
    TextView tv_intro;
    public final String EXTRA_MESSAGE ="Test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosses);

        button_boss1 = (Button)findViewById(R.id.button_boss1);
        button_boss2 = (Button)findViewById(R.id.button_boss2);
        tv_intro =(TextView)findViewById(R.id.tv_intro);

        button_boss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_intro.setText(R.string.button_Boss1);

                Helper h = new Helper("Test",100);
                Boss1 boss1 = new Boss1();
                Intent intent = new Intent(getApplicationContext() ,Boss1.class);
                intent.putExtra("bundle",h);
                startActivity(intent);
            }
        });

        button_boss2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogCaller();
  /*              Bundle bundle = new Bundle();
                bundle.putString(EXTRA_MESSAGE,"this is EXTRA_MESSAGE");
                Intent in = new Intent(getApplicationContext(),Boss1.class);
                startActivity(in);*/
            }
        });

    }
    public void alertDialogCaller(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Bosses.this);
        builder.setMessage(
            "Please create a HashMap as the first step \nand wait for GPS signal!")
            .setCancelable(false)
            .setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // do things
                        }
                    });
        AlertDialog alert = builder.create();
        alert.show();
        //getIMEI(); da im Emulator nicht geht
    }

    /**
     * Geht irgendwie nicht im Emulator: Requires READ_PHONE_STATE: Neither user 10054 nor current process has android.permission.READ_PHONE_STATE.
     */
    public void getIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String IMEIString = telephonyManager.getDeviceId();
        System.out.println(IMEIString);
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
