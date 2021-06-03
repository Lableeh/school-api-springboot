package io.javabrains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USEREXTENSION")
public class Userextension {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "DEPO_AO_ACCOUNTS")
    private String depositAccountOpeningTotalAccount;

    @Column(name = "VOCALINK_HIDE_POPUP_FLAG")
    private String vocalinkHidePopupFlag;

    @Column(name = "DEPO_AO_LAST_OPEN_DATE")
    private String depositAccountOpeningLastModifiedDate;

    @Column(name = "DEPO_AO_LAST_OPEN_DAILY_COUNT")
    private String depositAccountOpeningTotalDailyAccount;

    @Column(name = "PREF_SKIN_DISABLE")
    private String preferredSkinDisable;

    @Column(name = "ACCOUNT_LOCKED")
    private String lockStatus;
}
