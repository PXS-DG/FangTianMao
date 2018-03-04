package bean;

public class User {
public String u_id;
public String u_name;
public String u_pw;
public String u_sex;
public int u_h;
public int u_s;
public String backnews;
public String getId() {
    return u_id;
}
public void setId(String u_id) {
    this.u_id = u_id;
}
public String getName() {
    return u_name;
}
public void setName(String u_name) {
    this.u_name = u_name;
}
public String getPW() {
    return u_pw;
}
public void setPW(String u_pw) {
    this.u_pw = u_pw;
}
public String getSex() {
    return u_sex;
}
public void setSex(String u_sex) {
    this.u_sex = u_sex;
}
public int getH() {
    return u_h;
}
public void setH(int u_h) {
    this.u_h = u_h;
}
public int getS() {
    return u_s;
}
public void setS(int u_s) {
    this.u_s = u_s;
}
public String getBN() {
    return backnews;
}
public void setBN(String backnews) {
    this.backnews = backnews;
}
}
