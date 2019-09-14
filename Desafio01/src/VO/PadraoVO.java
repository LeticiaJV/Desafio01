package VO;

public abstract class PadraoVO {

    private int IdVO;
    private String nome;
    protected String definicaoVO; //Preenchido nos herdeiros com os respectivos nomes das entidades;


    public int getIdVO() {
        return IdVO;
    }

    public void setIdVO(int idVO) throws Exception {
        if (idVO <= 0)
            throw new Exception("Id inválido para " + definicaoVO);
        else
            IdVO = idVO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() == 0)
            throw new Exception("Forneça um nome para" + definicaoVO);
        else
            this.nome = nome;
    }
}
