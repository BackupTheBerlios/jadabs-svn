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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;

import ch.ethz.jadabs.remotefw.Framework;

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
public class SendMsgView extends Dialog
{
	private Shell dialogShell;
	
    private Composite sendmsgView;
    private StackLayout sendmsgViewLayout;
    
    	private Composite sendingView;
    
    		private Composite topLabels;
    			private Label toLabel;
    
    		private Text historyField;
    
    		private Composite middleLabels;
    
    		private Text inputField; 
    
    		private Composite bottomLabels;
    			private Button okButton;  
    			private Button sendButton;
    			private Button cancelButton;    
    
    	private Composite sentView;   	
    	private Button okButton2;  
	
	// own fields
	ch.ethz.jadabs.remotefw.Framework fw;
	
	public SendMsgView(Framework fw, Shell parent, int style)
	{
		super(parent, style);
		
		this.fw = fw;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
			
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(240,320));	
			
			{
				sendmsgView = new Composite(dialogShell, SWT.NONE);
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
		        		topLabels = new Composite(sendingView, SWT.BORDER);
		    	    	RowData topLabelsLData = new RowData();
		    	    	topLabelsLData.width = 215;
		    	    	topLabelsLData.height = 23;
		    	    	topLabels.setLayoutData(topLabelsLData);
		        	}
		    		{
		    			toLabel = new Label(topLabels, SWT.NONE);
		    			toLabel.setText("To:");
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
		    			
						{
							sendButton = new Button(bottomLabels, SWT.PUSH
								| SWT.CENTER);
							sendButton.setText("send");
							sendButton.addSelectionListener(new SelectionAdapter() {
	
									public void widgetSelected(SelectionEvent evt) {
										sendButtonWidgetSelected(evt);
									}
								});
						}
						
						{
							okButton = new Button(bottomLabels, SWT.PUSH
								| SWT.CENTER);
							okButton.setText("ok");
							okButton.addSelectionListener(new SelectionAdapter() {
	
									public void widgetSelected(SelectionEvent evt) {
										okButtonWidgetSelected(evt);
									}
								});
						}
						
						{
							cancelButton = new Button(bottomLabels, SWT.PUSH
								| SWT.CENTER);
							cancelButton.setText("cancel");
							cancelButton.addSelectionListener(new SelectionAdapter() {
	
									public void widgetSelected(SelectionEvent evt) {
										cancelButtonWidgetSelected(evt);
									}
								});
						}
		    		}
				}
			


    		
				{
					sentView = new Composite(sendmsgView, SWT.NONE);
					RowLayout sentViewLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData sentViewLData = new FormData();
					sentView.setLayout(sentViewLayout);
					sentView.setLayoutData(sentViewLData);
					
					{
						okButton2 = new Button(sentView, SWT.PUSH
							| SWT.CENTER);
						okButton2.setText("ok");
						okButton2.addSelectionListener(new SelectionAdapter() {

								public void widgetSelected(SelectionEvent evt) {
									okButtonWidgetSelected(evt);
								}
							});
					}
					
				}
			
			}
			
//			 Layout initialisieren
			sendmsgViewLayout.topControl = sendingView;
			sendmsgViewLayout.marginWidth = 5;
			sendmsgViewLayout.marginHeight = 5;
//			 Layout setzen
			sendmsgView.setLayout(sendmsgViewLayout);
//			 Neues Layout erzwingen				
			sendmsgView.layout();
			
			StackLayout dialogShellLayout = new StackLayout();
          
//			 Layout initialisieren
            dialogShellLayout.topControl = sendmsgView;
            dialogShellLayout.marginWidth = 0;
            dialogShellLayout.marginHeight = 0;
//			 Layout setzen    
            dialogShell.setLayout(dialogShellLayout);
//          thisLayout.spacing = 0;
            dialogShell.layout();
			
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}


	/** Auto-generated event handler method */
	protected void okButtonWidgetSelected(SelectionEvent evt)
    {
		dialogShell.dispose();
    }
	
	

	/** Auto-generated event handler method */
	protected void cancelButtonWidgetSelected(SelectionEvent evt)
	{
		dialogShell.dispose();
	}
	
	protected void sendButtonWidgetSelected(SelectionEvent evt)
	{

//		 Layout initialisieren
		sendmsgViewLayout.topControl = sentView;
		sendmsgViewLayout.marginWidth = 5;
		sendmsgViewLayout.marginHeight = 5;
//		 Layout setzen
		sendmsgView.setLayout(sendmsgViewLayout);
//		 Neues Layout erzwingen				
		sendmsgView.layout();
		
	}	
}
