/*
 * Created on Nov 12, 2004
 *
 */
package ch.ethz.jadabs.jxme.sip;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ch.ethz.jadabs.jxme.services.GroupService;


/**
 * @author andfrei
 * 
 */
public class SipGatewayActivator implements BundleActivator
{

    static BundleContext bc;
    
    SipGatewayImpl sipgw;
    
    static GroupService groupsvc;
    
    /* 
     */
    public void start(BundleContext bc) throws Exception
    {
        SipGatewayActivator.bc = bc;
        
        
        // get GroupService
        ServiceReference sref = bc.getServiceReference(GroupService.class.getName());
        groupsvc = (GroupService)bc.getService(sref);
        
        
        sipgw = new SipGatewayImpl();
        
        sipgw.start();
        
        
        
        bc.registerService(SipGateway.class.getName(), sipgw, null);
        
        
        
    }

    /*
     */
    public void stop(BundleContext bc) throws Exception
    {

    }

}
