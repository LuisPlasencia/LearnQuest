package es.ulpgc.eite.da.learnquest.data;

public class QuestionGeographyItem extends Question{

    public String geoSolution, geoHint;

    public QuestionGeographyItem(int id, String question, String geoSolution, String geoHint) {
        super(id, question);
        this.geoSolution = geoSolution;
        this.geoHint = geoHint;
    }

    public String getGeoSolution() {
        return geoSolution;
    }

    public void setGeoSolution(String geoSolution) {
        this.geoSolution = geoSolution;
    }

    public String getGeoHint() {
        return geoHint;
    }

    public void setGeoHint(String geoHint) {
        this.geoHint = geoHint;
    }
}
