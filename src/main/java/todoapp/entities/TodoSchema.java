package todoapp.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todo_schema")
public class TodoSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private boolean status;

    @Column(name = "date")
    private Date date;

    public TodoSchema() {
    }
    public TodoSchema(int id, String title, String description, boolean status, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
}
