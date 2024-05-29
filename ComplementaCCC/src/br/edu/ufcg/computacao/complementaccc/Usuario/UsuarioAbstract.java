package br.edu.ufcg.computacao.complementaccc.Usuario;

/**
 * A classe abstrata UsuarioAbstract é uma classe base para representar um usuário genérico.
 * 
 * @author Alexandre Campos
 */
public abstract class UsuarioAbstract {
    /**
	 * String com o nome do Usuário
	 */
	private String nome;
    /**
	 * String com o CPF do Usuário
	 */
	private String cpf;
    /**
	 * int com a senha do Usuário
	 */
	private int senha;

    /**
     * Construtor para criar um novo objeto UsuarioAbstract.
     * 
     * @param nome O nome do usuário.
     * @param cpf O CPF do usuário.
     * @param senha A senha do usuário.
     * @throws NullPointerException se o nome ou CPF forem nulos.
     * @throws IllegalArgumentException se o nome estiver vazio, se o CPF for inválido ou se a senha for inválida.
     */
    public UsuarioAbstract(String nome, String cpf, int senha) {
        usuarioValido(nome, cpf, senha);
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    private void usuarioValido(String nome, String cpf, int senha) {
        if (nome == null) {
            throw new NullPointerException("NOME NULO");
        } else if (nome.isBlank()) {
            throw new IllegalArgumentException("NOME INVÁLIDO"); 
        } else if(cpf == null) {
            throw new NullPointerException("CPF NULO");
        } else if (cpf.isBlank() || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF INVÁLIDO");
        } else if (String.valueOf(senha).length() != 8) {
            throw new IllegalArgumentException("SENHA INVÁLIDA");
        }
    }

    @Override
    public abstract String toString();

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public int getSenha() {
        return this.senha;
    }

    /**
     * Define um novo nome para o usuário.
     * 
     * @param novoNome O novo nome a ser atribuído ao usuário.
     * @throws IllegalArgumentException se o novo nome for nulo ou vazio.
     */
    public void setNome(String novoNome) throws IllegalArgumentException, NullPointerException{
        if (nome == "") {
            throw new IllegalArgumentException("NOME INVÁLIDO");
        } else if (nome == null) {
            throw new NullPointerException("NOME NULO");
        }

        this.nome = novoNome;
    }

    /**
     * Define uma nova senha para o usuário.
     * 
     * @param novaSenha A nova senha a ser atribuída ao usuário.
     * @throws IllegalArgumentException se a nova senha for inválida.
     */
    public void setSenha(int novaSenha) throws IllegalArgumentException {
        if (String.valueOf(senha).length() != 8) {
            throw new IllegalArgumentException("SENHA INVÁLIDA");
        }

        this.senha = novaSenha;
    }
}
