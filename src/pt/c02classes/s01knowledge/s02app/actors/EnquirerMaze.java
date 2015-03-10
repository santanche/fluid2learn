package pt.c02classes.s01knowledge.s02app.actors;

import java.util.Scanner;

import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

public class EnquirerMaze implements IEnquirer {

	IResponder responder;
	
	public void connect(IResponder responder) {
		this.responder = responder;
	}
	
	public boolean discover() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("(P)ergunta, (M)ovimento ou (F)im? ");
		String tipo = scanner.nextLine();
		while (!tipo.equalsIgnoreCase("F")) {
		   System.out.print("  --> ");
		   String pc = scanner.nextLine();
		   switch (tipo.toUpperCase()) {
		      case "P": String resposta = responder.ask(pc);
		                System.out.println("  Resposta: " + resposta);
		                break;
		      case "M": boolean moveu = responder.move(pc);
		                System.out.println((moveu)?"  Movimento executado!":"Não é possível mover");
		                break;
		   }
			System.out.print("(P)ergunta, (M)ovimento ou (F)im? ");
			tipo = scanner.nextLine();
		}
		
		if (responder.finalAnswer("cheguei"))
			System.out.println("Você encontrou a saida!");
		else
			System.out.println("Fuém fuém fuém!");
		
		scanner.close();
		
		return true;
	}
	
}
