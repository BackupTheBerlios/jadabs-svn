/*
 * Created on Nov 16, 2004
 *
 */
package ch.ethz.jadabs.im.api;


public class NeighbourTuple
{
    String sipaddress;
    int status;
    
    public NeighbourTuple(String sipaddress, int status)
    {
        this.sipaddress = sipaddress;
        this.status = status;
    }
	/**
	 * @return Returns the sipaddress.
	 */
	public String getSipaddress() {
		return sipaddress;
	}
	/**
	 * @param sipaddress The sipaddress to set.
	 */
	public void setSipaddress(String sipaddress) {
		this.sipaddress = sipaddress;
	}
	/**
	 * @return Returns the status.
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}