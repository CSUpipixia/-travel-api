package org.csu.travel.controller.WXController;

import org.csu.travel.annotation.Authorize;
import org.csu.travel.domain.Application;
import org.csu.travel.service.AccountService;
import org.csu.travel.service.ApplicationService;
import org.csu.travel.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Authorize
@RestController
public class WXUserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ReimburseService reimburseService;

    @GetMapping("/pages/applicationdetails/index")
    public Application application(@PathVariable("applicationId") int applicationId) {
        return applicationService.getApplication(applicationId);
    }

    @PostMapping("/apply")
    public void addApplication(@RequestBody Application application) {
        applicationService.addApplication(application);
    }

    @GetMapping("/pages/applications")
    public List<Application> applications(@PathVariable("userId") int userId) {
        return applicationService.getApplicationListByUser(userId);
    }

    @GetMapping("/pages/doneApplications")
    public List<Application> doneApplications(@PathVariable("userId") int userId) {
        return applicationService.getDoneApplicationListByUser(userId);
    }

    @GetMapping("/pages/application")
    public List<Application> departmentApplications(@PathVariable("department") String department) {
        return applicationService.getApplicationByDepartment(department);
    }

//    @RequestMapping("/")
//    public List<Application> timeApplications()

    @PostMapping("/pages/updateApplication")
    public void updateApplication(@RequestBody Application application) {
        applicationService.updateApplication(application);
    }

    @PostMapping("/pages/updateAudit")
    public  void updateAudit(@RequestBody Application application) {
        applicationService.updateAudit(application);
    }

    @PostMapping("/pages/updateGenAudit")
    public  void updateGenAudit(@RequestBody Application application) {
        applicationService.updateGenAudit(application);
    }
}
