package br.com.ergildo.crud.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.ergildo.crud.dao.PessoaDAO;
import br.com.ergildo.crud.dom.Pessoa;
import br.com.ergildo.crud.exception.PersistenceException;

/**
 * @author ergildo
 *
 */
@Repository
public class PessoaDAOImpl implements PessoaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Pessoa pessoa) throws PersistenceException {
		try {
			if (pessoa.getId() == null) {
				entityManager.persist(pessoa);
			} else {
				entityManager.merge(pessoa);
			}
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

	}

	@Override
	public Pessoa consultar(Integer id) throws PersistenceException {
		try {
			return entityManager.find(Pessoa.class, id);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public void excluir(Pessoa pessoa) throws PersistenceException {
		try {
			entityManager.remove(entityManager.merge(pessoa));
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listar() throws PersistenceException {
		try {
			Query query = entityManager.createNamedQuery("Pessoa.findAll");
			return query.getResultList();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

}
