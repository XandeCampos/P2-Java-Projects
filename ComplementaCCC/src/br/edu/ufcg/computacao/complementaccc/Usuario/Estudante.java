package br.edu.ufcg.computacao.complementaccc.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioAbstract;

/**
 * A classe Estudante representa um tipo de usuário do sistema, 
 * especializado para estudantes.
 * 
 * @author Alexandre Campos
 */
public class Estudante extends UsuarioAbstract {
    /**
	 * String com a matrícula do Estudante
	 */
	private String matricula;
    /**
	 * HashMap que associa o código da Atividade com a Atividade 
	 */
	private HashMap<String, AtividadeInterface> mapCodigoAtividade;
    /**
	 * ArrayList que guarda os relatórios na ordem em que são criados
	 */
	private ArrayList<RelatorioAbstract> relatorios;
    /**
	 * Variável de contagem para manter o index em que o próximo relatório será inserido
	 */
	private int indexRelatorios;

    /**
     * Construtor para criar um novo objeto Estudante.
     * 
     * @param nome O nome do estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param matricula A matrícula do estudante.
     * @throws NullPointerException se a matrícula for nula.
     * @throws IllegalArgumentException se a matrícula estiver vazia.
     */
    public Estudante(String nome, String cpf, int senha, String matricula) throws NullPointerException, IllegalArgumentException {
        super(nome,cpf,senha);
        
        if (matricula == null) throw new NullPointerException("Matricula nula");
        if (matricula.isBlank()) throw new IllegalArgumentException("Matricula inválida");
        this.matricula = matricula;
        
        this.mapCodigoAtividade = new HashMap<>();
        this.relatorios = new ArrayList<>();
        this.indexRelatorios = 0;
    }

    /**
     * Retorna uma representação textual do Estudante.
     * 
     * @return Uma string contendo o nome, CPF e matrícula do estudante.
     */
    @Override
    public String toString() {
        return "\nEstudante: " + super.getNome() + "\nCPF: " + super.getCPF() + "\nMatrícula: " + this.matricula + "\n";
    }

    /**
     * Adiciona uma atividade ao mapa de códigos de atividade do estudante.
     * 
     * @param atv A atividade a ser adicionada.
     * @return O código da atividade adicionada.
     */
    public String adicionaAtividade(AtividadeInterface atv) {
        String codigo = super.getCPF() + "_" + (mapCodigoAtividade.size() + 1);
        mapCodigoAtividade.put(codigo, atv);
        return codigo;
    }

    /**
     * Obtém uma atividade com base no código.
     * 
     * @param codigo O código da atividade desejada.
     * @return A atividade correspondente ao código.
     * @throws IllegalArgumentException se o código não existir no mapa.
     */
    public AtividadeInterface getAtividade(String codigo) throws IllegalArgumentException {
        if (mapCodigoAtividade.containsKey(codigo)) {
            return mapCodigoAtividade.get(codigo);
        } else {
            throw new IllegalArgumentException("Código não existe");
        }
    }

    public String getMatricula() {
        return this.matricula;
    }

    /**
     * Lista todas as atividades do estudante.
     * 
     * @return Uma lista contendo todas as atividades do estudante.
     */
    public ArrayList<AtividadeInterface> listaAtividades() {
        ArrayList<AtividadeInterface> atividades = new ArrayList<>();
        for (AtividadeInterface a : mapCodigoAtividade.values()) {
            atividades.add(a);
        }
        return atividades;
    }

    /**
     * Adiciona um relatório à lista de relatórios do estudante.
     * 
     * @param relatorio O relatório a ser adicionado.
     * @return O índice do relatório na lista.
     */
    public int adicionaRelatorio(RelatorioAbstract relatorio) {
        this.relatorios.add(relatorio);
        return indexRelatorios++;
    }

    /**
     * Obtém um relatório com base no índice.
     * 
     * @param index O índice do relatório desejado.
     * @return O relatório correspondente ao índice.
     */
    public RelatorioAbstract getRelatorio(int index) {
        return relatorios.get(index);
    }
}

