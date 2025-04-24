/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamaven.dao;

import com.info.crudjsfjpamaven.model.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author info2025
 */
@Stateless
public class LivroDAO {
    @PersistenceContext(unitName = "LivroPU")
    private EntityManager em;
    
    public void salva(Livro livro) {
        if (livro.getId() == 0) {
            em.persist(livro);
        } else {
            em.merge(livro);
        }
    }
    
    public void exclui(Livro livro) {
        livro = localiza(livro.getId());
        em.remove(livro);
    }
    
    public Livro localiza(int id) {
        return em.find(Livro.class, id);
    }
    
    public List<Livro> pesquisa(String parcial) {
        Query q = em.createQuery("select l from Livro l where l.titulo like :parcial");
        q.setParameter("parcial", "%" + parcial + "%");
        
        return q.getResultList();
    }
}
