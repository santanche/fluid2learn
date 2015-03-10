package pt.c02classes.s01knowledge.s02app.app;

import pt.c02classes.s01knowledge.s01base.impl.Statistics;
import pt.c02classes.s01knowledge.s01base.inter.IEnquirer;
import pt.c02classes.s01knowledge.s01base.inter.IResponder;
import pt.c02classes.s01knowledge.s01base.inter.IStatistics;
import pt.c02classes.s01knowledge.s02app.actors.EnquirerMaze;
import pt.c02classes.s01knowledge.s02app.actors.ResponderMaze;

public class OrchestratorInteractive
{
	public static void main(String[] args)
	{
		IEnquirer enq;
		IResponder resp;
		IStatistics stat;
		
		System.out.println("Enquirer com Mordor...");
		stat = new Statistics();
		resp = new ResponderMaze(stat, "mordor");
		enq = new EnquirerMaze();
		enq.connect(resp);
		enq.discover();
		System.out.println("----------------------------------------------------------------------------------------\n");
	}
}
