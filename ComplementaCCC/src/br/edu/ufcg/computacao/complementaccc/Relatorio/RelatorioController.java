package br.edu.ufcg.computacao.complementaccc.Relatorio;

import java.util.ArrayList;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeInterface;
import br.edu.ufcg.computacao.complementaccc.Usuario.Estudante;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

/**
 * A classe RelatorioController é responsável por gerenciar a criação e exibição de relatórios das atividades dos estudantes.
 * 
 * @author Alexandre Campos
 */
public class RelatorioController {
    /**
     * Construtor para criar um novo objeto RelatorioController.
     */
    public RelatorioController() {}

    /**
     * Cria um relatório completo para um estudante com base em suas atividades.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param uc o controlador de usuário para acessar informações do estudante
     * @return o índice do relatório criado para o estudante
     */
    public int criaRelatorioCompleto(String cpf, int senha, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        ArrayList<AtividadeInterface> atividadesEstudante = estudante.listaAtividades();
        String matricula = estudante.getMatricula();
        return estudante.adicionaRelatorio(new RelatorioDetalhado(estudante.getNome(), cpf, matricula, atividadesEstudante));
    }

    /**
     * Cria um relatório resumido para um estudante com base em suas atividades.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param uc o controlador de usuário para acessar informações do estudante
     * @return o índice do relatório criado para o estudante
     */
    public int criaRelatorioResumido(String cpf, int senha, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        ArrayList<AtividadeInterface> atividadesEstudante = estudante.listaAtividades();
        String matricula = estudante.getMatricula();
        return estudante.adicionaRelatorio(new RelatorioResumido(estudante.getNome(), cpf, matricula, atividadesEstudante));
    }

    /**
     * Cria um relatório específico para um tipo de atividade para um estudante com base em suas atividades.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param tipoAtividade o tipo de atividade para o qual o relatório será criado
     * @param uc o controlador de usuário para acessar informações do estudante
     * @return o índice do relatório criado para o estudante
     */
    public int criaRelatorioPorATV(String cpf, int senha, String tipoAtividade, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        ArrayList<AtividadeInterface> atividadesEstudante = estudante.listaAtividades();
        String matricula = estudante.getMatricula();
        return estudante.adicionaRelatorio(new RelatorioATV(estudante.getNome(), cpf, matricula, atividadesEstudante, tipoAtividade));
    }

    /**
     * Exibe um relatório específico de um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param indexRelatorio o índice do relatório a ser exibido
     * @param uc o controlador de usuário para acessar informações do estudante
     * @return uma representação em string do relatório solicitado
     */
    public String exibeRelatorio(String cpf, int senha, int indexRelatorio, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        return estudante.getRelatorio(indexRelatorio).toString();
    }
}
