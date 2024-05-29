package br.edu.ufcg.computacao.complementaccc.Atividade;

import br.edu.ufcg.computacao.complementaccc.Usuario.Estudante;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

/**
 * Controlador para operações relacionadas a atividades de estudantes.
 * 
 * @author Alexandre Campos
 */
public class AtividadeController {

    /**
     * Construtor padrão da classe AtividadeController.
     */
    public AtividadeController() {}

    /**
     * Adiciona uma atividade de monitoria a um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param tipo o tipo da atividade
     * @param unidadeAcumulada a quantidade de unidades acumuladas (semestres)
     * @param disciplina a disciplina associada à monitoria
     * @param uc o controlador de usuários
     * @return uma mensagem indicando o resultado da operação
     */
    public String adicionaAtividadeMonitorEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        Monitoria monitoria = new Monitoria(tipo, unidadeAcumulada, disciplina);
        return estudante.adicionaAtividade(monitoria);
    }

    /**
     * Adiciona uma atividade de pesquisa/extensão a um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param tipo o tipo da atividade
     * @param unidadeAcumulada a quantidade de unidades acumuladas (meses)
     * @param disciplina a disciplina associada à atividade
     * @param uc o controlador de usuários
     * @return uma mensagem indicando o resultado da operação
     */
    public String adicionaPesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        PesquisaExtensao pesquisa = new PesquisaExtensao(tipo, unidadeAcumulada, disciplina);
        return estudante.adicionaAtividade(pesquisa);
    }

    /**
     * Adiciona uma atividade de estágio a um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param tipo o tipo da atividade
     * @param unidadeAcumulada a quantidade de unidades acumuladas (meses)
     * @param disciplina a disciplina associada ao estágio
     * @param uc o controlador de usuários
     * @return uma mensagem indicando o resultado da operação
     */
    public String adicionaEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        Estagio estagio = new Estagio(tipo, disciplina, unidadeAcumulada);
        return estudante.adicionaAtividade(estagio);
    }

    /**
     * Adiciona uma atividade de publicação a um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param tipo o tipo da atividade
     * @param tituloArtigo o título do artigo publicado
     * @param doi o DOI (Digital Object Identifier) do artigo
     * @param qualis a classificação QUALIS do artigo
     * @param uc o controlador de usuários
     * @return uma mensagem indicando o resultado da operação
     */
    public String adicionaPublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        Publicacao publicacao = new Publicacao(tipo, tituloArtigo, doi, qualis);
        return estudante.adicionaAtividade(publicacao);
    }

    /**
     * Altera a descrição de uma atividade de um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param codigo o código da atividade a ser alterada
     * @param descricao a nova descrição da atividade
     * @param uc o controlador de usuários
     * @return true se a descrição foi alterada com sucesso
     */
    public boolean alteraDescricaoAtividadeController(String cpf, int senha, String codigo, String descricao, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        estudante.getAtividade(codigo).alteraDescricaoAtividade(descricao);
        return true;
    }

    /**
     * Altera a comprovação de uma atividade de um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param codigo o código da atividade a ser alterada
     * @param link o link de comprovação da atividade
     * @param uc o controlador de usuários
     * @return true se a comprovação foi alterada com sucesso
     */
    public boolean alteraComprovacaoAtividadeController(String cpf, int senha, String codigo, String link, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        estudante.getAtividade(codigo).alteraComprovacaoAtividade(link);
        return true;
    }

    /**
     * Obtém a quantidade de créditos de uma atividade de um estudante.
     *
     * @param cpf o CPF do estudante
     * @param senha a senha do estudante
     * @param codigoAtividade o código da atividade
     * @param uc o controlador de usuários
     * @return a quantidade de créditos da atividade
     */
    public double pegaCreditosAtividade(String cpf, int senha, String codigoAtividade, UsuarioController uc) {
        Estudante estudante = uc.pegaEstudante(cpf, senha);
        return estudante.getAtividade(codigoAtividade).getCreditos();
    }
}
