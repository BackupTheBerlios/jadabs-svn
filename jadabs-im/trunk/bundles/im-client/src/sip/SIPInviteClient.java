package sip;

import gov.nist.javax.sip.SIPConstants;
import gov.nist.javax.sip.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

//import javax.sdp.Attribute;
//import javax.sdp.Media;
//import javax.sdp.Origin;
//import javax.sdp.SdpFactory;
//import javax.sdp.SessionDescription;
//import javax.sdp.SessionName;
//import javax.sdp.Version;
import javax.sip.ClientTransaction;
import javax.sip.Dialog;
import javax.sip.RequestEvent;
import javax.sip.ResponseEvent;
import javax.sip.ServerTransaction;
import javax.sip.SipProvider;
import javax.sip.address.Address;
import javax.sip.address.AddressFactory;
import javax.sip.address.SipURI;
import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContactHeader;
import javax.sip.header.ContentTypeHeader;
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
public class SIPInviteClient {
	private static Logger logger = Logger.getLogger(SIPInviteClient.class);
	
	private SIPUserAgentClient sipUAClient;
	private int cseq = 0;
	private String SIPRemoteAddress;

	private HeaderFactory headerFactory;
	private AddressFactory addressFactory;
	private SipProvider sipProvider;
	private MessageFactory messageFactory;
	
	public SIPInviteClient (SIPUserAgentClient sipUAClient) {
		this.sipUAClient = sipUAClient;
		
		messageFactory = sipUAClient.getMessageFactory();
		headerFactory = sipUAClient.getHeaderFactory();
		addressFactory = sipUAClient.getAddressFactory();
		sipProvider = sipUAClient.getSipProvider();
	} 
	
