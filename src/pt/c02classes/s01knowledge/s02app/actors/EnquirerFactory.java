package pt.c02classes.s01knowledge.s02app.actors;

import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirerFactory;
import pt.c02classes.s01knowledge.s01base.inter.IObjetoConhecimento;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;

public class EnquirerFactory implements IEnquirerFactory
{
	public EnquirerFactory()
	{
	}

	public IEnquirer createEnquire(IResponder responder) {
		String scenario = responder.scenario();
		IEnquirer theEnquirer = null;
		
		switch (scenario) {
		case "animals" : theEnquirer = new EnquirerAnimals(); break;
		case "maze"    : theEnquirer = new EnquirerMaze(); break;
		}
		
		return theEnquirer;
	}
	
	
}
