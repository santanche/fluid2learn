package pt.c01interfaces.s01knowledge.s02app.app;

import pt.c01interfaces.s01knowledge.s01base.impl.BaseConhecimento;
import pt.c01interfaces.s01knowledge.s01base.impl.Statistics;
import pt.c01interfaces.s01knowledge.s01base.inter.IBaseConhecimento;
import pt.c01interfaces.s01knowledge.s01base.inter.IEnquirer;
import pt.c01interfaces.s01knowledge.s01base.inter.IResponder;
import pt.c01interfaces.s01knowledge.s01base.inter.IStatistics;
import pt.c01interfaces.s01knowledge.s02app.actors.Enquirer;
import pt.c01interfaces.s01knowledge.s02app.actors.Responder;

public class Orchestrator
{
	public static void main(String[] args)
	{
		IBaseConhecimento base = new BaseConhecimento();
		String listaAnimais[] = base.listaNomes();

		IEnquirer enq;
		IResponder resp;
		IStatistics stat;
		
        for (int animal = 0; animal < listaAnimais.length; animal++) {
			System.out.println("Enquirer com " + listaAnimais[animal] + "...");
			stat = new Statistics();
			enq = new Enquirer();
			resp = new Responder(stat, listaAnimais[animal]);
			enq.connect(resp);
			System.out.println("----------------------------------------------------------------------------------------\n");
        }		
	}
}
