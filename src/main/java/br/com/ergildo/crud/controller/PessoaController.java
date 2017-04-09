package br.com.ergildo.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ergildo.crud.dom.Pessoa;
import br.com.ergildo.crud.exception.AplicacaoException;
import br.com.ergildo.crud.service.PessoaService;

/**
 * @author ergildo
 *
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;

	/**
	 * @param pessoa
	 * @throws AplicacaoException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void salvar(@RequestBody Pessoa pessoa) throws AplicacaoException {
		pessoaService.salvar(pessoa);
	}

	/**
	 * @return
	 * @throws AplicacaoException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> listar() throws AplicacaoException {
		return pessoaService.listar();
	}

	/**
	 * @param id
	 * @throws AplicacaoException
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void excluir(@PathVariable("id") Integer id) throws AplicacaoException {
		Pessoa pessoa = pessoaService.consultar(id);
		pessoaService.excluir(pessoa);
	}

}
