package es.ulpgc.eite.da.learnquest.data;

public class User {

    private String username;
    private String password;
    private Integer photo;
    private int level;
    private int sublevel;
    private int id;

    public User(String username, String password, Integer id){
        this.username = username;
        this.password = password;
        this.id = id;
        this.level = 0;
        this.sublevel = 0;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
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

    public void setLevel(Integer level){
        this.level=level;
    }

    public void setSublevel(Integer sublevel){
        this.sublevel=sublevel;
    }

    public void setPhoto(Integer photo){
        this.photo = photo;
    }

}