	public void invite(String remoteURI) {
		try {
			/* when registering, the INVITE request should be sent to the domain, 
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
			Address requestAddress = addressFactory.createAddress(remoteURI);
	
			// CallId Header
			CallIdHeader callIdHeader = sipProvider.getNewCallId();
			
			// CSeq header
			CSeqHeader cSeqHeader = headerFactory.createCSeqHeader(cseq, Request.INVITE);
			
			// To Header
			Address address = addressFactory.createAddress(remoteURI);
			ToHeader toHeader = headerFactory.createToHeader(address, null);
			
			//From Header
			address = addressFactory.createAddress(sipUAClient.getLocalURI());
			FromHeader fromHeader = headerFactory.createFromHeader(address, null);
			fromHeader.setTag(Utils.generateTag());
			
			// Via Headers
			ArrayList viaHeaders = new ArrayList();
			ViaHeader viaHeader = headerFactory.createViaHeader(
					sipUAClient.getLocalAddress(), sipUAClient.getLocalPort(), sipUAClient.getLocalProtocol(), branchID);
			viaHeaders.add(viaHeader);
			
			// MaxForward Headers
			MaxForwardsHeader maxForwardsHeader = headerFactory.createMaxForwardsHeader(70);
			
			Request request = messageFactory.createRequest(
					requestAddress.getURI(),
					Request.INVITE,
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
	            
//	        ContentTypeHeader header = headerFactory.createContentTypeHeader("application","sdp");
//	        
//	        request.setContent("v=0\n" +
//	        		"o=linphone 123456 654321 IN IP4 127.0.0.1\n" +
//	        		"s=A conversation\n" +
//	        		"c=IN IP4 127.0.0.1\n" +
//	        		"t=0 0\n" +
//	        		"m=audio 7078 RTP/AVP 0 3 8 111 115 101\n" +
//	        		"b=AS:28\n" +
//	        		"a=rtpmap:0 PCMU/8000/1\n" +
//	        		"a=rtpmap:3 GSM/8000/1\n" +
//	        		"a=rtpmap:8 PCMA/8000/1\n" +
//	        		"a=rtpmap:111 speex/16000/1\n" +
//	        		"a=rtpmap:115 1015/8000/1\n" +
//	        		"a=rtpmap:101 telephone-event/8000\n" +
//	        		"a=fmtp:101 0-11", header);
	        
	     
	        // ****** SDP *********
//	        SdpFactory sdpFactory = SdpFactory.getInstance();
//	        Version version = sdpFactory.createVersion(0);
//	        Origin origin = sdpFactory.createOrigin("im-client", SdpFactory.getNtpTime(new Date()), 123, "IN", "IP4", sipUAClient.getLocalAddress());
//	        SessionName sessionName = sdpFactory.createSessionName("A chat");
//	        //Media media = sdpFactory.createMedia("application", sipUAClient.getLocalPort(), 1, "SIP", new Vector());
//	        Vector vv = new Vector();
//	        vv.addElement(""+0);
////	        vv.addElement(""+3);
////	        vv.addElement(""+8);
////	        vv.addElement(""+111);
////	        vv.addElement(""+115);
////	        vv.addElement(""+101);
//	        Media media = sdpFactory.createMedia("audio", sipUAClient.getLocalPort(), 1, "RTP/AVP", vv);
//	        Attribute attribute = sdpFactory.createAttribute("rtpmap", "0 PCMU/8000/1");
//	        
//	        SessionDescription sdp = sdpFactory.createSessionDescription();
//	        sdp.setVersion(version);
//	        sdp.setOrigin(origin);
//	        sdp.setSessionName(sessionName);
//	        Vector v = new Vector();
//			v.addElement(media);
//	        sdp.setMediaDescriptions(v);
//	        v= new Vector();
//	        v.addElement(attribute);
//	        sdp.setAttributes(v);
	        // *********************
	        
//	        ContentTypeHeadont(sdp, header);
	        
	        
			logger.debug("SENDING "+request);

			ClientTransaction clientTransaction = sipUAClient.getSipProvider().getNewClientTransaction(request);
			
			clientTransaction.sendRequest();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param responseEvent
	 */
	public void processResponse(ResponseEvent response) {
		logger.debug("Got Response !");
		logger.debug(response.getResponse());
		switch (response.getResponse().getStatusCode()) {
		case (Response.ACCEPTED):
		case (Response.OK):
			// WE GOT A 2XX RESPONSE !
			// Take the infos inside sdp payload, initiate chat communication with own protocol
			// Send to app ... ?
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

	/**
	 * @param requestEvent
	 */
	public void processRequest(RequestEvent requestEvent) {
		Request request = requestEvent.getRequest();
		ServerTransaction serverTransaction = requestEvent.getServerTransaction();
		try {
			if (serverTransaction == null) {
				logger.debug("*** New ServerTransaction ***");
				serverTransaction = sipUAClient.getSipProvider().getNewServerTransaction(request);
				Response response = sipUAClient.getMessageFactory().createResponse(101, request);
				
				SipURI sipURI = addressFactory.createSipURI(null,sipUAClient.getLocalAddress());
	            sipURI.setPort(sipUAClient.getLocalPort());
	            sipURI.setTransportParam(sipUAClient.getLocalProtocol());
	            Address contactAddress = addressFactory.createAddress(sipURI);
	            ContactHeader contactHeader=headerFactory.createContactHeader(contactAddress);
	            response.setHeader(contactHeader);
	            
	            ToHeader toHeader = (ToHeader)request.getHeader(SIPConstants.TO);
	            toHeader.setTag(Utils.generateTag());
	            response.setHeader(toHeader);
	            
	            ViaHeader viaHeader = (ViaHeader)request.getHeader(SIPConstants.VIA);
	            viaHeader.setBranch(Utils.generateBranchId());
	            response.setHeader(viaHeader);
	            
				logger.debug("sending response: ");
				logger.debug(response);
				
				Dialog dialog = serverTransaction.getDialog();
				serverTransaction.sendResponse(response);
				sipProvider.sendResponse(response);
				
				logger.debug(serverTransaction.getState());
				logger.debug(dialog.getState());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
