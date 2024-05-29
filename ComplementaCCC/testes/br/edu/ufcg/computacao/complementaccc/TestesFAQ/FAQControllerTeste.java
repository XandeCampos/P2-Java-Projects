package br.edu.ufcg.computacao.complementaccc.TestesFAQ;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.FAQ.FAQController;
import br.edu.ufcg.computacao.complementaccc.FAQ.ItemFAQ;
import br.edu.ufcg.computacao.complementaccc.Usuario.Admin;
import br.edu.ufcg.computacao.complementaccc.Usuario.UsuarioController;

public class FAQControllerTeste {
    private String[] tags;
    private UsuarioController uc;
    private ItemFAQ faqTeste1;
    private ItemFAQ faqTeste2;

    @BeforeEach
    void setUp() {
        this.tags = new String[2];
        this.tags[0] = "Mat";
        this.tags[1] = "Fis";
        
        this.uc = new UsuarioController();
        uc.configuraNovoAdmin("", 0, "adm", "12345678901", 12345678);

        this.faqTeste1 = new ItemFAQ("Qual a reposta pra vida o universo e tudo mais?", "João 3:16");
        this.faqTeste2 = new ItemFAQ("Como viveremos agora, então?", "Gálatas 2:20");
    }

    @Test 
    void construtorTest() {
        FAQController fc = new FAQController();
    }

    @Test
    void adicionaItemSemRepostaTest() {
        FAQController fc = new FAQController();
        assert fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", uc);
    }

    @Test
    void adicionaItemComRespostaTest() {
        FAQController fc = new FAQController();
        assert fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", "João 3:16" , uc);   
    }

    @Test
    void alteraRespostaItemTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", uc);
        assert (fc.alteraRespostaItemController("12345678901", 12345678, 0, "João 3:16", uc));
    }

    @Test
    void listaFAQTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", "João 3:16", uc);
        String[] faqsString = new String[2];
        faqsString[0] = faqTeste1.toString();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        faqsString[1] = faqTeste2.toString();
        assert (Arrays.equals(faqsString, fc.listaFAQ()));
    }

    @Test
    void destacaItemTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", "João 3:16", uc);
        assert (fc.destacaItem(0));
    }

    @Test
    void listaFAQPrioridadeDestaqueTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", "João 3:16", uc);
        faqTeste1.atualizaDestaque();
        fc.destacaItem(1);
        String[] faqsString = new String[2];
        faqsString[0] = faqTeste1.toString();
        faqsString[1] = faqTeste2.toString();
        assert (Arrays.equals(faqsString, fc.listaFAQPrioridadeDestaque()));
    }

    @Test
    void atribuiTagsItemTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        fc.atribuiTagsItem("12345678901", 12345678, 0, tags, uc);
        String[] tagTest = new String[1];
        tagTest[0] = faqTeste2.toString();
        assert (Arrays.equals(tagTest, fc.buscaItemFAQ(tags)));
    }
    
    @Test
    void atribuiTagsItemArrayVazioTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        String[] newTags = new String[2];
        newTags[0] = "";
        try {
            fc.atribuiTagsItem("12345678901", 12345678, 0, newTags, uc);
        } catch (IllegalArgumentException iae) {
            assertEquals("TAG inválida", iae.getMessage());
        }
    }

    @Test
    void buscaItemFAQTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        fc.adicionaItem("12345678901", 12345678, "Qual a reposta pra vida o universo e tudo mais?", "João 3:16", uc);
        String[] tags1 = new String[1];
        tags1[0] = "Mat";
        fc.atribuiTagsItem("12345678901", 12345678, 0, tags1, uc);
        String[] tags2 = new String[1];
        tags2[0] = "Fis";
        fc.atribuiTagsItem("12345678901", 12345678, 1, tags2, uc);
        String[] tagsResultante = new String[2];
        tagsResultante[0] = faqTeste2.toString();
        tagsResultante[1] = faqTeste1.toString();
        assert (Arrays.equals(tagsResultante, fc.buscaItemFAQ(tags)));
    }

    @Test
    void buscaItemFAQArrayRespostaVazioTest() {
        FAQController fc = new FAQController();
        fc.adicionaItem("12345678901", 12345678, "Como viveremos agora, então?", "Gálatas 2:20", uc);
        String[] tags1 = new String[1];
        tags1[0] = "Bio";
        fc.atribuiTagsItem("12345678901", 12345678, 0, tags1, uc);
        assertEquals(0, fc.buscaItemFAQ(tags).length);
    }

}