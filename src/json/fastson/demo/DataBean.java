package json.fastson.demo;

/**
 * Created with IntelliJ IDEA.
 * User: Devin     Date: 2017/1/11 14:29
 * More wonderful content please pay attention to -> http://zhangchuzhao.site
 */

public class DataBean {
    private long id;
    private String text;
    private String geo;
    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

}
