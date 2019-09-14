package DAO.DAOTxt;

import VO.FuncionarioVO;
import VO.PadraoVO;

import java.io.IOException;

public class FuncionarioDAO extends PadraoDAO {

    public FuncionarioDAO() throws IOException {
        super();
        nomeObjeto = "Gerente";
        chaveId = "IdGerente";
    }

    @Override
    protected PadraoVO MontaVO(String txt) throws Exception {
        FuncionarioVO f = new FuncionarioVO();
        String [] vetor;
        vetor = txt.split(" | ");
        f.setIdVO(Integer.parseInt(vetor[0].trim()));
        f.setNome(vetor[1].trim());
        f.setCargo(vetor[2].trim());
        f.setSenha(vetor[3].trim());
        return f;
    }

    @Override
    protected String VoConcatenado(PadraoVO p) {
        FuncionarioVO f = (FuncionarioVO) p;
        String retorno = f.getIdVO() + " | " + f.getNome() + " | " + f.getCargo() + " | " + f.getSenha() + "\n";
        return retorno;
    }
}
