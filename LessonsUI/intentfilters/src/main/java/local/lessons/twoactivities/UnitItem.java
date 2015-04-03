package local.lessons.twoactivities;

/**
 * Created by Less on 01.04.2015.
 */
public class UnitItem {
    private String name;
    private int id;
    private int color;

    public UnitItem(int id, String name, int color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
