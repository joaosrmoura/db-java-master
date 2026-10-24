package ORM.values;

public class Telefone {
    private String valor;

    public Telefone(String valor){
        try{
            if(this.validarTelefone(valor)){
                this.valor = valor;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validarTelefone(String valor) throws Exception{
        if(valor.isEmpty()){
            throw new Exception("Telefone não pode ser Vazio");
        }

        if(!valor.matches("^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$")){
            throw new Exception("Telefone no formato incorreto");
        }

        return true;
    }

    public String getDDD(){
        return this.valor.substring(0, 4);
    }
}
