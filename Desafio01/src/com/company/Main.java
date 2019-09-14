package com.company;

import DAO.DAOTxt.ClienteDAO;
import DAO.DAOTxt.FuncionarioDAO;
import DAO.DAOTxt.PedidoDAO;
import DAO.DAOTxt.ProdutoDAO;
import Funcoes.generica;
import Interface.InterfaceConsole;
import VO.PadraoVO;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean valida = true;
        try {

            FuncionarioDAO funcionario = new FuncionarioDAO();
            ClienteDAO cliente = new ClienteDAO();
            ProdutoDAO produto = new ProdutoDAO();
            PedidoDAO pedido = new PedidoDAO();

            generica g = new generica(funcionario.ListaVOs());
            InterfaceConsole interfaceC = new InterfaceConsole(g);
            while (valida)
                valida = interfaceC.Inicio();

            funcionario.SalvaElementos(interfaceC.listaFuncionario);
            cliente.SalvaElementos(interfaceC.listaClientes);
            produto.SalvaElementos(interfaceC.listaProdutos);
            pedido.SalvaElementos(interfaceC.listaPedidos);
        }
        catch (Exception erro){
            System.out.println(erro);
        }
    }
}
