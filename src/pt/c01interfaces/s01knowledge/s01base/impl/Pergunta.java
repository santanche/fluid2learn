package pt.c01interfaces.s01knowledge.s01base.impl;

public class Pergunta {

	private String pergunta;
	private String resposta;
	private int quantidadeVezes;

	public Pergunta(String pergunta, String resposta) {
		super();
		this.quantidadeVezes = 1;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public String toString() {
		return "Pergunta [pergunta= " + pergunta + ", resposta= " + resposta
				+ ", quantidadeVezes= " + quantidadeVezes + "]";
	}

	public String getPergunta() {
		return pergunta;
	}

	public void incQuantidadeVezes() {
		this.quantidadeVezes++;
	}
	
	public boolean repetiu() {
		if (quantidadeVezes == 1)
			return false;
		else return true;
	}
	
}
