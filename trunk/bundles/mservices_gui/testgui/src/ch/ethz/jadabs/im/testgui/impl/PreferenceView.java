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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.RowData;

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
public class PreferenceView extends Dialog
{
	private Shell dialogShell;
	
    private Composite preferenceView;
    private RowLayout preferenceViewLayout;
    
    	private Composite topLabels;
		
    	private TabFolder tabFolder1;
		
    		private TabItem tabItem1;
	    		private Composite compositeTabItem1;
		    		private Button button1;
		    		private Button button2;
			
			private TabItem tabItem2;
    		   	private Composite compositeTabItem2;
		    		private Button button3;
		    		private Button button4;    		

		private Text inputField;

		private Composite bottomLabels;
			private Button okButton;  
			private Button cancelButton;     

    		
	
	// own fields
	ch.ethz.jadabs.remotefw.Framework fw;
	
	public PreferenceView(Framework fw, Shell parent, int style)
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
				preferenceView = new Composite(dialogShell, SWT.NONE);
				RowLayout preferenceViewLayout1 = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
				preferenceView.setLayout(preferenceViewLayout1);
				{
					topLabels = new Composite(preferenceView, SWT.BORDER);
					RowLayout topLabelsLayout = new RowLayout(
						org.eclipse.swt.SWT.HORIZONTAL);
					RowData topLabelsLData = new RowData();
					topLabelsLData.width = 223;
					topLabelsLData.height = 73;
					topLabels.setLayoutData(topLabelsLData);
					topLabels.setLayout(topLabelsLayout);

				}
				{
					tabFolder1 = new TabFolder(preferenceView, SWT.NONE);
					RowLayout tabFolder1Layout = new RowLayout();
					RowData tabFolder1LData = new RowData();
					tabFolder1LData.width = 219;
					tabFolder1LData.height = 52;
					tabFolder1.setLayoutData(tabFolder1LData);
					{
						tabItem1 = new TabItem(tabFolder1, SWT.NONE);
						tabItem1.setText("tabItem1");
						{
							compositeTabItem1 = new Composite(
								tabFolder1,
								SWT.NONE);
							RowLayout compositeTabItem1Layout = new RowLayout(
								org.eclipse.swt.SWT.HORIZONTAL);
							compositeTabItem1
								.setLayout(compositeTabItem1Layout);
							tabItem1.setControl(compositeTabItem1);
							{
								button1 = new Button(
									compositeTabItem1,
									SWT.RADIO | SWT.LEFT);
								button1.setText("button1");
							}
							{
								button2 = new Button(
									compositeTabItem1,
									SWT.RADIO | SWT.LEFT);
								button2.setText("button2");
							}
						}
					}

					{
						tabItem2 = new TabItem(tabFolder1, SWT.NONE);
						tabItem2.setText("tabItem2");
						{
							compositeTabItem2 = new Composite(
								tabFolder1,
								SWT.NONE);
							RowLayout compositeTabItem2Layout = new RowLayout(
								org.eclipse.swt.SWT.HORIZONTAL);
							compositeTabItem2
								.setLayout(compositeTabItem2Layout);
							tabItem2.setControl(compositeTabItem2);
							{
								button3 = new Button(
									compositeTabItem2,
									SWT.CHECK | SWT.LEFT);
								button3.setText("button3");
							}
							{
								button4 = new Button(
									compositeTabItem2,
									SWT.CHECK | SWT.LEFT);
								button4.setText("button4");
							}
						}
					}
					tabFolder1.setLayout(tabFolder1Layout);
					tabFolder1.setSelection(0);
				}
				{
					inputField = new Text(preferenceView, SWT.CENTER
						| SWT.V_SCROLL
						| SWT.BORDER);
					inputField.setEditable(true);
					RowData inputFieldLData = new RowData();
					inputFieldLData.width = 196;
					inputFieldLData.height = 72;
					inputField.setLayoutData(inputFieldLData);
				}
				{
					bottomLabels = new Composite(preferenceView, SWT.BORDER);
					RowLayout bottomLabelsLayout = new RowLayout();
					bottomLabels.setLayout(bottomLabelsLayout);
					{
						okButton = new Button(bottomLabels, SWT.PUSH);
						okButton.setText("ok");
						okButton.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent evt) {
								okButtonWidgetSelected(evt);
							}
						});
					}

					{
						cancelButton = new Button(bottomLabels, SWT.PUSH);
						cancelButton.setText("cancel");
						cancelButton
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									cancelButtonWidgetSelected(evt);
								}
							});
					}

				}

//				 Neues Layout erzwingen				
			preferenceView.layout();	
			
			}

			
//			 Layout setzen
			dialogShell.setLayout(preferenceViewLayout);
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
	
		
		
}
