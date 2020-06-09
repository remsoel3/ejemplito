package pe.interbank.rss.test.tasklets;

import java.util.Map;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class PasoDosTasklet implements Tasklet{
	@Override
	 public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
			Map<String, Object> jobParameters = chunkContext.getStepContext().getJobParameters();
			
			String LOCALPATHIN	= (String)jobParameters.get("LOCALPATHIN");
	    	String LOCALPATHOUT	= (String)jobParameters.get("LOCALPATHOUT");
	    	
	    	//AQUI ESCRIBIMOS EL CODIGO REQUERIDO
	    	System.out.println(LOCALPATHIN+LOCALPATHOUT);
			return RepeatStatus.FINISHED;
			}

}
