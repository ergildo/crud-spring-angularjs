package br.com.ergildo.crud.service;

import java.util.List;

import br.com.ergildo.crud.dom.Pessoa;
import br.com.ergildo.crud.exception.AplicacaoException;

/**
 * @author ergildo
 *
 */
public interface PessoaService {
	/**
	 * @param pessoa
	 * @throws AplicacaoException
	 */
	public void salvar(Pessoa pessoa) throws AplicacaoException;

	/**
	 * @param id
	 * @return
	 * @throws AplicacaoException
	 */
	public Pessoa consultar(Integer id) throws AplicacaoException;

	/**
	 * @param pessoa
	 * @throws AplicacaoException
	 */
	public void excluir(Pessoa pessoa) throws AplicacaoException;

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	public List<Pessoa> listar() throws AplicacaoException;
}
