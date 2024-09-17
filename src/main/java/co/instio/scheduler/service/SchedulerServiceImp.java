package co.instio.scheduler.service;

import co.instio.scheduler.dto.ScheduleDto;
import co.instio.scheduler.entity.Schedule;
import co.instio.scheduler.enums.CommonErrorCodeEnum;
import co.instio.scheduler.exceptions.ServiceException;
import co.instio.scheduler.mapper.CommonMapper;
import co.instio.scheduler.repo.SchedulerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulerServiceImp implements SchedulerService {

    private final SchedulerRepo repo;
    private final CommonMapper mapper;

    @Override
    public ScheduleDto createSchedule(Schedule schedule){
        if(schedule == null ){
            log.error("NO data for creation!");
            throw new ServiceException(CommonErrorCodeEnum.BAD_REQUEST);
        }
        Schedule savedDetails = repo.save(schedule);
        return  mapper.toDto(savedDetails);
    }

    @Override
    public ScheduleDto getById(Long id){
        Schedule schedule = repo.findById(id).orElse(null);
        if(schedule == null){
            log.error("No data found!");
            throw new ServiceException(CommonErrorCodeEnum.NO_CONTENT);
        }
        return mapper.toDto(schedule);
    }
}
