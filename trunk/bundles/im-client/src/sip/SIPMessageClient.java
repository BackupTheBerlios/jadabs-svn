package sip;

import gov.nist.javax.sip.Utils;

import java.util.ArrayList;

import javax.sip.ClientTransaction;
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

/*
 * Created on Nov 24, 2004
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
public class SIPMessageClient {
	private SIPUserAgentClient sipUAClient;
	private int cseq = 0;
	private String SIPRemoteAddress;
	
	public SIPMessageClient(SIPUserAgentClient sipUAClient) {
		this.sipUAClient = sipUAClient;
	} 
	
	public void sendMessage(String SIPRemoteAddress) {
		try {
			/* when registering, the MESSAGE request should be sent to the domain, 
			 * which is what is after the @ in the remote user SIP address 
			 * (eg sip:bob@alice.com -> alice.com).
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
			Address requestAddress = addressFactory.createAddress(SIPRemoteAddress);
	
			// CallId Header
			CallIdHeader callIdHeader = sipProvider.getNewCallId();
			
			// CSeq header
			CSeqHeader cSeqHeader = headerFactory.createCSeqHeader(cseq, Request.MESSAGE);
			
			// To Header
			Address address = addressFactory.createAddress(SIPRemoteAddress);
			ToHeader toHeader = headerFactory.createToHeader(address, null);
			
			//From Header
			address = addressFactory.createAddress(sipUAClient.getLocalURI());
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
					Request.MESSAGE,
					callIdHeader,
					cSeqHeader,
					fromHeader,
					toHeader,
					viaHeaders,
					maxForwardsHeader);
			
			System.out.println(request.toString());
			
			// Contact header
//	        SipURI sipURI = addressFactory.createSipURI(null,sipUAClient.getLocalAddress());
//	        sipURI.setPort(sipUAClient.getLocalPort());
//	        sipURI.setTransportParam(sipUAClient.getLocalProtocol());
//	        Address contactAddress = addressFactory.createAddress(sipURI);
//	        ContactHeader contactHeader=headerFactory.createContactHeader(contactAddress);
//	        request.setHeader(contactHeader);
	
			ClientTransaction clientTransaction = sipUAClient.getSipProvider().getNewClientTransaction(request);
			clientTransaction.sendRequest();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
