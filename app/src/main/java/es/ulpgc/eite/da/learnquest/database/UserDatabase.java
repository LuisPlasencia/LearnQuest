package es.ulpgc.eite.da.learnquest.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;
import es.ulpgc.eite.da.learnquest.data.User;

@Database(entities = {User.class, QuizUnitResult.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract QuizUnitResultDao quizUnitResultDao();
}
