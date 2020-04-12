package es.ulpgc.eite.da.learnquest.app;

import java.util.Objects;

public class QuizUnitToQuestionState {

    public int option;

    public QuizUnitToQuestionState(int option){
        this.option=option;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuizUnitToQuestionState that = (QuizUnitToQuestionState) obj;
        return option == that.option;
    }

    @Override
    public int hashCode() {
        return Objects.hash(option);
    }
}
