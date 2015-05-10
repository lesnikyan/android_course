package local.lessons.services;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	private boolean serviceStarted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("MAIN_ACT", "onCreate");
	}

	public void onService(View v){
		if(serviceStarted) {
			stopService(new Intent(this, TargetService.class));
			((Button) v).setText(R.string.button_service_start);
			serviceStarted = false;
		} else {
			startService(new Intent(this, TargetService.class));
			((Button) v).setText(R.string.button_service_stop);
			serviceStarted = true;
		}
	}

	public void onBroadcastReceiver(View v){

	}

	public void onContentProvider(View v){

	}

	public void onHandler(View v){

	}

	public void onAsync(View v){

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
