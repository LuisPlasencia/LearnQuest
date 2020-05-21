package es.ulpgc.eite.da.learnquest.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;
import es.ulpgc.eite.da.learnquest.data.User;

@Dao
public interface QuizUnitResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addQuizUnitResult(QuizUnitResult quizUnitResult);

    @Query("SELECT * FROM quizUnitResultList WHERE userId=:userId AND questId=:questId ")
    List<QuizUnitResult> getQuizResultsOfUserAndQuest(int userId, int questId);

    @Query("SELECT * FROM quizUnitResultList WHERE userId=:userId")
    List<QuizUnitResult> getQuizResultsOfUser(int userId);

    @Query("SELECT * FROM quizUnitResultList ")
    List<QuizUnitResult> getQuizResults();

    @Update
    void updateQuizUnit(QuizUnitResult quizUnitResult);

    @Delete
    void deleteQuizUnit(QuizUnitResult quizUnitResult);

}
