/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Task;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import util.ConnectionFactory;

/**
 *
 * @author igor8
 */
public class TaskController {

    public void save(Task task) {
        String query = "INSERT INTO tasks ("
                + "name" 
                + "description"
                +"completed" 
                +"notes" 
                +"deadline" 
                +"createdAt" 
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
            statemant.setString(6, task.getName());
            statemant.setString(7, task.getName());
                    
        } catch (Exception e) {
            throw new SQLException("Erro ao adicionar a tarefa");
        } finally {
        }

    }

    public void update(Task task) {

    }

    public void removeById(int taskId) throws SQLException {
        String query = "DELETE FROM tasks WHERE id=?";

        Connection conn = null;
        PreparedStatement statemant = null;
        try {
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            statemant.setInt(1, taskId);
            statemant.execute();
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn);
        }

    }

    public List<Task> getAll(int idProject) {
        return null;
    }

}
