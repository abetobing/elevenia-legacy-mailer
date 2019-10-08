package id.co.elevenia.legacy.mailer.dto;

import java.time.Instant;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

public class MailRequestDTO {

	@Column(name = "TITLE")
	public String title;
	
	@Column(name = "NAME")
	public String name;

	@Column(name = "TID")
	public Long tid;
	
//	@Column(name = "LEGACYID")
//	private String legacyId;
//	
//	@Column(name = "AUTOTYPE")
//	private String type = "200";
//	
	@Column(name = "EMAIL")
	public String email;
	
	@CreationTimestamp
    @Type(type = "oracle_date")
	@Column(name = "SENDTIME")
	public Instant sendDate;  // when should be sent
		
	@Column(name = "CMPNCODE")
	public Long campaignCode = 10005l;
	
	public String[] param;

}
