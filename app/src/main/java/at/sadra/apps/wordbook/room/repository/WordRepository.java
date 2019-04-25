package at.sadra.apps.wordbook.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import at.sadra.apps.wordbook.model.Word;
import at.sadra.apps.wordbook.room.dao.WordDao;
import at.sadra.apps.wordbook.room.database.WordDatabase;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {
        WordDatabase database = WordDatabase.getInstance(application);
        wordDao = database.wordDao();
        allWords = wordDao.getAllWords();
    }

    public void insert(Word word) {
        new InsertWordAsyncTask(wordDao).execute(word);
    }

    public void update(Word word) {
        new UpdateWordAsyncTask(wordDao).execute(word);
    }

    public void delete(Word word) {
        new DeleteWordAsyncTask(wordDao).execute(word);
    }

    public void deleteAllWords(Word word) {
        new DeleteAllWordsAsyncTask(wordDao).execute();
    }

    public LiveData<List<Word>> getAllWords(Word word) {
        return allWords;
    }


    private static class InsertWordAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public InsertWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words[0]);
            return null;
        }
    }

    private static class UpdateWordAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public UpdateWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.update(words[0]);
            return null;
        }
    }

    private static class DeleteWordAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao wordDao;

        public DeleteWordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.delete(words[0]);
            return null;
        }
    }

    private static class DeleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {

        private WordDao wordDao;

        public DeleteAllWordsAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
