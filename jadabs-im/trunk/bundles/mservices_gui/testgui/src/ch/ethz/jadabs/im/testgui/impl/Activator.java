/*
 * Copyright (c) 2003-2004, Jadabs project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials
 *   provided with the distribution.
 *
 * - Neither the name of the Jadabs project nor the names of its
 *   contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Created on Apr 2, 2004
 *
 */
package ch.ethz.jadabs.im.testgui.impl;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ch.ethz.jadabs.im.testgui.SwtManager;
import ch.ethz.jadabs.remotefw.FrameworkManager;

import ch.ethz.jadabs.im.api.IMException;
import ch.ethz.jadabs.im.api.IMListener;
import ch.ethz.jadabs.im.api.IMService;
import ch.ethz.jadabs.im.jxme.IMServiceImpl;
import ch.ethz.jadabs.jxme.services.GroupService;
import ch.ethz.jadabs.sip.cons.MessageCons;

/**
 * @author andfrei
 *  
 */
public class Activator implements BundleActivator
{

    static BundleContext bc;

    static SwtManagerImpl ui;
    
    static TestGUI testgui;
    
    //<
    static String test1sipaddress = "sip:test1@wlab.ethz.ch";
    static String test2sipaddress = "sip:test2@wlab.ethz.ch";
    
    static GroupService groupsvc = null;
    
    static IMService imservice = null;
    
	//>
	
    /* RemoteFramework */
    static FrameworkManager rmanager;

    static String peername;
    
    /*
     *
     */
    public void start(BundleContext bc) throws Exception
    {
        // add context
        Activator.bc = bc;
        peername = bc.getProperty("ch.ethz.jadabs.jxme.peeralias");
        
        // instantiate the service
        ui = new SwtManagerImpl();
        ui.start();

        // FrameworkManager
        ServiceReference srefrm = Activator.bc.getServiceReference(FrameworkManager.class.getName());
        rmanager = (FrameworkManager) bc.getService(srefrm);

        
        //register service
        bc.registerService(SwtManager.class.getName(), ui, new Hashtable());
        //register service as a singleton... need a PID?

//<
        peername = bc.getProperty("ch.ethz.jadabs.jxme.peeralias");
        
        // get GroupService
        ServiceReference sref = bc.getServiceReference(
                "ch.ethz.jadabs.jxme.services.GroupService");
        
        if (sref == null)
            throw new Exception("could not properly initialize IM, GroupService is missing");
    
        groupsvc = (GroupService)bc.getService(sref);
        
        // create IMServiceImpl and do testrun
        if (peername.equals("peer1"))
        {
	        imservice = new IMServiceImpl(groupsvc, test1sipaddress);
	        
	        testrunPeer1();
        }
        else
        {
            imservice = new IMServiceImpl(groupsvc, test2sipaddress);
         
            testrunPeer2();
        }
        
        
        // register IMService
        //bc.registerService("ch.ethz.jadabs.jxme.im.IMService", imservice, null);
    
//>

        testgui = new TestGUI();
        ui.exec(testgui, false);
        
    }

    /*
     *
     */
    public void stop(BundleContext context) throws Exception
    {
        bc = null;
        ui.dispose();
        ui = null;
    }

    
    public void testrunPeer1()
    {
//        try
//        {
            // first subscribe
            imservice.register(new Peer1IMListener(), MessageCons.IM_STATUS_ONLINE);
            
            // send IM-Message
//            imservice.sendMessage(test2sipaddress, "testmessage");
//            
//            
//            
//        } catch (IMException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
    
    
    public void testrunPeer2()
    {
        try
        {
            // first subscribe
            imservice.register(new Peer2IMListener(), MessageCons.IM_STATUS_ONLINE);
            
            // send IM-Message
            imservice.sendMessage(test1sipaddress, "testmessage");
            
            
            
        } catch (IMException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    class Peer1IMListener implements IMListener
    {
    	public void imRegistered(String sipaddress, int status)
        {
            System.out.println("IM joined: "+sipaddress);
        }
        
        public void imUnregistered(String sipaddress)
        {
            System.out.println("IM left: "+sipaddress);
        }
        
        public void process(String sipaddress, String msg)
        {
            System.out.println("IM sent: "+sipaddress+":"+msg);
        }
    }
    
    class Peer2IMListener implements IMListener
    {
    	public void imRegistered(String sipaddress, int status)
        {
            System.out.println("IM joined: "+sipaddress);
        }
        
        public void imUnregistered(String sipaddress)
        {
            System.out.println("IM left: "+sipaddress);
        }
        
        public void process(String sipaddress, String msg)
        {
            System.out.println("IM sent: "+sipaddress+":"+msg);
        }
    }
}
