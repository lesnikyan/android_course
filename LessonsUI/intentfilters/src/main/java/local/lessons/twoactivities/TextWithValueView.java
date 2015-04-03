package local.lessons.twoactivities;

import android.content.Context;

/**
 * Created by Less on 01.04.2015.
 */
public class TextWithValueView extends android.widget.TextView {

    private Object extraValue;

    public TextWithValueView(Context context) {
        super(context);
    }

    public Object getExtraValue() {
        return extraValue;
    }

    public void setExtraValue(Object extraValue) {
        this.extraValue = extraValue;
    }
}
