package pe.interbank.rss.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class PruebaTest {

	//@Ignore
    @Test
    public void RSSE07WD(){
    	
        try {
            CommandLineJobRunner cljr = new CommandLineJobRunner();
            String[] args=new String[4];
            args[0] = "pe.interbank.rss.test.job.RssBatchConfiguration";
            args[1] = "RSSE07WD";
            args[2] = "LOCALPATHIN=D:\\Out\\07W\\";
            args[3] = "LOCALPATHOUT=D:\\Out\\07W\\";
            
            cljr.main(args);
            
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    }	 
	
}
