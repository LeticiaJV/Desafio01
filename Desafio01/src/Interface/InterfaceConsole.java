package Interface;

import Funcoes.generica;

import VO.*;

import  DAO.DAOTxt.*;

import java.util.List;

import java.util.Scanner;

public class InterfaceConsole {

    ClienteDAO cliente;
    FuncionarioDAO funcionario;
    PedidoDAO pedido;
    ProdutoDAO produto;

    public List<PadraoVO> listaClientes = cliente.ListaVOs();
    public List<PadraoVO> listaFuncionario = funcionario.ListaVOs();
    public List<PadraoVO> listaPedidos = pedido.ListaVOs();
    public List<PadraoVO> listaProdutos = produto.ListaVOs();

    generica g;

    public InterfaceConsole(generica gPar) throws Exception {
        listaClientes = cliente.ListaVOs();
        listaFuncionario = funcionario.ListaVOs();
        listaPedidos = pedido.ListaVOs();
        listaProdutos = produto.ListaVOs();
        g = gPar;
    }

    public boolean Inicio() throws Exception {
        System.out.println("Bem-vindo,\nSelecione uma das operações a seguir:\n1- Cadastro\n2- Listagem\n");
        int n = EntradaUsuario();
        if (n == 1){
            Cadastro();
            return true;
        }
        if (n == 2){
            Saida();
            return false;
        }
        else{
            System.out.println("Opção não encontrada\n");
            return true;
        }
    }

    public void Cadastro() throws Exception {
        System.out.println("Selecione a entidade que deseja cadastrar:\n1- Cliente\n2- Funcionário\n3- Pedido\n4- Produto\n");
        int n = EntradaUsuario();
        if (g.RegrasUsuario(1, n, g.FuncionarioLogado())){
            if (n == 1)
                CadastroCliente();
            if (n == 2)
                CadastroFuncionario();
            if (n == 3)
                CadastroPedido();
            if (n == 4)
                CadastroProduto();
            else
                System.out.println("Opção não encontrada");
        }
    }

    public boolean Saida(){
        System.out.println("By");
        return true;
    }

    public int EntradaUsuario(){
        Scanner entrada  = new Scanner(System.in);
        int n = entrada.nextInt();
        return n;
    }

    public String EntradaUsuarioString(){
        Scanner entrada  = new Scanner(System.in);
        String resposta = entrada.nextLine();
        return resposta;
    }

    public void CadastroCliente() throws Exception {
        ClienteVO c = new ClienteVO();
        System.out.println("Informe um Id para cliente\n");
        int id = EntradaUsuario();
        for (int n = 0; n < listaClientes.size(); n++){
            c = (ClienteVO) listaClientes.get(n);
            if (id == c.getIdVO())
                throw new Exception("Id repetido\n");
        }
        c.setIdVO(id);
        System.out.println("Informe um nome para cliente\n");
        c.setNome(EntradaUsuarioString());
        System.out.println("Informe um cpf para cliente\n");
        c.setCpf(EntradaUsuarioString());
    }

    public void CadastroFuncionario() throws Exception {
        FuncionarioVO f = new FuncionarioVO();
        System.out.println("Informe um Id para Funcionário\n");
        int id = EntradaUsuario();
        for (int n = 0; n < listaFuncionario.size(); n++){
            f = (FuncionarioVO) listaFuncionario.get(n);
            if (id == f.getIdVO())
                throw new Exception("Id repetido\n");
        }
        f.setIdVO(id);
        System.out.println("Informe um nome para Funcionário\n");
        f.setNome(EntradaUsuarioString());
        System.out.println("Informe um cargo para Funcionário\n");
        f.setCargo(EntradaUsuarioString());
        System.out.println("Informe senha para Funcionário\n");
        f.setSenha(EntradaUsuarioString());
    }
    public void CadastroPedido() throws Exception {
        PedidoVO p = new PedidoVO();
        System.out.println("Informe um Id para Pedido\n");
        int id = EntradaUsuario();
        for (int n = 0; n < listaPedidos.size(); n++){
            p = (PedidoVO) listaPedidos.get(n);
            if (id == p.getIdVO())
                throw new Exception("Id repetido\n");
        }
        p.setIdVO(id);
        System.out.println("Informe um nome para Pedido\n");
        p.setNome(EntradaUsuarioString());
        System.out.println("Informe um Id Cliente para Pedido\n");
        p.setIdCliente(EntradaUsuario());
        p.setIdUsuario(g.FuncionarioLogado().getIdVO());

    }
    public void CadastroProduto() throws Exception {
        ProdutoVO p = new ProdutoVO();
        System.out.println("Informe um Id para Produto\n");
        int id = EntradaUsuario();
        for (int n = 0; n < listaProdutos.size(); n++){
            p = (ProdutoVO) listaProdutos.get(n);
            if (id == p.getIdVO())
                throw new Exception("Id repetido\n");
        }
        p.setIdVO(id);
        System.out.println("Informe um nome para Produto\n");
        p.setNome(EntradaUsuarioString());
        System.out.println("Informe um tamanho para Produto\n");
        p.setTamanho(EntradaUsuarioString());
        System.out.println("Informe uma descrição para Produto\n");
        p.setDescricao(EntradaUsuarioString());
        System.out.println("Informe uma cor para Produto\n");
        p.setCor(EntradaUsuarioString());
        System.out.println("Informe um preço para Produto\n");
        p.setPreco(Double.parseDouble(EntradaUsuarioString()));
    }

    public List<PadraoVO> getListaClientes() {
        return listaClientes;
    }

    public List<PadraoVO> getListaPedidos() {
        return listaPedidos;
    }

    public List<PadraoVO> getListaFuncionario(){
        return listaFuncionario;
    }

    public List<PadraoVO> getListaProdutos(){
        return listaProdutos;
    }
}
