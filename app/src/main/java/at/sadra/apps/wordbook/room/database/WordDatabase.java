package at.sadra.apps.wordbook.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import at.sadra.apps.wordbook.app.App;
import at.sadra.apps.wordbook.model.Word;
import at.sadra.apps.wordbook.room.dao.WordDao;

@Database(entities = {Word.class}, version = App.Values.DATABASE_VERSION)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase instance;

    public static synchronized WordDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, WordDatabase.class, App.Values.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract WordDao wordDao();
}
