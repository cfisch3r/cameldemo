package de.agiledojo.cameldemo.businessevent;

import com.openpojo.business.annotation.BusinessKey;

/**
 * Event on login of a user
 * 
 * @author cfisch3r
 * 
 */
public class LoginBusinessEvent extends BusinessEvent {

	private static final long serialVersionUID = 1L;

	@BusinessKey
	private String userId;

	public LoginBusinessEvent(String origin, String userId) {
		super(origin);
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
