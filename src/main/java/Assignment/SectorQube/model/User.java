package Assignment.SectorQube.model;

import javax.persistence.*;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userid;
    String username;
    String password;
    String fullname;
    String roleid;
    Boolean active=true ;

    public User(int userid, String username, String password, String fullname, String roleid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.roleid = roleid;
    }

    public User() {

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}
