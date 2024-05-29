package br.edu.ufcg.computacao.complementaccc.Usuario;

import java.util.*;

/**
 * Classe Controller de Usuário. Cuida de toda a parte de guardar o admin e os usuários, bem como de gerenciar os comandos
 * de criação e alteração dos estados dessas. Devido à necessidade de verificação do Admin em diferentes partes do sistema,
 * essa classe também faz a verificação do Admin.
 * 
 * @author Alexandre Campos
 */
public class UsuarioController {
	/**
	 * Admin do sistema. É extremamente importante para o funcionamento do sistema como um todo pois só esse usuário tem a
	 * permissão de realizar diversos tipos de ações diferentes. Desse modo, é preciso realizar constantes autenticações e
	 * chamadas. Devido a existência exclusiva de um Admin por vez, não é necessário uma coleção, nem é inteligente guardar
	 * junto a uma coleção de UsuáriosAbstract.
	 */
	private Admin adm;
	/**
	 * Coleção que associa um objeto Estudante com o seu CPF - Identificação única deste no sistema.
	 */
	private HashMap<String, Estudante> mapEstudantes;
	
	/**
	 * Construtor que instancia inicialmente o Admin como nulo (é preciso depois adicioná-lo) e o Map de alunos vazio.
	 */
	public UsuarioController() {
		this.adm = null;
		this.mapEstudantes = new HashMap<>();
		}
	
	/**
	 * Método de validação. Compara os parâmetros recebidos com os do Admin estanciado a fim de confirmar se são os 
	 * dados do Admin ou não.
	 * 
	 * @param cpf a String com o cpf que será validado.
	 * @param senha o int com a senha do Admin.
	 * @return Um boolean que indica se as informações batem com a do Admin ou não.
	 * @throws IllegalArgumentException Caso o CPF não seja igual ao do Admin.
	 * @throws NullPointerException Caso algum dos parâmetros seja nulo.
	*/
	public boolean validaAdmin(String cpf, int senha) throws IllegalArgumentException, NullPointerException {
		if (!adm.getCPF().equals(cpf)) {
			throw new IllegalArgumentException("CPF incorreto!");
		}else if (adm.getSenha() != senha) {
			throw new IllegalArgumentException("Senha Incorreta!");
		}
		return true;
	}

	/**
	 * Método que cria um objeto Estudante e o guarda no HashMap<String, Estudante>.
	 * 
	 * @param nome String com o nome do estudante a ser criado.
	 * @param cpf String com o CPF do aluno. É sua identificação única no sistema e chave de acesso no Map.
	 * @param senha int com uma senha de 8 digitos para proteção de suas informações.
	 * @param matricula String com um número que representa sua matrícula.
	 * @return boolean True indicando que a operação foi bem sucedida.
	 * @throws IllegalArgumentException Lançada pelo construtor de Estudante caso algum dos parâmetros seja vazio.
	 * @throws NullPointerException Lançada pelo construtor de Estudante caso algum dos parâmetros seja nulo.
	 */
	public boolean criaEstudante(String nome, String cpf, int senha, String matricula) throws IllegalArgumentException, NullPointerException {
		Estudante estudante = new Estudante(nome, cpf, senha, matricula);
		mapEstudantes.put(cpf, estudante);
		return true;
	}

	/**
	 * Método para acessar um Estudante. Busca o Estudante pela chave fornecida (cpf) no HashMap de Estudantes e
	 * verifica se a senha bate com a do objeto guardado por aquela chave.
	 * 
	 * @param cpf String com o cpf do aluno. É a sua identificação única no sistema.
	 * @param senha int cadastrado pelo aluno para proteger o acesso a suas informações.
	 * @return O objeto do tipo Estudante que contem o cpf dado e a senha também dada.
	 * @throws NullPointerException Caso não exista no sistema um estudante com aquele CPF (chave).
	 * @throws IllegalArgumentException Caso exista um estudante cadastrado no sistema, mas não com a senha fornecida.
	 */
	public Estudante pegaEstudante(String cpf, int senha) throws NullPointerException, IllegalArgumentException {
		if (!mapEstudantes.containsKey(cpf)) {
			throw new NullPointerException("O estudante buscado não existe no sistema!");
		}

		Estudante estudante = mapEstudantes.get(cpf);

		if (estudante.getSenha() == senha) {
			return estudante;
		} else {
			throw new IllegalArgumentException("Senha incorreta");
		}
	}
	
