package pe.interbank.rss.test.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pe.interbank.rss.core.RssBatchScheduler;
import pe.interbank.rss.test.tasklets.PasoDosTasklet;
import pe.interbank.rss.test.tasklets.PasoUnoTasklet;

@Configuration
@EnableBatchProcessing
@Import(RssBatchScheduler.class)
public class RssBatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public SimpleJobLauncher jobLauncher;
	
	@Bean(name = "RSSE07WD")
	public Job jobPasos(Step stepPasoUno, Step stepPasoDos) {
	  return jobBuilderFactory.get("RSSE07WD")
	           .start(stepPasoUno)
	           .next(stepPasoDos)
	            .build();
	    }
	
	 @Bean
	    public Step stepPasoUno(){
	    	PasoUnoTasklet paso1 = new PasoUnoTasklet();
	        return stepBuilderFactory.get("paso1")
	        	.tasklet(paso1)
	            .build();
	    }
	 
	 @Bean
	    public Step stepPasoDos(){
	    	PasoDosTasklet paso2 = new PasoDosTasklet();
	        return stepBuilderFactory.get("paso2")
	        	.tasklet(paso2)
	            .build();
	    }
	
}
