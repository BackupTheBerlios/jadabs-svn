package sip;

import gov.nist.javax.sip.Utils;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.sip.ClientTransaction;
import javax.sip.ResponseEvent;
import javax.sip.SipProvider;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.HeaderFactory;
import javax.sip.header.MaxForwardsHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;
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
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class SIPRegistrationClient {
	private SIPUserAgentClient sipUAClient;
	private int cseq = 0;
	
	static Logger logger = Logger.getLogger(SIPRegistrationClient.class);
	
	public SIPRegistrationClient(SIPUserAgentClient sipUAClient) {
		this.sipUAClient = sipUAClient;
	}

	public void register() {
		try {
			/* when registering, the REGISTER request should be sent to the registrar, 
			 * which is what is after the @ in the user SIP address 
			 * (eg bob@alice.com -> alice.com).
			 * To and From Headers are the local URI (bob@alice.com).
			 * Contact Header identifies the UserAgent. It is his real address (bob@"IPAddress").
			 * Via Header contains IP/port/protocol of the local useragent
			 */
			
			MessageFactory messageFactory = sipUAClient.getMessageFactory();
			HeaderFactory headerFactory = sipUAClient.getHeaderFactory();
			AddressFactory addressFactory = sipUAClient.getAddressFactory();
			SipProvider sipProvider = sipUAClient.getSipProvider();

			cseq++;
			String branchID = Utils.generateBranchId();
			
			// Where to send the request
			Address requestAddress = addressFactory.createAddress("sip:"+sipUAClient.getRegistrar());

			// CallId Header
			CallIdHeader callIdHeader = sipProvider.getNewCallId();
			
			// CSeq header
			CSeqHeader cSeqHeader = headerFactory.createCSeqHeader(cseq, Request.REGISTER);
			
			// To Header
			Address address = addressFactory.createAddress(sipUAClient.getLocalURI());
			ToHeader toHeader = headerFactory.createToHeader(address, null);
			
			//From Header
			FromHeader fromHeader = headerFactory.createFromHeader(address, null);
			
			// Via Headers
			ArrayList viaHeaders = new ArrayList();
			ViaHeader viaHeader = headerFactory.createViaHeader(
					sipUAClient.getLocalAddress(), sipUAClient.getLocalPort(), sipUAClient.getLocalProtocol(), branchID);
			viaHeaders.add(viaHeader);
			
			// MaxForward Headers
			MaxForwardsHeader maxForwardsHeader = headerFactory.createMaxForwardsHeader(70);
			
			Request request = messageFactory.createRequest(
					requestAddress.getURI(),
					Request.REGISTER,
					callIdHeader,
					cSeqHeader,
					fromHeader,
					toHeader,
					viaHeaders,
					maxForwardsHeader);
			
			// Contact header
            SipURI sipURI = addressFactory.createSipURI(null,sipUAClient.getLocalAddress());
            sipURI.setPort(sipUAClient.getLocalPort());
            sipURI.setTransportParam(sipUAClient.getLocalProtocol());
            Address contactAddress = addressFactory.createAddress(sipURI);
            ContactHeader contactHeader=headerFactory.createContactHeader(contactAddress);
            request.setHeader(contactHeader);

			logger.debug("SENDING: "+request);
			
            
			ClientTransaction clientTransaction = sipUAClient.getSipProvider().getNewClientTransaction(request);
			clientTransaction.sendRequest();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param response
	 * @param clientTransaction
	 */
	public void processResponse(/*Response response, ClientTransaction clientTransaction*/ResponseEvent response) {
		// TODO see types
		switch (response.getResponse().getStatusCode()) {
			case (Response.ACCEPTED):
			case (Response.OK) :
				// WE GOT A 2XX RESPONSE !
				Vector sipUAListenerList = sipUAClient.getSIPUAListeners();
				Iterator i = sipUAListenerList.iterator();
				while (i.hasNext()) {
					SIPUserAgentListener handler = (SIPUserAgentListener) i.next();
					// TODO
					handler.processRegister(response);
				}
				break;
			case (Response.TRYING):
			case (Response.RINGING):
			case (Response.CALL_IS_BEING_FORWARDED):
			case (Response.QUEUED):
			case (Response.SESSION_PROGRESS):
				// WE GOT A 1XX RESPONSE !
				break;
		}
	}
	
	
}