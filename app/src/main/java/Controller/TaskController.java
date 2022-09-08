/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;

/**
 *
 * @author igor8
 */
public class TaskController {
    
    

    public void save(Task task){
        String query = "INSERT INTO tasks ("
                + "name," 
                + "description,"
                +"completed," 
                +"notes,"  
                +"createdAt," 
                +"deadline,"
                +"updatedAt"
                + " ) VALUES (?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement statemant = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            
            
            statemant.setString(1, task.getName());
            statemant.setString(2, task.getDescription());
            statemant.setBoolean(3, task.isCompleted());
            statemant.setString(4, task.getNotes());
            statemant.setDate(5, new Date(task.getCreatedAt().getTime()));
            statemant.setDate(6, new Date(task.getDeadline().getTime()));
            statemant.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statemant.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statemant);
            
        }

    }

    public void update(Task task) throws  Exception {
        String query = "UPDATE tasks SET"
                +"name=?, " 
                +"description=?, "
                +"completed=?, " 
                +"notes=?, "  
                +"createdAt=?, " 
                +"deadline=?, "
                +"updatedAt=? "
                +" WHERE id=?";

        Connection conn = null;
        PreparedStatement statemant = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            statemant.setString(1, task.getName());
            statemant.setString(2, task.getDescription());
            statemant.setBoolean(3, task.isCompleted());
            statemant.setString(4, task.getNotes());
            statemant.setDate(5, new Date(task.getCreatedAt().getTime()));
            statemant.setDate(6, new Date(task.getDeadline().getTime()));
            statemant.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statemant.setInt(7, task.getId_task());
            
            statemant.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statemant);
            
        }


    }

    public void removeById(int taskId)  {
        String query = "DELETE FROM tasks WHERE id=?";

        Connection conn = null;
        PreparedStatement statemant = null;
        try {
            
            conn = ConnectionFactory.getConnection();
            
            
            statemant = conn.prepareStatement(query);
            statemant.setInt(1, taskId);
            statemant.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn,statemant);
        }
    }
    public List<Task> getAll() {
        
        
        List<Task> lista = new ArrayList<>();
        String query = "Select * from tasks ";
        
        Connection conn = null;
        PreparedStatement statemant = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            resultSet = statemant.executeQuery();
         
                    while (resultSet.next()){
                        Task task = new Task();
                        
                        task.setId_task(resultSet.getInt("Id_task"));
                        task.setId_Project_fk(resultSet.getInt("Id_Project_fk"));
                        task.setName(resultSet.getString("Name"));
                        task.setDescription(resultSet.getString("Description"));
                        task.setNotes(resultSet.getString("Notes"));
                        task.setCompleted(resultSet.getBoolean("Completed"));
                        task.setDeadline(resultSet.getDate("Deadline"));                    
                        task.setCreatedAt(resultSet.getDate("CreatedAt"));
                        task.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                        lista.add(task);
                        
                    }
        } catch (Exception e) {
            throw new RuntimeException("Erro listar as tarefas"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn,statemant,resultSet);
        }
        
        return null;
    }

}
