/*
 * DebuggingFeaturesFrame.java
 *
 * Created on April 1, 2002, 3:08 PM
 */

package gov.nist.sip.proxy.gui;

import gov.nist.sip.proxy.Configuration;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author deruelle
 * @version 1.0
 */
public class DebugPanel extends JPanel
{

    protected JPanel firstPanel;

    protected JPanel thirdPanel;

    protected JLabel badMessageLogFileLabel;

    protected JLabel outputProxyFileLabel;

    protected JLabel debugFileLabel;

    protected JLabel serverLogFileLabel;

    protected JCheckBox enableDebugCheckBox;

    protected JTextField badMessageLogFileTextField;

    protected JTextField outputProxyFileTextField;

    protected JTextField debugFileTextField;

    protected JTextField serverLogFileTextField;

    protected ProxyLauncher proxyLauncher;

    /** Creates new form DebuggingFeaturesFrame */
    public DebugPanel(ProxyLauncher proxyLauncher)
    {
        this.proxyLauncher = proxyLauncher;

        initComponents();

        // Init the components input:
        try
        {
            Configuration configuration = proxyLauncher.getConfiguration();
            if (configuration == null)
                return;
            if (configuration.enableDebug)
                enableDebugCheckBox.setSelected(true);
            else
                enableDebugCheckBox.setSelected(false);
            if (configuration.badMessageLogFile != null)
                badMessageLogFileTextField.setText(configuration.badMessageLogFile);
            if (configuration.debugLogFile != null)
                debugFileTextField.setText(configuration.debugLogFile);
            if (configuration.serverLogFile != null)
                serverLogFileTextField.setText(configuration.serverLogFile);
            if (configuration.outputProxy != null)
                outputProxyFileTextField.setText(configuration.outputProxy);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    public void initComponents()
    {

        /** **************** The components ********************************* */
        firstPanel = new JPanel();
        firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 2));
        // If put to False: we see the container's background
        firstPanel.setOpaque(false);
        //rows, columns, horizontalGap, verticalGap
        firstPanel.setLayout(new GridLayout(5, 2, 2, 4));
        this.setBorder(BorderFactory.createEmptyBorder(3, 5, 5, 3));
        this.add(firstPanel);

        enableDebugCheckBox = new JCheckBox("Enable Debug");
        enableDebugCheckBox.setBorderPainted(true);
        enableDebugCheckBox.setBorder(ProxyLauncher.labelBorder);
        enableDebugCheckBox.setSelected(true);
        enableDebugCheckBox.setFont(new Font("Dialog", 1, 12));
        enableDebugCheckBox.setBackground(ProxyLauncher.labelBackGroundColor);
        firstPanel.add(enableDebugCheckBox);

        JCheckBox ghostCheckBox = new JCheckBox("");
        ghostCheckBox.setVisible(false);
        firstPanel.add(ghostCheckBox);

        badMessageLogFileLabel = new JLabel("Bad messages log file:");
        badMessageLogFileLabel.setToolTipText("The bad messages log file that will be generated by the proxy");
        // Alignment of the text
        badMessageLogFileLabel.setHorizontalAlignment(AbstractButton.CENTER);
        // Color of the text
        badMessageLogFileLabel.setForeground(Color.black);
        // Size of the text
        badMessageLogFileLabel.setFont(new Font("Dialog", 1, 12));
        // If put to true: we see the label's background
        badMessageLogFileLabel.setOpaque(true);
        badMessageLogFileLabel.setBackground(ProxyLauncher.labelBackGroundColor);
        badMessageLogFileLabel.setBorder(ProxyLauncher.labelBorder);
        badMessageLogFileTextField = new JTextField(18);
        badMessageLogFileTextField.setHorizontalAlignment(AbstractButton.CENTER);
        badMessageLogFileTextField.setFont(new Font("Dialog", 0, 12));
        badMessageLogFileTextField.setBackground(ProxyLauncher.textBackGroundColor);
        badMessageLogFileTextField.setForeground(Color.black);
        badMessageLogFileTextField.setBorder(BorderFactory.createLoweredBevelBorder());
        firstPanel.add(badMessageLogFileLabel);
        firstPanel.add(badMessageLogFileTextField);

        outputProxyFileLabel = new JLabel("Output proxy file:");
        outputProxyFileLabel.setToolTipText("The output of the proxy is logged to this file");
        // Alignment of the text
        outputProxyFileLabel.setHorizontalAlignment(AbstractButton.CENTER);
        // Color of the text
        outputProxyFileLabel.setForeground(Color.black);
        // Size of the text
        outputProxyFileLabel.setFont(new Font("Dialog", 1, 12));
        // If put to true: we see the label's background
        outputProxyFileLabel.setOpaque(true);
        outputProxyFileLabel.setBackground(ProxyLauncher.labelBackGroundColor);
        outputProxyFileLabel.setBorder(ProxyLauncher.labelBorder);
        outputProxyFileTextField = new JTextField(18);
        outputProxyFileTextField.setHorizontalAlignment(AbstractButton.CENTER);
        outputProxyFileTextField.setFont(new Font("Dialog", 0, 12));
        outputProxyFileTextField.setBackground(ProxyLauncher.textBackGroundColor);
        outputProxyFileTextField.setForeground(Color.black);
        outputProxyFileTextField.setBorder(BorderFactory.createLoweredBevelBorder());
        firstPanel.add(outputProxyFileLabel);
        firstPanel.add(outputProxyFileTextField);

        debugFileLabel = new JLabel("Debug file:");
        debugFileLabel.setToolTipText("The debug file that will be generated by the proxy");
        // Alignment of the text
        debugFileLabel.setHorizontalAlignment(AbstractButton.CENTER);
        // Color of the text
        debugFileLabel.setForeground(Color.black);
        // Size of the text
        debugFileLabel.setFont(new Font("Dialog", 1, 12));
        // If put to true: we see the label's background
        debugFileLabel.setOpaque(true);
        debugFileLabel.setBackground(ProxyLauncher.labelBackGroundColor);
        debugFileLabel.setBorder(ProxyLauncher.labelBorder);
        debugFileTextField = new JTextField(18);
        debugFileTextField.setHorizontalAlignment(AbstractButton.CENTER);
        debugFileTextField.setFont(new Font("Dialog", 0, 12));
        debugFileTextField.setBackground(ProxyLauncher.textBackGroundColor);
        debugFileTextField.setForeground(Color.black);
        debugFileTextField.setBorder(BorderFactory.createLoweredBevelBorder());
        firstPanel.add(debugFileLabel);
        firstPanel.add(debugFileTextField);

        serverLogFileLabel = new JLabel("Server log file:");
        serverLogFileLabel.setToolTipText("The server log file that will be generated"
                + "by the stack for logging the messages");
        // Alignment of the text
        serverLogFileLabel.setHorizontalAlignment(AbstractButton.CENTER);
        // Color of the text
        serverLogFileLabel.setForeground(Color.black);
        // Size of the text
        serverLogFileLabel.setFont(new Font("Dialog", 1, 12));
        // If put to true: we see the label's background
        serverLogFileLabel.setOpaque(true);
        serverLogFileLabel.setBackground(ProxyLauncher.labelBackGroundColor);
        serverLogFileLabel.setBorder(ProxyLauncher.labelBorder);
        serverLogFileTextField = new JTextField(18);
        serverLogFileTextField.setHorizontalAlignment(AbstractButton.CENTER);
        serverLogFileTextField.setFont(new Font("Dialog", 0, 12));
        serverLogFileTextField.setBackground(ProxyLauncher.textBackGroundColor);
        serverLogFileTextField.setForeground(Color.black);
        serverLogFileTextField.setBorder(BorderFactory.createLoweredBevelBorder());
        firstPanel.add(serverLogFileLabel);
        firstPanel.add(serverLogFileTextField);

    }

    public boolean check(String text)
    {
        if (text == null || text.trim().equals(""))
        {
            return false;
        } else
            return true;
    }

}