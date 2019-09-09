package org.csu.travel.service.serviceImp;

import org.csu.travel.domain.Application;
import org.csu.travel.persistence.ApplicationMapper;
import org.csu.travel.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ApplicationServiceImp implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public void addApplication(Application application) {
        applicationMapper.addApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
        applicationMapper.updateApplication(application);
    }

    @Override
    public void updateAudit(Application application) {
        applicationMapper.updateAudit(application);
    }

    @Override
    public void updateGenAudit(Application application) {
        applicationMapper.updateGenAudit(application);
    }

    @Override
    public List<Application> getApplicationListByUser(int userId) {
        return applicationMapper.getApplicationListByUser(userId);
    }

    @Override
    public Application getApplication(int applicationId) {
        return applicationMapper.getApplication(applicationId);
    }

    @Override
    public List<Application> getApplicationByDepartment(String department) {
        return applicationMapper.getApplicationListByDepartment(department);
    }

    @Override
    public List<Application> getDoneApplicationListByUser(int userId) {
        return applicationMapper.getDoneApplicationListByUsername(userId);
    }

    @Override
    public List<Application> getApplicationByTime(Date start, Date end) {
        return applicationMapper.getApplicationListByTime(start, end);
    }


}
