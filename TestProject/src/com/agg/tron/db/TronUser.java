package com.agg.tron.db;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
public class TronUser implements Serializable {

	private static final long serialVersionUID = -8248080091920360864L;
	
	@Id
	private String userID;
	private String displayName;
	
	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}   
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
   
	public String toString() {
		return TronUser.class.getSimpleName() + "[userID=" + userID + ", displayName=" + displayName + "]";
	}
}
