package ORM.tables;

import ORM.database.Database;
import ORM.entitys.Usuario;
import ORM.mappers.UsuarioMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UsuarioTable {
    protected static final String TABELA = "usuario";
    private static final Database db = new Database(UsuarioTable.TABELA);

    public static ArrayList<Usuario> find(ArrayList<String> colunas) {
        try {
            ResultSet resultado = db.selecionar(colunas).executarConsulta();
            return UsuarioMapper.mapper(resultado);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Usuario> find() {
        try {
            ResultSet resultado = db.selecionar().executarConsulta();
            return UsuarioMapper.mapper(resultado);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Usuario get_id(int id) throws SQLException {
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);

        ResultSet res = db.selecionar().where(condicao).executarConsulta();
        return UsuarioMapper.mapperUnique(res);
    }
    public static ResultSet get_id(ArrayList<String> colunas, int id) {
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);
        return db.selecionar(colunas).where(condicao).executarConsulta();
    }

    public static Integer create(HashMap<String, Object> valores) {
        return db.criar(valores).executarComando();
    }

    public static Integer update(HashMap<String, Object> camposAtualizados, int id) {
        return db.atualizar(camposAtualizados, id).executarComando();
    }

    public static Integer delete(int id) {
        return db.deletar(id).executarComando();
    }
}
