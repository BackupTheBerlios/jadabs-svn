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
 */
package ch.ethz.jadabs_im.testgui.impl;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.osgi.framework.Bundle;

import ch.ethz.jadabs.remotefw.BundleInfo;
import ch.ethz.jadabs.remotefw.BundleInfoListener;
import ch.ethz.jadabs.remotefw.Framework;
import ch.ethz.jadabs.remotefw.RemoteFrameworkListener;

import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class MainComposite extends Composite implements RemoteFrameworkListener, BundleInfoListener
{

    private static Logger LOG = Logger.getLogger(MainComposite.class.getName());

    private Menu menubar;
    
    private MenuItem aboutmenueItem;
    private Menu aboutmenue;
    
    private Composite standardView;
    private StackLayout standardViewLayout;
    
    	private Composite composite1;    	
    		private Button startButton;
    		
    	private Composite composite2;    	
    		private Button stopButton;
    
    private Composite sendmsgView;
    private StackLayout sendmsgViewLayout;
    
    	private Composite sendingView;
    
    		private Composite topLabels;
    			private Label toLabel;
    
    		private Text historyField;
    
    		private Composite middleLabels;
    
    		private Text inputField; 
    
    		private Composite bottomLabels;
    			private Button sendIMButton; 
    
    
    	private Composite sentView;   
    


    protected Tree peertree;

//    final MainComposite maincomposite = this;
    
    /* instance fields */
    //    TestGUI testgui;
    public MainComposite(Composite parent, int style)
    {
        super(parent, style);
        
        initGUI();
    }

    /**
     * Initializes the GUI. Auto-generated code - any changes you make will
     * disappear.
     */
    public void initGUI()
    {

		
        try
        {
            preInitGUI();


			{
				peertree = new Tree(this, SWT.SINGLE | SWT.BORDER);
				GridData peertreeLData = new GridData();
				peertreeLData.widthHint = 219;
				peertreeLData.heightHint = 279;
				peertree.setLayoutData(peertreeLData);
				peertree.setSize(new org.eclipse.swt.graphics.Point(486, 274));
				peertree.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent evt) {
						peertreeWidgetSelected(evt);
					}
				});

			}
				
			{
				standardView = new Composite(this, SWT.NONE);
				standardViewLayout = new StackLayout();
				GridData standardViewLData = new GridData();
				standardViewLData.widthHint = 240;
				standardViewLData.heightHint = 300;
				standardView.setLayoutData(standardViewLData);
				standardView.setSize(new org.eclipse.swt.graphics.Point(240, 300));
			
				{
					composite1 = new Composite(standardView, SWT.NONE);
					RowLayout composite1Layout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData composite1LData = new FormData();
					composite1LData.height = 48;
					composite1LData.width = 232;
					composite1.setLayoutData(composite1LData);
					composite1.setLayout(composite1Layout);
					{
						startButton = new Button(composite1, SWT.PUSH
							| SWT.CENTER);
						startButton.setText("start");
						startButton.addSelectionListener(new SelectionAdapter() {

								public void widgetSelected(SelectionEvent evt) {
									startButtonWidgetSelected(evt);
								}
							});
					}
				}
				
				{
					composite2 = new Composite(standardView, SWT.NONE);
					RowLayout composite2Layout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData composite2LData = new FormData();
					composite2.setLayout(composite2Layout);
					composite2.setLayoutData(composite2LData);
					{
						stopButton = new Button(composite2, SWT.PUSH
							| SWT.CENTER);
						stopButton.setText("stop");
						stopButton.addSelectionListener(new SelectionAdapter() {

							public void widgetSelected(SelectionEvent evt) {
								stopButtonWidgetSelected(evt);
							}
						});
					}
				}

//				 Layout initialisieren
				standardViewLayout.topControl = composite1;
				standardViewLayout.marginWidth = 5;
				standardViewLayout.marginHeight = 5;
//				 Layout setzen
				standardView.setLayout(standardViewLayout);
//				 Neues Layout erzwingen				
				standardView.layout();
			}
			
			{
				sendmsgView = new Composite(this, SWT.NONE);
				sendmsgViewLayout = new StackLayout();
				GridData sendmsgViewLData = new GridData();
				sendmsgViewLData.widthHint = 240;
				sendmsgViewLData.heightHint = 300;
				sendmsgView.setLayoutData(sendmsgViewLData);
				sendmsgView.setSize(new org.eclipse.swt.graphics.Point(240, 300));
				
				
				{					
					sendingView = new Composite(sendmsgView, SWT.NONE);
					RowLayout sendingViewLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData sendingViewLData = new FormData();
					sendingView.setLayout(sendingViewLayout);
					sendingViewLData.height = 48;
					sendingViewLData.width = 232;
					sendingView.setLayoutData(sendingViewLData);
					sendingView.setLayout(sendingViewLayout);
					
					{
						sendIMButton = new Button(composite1, SWT.PUSH
							| SWT.CENTER);
						sendIMButton.setText("sendIM");
						sendIMButton.addSelectionListener(new SelectionAdapter() {

								public void widgetSelected(SelectionEvent evt) {
									sendIMButtonWidgetSelected(evt);
								}
							});
					}
					
				
				}
				{
					sentView = new Composite(sendmsgView, SWT.NONE);
					RowLayout sentViewLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData sentViewLData = new FormData();
					sentView.setLayout(sentViewLayout);
					sentView.setLayoutData(sentViewLData);
				}
						

//				 Layout initialisieren
				sendmsgViewLayout.topControl = sendingView;
				sendmsgViewLayout.marginWidth = 5;
				sendmsgViewLayout.marginHeight = 5;
//				 Layout setzen
				sendmsgView.setLayout(sendmsgViewLayout);
//				 Neues Layout erzwingen				
				sendmsgView.layout();
				
			}
			
            this.setSize(240, 320);

