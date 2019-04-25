package at.sadra.apps.wordbook.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

import at.sadra.apps.wordbook.model.wordform.WordData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String word;
    @ColumnInfo(name = "word_type")
    private WordType type;
    @ColumnInfo(name = "word_data")
    private WordData data;
    private List<Translate> translates;
    private DateInfo dateInfo;

    public Word(String word, WordType type, WordData data, List<Translate> translates, DateInfo dateInfo) {
        this.word = word;
        this.type = type;
        this.data = data;
        this.translates = translates;
        this.dateInfo = dateInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) &&
                type == word1.type &&
                Objects.equals(data, word1.data) &&
                Objects.equals(translates, word1.translates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, type, data, translates);
    }

}
