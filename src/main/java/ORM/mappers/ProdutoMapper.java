package ORM.mappers;

import ORM.entitys.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoMapper implements Mapper {
    public static ArrayList<Produto> mapper(ResultSet resultado) throws SQLException {
        ArrayList<Produto> lista = new ArrayList<>();

        while(resultado.next()){
            Produto produto = new Produto(resultado.getInt("id"), resultado.getString("cpf"), resultado.getFloat("valor"), resultado.getString("categotia"));
            lista.add(produto);
        }

        return lista;
    }

    public static Produto mapperUnique(ResultSet resultado) throws SQLException {
        while(resultado.next()){
            return new Produto(resultado.getInt("id"), resultado.getString("cpf"), resultado.getFloat("valor"), resultado.getString("categotia"));
        }
        return null;
    }
}
