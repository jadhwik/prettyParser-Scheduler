package co.instio.scheduler.service;

import co.instio.scheduler.dto.ScheduleDto;
import co.instio.scheduler.entity.Schedule;

public interface SchedulerService {

    ScheduleDto createSchedule(Schedule schedule);
    ScheduleDto getById(Long id);
}
