package es.ulpgc.eite.da.learnquest.quests;

import es.ulpgc.eite.da.learnquest.data.RepositoryContract;

public class QuestsModel implements QuestsContract.Model {

    public static String TAG = QuestsModel.class.getSimpleName();

    private String mathLevel,englishLevel,geographyLevel;

    private int mathPhoto, englishPhoto, geographyPhoto;

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
    public void setSubjectImage(){
        setMathPhoto(quizRepository.getSubjectPhoto(1));
        setEnglishPhoto(quizRepository.getSubjectPhoto(2));
        setGeographyPhoto(quizRepository.getSubjectPhoto(3));
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
    @Override
    public String getMathLevel() {
        return mathLevel;
    }
    @Override
    public void setMathLevel(String mathLevel) {
        this.mathLevel = mathLevel;
    }
    @Override
    public String getEnglishLevel() {
        return englishLevel;
    }
    @Override
    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }
    @Override
    public String getGeographyLevel() {
        return geographyLevel;
    }
    @Override
    public void setGeographyLevel(String geographyLevel) {
        this.geographyLevel = geographyLevel;
    }
    @Override
    public int getMathPhoto() {
        return mathPhoto;
    }
    @Override
    public void setMathPhoto(int mathPhoto) {
        this.mathPhoto = mathPhoto;
    }
    @Override
    public int getEnglishPhoto() {
        return englishPhoto;
    }
    @Override
    public void setEnglishPhoto(int englishPhoto) {
        this.englishPhoto = englishPhoto;
    }
    @Override
    public int getGeographyPhoto() {
        return geographyPhoto;
    }
    @Override
    public void setGeographyPhoto(int geographyPhoto) {
        this.geographyPhoto = geographyPhoto;
    }


}
