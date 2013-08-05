package de.agiledojo.cameldemo;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

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

	@BusinessKey
	private String userId;

	@BusinessKey
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

	@Override
	public boolean equals(Object obj) {
		return BusinessIdentity.areEqual(this, obj);
	}

}
