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
import vo.Aluno;

/**
 *
 * @author info2025
 */
public class BdAluno {
    public void insere(Aluno aluno) {
        String sql = "insert into aluno(nome, serie, turma) values(?,?,?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getSerie());
            ps.setString(3, aluno.getTurma());
            ps.execute();
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    public void salva(Aluno aluno) {
        if (aluno.getCodigo() == 0) {
            insere(aluno);
        } else {
            String sql = "update aluno set nome=?, serie=?, turma=? where codigo=?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setString(1, aluno.getNome());
                ps.setInt(2, aluno.getSerie());
                ps.setString(3, aluno.getTurma());
                ps.setInt(4, aluno.getCodigo());
                ps.execute();
            } catch (SQLException e) {
                 System.out.println("Erro SQL: " + e.getMessage());
            }   
        }
    }
    
    public Aluno localiza(int codigo) {
        String sql = "select * from aluno where codigo=?";
        Aluno registro = new Aluno();
        
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setSerie(rs.getInt("serie"));
                registro.setTurma(rs.getString("turma"));
            }
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
        
        return registro;
    }
    
    public List pesquisa(String busca) {
        String sql = "select * from aluno where nome like ?";
        List lista = new ArrayList();
        
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, "%" + busca + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Aluno registro = new Aluno();
                registro.setCodigo(rs.getInt("codigo"));
                registro.setNome(rs.getString("nome"));
                registro.setSerie(rs.getInt("serie"));
                registro.setTurma(rs.getString("turma"));
                lista.add(registro);
            }
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
        
        return lista;
    }
    
    public void exclui(int codigo) {
        String sql = "delete from aluno where codigo=?";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
        } catch (SQLException e) {
             System.out.println("Erro SQL: " + e.getMessage());
        }
    }
}
