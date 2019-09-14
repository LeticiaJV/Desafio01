package Funcoes;

import VO.FuncionarioVO;
import VO.PadraoVO;

import java.util.List;
import java.util.Scanner;

public class generica {

    private List<PadraoVO> funcionarioVOS;
    private FuncionarioVO f;

    public generica(List<PadraoVO> funcionarioVOSPar){
        funcionarioVOS = funcionarioVOSPar;
    }

    public boolean Login(){
        Scanner entrada  = new Scanner(System.in);
        String auxLogin, auxSenha;
        FuncionarioVO aux;

        System.out.println("Login: \n");
        auxLogin = entrada.nextLine();
        System.out.println("Senha: \n");
        auxSenha = entrada.nextLine();

        for (int n = 0; n < funcionarioVOS.size(); n++){
            aux = (FuncionarioVO) funcionarioVOS.get(n);
            if (aux.getIdVO() == Integer.parseInt(auxLogin) && aux.getSenha().equals(auxSenha)){
                f = aux;
                return true;
            }
        }
        return false;
    }

    public boolean RegrasUsuario (int operacao, int entidade, FuncionarioVO f) {
        if ((operacao == 1) && (entidade == 2) && f.getCargo().toUpperCase().equals("VENDEDOR")){
            System.out.println("Vendedores não podem cadastrar ou excluir funcionários");
            return false;
        }
        return true;
    }

    public FuncionarioVO FuncionarioLogado(){
        return f;
    }
}
