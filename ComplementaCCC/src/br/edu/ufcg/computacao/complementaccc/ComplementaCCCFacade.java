package br.edu.ufcg.computacao.complementaccc;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeController;
import br.edu.ufcg.computacao.complementaccc.FAQ.FAQController;
import br.edu.ufcg.computacao.complementaccc.Relatorio.RelatorioController;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

public class ComplementaCCCFacade {
	private UsuarioController uc = new UsuarioController();
	private FAQController fc = new FAQController();
	private AtividadeController ac = new AtividadeController();
	private RelatorioController rc = new RelatorioController();
	
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return uc.criaEstudante(nome, cpf, senha, matricula);
	}
	String[] exibirEstudantes(String cpf, int senha){
		//ADMIN
		return uc.exibeEstudantes(cpf, senha);
	}
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		return uc.alteraEstudantes(cpf, senha, tipoAlteracao, novoValor);
	}
	String exibirAdmin(String cpf, int senha){
		return uc.exibeAdmin(cpf, senha);
		//ADMIN
	}
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova){
		return uc.configuraNovoAdmin(cpf, senhaAtual, nomeNovo, cpfNovo, senhaNova);
		//ADMIN
	}
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		return uc.configuraSenhaAdmin(cpf, senhaAtual, senhaNova);
		//ADMIN
	}
	
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		return fc.adicionaItem(cpf, senha, pergunta, uc);
		//ADMIN
	}
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		return fc.adicionaItem(cpf, senha, pergunta, resposta, uc);
		//ADMIN
	}
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		return fc.alteraRespostaItemController(cpf, senha, itemIndex, resposta, uc);
		//ADMIN
	}
	String[] listarFAQ() {
		return fc.listaFAQ();
	}
	String[] listarFAQPorDestaque() {
		return fc.listaFAQPrioridadeDestaque();
	}
	boolean destacarItem(int itemIndex) {
		return fc.destacaItem(itemIndex);
	}
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		return fc.atribuiTagsItem(cpf, senha, itemIndex, tags, uc);
		//ADMIN
	}
	String[] buscarItemFAQ(String[] tags) {
		return fc.buscaItemFAQ(tags);
	}
	
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.adicionaAtividadeMonitorEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina, uc);
	}
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		return ac.alteraDescricaoAtividadeController(cpf, senha, codigoAtividade, descricao, uc);
	}
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		return ac.alteraComprovacaoAtividadeController(cpf, senha, codigoAtividade, linkComprovacao, uc);
	}
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.adicionaPesquisaExtensaoEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina, uc);
	}
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		return ac.adicionaEstagioEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina, uc);
	}
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		return ac.adicionaPublicacaoEmEstudante(cpf, senha, tipo, tituloArtigo, doi, qualis, uc);
	}
	double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		return ac.pegaCreditosAtividade(cpf, senha, codigoAtividade, uc);
	}
	int criarRelatorioCompleto(String cpf, String senha) {
		return rc.criaRelatorioCompleto(cpf, Integer.parseInt(senha), uc);
	}
	int criarRelatorioResumido(String cpf, String senha) {
		return rc.criaRelatorioResumido(cpf, Integer.parseInt(senha), uc);
	}
	int criarRelatorioPorATV(String cpf, String senha, String tipoAtividade) {
		return rc.criaRelatorioPorATV(cpf, Integer.parseInt(senha), tipoAtividade, uc);
	}
	String exibirRelatorio(String cpf, String senha, int indexRelatorio) {
		return rc.exibeRelatorio(cpf, Integer.parseInt(senha), indexRelatorio, uc);
	}

}
