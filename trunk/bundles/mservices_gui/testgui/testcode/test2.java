			{
				sendmsgView = new Composite(this, SWT.NONE);
				sendmsgViewLayout = new StackLayout();
				GridData sendmsgViewLData = new GridData();
				sendmsgViewLData.widthHint = 240;
				sendmsgViewLData.heightHint = 300;
				sendmsgView.setLayoutData(sendmsgViewLData);
				sendmsgView.setSize(new org.eclipse.swt.graphics.Point(240, 300));

				{	
						menu1.addMenuListener(new MenuAdapter() {
						public void menuShown(MenuEvent evt) {
							menu1MenuShown(evt);
						}
					});
				}
				
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
					sentView = new Composite(sendmsgView, SWT.NONE);
					RowLayout sentViewLayout = new RowLayout(org.eclipse.swt.SWT.HORIZONTAL);
					FormData sentViewLData = new FormData();
					sentView.setLayout(sentViewLayout);
					sentView.setLayoutData(sentViewLData);
				}
			}			

//				 Layout initialisieren
				sendmsgViewLayout.topControl = sendingView;
				sendmsgViewLayout.marginWidth = 5;
				sendmsgViewLayout.marginHeight = 5;
//				 Layout setzen
				sendmsgView.setLayout(sendmsgViewLayout);
				
				sendmsgView.layout();
			
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
            menubar = new Menu(getShell(), SWT.BAR);
            aboutmenue = new MenuItem(menubar, SWT.CASCADE);
            menu1 = new Menu(aboutmenue);

            getShell().setMenuBar(menubar);

            aboutmenue.setText("About");

            aboutmenue.setMenu(menu1);
            menu1.addMenuListener(new MenuAdapter()
            {

                public void menuShown(MenuEvent evt)
                {
                    menu1MenuShown(evt);
                }
            });

            postInitGUI();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}