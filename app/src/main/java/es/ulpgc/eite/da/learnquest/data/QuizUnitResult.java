package es.ulpgc.eite.da.learnquest.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quiz_unit_result")
public class QuizUnitResult {

    @PrimaryKey
    private int id;

    private int questId, quizUnitId, user_id;
    private int mark;
    private boolean solved;

    public QuizUnitResult(int id, int questId, int quizUnitId, int user_id, int mark, boolean solved) {
        this.id = id;
        this.questId = questId;
        this.quizUnitId = quizUnitId;
        this.user_id = user_id;
        this.mark = mark;
        this.solved = solved;
    }

    public int getId() {
        return id;
    }

    public int getQuestId() {
        return questId;
    }

    public int getQuizUnitId() {
        return quizUnitId;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMark() {
        return mark;
    }

    public boolean isSolved() {
        return solved;
    }
}
