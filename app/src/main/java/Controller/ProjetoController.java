/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import util.ConnectionFactory;

/**
 *
 * @author igor8
 */
public class ProjetoController {
    
    public void save(Project projeto){
        
        
        String query = "INSERT INTO projeto ("
                +"name,"
                +"description,"  
                +"createdAt," 
                +"updatedAt"
                + " ) VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement statemant = null;
        
        try {
            
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            
            

            statemant.setString(1, projeto.getName());
            statemant.setString(2, projeto.getDescription());
            statemant.setDate(3, new Date(projeto.getCreatedAt().getTime()));
            statemant.setDate(4, new Date(projeto.getUpdatedAt().getTime()));
            statemant.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar a tarefa "+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statemant);
            
        }

    }

    public void update(Project projeto) throws  Exception {
      
          String query = "UPDATE projeto SET name = ?, description = ?, createdAt = ? , updatedAt = ? WHERE id_projeto = ?";

        Connection conn = null;
        PreparedStatement statemant = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            
            statemant.setString(1, projeto.getName());
            statemant.setString(2, projeto.getDescription());
            statemant.setDate(3, new Date(projeto.getCreatedAt().getTime()));
            statemant.setDate(4, new Date(projeto.getUpdatedAt().getTime()));
            statemant.setInt(5, projeto.getId_projeto());

            statemant.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statemant);
            
        }


    }

    public void removeById(int projetoId)  {
        String query = "DELETE FROM projeto WHERE id_projeto=?";

        Connection conn = null;
        PreparedStatement statemant = null;
        try {
            
            conn = ConnectionFactory.getConnection();
            
            
            statemant = conn.prepareStatement(query);
            statemant.setInt(1, projetoId);
            statemant.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a tarefa"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn,statemant);
        }
    }
    
    
    public List<Project> getAll() {
        
        List<Project> lista = new ArrayList<>();
        String query = "Select id_projeto, name, description ,createdAt,updatedAt from projeto;";
        
        Connection conn = null;
        PreparedStatement statemant = null;
        ResultSet resultSet = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statemant = conn.prepareStatement(query);
            resultSet = statemant.executeQuery();
            System.out.println("igor aqui 0");
                    while (resultSet.next()){
                        Project projeto = new Project();
                    System.out.println("igor aqui 1");
                        projeto.setId_projeto(resultSet.getInt("Id_projeto"));
                        System.out.println("igor aqui 2");
                        projeto.setName(resultSet.getString("Name"));
                        projeto.setDescription(resultSet.getString("Description"));
                        System.out.println("igor aqui 3");
                        projeto.setCreatedAt(resultSet.getDate("CreatedAt"));
                        projeto.setUpdatedAt(resultSet.getDate("UpdatedAt"));
                        lista.add(projeto);
                        
                    }
        } catch (SQLException e) {
            throw new RuntimeException("Erro listar as tarefas"+ e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn,statemant,resultSet);
        }
        
        return lista;
    }
    
}
