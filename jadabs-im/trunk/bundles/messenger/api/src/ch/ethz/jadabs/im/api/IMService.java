/*
 * Created on Nov 15, 2004
 *
 */
package ch.ethz.jadabs.im.api;

/**
 * @author andfrei
 * 
 */
public interface IMService
{  
    
    int getStatus();
    
    void register(IMListener imlistener, int status);
    
    void unregister();
    
    void sendMessage(String tosipaddress, String message)  throws IMException;
    
    NeighbourTuple[] getNeighbours();
    
}
