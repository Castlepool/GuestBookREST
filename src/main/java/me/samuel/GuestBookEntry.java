package me.samuel;

public class GuestBookEntry {
    private int id;
    private String eMail;
    private String name;
    private String text;

    public GuestBookEntry(){}

    GuestBookEntry(int id, String eMail, String name, String text) {
        this.id = id;
        this.eMail = eMail;
        this.name = name;
        this.text = text;
    }

    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return '{' +
                "id=" + id +
                ", eMail='" + eMail + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
