package es.ulpgc.eite.da.learnquest.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    public int id;

    public String username;
    public String password;
    public Integer photo;
    public String photoAdress;
    public int level;
    public int sublevel;
    private int mathPercentage;
    private int englishPercentage;
    private int geographyPercentage;
    @Ignore
    @SerializedName("quizUnitResultList")
    public List<QuizUnitResult> quizUnitResultList;
   // private String email;

    public User(String username, String password, Integer id){
        this.username = username;
        this.password = password;
        this.id = id;
        this.level = 0;
        this.sublevel = 0;
        this.mathPercentage = 0;
        this.englishPercentage = 0;
        this.geographyPercentage = 0;
   //     this.email = "ejemplo@gmail.com";
        this.setPhoto(android.R.drawable.ic_menu_camera);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getPhotoAdress(){
        return photoAdress;
    }

    public Integer getId(){
        return id;
    }

    public Integer getLevel(){
        return level;
    }

    public Integer getSublevel(){
        return sublevel;
    }

    public Integer getPhoto(){
        return photo;
    }

//    public String getEmail(){
//        return email;
//    }

    public void setLevel(Integer level){
        this.level=level;
    }

    public void setSublevel(Integer sublevel){
        this.sublevel=sublevel;
    }

    public void setPhoto(Integer photo){
        this.photo = photo;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPhotoAdress(String photoAdress){
        this.photoAdress=photoAdress;
    }

    public void setQuizUnitResultList(List<QuizUnitResult> quizUnitResultList){
        this.quizUnitResultList = quizUnitResultList;
    }

    public void addExperience(Integer experience) {
        sublevel = sublevel + experience;
        roundUpExperience();
    }

    public void roundUpExperience(){
         while(sublevel >= 100){
            sublevel = sublevel - 100;
            level ++ ;
        }
    }

    public Integer experienceToNextLevel(){
        return (100 - sublevel);
    }

    public Integer getMathPercentage(){
        return mathPercentage;
    }

    public Integer getEnglishPercentage(){
        return englishPercentage;
    }

    public Integer getGeographyPercentage(){
        return geographyPercentage;
    }

    public List<QuizUnitResult> getQuizUnitResultList(){
        return quizUnitResultList;
    }

    public void setMathPercentage(int mathPercentage){
        this.mathPercentage=mathPercentage;
    }
    public void setEnglishPercentage(int englishPercentage){
        this.englishPercentage=englishPercentage;
    }
    public void setGeographyPercentage(int geographyPercentage){
        this.geographyPercentage=geographyPercentage;
    }

//    public void setEmail(String email){
//        this.email = email;
//    }
}

