package ORM.values;

public class Email {
    private String valor;

    public Email(String valor){
        try{
            if(this.validarEmail(valor)) {
                this.valor = valor;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get_valor(){
        return this.valor;
    }

    public Boolean validarEmail(String valor) throws Exception{
        if (valor.isEmpty()){
            throw new Exception("Email não pode ser vazio");
        }
        if (!valor.contains("@")){
            throw new Exception("Email com formato incorreto, adicione o @");
        }
        return true;
    }
}
