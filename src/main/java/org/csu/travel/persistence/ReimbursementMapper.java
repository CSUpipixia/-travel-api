package org.csu.travel.persistence;

import org.csu.travel.domain.Reimbursement;

import java.util.List;

public interface ReimbursementMapper {

    void addReimbursement(Reimbursement reimbursement);

    void deleteReimbursement(Reimbursement reimbursement);

    void updateAudit(Reimbursement reimbursement);

    void updateGenAudit(Reimbursement reimbursement);

    Reimbursement getReimbursementsByApplicationIdAndPicture(Reimbursement reimbursement);

    List<Reimbursement> getReimbursementsByApplicationId(int applicationId);

    List<Reimbursement> getReimbursementsByApplicantId(int applicantId);

    List<Reimbursement> getReimbursementsByStatus(int status);

}
