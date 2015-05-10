package android.forestlab.info.baseactivities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Simple Activity example
 * with 2 ways of adding onClick Listeners
 * 1. Activity: 	Button.setOnClickListener(...);
 * 2. layout.xml: 	<Button android:onClick="..." />
 */
public class MainActivity extends ActionBarActivity {

	TextView textView2;
	EditText edit2;
	Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// init example 1 widgets and onClick Listener
		final TextView textView1 = (TextView) findViewById(R.id.textView1);
		final EditText edit1 = (EditText) findViewById(R.id.editText1);
		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String text = edit1.getText().toString();
				textView1.setText(text);
			}
		});

		// init example 2 widgets
		textView2 = (TextView) findViewById(R.id.textView2);
		edit2 = (EditText) findViewById(R.id.editText2);
		button2 = (Button) findViewById(R.id.button2);
	}

	/**
	 * example 2 onClick Listener
	 * @param v
	 */
	public void onButton2Click(View v){
		String text = edit2.getText().toString();
		textView2.setText(text);
	}

}
