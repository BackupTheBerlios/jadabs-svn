package sip;

import java.awt.Event;

import javax.sip.ResponseEvent;


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
public interface SIPUserAgentListener {
	//TODO change event type
	public void processRegister(ResponseEvent e);
	public void processMessage();
	public void processNotify();
	public void processSubscribe();
}
