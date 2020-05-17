package connection;

public class Newspaper {
    public int id;
    public String newspapernumber;
    public int userid;

    public Newspaper(int id, String newspapernumber, int userid) {
        this.id = id;
        this.newspapernumber = newspapernumber;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return newspapernumber;
    }

    public void setNumber(String newspapernumber) {
        this.newspapernumber = newspapernumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "id=" + id +
                ", newspapernumber='" + newspapernumber + '\'' +
                ", userid=" + userid +
                '}';
    }
}
