package es.ulpgc.eite.da.learnquest.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "quizUnitResultList",
        foreignKeys = @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = CASCADE
    )
)
public class QuizUnitResult {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "userId")
    public int user_id;

    public int questId, quizUnitId;
    public int mark;
    public String medalla;

    public QuizUnitResult(int id, int questId, int quizUnitId, int user_id, int mark, String medalla) {
        this.id = id;
        this.questId = questId;
        this.quizUnitId = quizUnitId;
        this.user_id = user_id;
        this.mark = mark;
        this.medalla = medalla;
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

    public String getMedalla() {
        return medalla;
    }
}
