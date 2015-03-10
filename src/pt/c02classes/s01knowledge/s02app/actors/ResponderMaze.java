package pt.c02classes.s01knowledge.s02app.actors;

import pt.c02classes.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IDeclaracao;
import pt.c02classes.s01knowledge.s01base.inter.IObjetoConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;
import pt.c02classes.s01knowledge.s01base.inter.IStatistics;

public class ResponderMaze implements IResponder {
	private IObjetoConhecimento obj;
	
    private char mazeMatrix[];
	private int nLinhas = 0, nColunas = 0;
	private int linhaAtual = 0, colunaAtual = 0;
	
	public ResponderMaze(IStatistics estatisticas, String maze) {
		IBaseConhecimento bc = new BaseConhecimento();
        bc.setScenario("maze");
		
		this.obj = bc.recuperaObjeto(maze);

		IDeclaracao decl = obj.primeira();
		if (decl != null) {
			String mazeFlat = decl.getValor();
			nColunas = mazeFlat.length();
			nLinhas = 1;
			decl = obj.proxima();
			while (decl != null) {
				mazeFlat += decl.getValor();
				nLinhas++;
				decl = obj.proxima();
			}
			
			int pos = mazeFlat.indexOf("E");
			
			linhaAtual = pos / nColunas;
			colunaAtual = pos - (linhaAtual * nColunas);
			
			mazeMatrix = mazeFlat.toCharArray();
		}
	}
	
	public String scenario() {
		return "maze";
	}
	
	public String ask(String question) {
		String resposta = null;
		
		int novaLinha = linhaAtual,
			novaColuna = colunaAtual;
		switch (question) {
			case "norte": novaLinha--; break;
			case "sul":   novaLinha++; break;
			case "leste": novaColuna++; break;
			case "oeste": novaColuna--; break;
			case "aqui": break;
			default: resposta = "nao sei";
		}
		
		if (resposta == null) {
		   if (novaLinha < 0 || novaLinha >= nLinhas || novaColuna < 0 || novaColuna >= nColunas)
			   resposta = "mundo";
		   else {
			   char celula = mazeMatrix[novaLinha*nColunas+novaColuna];
			   switch (celula) {
			      case '#': resposta = "parede"; break;
			      case ' ': resposta = "passagem"; break;
			      case 'E': resposta = "entrada"; break;
			      case 'S': resposta = "saida"; break;
			   }
		   }
		}
		
		return resposta;
	}
	
	public boolean move(String direction) {
		boolean movimento = true;
		int novaLinha = linhaAtual,
			novaColuna = colunaAtual;
		switch (direction) {
			case "norte": novaLinha--; break;
			case "sul":   novaLinha++; break;
			case "leste": novaColuna++; break;
			case "oeste": novaColuna--; break;
		}
		if (novaLinha < 0 || novaLinha >= nLinhas ||
			novaColuna < 0 || novaColuna >= nColunas ||
			mazeMatrix[novaLinha*nColunas+novaColuna] == '#')
			movimento = false;
		else {
			linhaAtual = novaLinha;
			colunaAtual = novaColuna;
		}
		return movimento;
	}

	public boolean finalAnswer(String answer) {
		return (mazeMatrix[linhaAtual*nColunas+colunaAtual] == 'S');
	}

}
