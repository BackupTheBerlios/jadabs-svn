package clienttest;


import sip.SIPUserAgentClient;
import sip.SIPUserAgentListener;

import java.util.Vector;

import javax.sip.ResponseEvent;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/*
 * Created on Nov 23, 2004
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
public class TestClient2 implements SIPUserAgentListener {

	static Logger logger = Logger.getLogger(TestClient2.class);
	/* (non-Javadoc)
	 * @see SIPUserAgentListener#processRegister(javax.sip.ResponseEvent)
	 */
	public void processRegister(ResponseEvent e) {
		//logger.debug(e.getResponse());
	}

	
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.DEBUG);
		
		logger.info("Client Started");
		
		SIPUserAgentClient sipUAClient = new SIPUserAgentClient();
		sipUAClient.setLocalPort(5066);
		sipUAClient.setLocalUserName("chris");
		sipUAClient.setLocalDomain("127.0.0.1:5066");
		TestClient2 test = new TestClient2();
		
		sipUAClient.addSIPUserAgentListener(test);
		sipUAClient.start();
		
		sipUAClient.getSIPInviteClient().invite("sip:franz@127.0.0.1:5062");
	
//		UserList users = new UserList();
//		users.getFromFile("bundles/im-client/src/buddies.xml");
		
//		logger.debug(((User)buddies.iterator().next()).getName());
//		logger.debug((((User)buddies.iterator().next()).getSIPAddresses().iterator().next()).toString());
		
//		logger.debug(users.getUsers().iterator().next());
		
//		logger.debug(users);
	}



	/* (non-Javadoc)
	 * @see SIPUserAgentListener#processMessage()
	 */
	public void processMessage() {
		// TODO Auto-generated method stub
		
	}



	/* (non-Javadoc)
	 * @see SIPUserAgentListener#processNotify()
	 */
	public void processNotify() {
		// TODO Auto-generated method stub
		
	}



	/* (non-Javadoc)
	 * @see SIPUserAgentListener#processSubscribe()
	 */
	public void processSubscribe() {
		// TODO Auto-generated method stub
		
	}
}
