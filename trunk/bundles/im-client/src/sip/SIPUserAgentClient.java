package sip;

import java.util.Properties;
import java.util.Vector;

import javax.sip.ClientTransaction;
import javax.sip.ListeningPoint;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.SipFactory;
import javax.sip.SipListener;
import javax.sip.SipProvider;
import javax.sip.SipStack;
import javax.sip.TimeoutEvent;
import javax.sip.address.AddressFactory;
import javax.sip.header.CSeqHeader;
import javax.sip.header.HeaderFactory;
import javax.sip.message.MessageFactory;
import javax.sip.message.Request;
import javax.sip.message.Response;

import org.apache.log4j.Logger;


/*
 * Created on Nov 22, 2004
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
public class SIPUserAgentClient implements SipListener {
	
	static Logger logger = Logger.getLogger(SIPUserAgentClient.class);
	
	private SipFactory sipFactory;
	private MessageFactory messageFactory;
	private HeaderFactory headerFactory;
	private AddressFactory addressFactory;
	private SipStack sipStack;
	private SipProvider TCPProvider;
	private SipProvider UDPProvider;
	private int port = 5060; // don't touch it !
	private String localAddress = "127.0.0.1";
	private String localUserName = "franz";
	private String localDomain = "franz.ch";
	private Proxy proxy;
	
	private Vector sipUAListenerList;
	
	private SIPRegistrationClient sipRC;
	private SIPMessageClient sipMC;
	private SIPInviteClient sipIC;
	
	public SIPUserAgentClient() {
		sipUAListenerList = new Vector();
	}
	
	public void start() {
		sipFactory = SipFactory.getInstance();
		sipFactory.setPathName("gov.nist");
		
		Properties props = new Properties();

		props.setProperty("javax.sip.IP_ADDRESS","127.0.0.1");
//		props.setProperty("javax.sip.IP_ADDRESS","172.30.57.44");
		props.setProperty("javax.sip.STACK_NAME","NISTv1.1");
//		props.setProperty("javax.sip.OUTBOUND_PROXY", "172.30.57.44:5060/TCP");
		props.setProperty(
				"gov.nist.javax.sip.DEBUG_LOG",
				"shootistdebug.txt");
		props.setProperty(
				"gov.nist.javax.sip.SERVER_LOG",
				"shootistlog.txt");
		try {
			sipStack = sipFactory.createSipStack(props);
			
			ListeningPoint listeningPoint = sipStack.createListeningPoint(port, "TCP");
			TCPProvider = sipStack.createSipProvider(listeningPoint);
			TCPProvider.addSipListener(this);
			
			listeningPoint = sipStack.createListeningPoint(port, "UDP");
			UDPProvider = sipStack.createSipProvider(listeningPoint);
			UDPProvider.addSipListener(this);
			
			messageFactory = sipFactory.createMessageFactory();
			headerFactory = sipFactory.createHeaderFactory();
			addressFactory = sipFactory.createAddressFactory();
			
			sipRC = new SIPRegistrationClient(this);
			sipMC = new SIPMessageClient(this);
			sipIC = new SIPInviteClient(this);
			
			logger.debug("IP Address: "+getLocalAddress()+" local port: "+getLocalPort()+ " protocol: "+getLocalProtocol());
			logger.debug("SIP Address: "+getLocalURI());
			// TODO not here
//			sipRC.register();
			//sipMC.sendMessage("sip:franz@127.0.0.1");
//			sipIC.invite("sip:linphone@127.0.0.1");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SIPInviteClient getSIPInviteClient () {
		return sipIC;
	}
	
	public SipProvider getSipProvider() {
		// TODO UDP/TCP
		return TCPProvider;
	}
	
	public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public HeaderFactory getHeaderFactory() {
    	return headerFactory;
    }
    
    public AddressFactory getAddressFactory() {
    	return addressFactory;
    }
    
    public String getLocalAddress() {
    	return localAddress;
    }
    
    public void setLocalAddress(String address) {
    	this.localAddress = address;
    }
    
    public int getLocalPort() {
    	// TODO Port
    	return port;
    }
    
    public void setLocalPort(int port) {
    	this.port = port;
    }
    
    public String getLocalProtocol() {
    	// TODO Protocol
    	return "TCP";
    }
    
    public String getLocalURI() {
    	// TODO URI
    	return "sip:"+localUserName+"@"+localDomain;
    }
    
    public void setLocalUserName(String userName) {
    	this.localUserName = userName;
    }
    
    public void setLocalDomain (String domain) {
    	this.localDomain = domain;
    }
	/**
	 * @return
	 */
	public String getProxy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getRegistrar() {
		// TODO Auto-generated method stub
		return "127.0.0.1:4000";
//		return "172.30.57.44";
	}
	
	public Vector getSIPUAListeners() {
		return sipUAListenerList;
	}
	
//	public static void main(String[] args) {
//		SIPUserAgentClient sipua = new SIPUserAgentClient();
//		sipua.start();
//
//	}

	public void addSIPUserAgentListener(SIPUserAgentListener sipUAListener) {
		sipUAListenerList.add(sipUAListener);
	}
	
	/* (non-Javadoc)
	 * @see javax.sip.SipListener#processRequest(javax.sip.RequestEvent)
	 */
	public void processRequest(RequestEvent requestEvent) {
		// TODO Auto-generated method stub
		Request request = requestEvent.getRequest();
		logger.debug("Request: "+request.getMethod());
		logger.debug(request);
		
		if(request.getMethod().equals("INVITE")) {
			// logger.debug("INVITE Request received");
			sipIC.processRequest(requestEvent);
		}
		else {
			logger.info("Not supported yet");
		}
	}



	/* (non-Javadoc)
	 * @see javax.sip.SipListener#processResponse(javax.sip.ResponseEvent)
	 */
	public void processResponse(ResponseEvent responseEvent) {
		Response response = responseEvent.getResponse();
		ClientTransaction clientTransaction = responseEvent.getClientTransaction();
		CSeqHeader cseqHeader=(CSeqHeader)response.getHeader(CSeqHeader.NAME);
		
		logger.debug("Response: " + response.getStatusCode()+" "+cseqHeader.getMethod());
		logger.debug(response);
		
		if (cseqHeader.getMethod().equals("REGISTER")) {
			//	logger.info("REGISTER Response received");
			// TODO change type
			sipRC.processResponse(responseEvent);
		}
		if (cseqHeader.getMethod().equals("INVITE")) {
			//	logger.info("INVITE Response received");
			// TODO change type
			sipIC.processResponse(responseEvent);
		}
		if (cseqHeader.getMethod().equals("ACK")) {
			
		}
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipListener#processTimeout(javax.sip.TimeoutEvent)
	 */
	public void processTimeout(TimeoutEvent timeoutEvent) {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @return
	 */

}

