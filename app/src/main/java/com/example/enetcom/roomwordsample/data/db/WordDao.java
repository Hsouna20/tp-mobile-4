package com.example.enetcom.roomwordsample.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.enetcom.roomwordsample.model.Word;

import java.util.List;

@Dao
public interface WordDao {

    // Permettre l'insertion du même mot plusieurs fois en passant
    // une stratégie de résolution de conflits.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAlphabetizedWords();
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();
    @Delete
    void deleteWord(Word word);
}
