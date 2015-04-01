package MyViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RemoteViews;

/**
 * Created by Less on 14.03.2015.
 */
@RemoteViews.RemoteView
public class NumeredButton extends Button {

    private int val;

    public NumeredButton(Context context, AttributeSet attributes){
        super(context, attributes);
    }

    public void setVal(int val){
        this. val = val;
    }

    public int getVal(){
        return val;
    }

    public void incVal(){
        val++;
    }

}
