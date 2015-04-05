package local.lessons.activity2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Less on 01.04.2015.
 */
public class ItemAdapter extends ArrayAdapter<UnitItem> {

    private int resource;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, int resource, List<UnitItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        View resView = view;
        if(view == null){
            resView = inflater.inflate(R.layout.activity_view_item, parent, false);
        }

        UnitItem item = getItem(position);
        if(item == null){
            Log.d("ADAPTER", "item = null");
            return resView;
        }
        resView.setBackgroundColor(item.getColor());
        TextView id = (TextView)resView.findViewById(R.id.itemId);
        id.setText(Integer.toString(item.getId()));
        id.setTextColor(MyColors.colorByBackground(item.getColor()));

        TextView name = (TextView)resView.findViewById(R.id.content);
        name.setText(item.getName());
        name.setTextColor(MyColors.colorByBackground(item.getColor()));

        return resView;
    }

}
