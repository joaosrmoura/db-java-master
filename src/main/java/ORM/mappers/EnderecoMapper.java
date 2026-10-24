package ORM.mappers;

import ORM.entitys.Endereco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoMapper implements Mapper {
    public static ArrayList<Endereco> mapper(ResultSet resultado) throws SQLException {
        ArrayList<Endereco> lista = new ArrayList<>();

        while(resultado.next()){
            Endereco produto = new Endereco(resultado.getInt("id"), resultado.getString("cpf"), resultado.getFloat("valor"), resultado.getString("categotia"));
            lista.add(produto);
        }

        return lista;
    }

    public static Endereco mapperUnique(ResultSet resultado) throws SQLException {
        while(resultado.next()){
            return new Endereco(resultado.getInt("id"), resultado.getString("cpf"), resultado.getFloat("valor"), resultado.getString("categotia"));
        }
        return null;
    }
}
