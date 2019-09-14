package VO;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PedidoVO extends PadraoVO {

    private int idCliente;
    private int idUsuario;

    public PedidoVO()
    {
        definicaoVO = "Pedido";
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws Exception {
        if (idCliente <= 0)
            throw new Exception("Código informado para cliente é inválido");
        else
            this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) throws Exception {
        if (idUsuario <= 0)
            throw new Exception("Código informado para usuário é inválido");
        this.idUsuario = idUsuario;
    }

}
