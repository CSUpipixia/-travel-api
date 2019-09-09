package org.csu.travel.service.serviceImp;

import org.csu.travel.domain.Reimbursement;
import org.csu.travel.persistence.ReimbursementMapper;
import org.csu.travel.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimburseServiceImp implements ReimburseService {

    @Autowired
    private ReimbursementMapper reimbursementMapper;

    @Override
    public void addReimbursement(Reimbursement reimbursement) {
        reimbursementMapper.addReimbursement(reimbursement);
    }

    @Override
    public void deleteReimbursement(Reimbursement reimbursement) {
        reimbursementMapper.deleteReimbursement(reimbursement);
    }

    @Override
    public void updateReimbursement(Reimbursement reimbursement) {
        if (reimbursement.getAuditorName() != null) {
            reimbursementMapper.updateAudit(reimbursement);
        } else if (reimbursement.getGenAuditorName() != null) {
            reimbursementMapper.updateGenAudit(reimbursement);
        }
    }

    @Override
    public Reimbursement getReimbursementsByApplicationIdAndPicture(Reimbursement reimbursement) {
        return reimbursementMapper.getReimbursementsByApplicationIdAndPicture(reimbursement);
    }

    @Override
    public List<Reimbursement> getReimbursementsByApplicationId(int applicationId) {
        return reimbursementMapper.getReimbursementsByApplicationId(applicationId);
    }

    @Override
    public List<Reimbursement> getReimbursementsByApplicantId(int applicantId) {
        return reimbursementMapper.getReimbursementsByApplicantId(applicantId);
    }

    @Override
    public List<Reimbursement> getReimbursementsByStatus(int status) {
        return reimbursementMapper.getReimbursementsByStatus(status);
    }
}
