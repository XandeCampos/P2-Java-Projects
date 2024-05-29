package br.edu.ufcg.computacao.complementaccc.TestesFAQ;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.FAQ.ItemFAQ;

public class ItemFAQTeste {
    private String[] tags;

    @BeforeEach
    void setUp() {
        this.tags = new String[2];
        this.tags[0] = "Mat";
        this.tags[1] = "Fis";
    }

    @Test
    void construtorCompletoTeste() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
    }

    @Test
    void construtorParcialTeste() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?");
    }

    @Test
    void construtorPerguntaVaziaTeste() {
        try {
            ItemFAQ faq = new ItemFAQ("");        
        } catch (IllegalArgumentException iae) {
            assertEquals("Pergunta inválida", iae.getMessage());
        }
    }

    @Test
    void toStringTeste() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        assertEquals("\nPergunta: Qual a reposta pra vida o universo e tudo mais?\nResposta: João 3:16\nDestaque: 0", faq.toString());
    }

    @Test
    void adicionaTagTeste() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        faq.adicionaTag(tags);
    } 

    @Test
    void adicionaTagTesteArrayMaiorQue3Teste() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        String[] tagsGrande = new String[5];
        for (int i = 0; i < 5; i++) {
            tagsGrande[i] = String.valueOf(i);
        }
        try {
            faq.adicionaTag(tagsGrande);
        } catch (IllegalArgumentException iae) {
            assertEquals("Array grande demais", iae.getMessage());
        }
    }

    @Test
    void adicionaTagSetPreenchidoTest() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        String[] tags1 = new String[3];
        String[] tags2 = new String[3];
        for (int i = 0; i < 3; i++) {
            tags1[i] = String.valueOf(i);
            tags2[i] = String.valueOf(i);            
        }

        faq.adicionaTag(tags1);
        try {
            faq.adicionaTag(tags2);
        } catch (IllegalArgumentException iae) {
            assertEquals("Tags preenchidas", iae.getMessage());
        }

    }

    @Test
    void adicionaTagVaziaTest() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        String[] tagsVazia = new String[3];
        tagsVazia[0] = "mat";
        tagsVazia[1] = "";
        try {
            faq.adicionaTag(tagsVazia);
        } catch (IllegalArgumentException iae) {
            assertEquals("TAG inválida", iae.getMessage());
        }        
    }

    @Test
    void contemTagTest() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        faq.adicionaTag(tags);
        String[] tagTest = new String[2];
        tagTest[0] = "Mat";
        tagTest[1] = "car";
        assert (faq.contemTag(tags));
        assert (faq.contemTag(tagTest));    
    }

    @Test
    void contemTagFalseTest() {
        ItemFAQ faq = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        faq.adicionaTag(tags);
        String[] tagTest = new String[2];
        tagTest[0] = "Bio";
        tagTest[1] = "Qui";
        assert !(faq.contemTag(tagTest));
    }
}
