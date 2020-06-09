package pe.interbank.rss.core;

import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;

public class RssBatchScheduler {
	@Bean 
	public JobRepository jobRepository() throws Exception{
	    MapJobRepositoryFactoryBean factoryBean = new MapJobRepositoryFactoryBean(new ResourcelessTransactionManager());
	    factoryBean.afterPropertiesSet();
	    return (JobRepository) factoryBean.getObject();
	}
	@Bean
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
    SimpleJobLauncher launcher = new SimpleJobLauncher();
    launcher.setJobRepository(jobRepository);
    return launcher;
	}
}
