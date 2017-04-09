package br.com.ergildo.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ergildo.crud.dao.PessoaDAO;
import br.com.ergildo.crud.dom.Pessoa;
import br.com.ergildo.crud.exception.AplicacaoException;
import br.com.ergildo.crud.exception.PersistenceException;
import br.com.ergildo.crud.service.PessoaService;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {
	@Autowired
	private PessoaDAO pessoaDAO;

	/**
	 * @param pessoa
	 * @throws AplicacaoException
	 */
	@Override
	public void salvar(Pessoa pessoa) throws AplicacaoException {
		try {
			pessoaDAO.salvar(pessoa);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @throws AplicacaoException
	 */
	@Override
	public Pessoa consultar(Integer id) throws AplicacaoException {
		try {
			return pessoaDAO.consultar(id);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

	/**
	 * @param pessoa
	 * @throws AplicacaoException
	 */
	@Override
	public void excluir(Pessoa pessoa) throws AplicacaoException {
		try {
			pessoaDAO.excluir(pessoa);
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}

	}

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	@Override
	public List<Pessoa> listar() throws AplicacaoException {
		try {
			return pessoaDAO.listar();
		} catch (PersistenceException e) {
			throw new AplicacaoException(e);
		}
	}

}
