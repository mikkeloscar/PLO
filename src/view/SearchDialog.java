package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchDialog extends JDialog implements ActionListener {
	
	private JTextField cprField;
    private boolean done;
    
    public SearchDialog(JFrame owner, boolean modal)
    {
        super(owner, modal);
        done = false;
        
        // Create the GUI
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3,2));
        
        cprField = new JTextField(16);
        inputPanel.add(new JLabel("Cpr:"));
        inputPanel.add(cprField);
        
        JPanel btnPanel   = new JPanel();
        JButton okBtn     = new JButton("Ok");
        JButton cancelBtn = new JButton("Cancel");
        okBtn.setActionCommand("ok");
        okBtn.addActionListener(this);
        cancelBtn.setActionCommand("cancel");
        cancelBtn.addActionListener(this);
        btnPanel.add(okBtn);
        btnPanel.add(cancelBtn);
        
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible(true);
    }
    
    public String getCpr()
    {
        if (!canceled())
            return cprField.getText();
        return null;
    }
    
    public boolean canceled()
    {
        return !done;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        if (command.equals("ok"))
        {
            if (cprField.getText().length() != 10)
                JOptionPane.showMessageDialog(this, "Indtast et gyldigt, CPR nr.");
            else
            {
                
                done = true;
                this.dispose();
                
            }
        }
        else if (command.equals("cancel"))
        {
            this.dispose();
        }
    }
}
