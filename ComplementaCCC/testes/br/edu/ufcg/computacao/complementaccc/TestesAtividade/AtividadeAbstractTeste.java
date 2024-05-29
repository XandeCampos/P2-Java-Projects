package br.edu.ufcg.computacao.complementaccc.TestesAtividade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.edu.ufcg.computacao.complementaccc.Atividade.AtividadeAbstract;
import br.edu.ufcg.computacao.complementaccc.Atividade.Estagio;

public class AtividadeAbstractTeste {
    @Test
    void construtorTipoNullTest() {
        try{
            AtividadeAbstract aa = new Estagio(null, "P2", 300);
        } catch (NullPointerException npe) {
            assertEquals("Tipo nulo", npe.getMessage());
        }
    }

    @Test
    void construtorTipoBlankTest() {
        try{
            AtividadeAbstract aa = new Estagio("", "P2", 300);
        } catch (IllegalArgumentException iae) {
            assertEquals("Tipo inválido", iae.getMessage());
        }
    }

    @Test
    void alteraDescricaoAtividadeTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        aa.alteraDescricaoAtividade("Estágio na Oracle");
        assertEquals("Estágio na Oracle", aa.getDescricao());
    }
    
    @Test
    void alteraDescricaoAtividadeNullTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.alteraDescricaoAtividade(null);
        } catch (NullPointerException npe) {
            assertEquals("Descrição nula", npe.getMessage());
        }
    }

    @Test
    void alteraDescricaoAtividadeBlankTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.alteraDescricaoAtividade("");
        } catch (IllegalArgumentException iae) {
            assertEquals("Descrição inválida", iae.getMessage());
        }
    }

    @Test
    void alteraComprovacaoAtividadeTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        aa.alteraComprovacaoAtividade("www.nothingreally.com");
    }

    @Test
    void alteraComprovacaoAtividadeNullTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.alteraComprovacaoAtividade(null);
        } catch (NullPointerException npe) {
            assertEquals("Link nulo", npe.getMessage());
        }
    }

    @Test
    void alteraComprovacaoAtividadeBlankTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.alteraComprovacaoAtividade("");
        } catch (IllegalArgumentException iae) {
            assertEquals("Link inválido", iae.getMessage());
        }
    }

    @Test
    void setCodigoTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        aa.setCodigo("123");
        assertEquals("123", aa.getCodigo());
    }
    
    @Test
    void setCodigoNullTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.setCodigo(null);
        } catch (NullPointerException npe) {
            assertEquals("Código nulo", npe.getMessage());
        }
    }

    @Test
    void setCodigoBlankTest() {
        AtividadeAbstract aa = new Estagio("Estágio", "P2", 300);
        try{
            aa.setCodigo("");
        } catch (IllegalArgumentException iae) {
            assertEquals("Código inválido", iae.getMessage());
        }
    }
}
