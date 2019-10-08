package id.co.elevenia.legacy.mailer.domain.netpathy;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import id.co.elevenia.legacy.mailer.usertype.OracleDate;

@Entity
@Table(name = "AUTOMAIL_INTERFACE_USER", schema = "NETPATHY")
@TypeDefs(
	    value = @TypeDef(
	        name = "oracle_date", 
	        typeClass = OracleDate.class
	    )
	)
public class AutomailUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -429706024689230847L;
	
	@Id
	@Column(name = "AUTOCODE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AUTOMAIL")
	@SequenceGenerator(name = "SEQ_AUTOMAIL", sequenceName = "SEQ_AUTOMAIL", allocationSize = 1)
	private Long autoCode;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "TID")
	private Long tid;
	
	@Column(name = "LEGACYID")
	private String legacyId;
	
	@Column(name = "AUTOTYPE")
	private String type = "200";
	
	@Column(name = "EMAIL")
	private String email;
	
	@CreationTimestamp
    @Type(type = "oracle_date")
	@Column(name = "INSERTDATE", updatable = false)
	private Instant insertDate;
	
	@CreationTimestamp
    @Type(type = "oracle_date")
	@Column(name = "SENDTIME")
	private Instant sendDate;  // when should be sent
	
	@Column(name = "SENDYN")
	private String isSent = "N";
	
	@Column(name = "CMPNCODE")
	private Long campaignCode = 10005l;
	
	@Column(name = "OPENTIME")
	private Instant openDate;
	
	@Column(name = "SENTTIME")
	private Instant sentDate;  // when actually sent by system
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn(name="AUTOCODE", referencedColumnName="AUTOCODE")
	private AutomailParam param;

	public Long getAutoCode() {
		return autoCode;
	}

	public void setAutoCode(Long autoCode) {
		this.autoCode = autoCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getLegacyId() {
		return legacyId;
	}

	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Instant insertDate) {
		this.insertDate = insertDate;
	}

	public Instant getSendDate() {
		return sendDate;
	}

	public void setSendDate(Instant sendDate) {
		this.sendDate = sendDate;
	}

	public String getIsSent() {
		return isSent;
	}

	public void setIsSent(String isSent) {
		this.isSent = isSent;
	}

	public Long getCampaignCode() {
		return campaignCode;
	}

	public void setCampaignCode(Long campaignCode) {
		this.campaignCode = campaignCode;
	}

	public Instant getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Instant openDate) {
		this.openDate = openDate;
	}

	public Instant getSentDate() {
		return sentDate;
	}

	public void setSentDate(Instant sentDate) {
		this.sentDate = sentDate;
	}

	public AutomailParam getParam() {
		return param;
	}

	public void setParam(AutomailParam param) {
		this.param = param;
	}

}