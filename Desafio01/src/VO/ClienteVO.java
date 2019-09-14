package VO;

public class ClienteVO extends PadraoVO {

    private String cpf;

    public ClienteVO(){
        definicaoVO = "Cliente";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
