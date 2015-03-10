package pt.c02classes.s01knowledge.s02app.actors;

import pt.c02classes.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IDeclaracao;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IObjetoConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

public class EnquirerAnimals implements IEnquirer {

	IResponder responder;
	
	public void connect(IResponder responder) {
		this.responder = responder;
	}
	
	public boolean discover() {
        IBaseConhecimento bc = new BaseConhecimento();
        IObjetoConhecimento obj;
		
		bc.setScenario("animals");
        obj = bc.recuperaObjeto("tiranossauro");

		IDeclaracao decl = obj.primeira();
		
        boolean animalEsperado = true;
		while (decl != null && animalEsperado) {
			String pergunta = decl.getPropriedade();
			String respostaEsperada = decl.getValor();
			
			String resposta = responder.ask(pergunta);
			if (resposta.equalsIgnoreCase(respostaEsperada))
				decl = obj.proxima();
			else
				animalEsperado = false;
		}
		
		boolean acertei = responder.finalAnswer("tiranossauro");
		
		if (acertei)
			System.out.println("Oba! Acertei!");
		else
			System.out.println("fuem! fuem! fuem!");
		
		return acertei;
	}

}
