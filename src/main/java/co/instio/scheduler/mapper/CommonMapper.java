package co.instio.scheduler.mapper;

import co.instio.scheduler.dto.ScheduleDto;
import co.instio.scheduler.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper
public interface CommonMapper {

    ScheduleDto toDto(Schedule schedule);
}
