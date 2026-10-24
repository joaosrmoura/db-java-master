package ORM.database;
import java.sql.*;
import java.util.*;

public class Database {
    private String url = "jdbc:mysql://localhost:3306/loja";
    private String usuario = "root";
    private String senha = "";

    private Connection conexao;
    private Statement ponteiro;

    private String tabela;
    private String query = "";

    public Database(String nomeTabela){
        this.tabela = nomeTabela;

        try {
            this.conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
            this.ponteiro = this.conexao.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void conectar(){}

    public Database selecionar(List<String> nomeColunas){
        this.query = "SELECT ";

        if(nomeColunas.isEmpty()){
            nomeColunas.add("*");
        }

        for(int indexAtual = 0; nomeColunas.size() > indexAtual; indexAtual++){
            this.query += nomeColunas.get(indexAtual);

            if (indexAtual < nomeColunas.size() - 1){
                this.query += ", ";
            }
        }

        this.query += " FROM " + this.tabela;
        return this;
    }
    public Database selecionar(){
        this.query = "SELECT * FROM " + this.tabela;
        return this;
    }

    public Database criar(HashMap<String, Object> colunaValor){
        this.query = "INSERT INTO " + this.tabela + "(";
        int contador = 0;

        for (Map.Entry<String, Object> entry : colunaValor.entrySet()){
            contador++;
            this.query += entry.getKey() + ((colunaValor.size() == contador)  ? ")" : ",");
        }

        this.query += " VALUES(";

        for (Map.Entry<String, Object> entry : colunaValor.entrySet()){
            contador++;
            Object valor = entry.getValue();

            String valorFormatado = (valor instanceof String) ? "'" + valor + "'" : String.valueOf(valor);

            this.query += valorFormatado;
            this.query += (colunaValor.size()  == contador/2 ) ? ")" : ",";
        }

        return this;
    }
    public Database atualizar(HashMap<String, Object> camposAlterados, int id){
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);

        this.query = "UPDATE FROM " + this.tabela + " SET ";

        for (Map.Entry<String, Object> entry : camposAlterados.entrySet()){
            this.query += entry.getKey() + " = " + entry.getValue();
        }

        return this.where(condicao);
    }
    
    public Database deletar(int id){
        HashMap<String, Object> condicao = new HashMap<>();
        condicao.put("id =", id);
        this.query += "DELETE FROM " + this.tabela;

        return this.where(condicao);
    }

    public ResultSet executarConsulta(){
        this.query += ";";
        System.out.println(this.query);
        try{
            System.out.println(this.query);
            this.ponteiro.closeOnCompletion();
            return this.ponteiro.executeQuery(this.query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.query = "";
        }
    }

    public int executarComando(){
        this.query += ";";
        System.out.println(this.query);
        try{
            System.out.println(this.query);
            this.ponteiro.closeOnCompletion();
            return this.ponteiro.executeUpdate(this.query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.query = "";
        }
    }

    public  Database where(HashMap<String, Object> regras){
        this.query += " WHERE ";

        for (Map.Entry<String, Object> entry : regras.entrySet()){
            this.query += entry.getKey() + " ";

            if(!entry.getKey().contains("=")){
                this.query += " LIKE " + ((entry.getValue() instanceof String) ? "'%" + entry.getValue() + "%'" : entry.getValue());
            } else {
                this.query += (entry.getValue() instanceof String) ? "'" + entry.getValue() + "'" : entry.getValue();
            }
        }

        return this;
    }
}
