package local.lessons.fewactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    class NamedColor {
        public final String name;
        public final int value;

        public NamedColor(String name, int value){
            this.name = name;
            this.value = value;
        }
    }

    List<UnitItem> items = new ArrayList<UnitItem>();
    UnitItem currentItem = null;
    NamedColor currentColor = new NamedColor("Black", MyColors.black);
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NamedColor[] colors = new NamedColor[]{
                new NamedColor("Black", MyColors.black),
                new NamedColor("Red", MyColors.red),
                new NamedColor("Blue", MyColors.blue),
                new NamedColor("Green", MyColors.green),
                new NamedColor("Yellow", MyColors.yellow),
                new NamedColor("Orange", MyColors.orange),
                new NamedColor("Silver", MyColors.silver),
                new NamedColor("White", 0xffffffff)
        };

        LinearLayout colorList = ((LinearLayout) findViewById(R.id.listColors));
        final Activity that = this;
        final TextView colorView = (TextView) that.findViewById(R.id.textViewColor);

        class OnColorClick implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                TextWithValueView view = (TextWithValueView)v;
                NamedColor color = (NamedColor) view.getExtraValue();
                colorView.setText(color.name);
                colorView.setBackgroundColor(color.value);
                currentColor = color;
            }
        }

        OnColorClick colorListener = new OnColorClick();

        for(NamedColor color : colors){
            TextWithValueView colorUnit = new TextWithValueView(this);
            //    colorUnit.setText(color.name);
            colorUnit.setText(" # ");
            colorUnit.setExtraValue(color);
            colorUnit.setBackgroundColor(color.value);
            colorUnit.setTextColor(MyColors.colorByBackground(color.value));
            colorUnit.setOnClickListener(colorListener);
            colorList.addView(colorUnit);
        }


        // List by Adapter
        adapter = new ItemAdapter(this, R.layout.activity_view_item, items);
        ListView itemsView = (ListView) findViewById(R.id.listItems);
        itemsView.setAdapter(adapter);

        // Set item
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEdit = (EditText) findViewById(R.id.editName);
                String name = nameEdit.getText().toString();
                if(name == "")
                    return;
                nameEdit.setText("");
                currentItem = new UnitItem(items.size() + 1, name, currentColor.value);
                items.add(currentItem);
                adapter.notifyDataSetChanged();
            }
        });


        // Show Items

        Button showBtn = (Button) findViewById(R.id.buttonShowItems);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentItem == null)
                    return;
                showItem();
            }
        });
    }

    private void showItem(){
        Intent intent = new Intent(this, ReceivedValueActivity.class);
        intent.putExtra("itemName", currentItem.getName());
        intent.putExtra("itemColor", currentItem.getColor());

        startActivity(intent);
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
