/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package notrproj;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Samar
 */
public class Notrproj extends JFrame{
    JTextArea a1;
    String str1;
    String str2;
    String str3;
    JMenu m1=new JMenu("FILE");
    JMenu m2=new JMenu("EDIT");
    JMenuBar b1=new JMenuBar();
    JMenuItem i1=new JMenuItem("CUT");
    JMenuItem i2=new JMenuItem("COPY");
    JMenuItem i3=new JMenuItem("PASTE");
    JMenuItem i4=new JMenuItem("CLOSE");
    JMenuItem i5=new JMenuItem("NEW");
    Notrproj()
    {
        this.a1 = new JTextArea(25,50);
        a1.setAlignmentY(JTextField.TOP);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        b1.add(m1);
        b1.add(m2);
        m2.add(i1);
        m2.add(i2);
        m2.add(i3);
        m1.add(i4);
        m1.add(i5);
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        this.add(b1,c);
        c.gridy=1;
        c.gridwidth = 7;
        this.add(a1,c);
        Handleclass h1=new Handleclass();
        i1.addActionListener(h1);
        i2.addActionListener(h1);
        i3.addActionListener(h1);
        i4.addActionListener(h1);
        i5.addActionListener(h1);
    }
    private class Handleclass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            str1=e.getActionCommand();
            switch(str1)
            {
                case "cut":str2=a1.getSelectedText();
                    break;
                case "copy":str2=a1.getSelectedText();
                    break;
                case "paste":a1.setText(str2);
                    break;
            }
        }

        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Notrproj f1=new Notrproj();
        f1.setSize(600,600);
        f1.setVisible(true);
        // TODO code application logic here
    }

   
    
}
