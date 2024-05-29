package br.edu.ufcg.computacao.complementaccc.Usuario;

/**
 * Classe que representa o Admin do sistema.
 * 
 * @author Alexandre Campos
 */
public class Admin extends UsuarioAbstract {
	public Admin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}
	
	/**
     * Retorna uma representação textual do Estudante.
     * 
     * @return Uma string contendo o nome e o CPF do admin.
     */
	@Override
	public String toString() {
		return "\nAdmin: " + super.getNome() + "\nCPF: " + super.getCPF() + "\n";
	}
}
