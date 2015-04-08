package local.lessons.sqlitestart.entities;

import java.io.Serializable;

/**
 * Created by Less on 09.04.2015.
 */
public class User implements Serializable {
	String name;
	Integer id;
	public User(int id, String name){
		this.id = id;
		this.name = name;
	}
}
