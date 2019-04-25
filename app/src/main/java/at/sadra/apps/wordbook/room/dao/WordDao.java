package at.sadra.apps.wordbook.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.sadra.apps.wordbook.app.App;
import at.sadra.apps.wordbook.model.Word;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);

    @Query(App.Query.DELETE_ALL)
    void deleteAllWords();

    @Query(App.Query.SELECT_ALL_FROM_WORD_ORDER_BY_DATEINFO)
    LiveData<List<Word>> getAllWords();
}
