package es.ulpgc.eite.da.learnquest.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;

@Dao
public interface QuizUnitResultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addQuizUnitResult(QuizUnitResult quizUnitResult);

    @Query("SELECT * FROM quiz_unit_result WHERE user_id=:userId AND questId=:questId ")
    List<QuizUnitResult> getQuizResultsOfUserAndQuest(int userId, int questId);
}
