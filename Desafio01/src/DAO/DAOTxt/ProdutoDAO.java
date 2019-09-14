package DAO.DAOTxt;

import VO.PadraoVO;
import VO.ProdutoVO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoDAO extends PadraoDAO {

        public ProdutoDAO() throws IOException {
            caminhoCompleto = new File(RetornoCaminho());
            brLe = new BufferedReader(new FileReader(caminhoCompleto));
        }

    protected List<String> ListaElementosTxt () throws IOException {//separa o arquivo txt por linhas
        try
        {
            String aux;
            Set<String> linhas = new HashSet<>();
            while ((aux = brLe.readLine()) != null)
                if (aux.trim().length() != 0 && aux != null)
                    linhas.add(aux);
            return (List<String>) linhas;
        }
        catch (Exception erro) {
            System.out.println("Caminho para produto.txt não encontrado");
            FileWriter arq = new FileWriter(caminhoCompleto);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("");
            return null;
        }
    }
    public List<PadraoVO> ListaVOs () throws Exception {//devolve lista de VOs presentes no arquivo txt
        List<String> lista = ListaElementosTxt();
        Set<PadraoVO> VOs = new HashSet<>();
        for (String s: lista)
            VOs.add(MontaVO(s));
        return (List<PadraoVO>) VOs;
    }


    public void SalvaElementos (List<PadraoVO> lista) {
        try{
            String txt = "";
            for (PadraoVO p: lista)
                txt += VoConcatenado(p);
            Files.write(Paths.get(RetornoCaminho()), Collections.singleton(txt), StandardCharsets.UTF_8);
        }
        catch (Exception erro){

        }
    }

    protected String RetornoCaminho() throws IOException {
        String caminho = new File("/Parser01//src//com//company//arquivostexto//produto.txt").getCanonicalPath();
        return caminho;
    }

    @Override
    protected PadraoVO MontaVO(String txt) throws Exception {
        ProdutoVO p = new ProdutoVO();
        String[] vetor;
        vetor = txt.split(" | ");
        p.setIdVO( Integer.parseInt(vetor[0].trim()));
        p.setNome(vetor[1].trim());
        p.setDescricao((vetor[2].trim()));
        p.setCor(vetor[3].trim().trim());
        p.setTamanho(vetor[4].trim());
        p.setPreco(Double.parseDouble(vetor[5].trim()));
        return p;
    }


    @Override
    protected String VoConcatenado(PadraoVO p)
    {
        ProdutoVO produto = (ProdutoVO) p;
        String retorno = produto.getIdVO() + " | " + produto.getNome() + " | " + produto.getDescricao() +
        " | " + produto.getCor() + " | " + produto.getTamanho() + " | " + produto.getPreco() + "\n";
        return retorno;
    }
}
