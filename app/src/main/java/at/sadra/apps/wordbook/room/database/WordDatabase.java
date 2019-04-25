package at.sadra.apps.wordbook.room.database;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.time.LocalDate;
import java.util.Arrays;

import at.sadra.apps.wordbook.app.App;
import at.sadra.apps.wordbook.model.DateInfo;
import at.sadra.apps.wordbook.model.LanguageType;
import at.sadra.apps.wordbook.model.Translate;
import at.sadra.apps.wordbook.model.Word;
import at.sadra.apps.wordbook.model.WordType;
import at.sadra.apps.wordbook.model.wordform.Article;
import at.sadra.apps.wordbook.model.wordform.Conjugate;
import at.sadra.apps.wordbook.model.wordform.Noun;
import at.sadra.apps.wordbook.model.wordform.Perfect;
import at.sadra.apps.wordbook.model.wordform.Verb;
import at.sadra.apps.wordbook.room.dao.WordDao;

@Database(entities = {Word.class}, version = App.Values.DATABASE_VERSION)
public abstract class WordDatabase extends RoomDatabase {

    private static WordDatabase instance;

    public abstract WordDao wordDao();

    public static synchronized WordDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, WordDatabase.class, App.Values.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    // This code to Add one Note in first time run.
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private WordDao wordDao;

        public PopulateDbAsyncTask(WordDatabase wordDatabase) {
            this.wordDao = wordDatabase.wordDao();
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.insert(new Word(
                            "Wortbuch",
                            WordType.NOUN,
                            new Noun(Article.DER, "Wortbrüche"),
                            Arrays.asList(
                                    new Translate(LanguageType.ENGLISH, "word book"),
                                    new Translate(LanguageType.PERSIAN, "کتاب کلمه")
                            ),
                            new DateInfo(LocalDate.now(), LocalDate.now())
                    )
            );
            wordDao.insert(new Word(
                            "haben",
                            WordType.VERB,
                            new Verb(
                                    new Conjugate("hab(e)", "hast", "hat", "haben", "habt", "haben"),
                                    new Perfect("haben", "gehabt"),
                                    new Conjugate("hatte", "hattest", "hatte", "hatten", "hattet", "hatten"),
                                    new Conjugate("habe", "habest", "habe", "haben", "habet", "haben"),
                                    new Conjugate("hätte", "hättest", "hätte", "hätten", "hättet", "hätten"),
                                    new Conjugate("-", "hab(e)", "-", "haben", "habt", "haben")
                            ),
                            Arrays.asList(
                                    new Translate(LanguageType.ENGLISH, "to have"),
                                    new Translate(LanguageType.PERSIAN, "داشتن")
                            ),
                            new DateInfo(LocalDate.now(), LocalDate.now())
                    )
            );
            wordDao.insert(new Word(
                            "ich",
                            WordType.VERB,
                            null,
                            Arrays.asList(
                                    new Translate(LanguageType.ENGLISH, "I"),
                                    new Translate(LanguageType.PERSIAN, "من")
                            ),
                            new DateInfo(LocalDate.now(), LocalDate.now())
                    )
            );

            return null;
        }
    }
}
