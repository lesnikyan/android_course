package local.lessons.fewactivities;

/**
 * Created by Less on 01.04.2015.
 */
public class MyColors{
    public static final int black =    0xff000000;
    public static final int red =      0xffff0000;
    public static final int blue =     0xff0000ff;
    public static final int green =    0xff00ff00;
    public static final int yellow =   0xffffff00;
    public static final int silver =   0xffe0e0e0;
    public static final int orange =   0xffff8800;

    public static int colorByBackground(int c){
        int r = 0xff0000;
        int g = 0x00ff00;
        int b = 0x0000ff;
        int colorSum = (c & r >> 16) + (c & g >> 8) + (c & b);
        return (colorSum > 250 ? 0xff000000 : 0xffffffff);
    }
}