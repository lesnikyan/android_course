package local.lessons.sqlitestart;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import local.lessons.sqlitestart.entities.User;

/**
 * Created by Less on 09.04.2015.
 */
public class SqlDataSource {

	private SQLiteDatabase db;

	public SqlDataSource(SQLiteDatabase db){
		this.db = db;
		Phones p;
	}


	public class Users {

		String table = "users";

		public List<User> getAll(){
			List<User> list = new ArrayList<User>();
			SQLiteDatabase db = SqlDataSource.this.db;
			Cursor c = db.query(table, null, null, null, null, null, null);
			if(c.moveToFirst()){
				int indexId = c.getColumnIndex("id");
				int indexName = c.getColumnIndex("name");
				do{
					list.add(new User(
							c.getInt(indexId),
							c.getString(indexName)
					));
				}while(c.moveToNext());
			}
			return list;
		}

		public long create(String name){
			ContentValues vals = new ContentValues();
			vals.put("name", name);
			return SqlDataSource.this.db.insert(table, null, vals);
		}

	}

	public class Phones {

		private String table = "phones";

		public long create(String number, int userId){
			ContentValues vals = new ContentValues();
			vals.put("number", number);
			vals.put("user_id", userId);
			return SqlDataSource.this.db.insert(table, null, vals);
		}
	}

}
