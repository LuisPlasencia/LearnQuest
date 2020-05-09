package es.ulpgc.eite.da.learnquest.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;

    private String username;
    private String password;
    private Integer photo;
    private String photoAdress;
    private int level;
    private int sublevel;
    private int mathPercentage;
    private int englishPercentage;
    private int geographyPercentage;
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

