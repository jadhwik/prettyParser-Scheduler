package co.instio.scheduler.repo;

import co.instio.scheduler.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepo extends JpaRepository<Schedule,Long> {
}
