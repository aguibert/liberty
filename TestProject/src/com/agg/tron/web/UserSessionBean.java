package com.agg.tron.web;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
@LocalBean
public class UserSessionBean {
	
	private boolean loggedIn = false;

	private String displayName;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
