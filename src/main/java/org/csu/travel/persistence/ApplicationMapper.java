package org.csu.travel.persistence;

import org.csu.travel.domain.Application;

import java.sql.Date;
import java.util.List;

public interface ApplicationMapper {

    void addApplication(Application application);

    void updateApplication(Application application);

    void updateAudit(Application application);

    void updateGenAudit(Application application);

    Application getApplication(int applicationId);

    List<Application> getApplicationListByUser(int userId);

    List<Application> getApplicationListByDepartment(String department);

    List<Application> getDoneApplicationListByUsername(int username);

    List<Application> getApplicationListByTime(Date start, Date end);

}