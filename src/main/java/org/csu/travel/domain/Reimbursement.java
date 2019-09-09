package org.csu.travel.domain;

public class Reimbursement {

    private int applicationId;
    private String picture;
    private int applicantId;
    private String applicantName;
    private int auditorId;
    private String auditorName;
    private String audit;
    private String auditSuggest;
    private int genAuditorId;
    private String genAuditorName;
    private String genAudit;
    private String genSuggest;
    private String status;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public int getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(int auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getAuditSuggest() {
        return auditSuggest;
    }

    public void setAuditSuggest(String auditSuggest) {
        this.auditSuggest = auditSuggest;
    }

    public int getGenAuditorId() {
        return genAuditorId;
    }

    public void setGenAuditorId(int genAuditorId) {
        this.genAuditorId = genAuditorId;
    }

    public String getGenAuditorName() {
        return genAuditorName;
    }

    public void setGenAuditorName(String genAuditorName) {
        this.genAuditorName = genAuditorName;
    }

    public String getGenAudit() {
        return genAudit;
    }

    public void setGenAudit(String genAudit) {
        this.genAudit = genAudit;
    }

    public String getGenSuggest() {
        return genSuggest;
    }

    public void setGenSuggest(String genSuggest) {
        this.genSuggest = genSuggest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
