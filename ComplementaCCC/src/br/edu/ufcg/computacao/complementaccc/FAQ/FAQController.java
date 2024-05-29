package br.edu.ufcg.computacao.complementaccc.FAQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

/**
 * A classe FAQController é responsável por gerenciar os itens de FAQ do sistema.
 * 
 * @author Alexandre Campos
 */
public class FAQController {
    /** 
	 * Lista de itens de FAQ
	 */
    private ArrayList<ItemFAQ> itens;

    /**
     * Construtor para criar um novo objeto FAQController.
     */
    public FAQController() {
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um novo item de FAQ à lista.
     * 
     * @param cpfAdm O cpf do admin.
     * @param senhaAdm A senha do admin.
     * @param pergunta A pergunta do FAQ.
     * @param uc O controlador de usuário para validar as credenciais de admin.
     * @return true se o item foi adicionado com sucesso
     */
    public boolean adicionaItem(String cpfAdm, int senhaAdm, String pergunta, UsuarioController uc) {
        if (uc.validaAdmin(cpfAdm, senhaAdm)) {
            ItemFAQ item = new ItemFAQ(pergunta);
            itens.add(item);
        }
        return true;
    }

    /**
     * Adiciona um novo item de FAQ com resposta à lista.
     * 
     * @param cpfAdm O cpf do admin.
     * @param senhaAdm A senha do admin.
     * @param pergunta A pergunta do FAQ.
     * @param resposta A resposta do FAQ.
     * @param uc O controlador de usuário para validar as credenciais de admin.
     * @return true se o item foi adicionado com sucesso
     */
    public boolean adicionaItem(String cpfAdmAdm, int senhaAdmAdm, String pergunta, String resposta, UsuarioController uc) {
        if (uc.validaAdmin(cpfAdmAdm, senhaAdmAdm)) {
            ItemFAQ item = new ItemFAQ(pergunta, resposta);
            itens.add(item);
        }
        return true;
    }

	    /**
     * Altera a resposta de um item de FAQ.
     * 
     * @param cpfAdm O cpf do admin.
     * @param senhaAdm A senha do admin.
     * @param itemIndex O índice do item de FAQ a ser alterado.
     * @param resposta A nova resposta.
     * @param uc O controlador de usuário para validar as credenciais de admin.
     * @return true se a resposta foi alterada com sucesso
     */
    public boolean alteraRespostaItemController(String cpfAdm, int senhaAdm, int itemIndex, String resposta, UsuarioController uc) {
        if(uc.validaAdmin(cpfAdm, senhaAdm)) {
            itens.get(itemIndex).setResposta(resposta);
        }
        return true;
    }

    /**
     * Retorna uma representação em string de todos os itens de FAQ.
     * 
     * @return Um array de strings contendo a representação de cada item de FAQ.
     */
    public String[] listaFAQ() {
        ArrayList<String> representacaoFAQ = new ArrayList<>();
        for (ItemFAQ i : itens) {
            representacaoFAQ.add(i.toString());
        }
        return representacaoFAQ.toArray(new String[representacaoFAQ.size()]);
    }

    /**
     * Retorna uma representação em string dos itens de FAQ ordenados por prioridade de destaque.
     * 
     * @return Um array de strings contendo a representação de cada item de FAQ, ordenados por prioridade de destaque.
     */
    public String[] listaFAQPrioridadeDestaque() {
        ArrayList<ItemFAQ> cloneItens = new ArrayList<>(itens);
        Collections.sort(cloneItens, Comparator.comparingInt(ItemFAQ::getDestaque).reversed());
        ArrayList<String> representacaoFAQ = new ArrayList<>();
        for (ItemFAQ i : cloneItens) {
            representacaoFAQ.add(i.toString());
        }
        return representacaoFAQ.toArray(new String[representacaoFAQ.size()]);
    }

    /**
     * Destaca um item de FAQ.
     * 
     * @param itemIndex O índice do item de FAQ a ser destacado.
     * @return true se o item foi destacado com sucesso
     */
    public boolean destacaItem(int itemIndex) {
        itens.get(itemIndex).atualizaDestaque();
        return true;
    }

    /**
     * Atribui tags a um item de FAQ.
     * 
     * @param cpfAdm O cpf do admin.
     * @param senhaAdm A senha do adm.
     * @param itemIndex O índice do item de FAQ a ser alterado.
     * @param tags As tags a serem atribuídas ao item de FAQ.
     * @param uc O controlador de usuário para validar as credenciais de admin.
     * @return true se as tags foram atribuídas com sucesso
     */
    public boolean atribuiTagsItem(String cpfAdm, int senhaAdm, int itemIndex, String[] tags, UsuarioController uc) {
        if (uc.validaAdmin(cpfAdm, senhaAdm)) {
            itens.get(itemIndex).adicionaTag(tags);
        }
        return true;
    }

    /**
     * Busca itens de FAQ por tags.
     * 
     * @param tags As tags a serem buscadas nos itens de FAQ.
     * @return Um array de strings contendo a representação de cada item de FAQ que contém as tags especificadas.
     */
    public String[] buscaItemFAQ(String[] tags) {
        ArrayList<String> itensCorrespondentes = new ArrayList<>();
        for (ItemFAQ i : itens) {
            if (i.contemTag(tags)) {
                itensCorrespondentes.add(i.toString());
            }
        }
        return itensCorrespondentes.toArray(new String[itensCorrespondentes.size()]);
    }
}
