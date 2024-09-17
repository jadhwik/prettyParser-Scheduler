package co.instio.scheduler.service.scheduler;

import co.instio.scheduler.entity.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ocpsoft.prettytime.nlp.PrettyTimeParser;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleJob {

    private final Scheduler scheduler;

    public void schedule(Schedule schedule) {
        try {
            // Create job detail
            JobDetail jobDetail = createJobDetails(schedule);

            // Create trigger
            Trigger trigger = createTrigger(jobDetail, schedule);

            // Schedule the job with the trigger
            scheduler.scheduleJob(jobDetail, trigger);
            log.info("Job scheduled with name: {}", schedule.getJobName());

        } catch (Exception e) {
            log.error("Error scheduling job", e);
        }
    }

    public List<Date> parseDate(String timeSentence) {
        PrettyTimeParser parser = new PrettyTimeParser();
        return parser.parse(timeSentence);
    }

    public JobDetail createJobDetails(Schedule schedule) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobName", schedule.getJobName());
        jobDataMap.put("description", schedule.getSchedule());

        return JobBuilder.newJob()
                .withIdentity(UUID.randomUUID().toString(), "jobName")
                .withDescription("Simple job description")
                .storeDurably()
                .usingJobData(jobDataMap)
                .build();
    }

    public Trigger createTrigger(JobDetail jobDetail, Schedule schedule) {
        sch

        return TriggerBuilder.newTrigger()
                .withIdentity(jobDetail.getKey().getName(), "simple jobs")
                .withDescription("Trigger for sample job")
                .forJob(jobDetail)
                .startAt(triggerDate)
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0)) // Adjust the schedule as needed
                .build();
    }
}
