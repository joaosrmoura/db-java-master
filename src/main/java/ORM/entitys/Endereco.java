package ORM.entitys;

public class Endereco {
    private String rua;
    private String bairro;
    private Integer numero;
    private String estado;
    private String pais;
    private String cep;

    public Endereco(
            String rua,
            String bairro,
            Integer numero,
            String estado,
            String pais,
            String cep
    ){
        try{
            if(validarCEP(cep)){
                this.cep = cep;
                this.rua = rua;
                this.bairro = bairro;
                this.numero = numero;
                this.estado = estado;
                this.pais = pais;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Boolean validarCEP(String cep) throws Exception {
        if (cep.isEmpty()) {
            throw new Exception("CEP obrigatório");
        }

        String valor = cep.trim();

        if (!valor.matches("[0-9]{5}-?[0-9]{3}")) {
            throw new Exception(
                    "CEP deve conter 8 dígitos, com ou sem hífen"
            );
        }

        return true;
    }

    public String getRua() {
        return this.rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getPais() {
        return this.pais;
    }

    public String getCEP() {
        return this.cep;
    }
}
