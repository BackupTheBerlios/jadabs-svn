package sip;

import java.util.Iterator;
import java.util.Vector;

/*
 * Created on Nov 29, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author franz
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class UserList {

	private Vector users;
	
//	public UserList(Vector users) {
//		this.users = users;
//	}
	
	public void addUser (User user) {
		users.addElement(user);
	}
	
	public Vector getUsers(){
		return users;
	}
	
	public User getUserbyName(String name) {
		Iterator i = users.iterator();
		while (i.hasNext()) {
			User u = (User)i.next();
			if (u.getName().equalsIgnoreCase(name)) {
				return u;
			}
		}
		return null;
	}
	
	public void getFromFile(String fileName) {
		XMLBuddyParser parser = new XMLBuddyParser(fileName);
		parser.parse();
		users = parser.getBuddies();
	}
	
	public String getXMLTag() {
		StringBuffer sb = new StringBuffer();
//		sb.append("<?xml version='1.0' encoding='us-ascii'?> ");
		sb.append("<BUDDIES>\n");
		Iterator i = users.iterator();
		while (i.hasNext()) {
			sb.append(((User)i.next()).getXMLTag());
		}
		sb.append("</BUDDIES>");
//		IMUtilities.writeFile(sb.toString(), fileName);
		return sb.toString();
	}
	
	public String toString() {
		return getXMLTag();
	}
}