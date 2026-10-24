package ORM.values;

public class Cpf {
    private String valor;

    public Cpf(String valor){
        try{
            if(this.validarCpf(valor)){
                this.valor = valor;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean validarCpf(String valor) throws Exception{
        if (valor.isEmpty()){
            throw new Exception("CPF não pode ser vazio");
        }

        if (!valor.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$")){
            throw new Exception("CPF no formato invalido");
        }
        return true;
    }

    public String getDigitos(){
        return this.valor.substring(9, 10);
    }
}
