package pt.c01interfaces.s01knowledge.s01base.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import pt.c01interfaces.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c01interfaces.s01knowledge.s01base.inter.IDeclaracao;
import pt.c01interfaces.s01knowledge.s01base.inter.IObjetoConhecimento;

public class BaseConhecimento implements IBaseConhecimento
{
	public static final String DIRETORIO_RELATIVO = "../../s02app/bd",
	                           EXTENSAO = ".txt";
	String diretorio = BaseConhecimento.class.getResource(DIRETORIO_RELATIVO).getPath();
	
    public String[] listaNomes()
    {
    	File diretorioRaiz = new File(diretorio);
        
        String lista[] = diretorioRaiz.list();
        Vector<String> listaFiltrada = new Vector<String>();
        
        for (int n = 0; n < lista.length; n++)
            if (lista[n].endsWith(".txt"))
                listaFiltrada.add(lista[n].substring(0, lista[n].length() - 4));
        
        return (String[])listaFiltrada.toArray(new String[0]);
    }
    
    public IObjetoConhecimento recuperaObjeto(String nome)
    {
		Vector<IDeclaracao> vdecl = new Vector<IDeclaracao>();

		try {
    		FileReader arquivo = new FileReader(diretorio + "/" + nome + EXTENSAO);
    		BufferedReader formatado = new BufferedReader(arquivo);
    	    
    	    String linha = formatado.readLine();
    	    while (linha != null)
    	    {
    	    	IDeclaracao decl = montaDeclaracao(linha);
    	    	
    	    	if (decl != null)
    	    		vdecl.add(decl);
    	    	
    	    	linha = formatado.readLine();
    	    }
    	    
    	    arquivo.close();
    	} catch (IOException erro) {
    		erro.printStackTrace();
    	}
    	
    	IObjetoConhecimento obj = new ObjetoConhecimento(vdecl.toArray(new IDeclaracao[0]));
    	
    	return obj;
    }
    
    private IDeclaracao montaDeclaracao(String linha)
    {
    	String propriedade = null,
    	       valor = null;
    	
        if (linha != null) {
        	char clinha[] = linha.toCharArray();
        	int p = 0;

        	if (clinha[p] == '\"') {
	    		propriedade = "";
	    		p++;
	    		while (p < clinha.length && clinha[p] != '\"') {
	    			propriedade += clinha[p];
	    			p++;
	    		}
	    		p++;
	    		
	    		if (p < clinha.length) {
	    			while (p < clinha.length && clinha[p] != '\"') 
	        			p++;
	    			if (p < clinha.length) {
	    				valor = "";
	    				p++;
	    	    		while (p < clinha.length && clinha[p] != '\"') {
	    	    			valor += clinha[p];
	    	    			p++;
	    	    		}
	    			}
	    		}
	    	}
        }
        
    	IDeclaracao decl = null;
    	if (propriedade != null && valor != null)
    		decl = new Declaracao(propriedade, valor);
    	
    	return decl;
    }
}
