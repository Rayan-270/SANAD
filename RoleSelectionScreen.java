package SanadUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RoleSelectionScreen extends JFrame {

    public RoleSelectionScreen() {
        setTitle("SANAD - Choose Role");    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setSize(800, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(249, 244, 227)); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        add(panel);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("logo.jpg"));
        Image logoImage = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(logoImage);
        
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logoLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        
        
     

        JLabel label2 = new JLabel("اختر دورك");
        label2.setFont(new Font("SansSerif", Font.BOLD, 24));
        label2.setForeground(new Color(44, 90, 54));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(0, 40)));

        
        
        
        
        JButton victimButton = new JButton("متضرر");
        victimButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        victimButton.setMaximumSize(new Dimension(500, 45));
        victimButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        victimButton.setForeground(new Color(249, 244, 227));
        victimButton.setBackground(new Color(44, 90, 54));
        panel.add(victimButton);
        
        victimButton.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	        dispose();
    	        VictimScreen victimScreen = new VictimScreen();
    	        victimScreen.setVisible(true);
    		}
        });
              panel.add(victimButton);
        
        

        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton donorButton = new JButton("متبرع");
        donorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        donorButton.setMaximumSize(new Dimension(500, 45));
        donorButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        donorButton.setForeground(new Color(249, 244, 227));
        donorButton.setBackground(new Color(44, 90, 54));
        panel.add(donorButton);
        
        donorButton.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    	        dispose();
    	        DonorScreen donorScreen = new DonorScreen();
    	        donorScreen.setVisible(true);
    		}
        });
              panel.add(donorButton);
        

        setVisible(true);
    }
}