package DAO.DAOTxt;

import java.io.*;
import VO.PadraoVO;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public abstract class PadraoDAO {

    protected String nomeObjeto;
    protected String chaveId;
    protected File caminhoCompleto = new File(RetornoCaminho());
    protected BufferedReader brLe = new BufferedReader(new FileReader(caminhoCompleto));

    protected PadraoDAO() throws IOException {
    }

    protected abstract PadraoVO MontaVO (String txt) throws Exception;//monta o VO
    protected abstract String VoConcatenado (PadraoVO p); //concatena dados das entidades

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
            System.out.println("Caminho para " + nomeObjeto + " não encontrado");
            FileWriter arq = new FileWriter(caminhoCompleto);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("");
            return null;
        }
    }
    public List<PadraoVO> ListaVOs () throws Exception {//devolve lista de VOs presentes no arquivo txt
        try {
            List<String> lista = ListaElementosTxt();
            Set<PadraoVO> VOs = new HashSet<>();
            for (String s: lista)
                VOs.add(MontaVO(s));
            return (List<PadraoVO>) VOs;
        }
        catch (Exception erro){
            System.out.println(erro);
            return null;
        }
    }


    public void SalvaElementos (List<PadraoVO> lista) throws IOException {
        try{
        String txt = "";
        for (PadraoVO p: lista)
            txt += VoConcatenado(p);
        Files.write(Paths.get(RetornoCaminho()), Collections.singleton(txt), StandardCharsets.UTF_8);
        }
        catch (Exception erro){
            System.out.println(erro);
        }
    }

    private String RetornoCaminho() throws IOException {
        try{
            String caminho = new File("\\Desafio01\\src\\com\\company\\arquivostexto" + nomeObjeto + ".txt").getCanonicalPath();
            return caminho;
        }
        catch (Exception erro){
            System.out.println(erro);
            return null;
        }
    }
}
