package io.javabrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Entity
@Table(name = "USEROBJECT")
@Data
public class User {

    @Id
    @Size(max = 20)
    private String userId;

    @NotNull
    @Size(max = 20)
    private String rmNumber;

    @Size(max = 50)
    private String firstName;

    @Size(max = 25)
    private String middleName;

    @Size(max = 50)
    private String lastName;

    @Size(max = 50)
    private String emailAddress;

    private String address;

    @Column(name = "TEL_NUMBER")
    @Size(max = 20)
    private String telephoneNumber;

    @Column(name = "TEL_EXTENSION")
    @Size(max = 20)
    private String telephoneExtension;

    @Size(max = 10)
    private String accessType;

    private Integer accountStatus;

    @Column(name = "THRESHOLD_BP")
    private BigDecimal thresholdBP;

    @Column(name = "THRESHOLD_FT")
    private BigDecimal thresholdFT;

    @Column(name = "THRESHOLD_FA")
    private BigDecimal thresholdFA;

    @NotNull
    private Character emailNotificationFlag;

    @NotNull
    private Character otpStatus;

    @NotNull
    private Character surveySent;

    @Column(name = "CHGPWD")
    private String changePassword;

    @Column(name = "CHGPWD_DATE")
    private Date changePasswordDate;

    @Column(name = "LAST_BAD_ATTEMPT_DATE")
    private Date lastBadAttemptDate;

    @Column(name = "LAST_LOG_DATE")
    private Date lastLogDate;

    @Column(name = "LAST_LOG_HOSTNAME")
    private String lastLogHostname;

    @Column(name = "IPADDRESS")
    private String ipAddress;

    @Column(name = "IPADDRESS_BADATTEMPTS")
    private String ipAddressBadAttempts;

    private Integer attempts;

    @Column(name = "ECFLAG")
    @Size(max = 2)
    private String exclusiveClientFlag;

    @Column(name = "RSA_ID")
    @Size(max = 128)
    private String rsaId;

    @Column(name = "RSA_REGISTERED_FLAG")
    private Character rsaRegisteredFlag;

    @Column(name = "SECURITY_LEVEL")
    private Integer securityLevel;
}
