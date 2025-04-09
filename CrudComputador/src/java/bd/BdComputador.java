/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.Computador;

/**
 *
 * @author info2025
 */
public class BdComputador {
    public void insere(Computador computador) {
        String sql = "insert into computador (nome, localizacao, enderecoip, configuracao) values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, computador.getNome());
            ps.setString(2, computador.getLocalizacao());
            ps.setString(3, computador.getEnderecoip());
            ps.setString(4, computador.getConfiguracao());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    public void salva(Computador computador) {
        if (computador.getId() == 0) {
            insere(computador);
        } else {
            String sql = "update computador set nome=?, localizacao=?, enderecoip=?, configuracao=? where id=?";

            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setString(1, computador.getNome());
                ps.setString(2, computador.getLocalizacao());
                ps.setString(3, computador.getEnderecoip());
                ps.setString(4, computador.getConfiguracao());
                ps.setInt(5, computador.getId());
                ps.execute();
            } catch (SQLException e) {
                System.out.println("Erro SQL: " + e.getMessage());
            }
        }
    }
    
    public Computador localiza(int id) {
        String sql = "select * from computador where id=?";
        
        Computador computador = new Computador();
        
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
               computador = new Computador(rs.getInt("id"), rs.getString("nome"), rs.getString("localizacao"), rs.getString("enderecoip"), rs.getString("configuracao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
        
        return computador;
    }
    
    public List pesquisa(String busca) {
        String sql = "select * from computador where nome like ?";
        
        List lista = new ArrayList();
        
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Computador registro = new Computador(rs.getInt("id"), rs.getString("nome"), rs.getString("localizacao"), rs.getString("enderecoip"), rs.getString("configuracao"));
                
                lista.add(registro);
            }
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
        
        return lista;
    }
    
    public void exclui(int id) {
        String sql = "delete from computador where id=?";
        
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
    }
}
