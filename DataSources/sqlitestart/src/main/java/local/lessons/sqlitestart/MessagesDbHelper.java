package local.lessons.sqlitestart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Less on 09.04.2015.
 */
public class MessagesDbHelper extends SQLiteOpenHelper {

	public MessagesDbHelper(Context context) {
		// конструктор суперкласса
		super(context, "messages_archive", null, 3);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		InstallDB.addUsers(db);
		InstallDB.addPhones(db);
		InstallDB.addMessages(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// add messages
		if (oldVersion < 3) {
			if (oldVersion < 2) {
				InstallDB.addPhones(db);
			}
			InstallDB.addMessages(db);
		}
	}

	private static class InstallDB {

		public static void addUsers(SQLiteDatabase db) {
			String sql = "create table users(" +
					"id integer primary key autoincrement," +
					"name varchar(64)," +
					");";
			db.execSQL(sql);
		}

		public static void addPhones(SQLiteDatabase db) {
			String sql = "create table phones (" +
					"id integer primary key autoincrement," +
					"number varchar(16)," +
					"user_id integer," +
					"foreign key (user_id) references users(id)" +
					");";
			db.execSQL(sql);
		}

		public static void addMessages(SQLiteDatabase db) {
			String sql = "create table messages(" +
					"id integer primary key autoincrement," +
					"title varchar(128)," +
					"content," +
					"phone_id integer," +
					"foreign key (phone_id) references phones(id) );";
			db.execSQL(sql);
		}
	}


}
