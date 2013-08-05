package de.agiledojo.cameldemo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Event on login of a user
 * 
 * @author cfisch3r
 * 
 */
@Document
public class LoginBusinessEvent {
	@Id
	private ObjectId id;

	private String userId;

	private Date created;

	public LoginBusinessEvent(String userId, Date created) {
		this.userId = userId;
		this.created = created;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
