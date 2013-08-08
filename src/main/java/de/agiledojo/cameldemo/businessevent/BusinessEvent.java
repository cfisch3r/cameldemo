package de.agiledojo.cameldemo.businessevent;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

/**
 * Base class for business events stored in database
 * 
 * @author cfisch3r
 * 
 */
@Document
public abstract class BusinessEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;

	@BusinessKey
	protected String origin;

	@BusinessKey
	protected Date created;

	protected BusinessEvent(String origin) {
		this.origin = origin;
		this.created = Calendar.getInstance().getTime();
	}

	public ObjectId getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public String getOrigin() {
		return origin;
	}

	@Override
	public boolean equals(Object obj) {
		return BusinessIdentity.areEqual(this, obj);
	}

}