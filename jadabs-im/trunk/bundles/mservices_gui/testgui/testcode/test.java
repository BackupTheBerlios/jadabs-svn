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
				
				standardView.layout();
			}