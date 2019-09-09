package org.csu.travel.service;

import org.csu.travel.domain.Reimbursement;

import java.util.List;

public interface ReimburseService {
    //新增报销申请
    void addReimbursement(Reimbursement reimbursement);

    //删除报销申请
    void deleteReimbursement(Reimbursement reimbursement);

    //更新报销申请
    void updateReimbursement(Reimbursement reimbursement);

    //得到报销项
    Reimbursement getReimbursementsByApplicationIdAndPicture(Reimbursement reimbursement);

    //根据报销编号得到报销项
    List<Reimbursement> getReimbursementsByApplicationId(int applicationId);

    //根据报销人编号得到报销项
    List<Reimbursement> getReimbursementsByApplicantId(int applicantId);

    //根据状态得到报销项
    List<Reimbursement> getReimbursementsByStatus(int status);
}
