package com.agg.tron.web;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.agg.tron.db.TronUser;

@Stateless
public class DatabaseBean {
	
	@PersistenceContext(unitName = "UserPU")
	EntityManager em;
	
	public String getPlayerName(String email) {
		TronUser user = em.find(TronUser.class, email);
		
		if(user == null) {
			System.out.println("User " + email + " was not found in db.");
			return null;
		} else {
			System.out.println("User " + email + " has name " + user.getDisplayName());
			return user.getDisplayName();
		}
	}
	
	public boolean registerPlayer(String userID, String displayName) {
		TronUser u = new TronUser();
		u.setUserID(userID);
		u.setDisplayName(displayName);
		try {
			em.persist(u);
			return true;
		} catch (EntityExistsException e) {
			System.out.println("User " + userID + " was already registered in the database.");
			return false;
		}
	}
}
