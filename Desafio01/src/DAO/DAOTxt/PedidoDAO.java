package DAO.DAOTxt;

import VO.PadraoVO;
import VO.PedidoVO;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class PedidoDAO extends PadraoDAO {

    public PedidoDAO() throws IOException {
        super();
        nomeObjeto = "Pedido";
        chaveId = "IdPedido";
    }

    @Override
    protected PadraoVO MontaVO(String txt) throws Exception {
        PedidoVO p = new PedidoVO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String[] vetor;
        vetor = txt.split(" | ");
        p.setIdVO(Integer.parseInt(vetor[0].trim()));
        p.setNome(vetor[1].trim());
        p.setIdCliente(Integer.parseInt(vetor[2].trim()));
        p.setIdUsuario(Integer.parseInt(vetor[3].trim()));
        return p;
    }

    @Override
    protected String VoConcatenado(PadraoVO p) {
        PedidoVO pedido = (PedidoVO) p;
        String retorno = pedido.getIdVO() + " | " + pedido.getNome() + " | " + pedido.getIdCliente() + " | " +
                pedido.getIdUsuario() + " | " + "\n";
        return retorno;
    }
}
