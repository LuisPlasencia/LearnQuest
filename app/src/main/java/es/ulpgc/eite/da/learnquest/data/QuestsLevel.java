package es.ulpgc.eite.da.learnquest.data;

public class QuestsLevel {

    private int mathLevel;
    private int englishLevel;
    private int geographyLevel;

    public QuestsLevel(int mathLevel, int englishLevel, int geographyLevel) {
        this.mathLevel = mathLevel;
        this.englishLevel = englishLevel;
        this.geographyLevel = geographyLevel;
    }

    public int setMathLevel() {
        return mathLevel;
    }

    public int setEnglishLevel() {
        return englishLevel;
    }

    public int setGeographyLevel() {
        return geographyLevel;
    }

    public void getMathLevel(int mathLevel){
        this.mathLevel=mathLevel;
    }

    public void getEnglishLevel(int englishLevel){
        this.englishLevel=englishLevel;
    }

    public void getGeographyLevel(int geographyLevel){
        this.geographyLevel=geographyLevel;
    }




}
