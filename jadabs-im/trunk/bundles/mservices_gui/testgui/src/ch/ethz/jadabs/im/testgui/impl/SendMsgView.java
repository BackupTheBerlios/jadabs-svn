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
package ch.ethz.jadabs.im.testgui.impl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
    private RowLayout sendmsgViewLayout;
    
    	private Composite sendingView;
    	private RowLayout sendingViewLayout;
    
    		private Composite topLabels;
    			private Label toLabel;
    
    		private Text historyField;
    
    		private Composite middleLabels;
    			private Label statusLabel;
    			private Label statusLabelImage;
    
    		private Text inputField; 
    
    		private Composite bottomLabels;
    			private Button okButton;  
    			private Button sendButton;
    			private Button cancelButton;    
    
    	private Composite sentView; 
    		private RowLayout sentViewLayout;
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
				sendmsgView.setBounds(0, 0, 232, 285);

				{
					sendingView = new Composite(sendmsgView, SWT.NONE);
					sendingViewLayout = new RowLayout(org.eclipse.swt.SWT.VERTICAL);
					sendingView.setBounds(0, 0, 232, 285);
					sendingView.setLayout(sendingViewLayout);
					{
						topLabels = new Composite(sendingView, SWT.BORDER);
						RowLayout topLabelsLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
						topLabels.setLayout(topLabelsLayout);
						{
							toLabel = new Label(topLabels, SWT.NONE);
							toLabel.setText("To:");
						}
						{
							historyField = new Text(sendingView, SWT.MULTI
								| SWT.CENTER
								| SWT.READ_ONLY
								| SWT.V_SCROLL
								| SWT.BORDER);
							RowData historyFieldLData = new RowData();
							historyFieldLData.width = 196;
							historyFieldLData.height = 80;
							historyField.setLayoutData(historyFieldLData);
						}
						
						{
							middleLabels = new Composite(
								sendingView,
								SWT.BORDER);
							RowLayout middleLabelsLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
							middleLabels.setLayout(middleLabelsLayout);
							{
								statusLabel = new Label(middleLabels, SWT.NONE);
								statusLabel.setText("Status:");
								RowData statusLabelLData = new RowData();
								statusLabelLData.width = 46;
								statusLabelLData.height = 26;
								statusLabel.setLayoutData(statusLabelLData);
								{
									statusLabelImage = new Label(
										middleLabels,
										SWT.NONE);
								}
							}
							{
								inputField = new Text(
									sendingView,
									SWT.CENTER | SWT.V_SCROLL | SWT.BORDER);
								inputField.setEditable(true);
								RowData inputFieldLData = new RowData();
								inputFieldLData.width = 196;
								inputFieldLData.height = 80;
								inputField.setLayoutData(inputFieldLData);
							}
						}
						{
							bottomLabels = new Composite(
								sendingView,
								SWT.BORDER);
							RowLayout bottomLabelsLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
							bottomLabels.setLayout(bottomLabelsLayout);
							{
								okButton = new Button(
									bottomLabels,
									SWT.PUSH);
								okButton.setText("ok");
								okButton
								.addSelectionListener(new SelectionAdapter() {

									public void widgetSelected(
										SelectionEvent evt) {
										okButtonWidgetSelected(evt);
									}
								});									
							}
							
							{
								sendButton = new Button(
									bottomLabels,
									SWT.PUSH);
								sendButton.setText("send");
								sendButton
								.addSelectionListener(new SelectionAdapter() {

									public void widgetSelected(
										SelectionEvent evt) {
										sendButtonWidgetSelected(evt);
									}
								});									
							}
							{
								cancelButton = new Button(
									bottomLabels,
									SWT.PUSH);
								cancelButton
									.setText("cancel");
								cancelButton
									.addSelectionListener(new SelectionAdapter() {
										public void widgetSelected(
											SelectionEvent evt) {
											cancelButtonWidgetSelected(evt);
										}
									});
							}
						}
					}
				}

				{
					sentView = new Composite(sendmsgView, SWT.NONE);
					RowLayout sentViewLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					sentView.setBounds(0, 0, 232, 285);
					sentView.setLayout(sentViewLayout);
					{
						okButton2 = new Button(sentView, SWT.PUSH
							| SWT.CENTER);
						RowData okButton2LData = new RowData();
						okButton2.setText("ok");
						RowData okButton2LData1 = new RowData();
						okButton2LData1.width = 23;
						okButton2LData1.height = 23;
						okButton2.setLayoutData(okButton2LData1);
						okButton2
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(
									SelectionEvent evt) {
									okButtonWidgetSelected(evt);
								}
							});
					}

				}
				
//				 Layout setzen
				sendmsgView.setLayout(sendingViewLayout);
//				 Neues Layout erzwingen				
				sendmsgView.layout();		
				
			}


			
//			 Layout setzen
			dialogShell.setLayout(sendmsgViewLayout);
//			 Neues Layout erzwingen				
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
		sendmsgView.setLayout(sentViewLayout);
//		 Neues Layout erzwingen				
		sendmsgView.layout();		
		
//		 Layout setzen
		dialogShell.setLayout(sendmsgViewLayout);
//		 Neues Layout erzwingen				
		dialogShell.layout();
	
		
	}	
}
