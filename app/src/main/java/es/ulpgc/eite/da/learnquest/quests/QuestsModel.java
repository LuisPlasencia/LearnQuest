package es.ulpgc.eite.da.learnquest.quests;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestsModel implements QuestsContract.Model {

    public static String TAG = QuestsModel.class.getSimpleName();

    private String mathLevel,englishLevel,geographyLevel;

    private RepositoryContract quizRepository;

    public QuestsModel(RepositoryContract quizRepository) {
        this.quizRepository=quizRepository;
    }

    @Override
    public void setSubjectLevels(){
        setMathLevel(quizRepository.getSubjectPercentage(1).toString()+"%");
        setEnglishLevel(quizRepository.getSubjectPercentage(2).toString()+"%");
        setGeographyLevel(quizRepository.getSubjectPercentage(3).toString()+"%");
    }

    @Override
    public void onRestartScreen(QuestsState data){
        mathLevel=data.mathLevel;
        englishLevel=data.englishLevel;
        geographyLevel=data.geographyLevel;
    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }

    public String getMathLevel() {
        return mathLevel;
    }

    public void setMathLevel(String mathLevel) {
        this.mathLevel = mathLevel;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getGeographyLevel() {
        return geographyLevel;
    }

    public void setGeographyLevel(String geographyLevel) {
        this.geographyLevel = geographyLevel;
    }


}
