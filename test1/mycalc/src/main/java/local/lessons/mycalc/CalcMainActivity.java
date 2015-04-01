package local.lessons.mycalc;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


public class CalcMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);
        ((Button) findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView) findViewById(R.id.textView2)).setText(Long.toString(System.currentTimeMillis()));
            }
        });

        TableLayout tl = ((TableLayout)findViewById(R.id.layoutButtons));

        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        int btnBaseId = 3;
        for(int i = 0; i < 2; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(lp);
            tl.addView(row);
            for(int j = 0; j < 3; j++){
                Button bt = new Button(this);
                //bt.setId(View.generateViewId());
                bt.setId(100 + j);
                bt.setText("g");
                row.addView(bt);
            }
        }

        List<View> buttons = tl.getTouchables();
        System.out.println(buttons.size());

//        for(int i = 0; i < 9; i++){
//            ((Button) buttons.get(i)).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ((TextView) findViewById(R.id.textView2)).setText(
//                            ((Button)v).getText()
//                    );
//                }
//            });
//        }
        RelativeLayout rl = ((RelativeLayout)findViewById(R.id.mainLayout));

        Button bt = new Button(this);
        bt.setId(R.id.goToAnotherScreen);
        bt.setText("Go to Another Screen");
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)bt.getLayoutParams();
        params = new RelativeLayout.LayoutParams(200, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.layoutButtons);
        bt.setLayoutParams(params);
        rl.addView(bt);

        final Activity that = this;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(that, AnotherActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc_main, menu);
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
