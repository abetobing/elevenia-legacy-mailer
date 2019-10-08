package id.co.elevenia.legacy.mailer.domain.netpathy;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOMAIL_INTERFACE_PARAM", schema = "NETPATHY")
public class AutomailParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -561613691654729688L;
	
	public AutomailParam() {
		
	}
	
	public AutomailParam(Long autoCode, String param) {
		setAutoCode(autoCode);
		setParam(param);
	}
	
	public AutomailParam(AutomailUser user, String param) {
		setUser(user);
		setParam(param);
	}

	public AutomailParam(String param) {
		setParam(param);
	}

	@Id
	@Column(name = "AUTOCODE")
	private Long autoCode;
	
	@Column(name = "PARAM")
	private String param;
	
	@OneToOne
	@JoinColumn(name = "AUTOCODE", referencedColumnName = "AUTOCODE")
	@MapsId
	private AutomailUser user;

	public Long getAutoCode() {
		return autoCode;
	}

	public void setAutoCode(Long autoCode) {
		this.autoCode = autoCode;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public AutomailUser getUser() {
		return user;
	}

	public void setUser(AutomailUser user) {
		this.user = user;
	}

}
