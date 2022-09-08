/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

//create table tasks 
//(
//id_task int primary key auto_increment not null,
//id_Project_fk int ,
//name varchar(50),
//description varchar (255),
//completed boolean,
//notes varchar(255),
//deadline datetime,
//createdAt datetime,
//updatedAt datetime,
//FOREIGN KEY (id_Project_fk) REFERENCES projeto(id_projeto)
//);
public class Task {

    private int id_task;
    private int id_Project_fk;
    private String name;
    private String description;
    private boolean completed;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id_task, int id_Project_fk, String name, String description, boolean completed, String notes, Date deadline, Date createdAt, Date updatedAt) {
        this.id_task = id_task;
        this.id_Project_fk = id_Project_fk;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.notes = notes;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        this.completed = false;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    
    
    
    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public int getId_Project_fk() {
        return id_Project_fk;
    }

    public void setId_Project_fk(int id_Project_fk) {
        this.id_Project_fk = id_Project_fk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id_task=" + id_task + ", id_Project_fk=" + id_Project_fk + ", name=" + name + ", description=" + description + ", completed=" + completed + ", notes=" + notes + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    

}
