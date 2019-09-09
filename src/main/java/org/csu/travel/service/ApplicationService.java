package org.csu.travel.service;

import org.csu.travel.domain.Application;

import java.sql.Date;
import java.util.List;

public interface ApplicationService {

    //添加申请项
    void addApplication(Application application);

    //更新申请项
    void updateApplication(Application application);

    //更新一审状态
    void updateAudit(Application application);

    //更新二审状态
    void updateGenAudit(Application application);

    //根据用户名找到其所有申请项
    List<Application> getApplicationListByUser(int userId);

    //找到某项申请项
    Application getApplication(int applicationId);

    //根据部门得到其下所有申请
    List<Application> getApplicationByDepartment(String department);

    //查询已经完成的申请项
    List<Application> getDoneApplicationListByUser(int userId);

    //查询时间段内的申请项
    List<Application> getApplicationByTime(Date start, Date end);
}
