package local.lessons.simplewidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 */
public class Variant1AppWidget extends AppWidgetProvider {

	public static final String CLICK_ACTION = "com.poster.Akuna.Matata.click";

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		// There may be multiple widgets active, so update all of them
		Log.d("MAIN2", "onUpdate: 1 step");
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
		}
	}


	@Override
	public void onEnabled(Context context) {
		Log.d("MAIN2", "onEnabled");
	}

	@Override
	public void onDisabled(Context context) {
		Log.d("MAIN2", "onDisabled");
	}

	static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
								int appWidgetId) {

		CharSequence widgetText = context.getString(R.string.appwidget_text);
		// Construct the RemoteViews object
		RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.variant1_app_widget);
		views.setTextViewText(R.id.appwidget_text, widgetText);

		Intent clickIntent = new Intent(context, Variant1AppWidget.class);
		clickIntent.setAction(CLICK_ACTION);
		clickIntent.putExtra("widgetId", appWidgetId);
		PendingIntent pIntent = PendingIntent.getBroadcast(context, appWidgetId, clickIntent, 0);
		views.setOnClickPendingIntent(R.id.imageButtonClicker, pIntent);

		// Instruct the widget manager to update the widget
		appWidgetManager.updateAppWidget(appWidgetId, views);
	}

	@Override
	public void onReceive(Context context, Intent intent){
		super.onReceive(context, intent);
		Bundle bn = intent.getExtras();
		Log.d("MAIN2", "onReceive: " + intent.getAction() + "; ID = " + intent.getIntExtra("widgetId", -1));
		int x=1;
	}
}


