package com.bam.bamcoreport.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Table
@Entity
public class Reject {
    @Id
    @SequenceGenerator(name = "reject_seq", sequenceName = "reject_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reject_seq")
    private Long id;
    private String flowType; //debiteur ou créditeur
    private String rejectNature; //urgent ..
    private String entity;// nom de banque
    private LocalDate declarationDate;
    private String agencyCode;
    private Long userRegistrationNumber;
    private String bu;
    private String su;
    private String regionalDelegation;
    private String subDelegationType;
    private String subDelegationName;
    private Long cliFileCode;
    private Long clientCode;
    private Long  Rib;
    private String gravity;//low or height
    private Long zoneCode;
    private boolean isWrongField;
    private String errorCode;
    private String errorLabel;
    private boolean isRequestTaken;//false if is ot yet affected
    private String actionDetail;
    private File file;
    @OneToOne(targetEntity = Reject.class,cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users TakenBy;

    public Reject() {
    }

    public Reject(Long id, String flowType, String rejectNature, String entity, LocalDate declarationDate, String agencyCode, Long userRegistrationNumber, String bu, String su, String regionalDelegation, String subDelegationType, String subDelegationName, Long cliFileCode, Long clientCode, Long rib, String gravity, Long zoneCode, Boolean isWrongField, String errorCode, String errorLabel, Boolean isRequestTaken, String actionDetail, File file, Users takenBy) {
        this.id = id;
        this.flowType = flowType;
        this.rejectNature = rejectNature;
        this.entity = entity;
        this.declarationDate = declarationDate;
        this.agencyCode = agencyCode;
        this.userRegistrationNumber = userRegistrationNumber;
        this.bu = bu;
        this.su = su;
        this.regionalDelegation = regionalDelegation;
        this.subDelegationType = subDelegationType;
        this.subDelegationName = subDelegationName;
        this.cliFileCode = cliFileCode;
        this.clientCode = clientCode;
        Rib = rib;
        this.gravity = gravity;
        this.zoneCode = zoneCode;
        this.isWrongField = isWrongField;
        this.errorCode = errorCode;
        this.errorLabel = errorLabel;
        this.isRequestTaken = isRequestTaken;
        this.actionDetail = actionDetail;
        this.file = file;
        TakenBy = takenBy;
    }

    public Reject(String flowType, String rejectNature, String entity, LocalDate declarationDate, String agencyCode, Long userRegistrationNumber, String bu, String su, String regionalDelegation, String subDelegationType, String subDelegationName, Long cliFileCode, Long clientCode, Long rib, String gravity, Long zoneCode, Boolean isWrongField, String errorCode, String errorLabel, Boolean isRequestTaken, String actionDetail, File file, Users takenBy) {
        this.flowType = flowType;
        this.rejectNature = rejectNature;
        this.entity = entity;
        this.declarationDate = declarationDate;
        this.agencyCode = agencyCode;
        this.userRegistrationNumber = userRegistrationNumber;
        this.bu = bu;
        this.su = su;
        this.regionalDelegation = regionalDelegation;
        this.subDelegationType = subDelegationType;
        this.subDelegationName = subDelegationName;
        this.cliFileCode = cliFileCode;
        this.clientCode = clientCode;
        Rib = rib;
        this.gravity = gravity;
        this.zoneCode = zoneCode;
        this.isWrongField = isWrongField;
        this.errorCode = errorCode;
        this.errorLabel = errorLabel;
        this.isRequestTaken = isRequestTaken;
        this.actionDetail = actionDetail;
        this.file = file;
        TakenBy = takenBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getRejectNature() {
        return rejectNature;
    }

    public void setRejectNature(String rejectNature) {
        this.rejectNature = rejectNature;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public LocalDate getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(LocalDate declarationDate) {
        this.declarationDate = declarationDate;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public Long getUserRegistrationNumber() {
        return userRegistrationNumber;
    }

    public void setUserRegistrationNumber(Long userRegistrationNumber) {
        this.userRegistrationNumber = userRegistrationNumber;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getRegionalDelegation() {
        return regionalDelegation;
    }

    public void setRegionalDelegation(String regionalDelegation) {
        this.regionalDelegation = regionalDelegation;
    }

    public String getSubDelegationType() {
        return subDelegationType;
    }

    public void setSubDelegationType(String subDelegationType) {
        this.subDelegationType = subDelegationType;
    }

    public String getSubDelegationName() {
        return subDelegationName;
    }

    public void setSubDelegationName(String subDelegationName) {
        this.subDelegationName = subDelegationName;
    }

    public Long getCliFileCode() {
        return cliFileCode;
    }

    public void setCliFileCode(Long cliFileCode) {
        this.cliFileCode = cliFileCode;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public Long getRib() {
        return Rib;
    }

    public void setRib(Long rib) {
        Rib = rib;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public Long getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(Long zoneCode) {
        this.zoneCode = zoneCode;
    }

    public Boolean getWrongField() {
        return isWrongField;
    }

    public void setWrongField(Boolean wrongField) {
        isWrongField = wrongField;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel = errorLabel;
    }

    public Boolean getRequestTaken() {
        return isRequestTaken;
    }

    public void setRequestTaken(Boolean requestTaken) {
        isRequestTaken = requestTaken;
    }

    public String getActionDetail() {
        return actionDetail;
    }

    public void setActionDetail(String actionDetail) {
        this.actionDetail = actionDetail;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Users getTakenBy() {
        return TakenBy;
    }

    public void setTakenBy(Users takenBy) {
        TakenBy = takenBy;
    }
}
