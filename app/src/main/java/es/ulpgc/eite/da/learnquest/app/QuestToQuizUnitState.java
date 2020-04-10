package es.ulpgc.eite.da.learnquest.app;

import java.util.Objects;

public class QuestToQuizUnitState {

    public String subject;

    public QuestToQuizUnitState(String subject){
        this.subject=subject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuestToQuizUnitState that = (QuestToQuizUnitState) obj;
        return subject == that.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
