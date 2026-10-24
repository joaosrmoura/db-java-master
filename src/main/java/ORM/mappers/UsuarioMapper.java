package ORM.mappers;

import ORM.entitys.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioMapper implements Mapper {
    public static ArrayList<Usuario> mapper(ResultSet resultado) throws SQLException {
        ArrayList<Usuario> lista = new ArrayList<>();

        while(resultado.next()){
            Usuario usuario = new Usuario(resultado.getInt("id"),resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("telefone"), resultado.getDate("data_nascimento"));
            lista.add(usuario);
        }

        return lista;
    }
    public static Usuario mapperUnique(ResultSet resultado) throws SQLException {
            return new Usuario(resultado.getInt("id"),resultado.getString("nome"), resultado.getString("cpf"), resultado.getString("email"), resultado.getString("telefone"), resultado.getDate("data_nascimento"));
    }
}
