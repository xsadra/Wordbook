package at.sadra.apps.wordbook.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import at.sadra.apps.wordbook.model.Word;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);

    @Query("DELETE FROM word_table")
    void deleteAllWords(Word word);

    @Query("SELECT * FROM word_table ORDER BY dateInfo DESC")
    LiveData<List<Word>> getAllWords(Word word);
}