	/**
	 * Método que devolve um Array de Strings com as representações textuais dos estudantes cadastrados, em ordem alfabética.
	 * 
	 * @param cpfAdmin String com o cpf do admin.
	 * @param senhaAdmin int com a senha do admin.
	 * @return Array de Strings com as representações de cada estudante cadastrado, em ordem alfabética.
	 * @throws IllegalArgumentException Lançada pelo validaAdmin() caso os dados do admin estejam errados.
	 */
	public String[] exibeEstudantes(String cpfAdmin, int senhaAdmin) throws IllegalArgumentException {
		ArrayList<String> estudantes = new ArrayList<>();
		if (validaAdmin(cpfAdmin, senhaAdmin)) {
			for (Estudante e : mapEstudantes.values()) {
				estudantes.add(e.toString());
			}
		}
		Collections.sort(estudantes);
		return estudantes.toArray(new String[estudantes.size()]);	
	}
	
	/**
	 * Método que altera as informações de um Estudante cadastrado no sistema. É possível alterar nome ou senha.
	 * 
	 * @param cpf String com o cpf do estudante que se deseja acessar.
	 * @param senha int com a senha do estudante que se deseja acessar.
	 * @param tipoAlteracao String que identifica qual informação do estudante será alterada.
	 * @param novoValor String com o novo valor da informação alterada.
	 * @return boolean true indicando que a troca foi feita com sucesso.
	 * @throws NullPointerException Lançado pelo pegaEstudante() caso algum dos parâmetros seja nulo
	 * @throws IllegalArgumentException Lançado pelo pegaEstudante() caso algum dos parâmetros seja vazio.
	 */
	public boolean alteraEstudantes(String cpf, int senha, String tipoAlteracao, String novoValor) throws NullPointerException, IllegalArgumentException{
		Estudante estudante = pegaEstudante(cpf, senha);

		switch (tipoAlteracao.toLowerCase()) {
			case "nome":
				estudante.setNome(novoValor);
				break;
			case "senha":
				if (novoValor.length() != 8) throw new IllegalArgumentException("Nova senha inválida");
				estudante.setSenha(Integer.valueOf(novoValor));
				break;
			default:
				throw new IllegalArgumentException("Alteração inválida");
		}

		return true;
	}

	/**
	 * Método que retorna a representação textual do admin cadastrado.
	 * 
	 * @param cpf String com o CPF do admin.
	 * @param senha int com a senha do admin.
	 * @return String com a representação textual do admin do sistema.
	 * @throws IllegalArgumentException Lançado pelo validaAdmin() caso o cpf ou a senha não sejam iguais as do admin cadastrado no sistema.
	 */
	public String exibeAdmin(String cpf, int senha) throws IllegalArgumentException {
		validaAdmin(cpf, senha);
		return adm.toString();
	}

	/**
	 * Método que cadastra um novo admin no sistema. Caso seja o primeiro admin adicionado (Nesse caso this.adm == null), o cadastro é feito
	 * sem verificação. Caso não seja o primeiro cadastro, apenas o admin atual pode cadastrar um novo admin.
	 * 
	 * @param cpf String com o cpf do admin atual.
	 * @param senhaAtual int com a senha do admin atual.
	 * @param nomeNovo String com o nome do novo admin.
	 * @param cpfNovo String com o cpf do novo admin.
	 * @param senhaNova int com a senha do novo admin.
	 * @return boolean True indicando que a troca foi bem sucedida.
	 * @throws IllegalArgumentException Lançada pelo validaAdmin() caso o cpf ou a senha do admin atual esteja errada. Ou lançada pelo construtor
	 * de Admin, caso um dos parâmetros seja vazio.
	 */
	public boolean configuraNovoAdmin(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova) throws IllegalArgumentException {
		if (this.adm == null) {
			Admin admin = new Admin(nomeNovo, cpfNovo, senhaNova);
			this.adm = admin;
		} else if (validaAdmin(cpf, senhaAtual)) {
			Admin admin = new Admin(nomeNovo, cpfNovo, senhaNova);
			this.adm = admin;
		}
		return true;
	}
	
	/**
	 * Método que troca a senha do admin.
	 * 
	 * @param cpf String com o cpf do admin atual.
	 * @param senhaAtual int com a senha atual do admin.
	 * @param senhaNova int com a nova senha do admin.
	 * @return boolean True que indica que a troca foi bem sucedida.
	 */
	public boolean configuraSenhaAdmin(String cpf, int senhaAtual, int senhaNova) {
		if (validaAdmin(cpf, senhaAtual)) {
			adm.setSenha(senhaNova);
		}
		return true;
	}
}
