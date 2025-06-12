/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.info.crudjsfjpamavenproduto.dao;

import com.info.crudjsfjpamavenproduto.model.Produto;
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
public class ProdutoDAO {

    @PersistenceContext(unitName = "ProdutoPU")
    private EntityManager em;

    public void salvar(Produto produto) {
        if (produto.getId() == 0) {
            em.persist(produto);
        } else {
            em.merge(produto);
        }
    }

    public void excluir(Produto produto) {
        produto = localiza(produto.getId());
        em.remove(produto);;
    }

    public Produto localiza(int id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> pesquisa(String parcial) {
        Query q = em.createQuery("select p from Produto p where p.descricao like :parcial");
        q.setParameter("parcial", "%" + parcial + "%");
        return q.getResultList();
    }
}
