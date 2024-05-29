package br.edu.ufcg.computacao.complementaccc.FAQ;

import java.util.HashSet;

/**
 * Representa um item de perguntas frequentes (FAQ).
 * 
 * @author Alexandre Campos
 */
public class ItemFAQ {

	/**
	 * int que representa o nível de destaque da FAQ em questão
	 */
    private int destaque;
	/**
	 * String com a pergunta da FAQ
	 */
    private String pergunta;
    /**
	 * String com a resposta a FAQ
	 */
	private String resposta;
	/**
	 * HashSet com as tags associadas a FAQ
	 */
    private HashSet<String> tags;

    /**
     * Construtor para criar um ItemFAQ com apenas a pergunta especificada.
     *
     * @param pergunta a pergunta para a qual criar o item FAQ
     * @throws IllegalArgumentException se a pergunta estiver em branco
     */
    public ItemFAQ(String pergunta) {
        this(pergunta, "");
    }

    /**
     * Construtor para criar um ItemFAQ com a pergunta e resposta especificadas.
     *
     * @param pergunta a pergunta para a qual criar o item FAQ
     * @param resposta a resposta associada à pergunta
     * @throws IllegalArgumentException se a pergunta estiver em branco
     */
    public ItemFAQ(String pergunta, String resposta) throws IllegalArgumentException {
        if (pergunta.isBlank()) {
            throw new IllegalArgumentException("Pergunta inválida");
        }
        this.destaque = 0;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.tags = new HashSet<>();
    }

    /**
     * Retorna uma representação em formato de string do ItemFAQ.
     *
     * @return uma string representando o ItemFAQ
     */
    @Override
    public String toString() {
        return "\nPergunta: " + pergunta + "\nResposta: " + resposta + "\nDestaque: " + destaque;
    }

    /**
     * Incrementa o destaque do ItemFAQ.
     */
    public void atualizaDestaque() {
        this.destaque++;
    }

    public void setResposta(String novaResposta) {
        this.resposta = novaResposta;
    }

    /**
     * Adiciona novas tags ao ItemFAQ.
     *
     * @param novasTags as novas tags a serem adicionadas
     * @throws IllegalArgumentException se o array de tags for muito grande ou se alguma tag for inválida
     */
    public void adicionaTag(String[] novasTags) throws IllegalArgumentException {
        if (novasTags.length <= 3) {
            for (String t : novasTags) {
                if (this.tags.size() == 3) throw new IllegalArgumentException("Tags preenchidas");
                if (t == null) continue;
                if (t.isBlank()) throw new IllegalArgumentException("TAG inválida");
                tags.add(t);
            }
        } else {
            throw new IllegalArgumentException("Array grande demais");
        }
    }

    /**
     * Verifica se o ItemFAQ contém pelo menos uma das tags especificadas.
     *
     * @param tagsBuscadas as tags a serem verificadas
     * @return true se o ItemFAQ contiver pelo menos uma das tags, false caso contrário
     */
    public boolean contemTag(String[] tagsBuscadas) {
        for (String t : tagsBuscadas) {
            if (t == null) continue;
            if (tags.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public int getDestaque() {
        return destaque;
    }
}