//            standardViewLayout.marginWidth = 0;
//            standardViewLayout.marginHeight = 0;
//            standardViewLayout.fill = true;

//            peertree.setEnabled(false);
            StackLayout thisLayout = new StackLayout();
            
//			 Layout initialisieren
            thisLayout.topControl = standardView;
            thisLayout.marginWidth = 0;
            thisLayout.marginHeight = 0;
//			 Layout setzen    
            this.setLayout(thisLayout);
//            thisLayout.spacing = 0;
            this.layout();
            
            {            
	            menubar = new Menu(getShell(), SWT.BAR);
	            aboutmenueItem = new MenuItem(menubar, SWT.CASCADE);
	            aboutmenue = new Menu(aboutmenueItem);
	
	            getShell().setMenuBar(menubar);
	
	            aboutmenueItem.setText("About");
	
	            aboutmenueItem.setMenu(aboutmenue);
	            aboutmenue.addMenuListener(new MenuAdapter()
	            {
	
	                public void menuShown(MenuEvent evt)
	                {
	                    aboutmenueItMenuShown(evt);
	                }
	            });
            
            }
            
        	{
        		topLabels = new Composite(sendingView, SWT.BORDER);
    	    	RowData topLabelsLData = new RowData();
    	    	topLabelsLData.width = 215;
    	    	topLabelsLData.height = 23;
    	    	topLabels.setLayoutData(topLabelsLData);
        	}
    		{
    			toLabel = new Label(topLabels, SWT.NONE);
    			toLabel.setText("label1");
    		}
        	{
    			historyField = new Text(sendingView, SWT.MULTI | SWT.LEFT | SWT.READ_ONLY | SWT.V_SCROLL | SWT.BORDER);
    			RowData historyFieldLData = new RowData();
    			historyFieldLData.width = 189;
    			historyFieldLData.height = 75;
    			historyField.setLayoutData(historyFieldLData);
    		}
        	
    		{
    			middleLabels = new Composite(sendingView, SWT.BORDER);
    			GridLayout middleLabelsLayout = new GridLayout();
    			RowData middleLabelsLData = new RowData();
    			middleLabelsLData.width = 215;
    			middleLabelsLData.height = 23;
    			middleLabels.setLayoutData(middleLabelsLData);
    			middleLabelsLayout.makeColumnsEqualWidth = true;
    			middleLabels.setLayout(middleLabelsLayout);
    		}


    		
    		{
    			inputField = new Text(sendingView, SWT.V_SCROLL | SWT.BORDER);
    			inputField.setEditable(true);
    			RowData inputFieldLData = new RowData();
    			inputFieldLData.width = 181;
    			inputFieldLData.height = 88;
    			inputField.setLayoutData(inputFieldLData);
    			inputFieldLData.width = 188;
    			inputFieldLData.height = 86;
    			inputField.setLayoutData(inputFieldLData);
    		}

    		{
    			bottomLabels = new Composite(sendingView, SWT.BORDER);
    			GridLayout bottomLabelsLayout = new GridLayout();
    			RowData bottomLabelsLData = new RowData();
    			bottomLabelsLData.width = 215;
    			bottomLabelsLData.height = 26;
    			bottomLabels.setLayoutData(bottomLabelsLData);
    			bottomLabelsLayout.makeColumnsEqualWidth = true;
    			bottomLabels.setLayout(bottomLabelsLayout);
    		}

            postInitGUI();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /** Add your pre-init code in here */
    public void preInitGUI()
    {
    }

    /** Add your post-init code in here */
    public void postInitGUI()
    {
    }

    /*
     * 
     */
    public void enterFrameworkEvent(Framework rframework)
    {
        final Framework finalrfw = rframework;
        //list1.add(rframework.getPeername());
        
        // register this gui as listener change in the framework
        rframework.addBundleInfoListener(this);
        
        TestGUI.manager.exec(new Runnable()
        {

            public void run()
            {
                TreeItem item = new TreeItem(peertree, SWT.NULL);
                item.setText(finalrfw.getPeername());
            }
        }, false);

    }

    /*
     *
     */
    public void leaveFrameworkEvent(Framework rframework)
    {
        //        list1.remove(rframework.getPeername());
        final Framework finalrfw = rframework;
        
        // register this gui as listener change in the framework
        rframework.removeBundleInfoListener(this);
        
        LOG.debug("leave frameworkevent: "+rframework.getPeername());
         
        TestGUI.manager.exec(new Runnable()
        {

            public void run()
            {
                //                peerList.remove(finalrfw.getPeername());
                synchronized(peertree)
                {
                    synchronized(peertree)
                    {
		                TreeItem[] items = peertree.getItems();
		                for (int i = 0; i < items.length; i++)
		                {
		                    if (items[i].getText().equals(finalrfw.getPeername()))
		                        items[i].dispose();
		                }
                    }
                }
            }
        }, false);
    }

    protected void select(String peername)
    {
        TreeItem peeritem = null;

        // get peer-item
        TreeItem[] titems = peertree.getItems();
        for (int i = 0; i < titems.length; i++)
        {
            if (titems[i].getText().equals(peername))
            {
                peeritem = titems[i];
                break;
            }
        }
        
        if (peeritem != null)
            peertree.setSelection(new TreeItem[]{peeritem});
    }
    
    /**
     * PeerTree Selected change.
     * 
     * @param evt
     */
    protected void peertreeWidgetSelected(SelectionEvent evt)
    {        
        TreeItem titem;
        TreeItem[] selection;
        if ( (peertree.getSelection().length > 0) && 
             ((titem = peertree.getSelection()[0]).getParentItem() == null) &&
             (titem.getItems().length == 0))
        {
            //            TreeItem titem = treeitems[0];
            
            // get Bundles for the selection
            String peername = titem.getText();
            Framework rframework = Activator.rmanager.getFrameworkByPeername(peername);
            
            // register this gui as listener change in the framework
            rframework.addBundleInfoListener(this);
            
            long[] bids = rframework.getBundles();
            
            if (bids != null)
            {
	            Arrays.sort(bids);
	
	//            TreeItem[] items = titem.getItems();
	//            for (int k = 0; k < items.length; k++)
	//                items[k].dispose();
	
	            for (int i = 0; i < bids.length; i++)
	            {
	                addBundle(peername, titem, rframework.getBundleInfo(bids[i]));
	            }
            }
            
            //titem.setExpanded(true);
        }
    }

    protected void fillupTree()
    {
        Enumeration en = Activator.rmanager.getFrameworks();
        
        for (; en.hasMoreElements();)
        {
            Framework frw = (Framework) en.nextElement();
                        
            // refresh remoteFW
            frw.refresh();
            synchronized(peertree)
            {
                TreeItem item = new TreeItem(peertree, SWT.NULL);
                item.setText(frw.getPeername());
            }
        }
    }
    
    /**
     * Update PeerTree
     */
    protected void updateButtonWidgetSelected(SelectionEvent evt)
    {
        Enumeration en = Activator.rmanager.getFrameworks();
        
        synchronized(peertree)
        {
	        peertree.removeAll();
	
	        for (; en.hasMoreElements();)
	        {
	            Framework frw = (Framework) en.nextElement();
	
	            // refresh remoteFW
	            frw.refresh();
	
	            TreeItem item = new TreeItem(peertree, SWT.NULL);
	            item.setText(frw.getPeername());
	        }
        }
    }

    /**
     * Refresh the given item, whereas the item should be the peer item.
     * All bundle subtree items will be deleted and the peer item is filled
     * with the new bundle values from the framework.
     * 
     * @param item
     * @param fw
     */
    protected void refreshTreeItem(TreeItem item, Framework fw)
    {

        if (item != null && fw != null)
        {

            // dispose old one
            TreeItem[] items = item.getItems();
            for (int i = 0; i < items.length; i++)
            {
                items[i].dispose();
                items[i] = null;
            }

            long[] bids = fw.getBundles();
            Arrays.sort(bids);

            for (int i = 0; i < bids.length; i++)
            {
                String bname = fw.getBundleName(bids[i]);
                String state = getBundleState(fw.getBundleState(bids[i]));

                TreeItem it = new TreeItem(item, SWT.NULL);
                it.setText(bids[i] + " : " + state + " : " + bname);
            }

            item.setExpanded(true);
        }
    }

    /**
     * Start a bundle in a Framework.
     * 
     * @param evt
     */
    protected void startButtonWidgetSelected(SelectionEvent evt)
    {
    	System.out.println("start start");
    	
     	standardViewLayout.topControl = composite2;
//    	 Neues Layout erzwingen
    	standardView.layout();
//    	 Fokus auf sichtbare Taste setzen
    	stopButton.setFocus();
    	      
        System.out.println("start end");
    	
    }

    /**
     * Install a Bundle in a Framework.
     * 
     * @param evt
     */
    protected void sendIMButtonWidgetSelected(SelectionEvent evt)
    {
    	
    	
 /*       TreeItem titem = null;
        Framework fw = null;
        if ( peertree.getSelection().length > 0 && 
             (titem = peertree.getSelection()[0]).getParentItem() == null)
        {
            String peername = titem.getText();

            fw = Activator.rmanager.getFrameworkByPeername(peername);

            SendMsgView sendMsgViewer = new SendMsgView(fw, TestGUI.shell, SWT.ICON_QUESTION);
            sendMsgViewer.open();

        } else
            System.out.println("select first a peer!");
            
*/
    	Framework fw = null;
    	fw = Activator.rmanager.getFrameworkByPeername(Activator.peername);
        SendMsgView sendMsgViewer = new SendMsgView(fw, TestGUI.shell, SWT.ICON_QUESTION);
        sendMsgViewer.open();

    }

    /**
     * Stop a bundle in a Framework.
     * 
     * @param evt
     */
    protected void stopButtonWidgetSelected(SelectionEvent evt)
    {
    	standardViewLayout.topControl = composite1;
//   	 Neues Layout erzwingen
    	standardView.layout();
//   	 Fokus auf sichtbare Taste setzen
    	startButton.setFocus();
    	
    }

    /**
     * Remove a bundle from a framework.
     * 
     * @param evt
     */
    protected void uninstallButtonWidgetSelected(SelectionEvent evt)
    {
        TreeItem titem;
        Framework fw = null;
        if ((titem = peertree.getSelection()[0]).getParentItem() != null)
        {
            String peername = titem.getParentItem().getText();
            String bundlestr = titem.getText();
            
            StringTokenizer st = new StringTokenizer(bundlestr, ": ");
            long bid = new Long(st.nextToken()).longValue();

            fw = Activator.rmanager.getFrameworkByPeername(peername);
            fw.uninstallBundle(bid);

        } else
            System.out.println("do a proper selection");

    }

    //
    // helper function
    //

    public static String getBundleState(int state)
    {
        switch (state) {
        case Bundle.ACTIVE:
            return "active";
        case Bundle.INSTALLED:
            return "installed";
        case Bundle.RESOLVED:
            return "resolved";
        case Bundle.STARTING:
            return "starting";
        case Bundle.STOPPING:
            return "stopping";
        case Bundle.UNINSTALLED:
            return "uninstalled";
        default:
            return "";
        }

    }

    public void allBundlesChanged(String peername, Framework framework)
    {
        final Framework fframework = framework;
        final String fpeername = peername;

        TestGUI.manager.exec(new Runnable()
        {

            public void run()
            {
                TreeItem peeritem = null;

                // get peer-item
                TreeItem[] titems = peertree.getItems();
                for (int i = 0; i < titems.length; i++)
                {
                    if (titems[i].getText().equals(fpeername))
                    {
                        peeritem = titems[i];
                        break;
                    }
                }

                // get bundle-item
                if (peeritem != null)
                {
                    refreshTreeItem(peeritem, fframework);
                } else
                {
                    LOG.warn("this is a new peer: " + fpeername);

                }

	           
            }
        }, false);

    }
    
    /**
     * Update the TreeView for changed BundleInfos
     */
    public void bundleChanged(String peername, BundleInfo bundleinfo)
    {

        final String fpeername = peername;
        final BundleInfo fbundleinfo = bundleinfo;

        TestGUI.manager.exec(new Runnable()
        {

            public void run()
            {
                TreeItem peeritem = null;

                // get peer-item
                TreeItem[] titems = peertree.getItems();
                for (int i = 0; i < titems.length; i++)
                {
                    if (titems[i].getText().equals(fpeername))
                    {
                        peeritem = titems[i];
                        break;
                    }
                }

                // get bundle-item
                if (peeritem != null)
                {
                    TreeItem bundleitem = null;
                    titems = peeritem.getItems();
                    long bid = fbundleinfo.bid;

                    for (int i = 0; i < titems.length; i++)
                    {
                        if (titems[i].getText().startsWith(new Long(bid).toString()))
                        {
                            bundleitem = titems[i];
                            break;
                        }
                    }

                    // bundleitem is new
                    if (bundleitem == null)
                    {
                        bundleitem = addBundle(fpeername, peeritem, fbundleinfo);
                    } else
                    {
                        // set text of bundle-item
                        setBundleItemText(bundleitem, fbundleinfo);
                    }
                } else
                {
                    LOG.warn("this is a new peer: " + fpeername);

                }

	           
            }
        }, false);

    }

    private TreeItem addBundle(String peername, TreeItem peeritem, BundleInfo binfo)
    {

        Framework frwk = Activator.rmanager.getFrameworkByPeername(peername);

        TreeItem bundleitem = new TreeItem(peeritem, SWT.NULL);

        setBundleItemText(bundleitem, binfo);

        return bundleitem;
    }

    private void setBundleItemText(TreeItem item, BundleInfo binfo)
    {
        item.setText(binfo.bid + " : " + getBundleState(binfo.state) + " : " + binfo.name);
    }

    /**
     * Setup the About Box.
     * 
     * @param evt
     */
    protected void aboutmenueItMenuShown(MenuEvent evt)
    {
        MessageBox messageBox = new MessageBox(getShell(), SWT.OK | SWT.ICON_INFORMATION);
        messageBox.setMessage("Jadabs - Administrator\n\n" + "ETH - Zuerich, IKS-Group\n\n"
                + "Andreas Frei, frei@inf.ethz.ch");

        messageBox.open();
    }
    
    public void dispose()
    {
        
        // remove this as frameworkListener
        Activator.rmanager.removeListener(this);
        
        // remove all bundle listener
        TreeItem[] items = peertree.getItems();
        
         
        for(int i =0; i < items.length; i++)
        {            
            Framework fw = Activator.rmanager.getFrameworkByPeername(
                    items[i].getText());
            fw.removeBundleInfoListener(this);
            
        }
    }
}