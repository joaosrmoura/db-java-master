package ORM.tables;

import ORM.database.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ProdutoTable {
    protected static final String TABELA = "produto";
    private static final Database db = new Database(ProdutoTable.TABELA);

    public static ResultSet find(ArrayList<String> colunas) {
        return db.selecionar(colunas).executarConsulta();
    }
    public static ResultSet find() {
        return db.selecionar().executarConsulta();
    }

    public static ResultSet get_id(int id) {
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);
        return db.selecionar().where(condicao).executarConsulta();
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
