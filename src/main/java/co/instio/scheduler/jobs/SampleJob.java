package co.instio.scheduler.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class SampleJob implements Job {

    public void execute(JobExecutionContext var1) throws JobExecutionException{
        log.error("Executing the trigger job..............!");
        throw new JobExecutionException("Executing successfully....");

    }
}
