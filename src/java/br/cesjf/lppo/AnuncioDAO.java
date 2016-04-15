package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnuncioDAO {

    List<Anuncio> listaTodos() {
        List<Anuncio> todos = new ArrayList<>();

        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM anuncio");
            while (resultado.next()) {
                Anuncio anc = new Anuncio();
                anc.setId(resultado.getLong("id"));
                anc.setNome(resultado.getString("nome"));
                anc.setPreco(resultado.getFloat("preco"));
                anc.setDescricao(resultado.getString("descricao"));
                todos.add(anc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return todos;
    }
    
        void criar(Anuncio novoAnc) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2016-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(String.format("INSERT INTO anuncio(nome, descricao) VALUES('%s','%s')", novoAnc.getNome(), novoAnc.getDescricao()));

        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

