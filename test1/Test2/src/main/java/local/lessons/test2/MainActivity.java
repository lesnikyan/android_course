package local.lessons.test2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import MyViews.NumeredButton;


public class MainActivity extends ActionBarActivity {

    private String TAG = "testTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        NumeredButton fb = (NumeredButton) findViewById(R.id.firstButton);
        fb.setText("Text 2");
        fb.setTextColor(0xff880088);
        fb.setVal(10);
        //fb.setBackgroundColor(0xff44ff44);

        final TextView tw = (TextView)findViewById(R.id.targetText);

        final MainActivity thisIs = this;
        class FbuttonClickListener implements View.OnClickListener {
            private int val;
            // for standard button
            FbuttonClickListener(int val){
                this.val = val;
            }
            @Override
            public void onClick(View v) {
                // for extended button
                NumeredButton nb = (NumeredButton) v;
                tw.setText(Integer.toString(nb.getVal()));
                nb.incVal();
                Log.d(TAG, "FbuttonClickListener.onClick: end; id = " + nb.getId());
                Toast.makeText(MainActivity.this, "toast: " + nb.getVal(), Toast.LENGTH_LONG).show();
            }
        }
        fb.setOnClickListener(new FbuttonClickListener(123));

    }


    /**
     * http://developer.alexanderklimov.ru/android/theory/menu.php
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;
        menu.add("menu 1").setVisible(true);
        menu.add("menu 2");
        menu.add("menu 3");
        menu.add("menu 4");
        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true; // super.onOptionsItemSelected(item);
    }
}
