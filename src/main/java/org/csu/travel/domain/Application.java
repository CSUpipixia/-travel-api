package org.csu.travel.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class Application {

    private int application_id;
    private int applicant_id;
    private String applicant_name;
    private String applicant_position;
    private String applicant_department;
    private String participant;
    private Date applyDate;
    private Date startDate;
    private int duration;
    private String origin;
    private String destination;
    private BigDecimal trans_cost;
    private BigDecimal hotel_cost;
    private String reason;
    private int auditorId;
    private String auditorName;
    private String audit;
    private String auditSuggest;
    private int genAuditorId;
    private String genAuditorName;
    private String genAudit;
    private String genSuggest;
    private String status;


    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getParticipant() {
        return participant;
    }

    public void setPaticipant(String paticipant) {
        this.participant = paticipant;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getTrans_cost() {
        return trans_cost;
    }

    public void setTrans_cost(BigDecimal trans_cost) {
        this.trans_cost = trans_cost;
    }

    public BigDecimal getHotel_cost() {
        return hotel_cost;
    }

    public void setHotel_cost(BigDecimal hotel_cost) {
        this.hotel_cost = hotel_cost;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getApplicant_department() {
        return applicant_department;
    }

    public void setApplicant_department(String applicant_department) {
        this.applicant_department = applicant_department;
    }

    public String getApplicant_position() {
        return applicant_position;
    }

    public void setApplicant_position(String applicant_position) {
        this.applicant_position = applicant_position;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
