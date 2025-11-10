package SanadUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Welcome screen for SANAD app (Java Swing).
 * - Arabic texts 
 * - Button label
 * - The app logo
 */
public class WelcomeScreen extends JFrame {
	 private JFrame frame;
    public WelcomeScreen() {
        setTitle("SANAD - Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null); // center on screen
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(249, 244, 227));
 
        add(mainPanel);
        

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("sanad_logo.jpg"));
		Image sanadImage = logoIcon.getImage();
		Image image = sanadImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(image);
		JLabel sanadImageLabel = new JLabel(logoIcon);
		sanadImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
		
		JLabel textLabel1 = new JLabel(" سند... نحن بخير مادمنا معاً" , SwingConstants.CENTER);
		textLabel1.setFont(new Font("SansSerif", Font.BOLD, 25));
		textLabel1.setForeground(new Color(44, 90, 54));
		textLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		
        JLabel textLabel2 = new JLabel(" ساعد.. تبرع.. أو اطلب المساعدة! " , SwingConstants.CENTER);
        textLabel2.setFont(new Font("SansSerif", Font.BOLD, 25));
        textLabel2.setForeground(new Color(44, 90, 54));
        textLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
            
        
        JButton chooseButton = new JButton("اختر دورك");
        chooseButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        chooseButton.setBackground(new Color(44, 90, 54));
        chooseButton.setForeground(new Color(249, 244, 227));
        chooseButton.setFocusPainted(false);
        chooseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseButton.setPreferredSize(new Dimension(600, 45));
        chooseButton.setMaximumSize(new Dimension(600, 45));
        
        
        chooseButton.addActionListener(new ActionListener() {
        		
        		@Override
        		public void actionPerformed(ActionEvent e) {
        	         new RoleSelectionScreen();
                     dispose();
        	        
        	
        }
    	});
        
        
        JButton aboutButton = new JButton("عن التطبيق");
        aboutButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        aboutButton.setBackground(new Color(44, 90, 54));
        aboutButton.setForeground(new Color(249, 244, 227));
        aboutButton.setFocusPainted(false);
        aboutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        aboutButton.setPreferredSize(new Dimension(600, 45));
        aboutButton.setMaximumSize(new Dimension(600, 45));
        
        
        aboutButton.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
                dispose();
              AboutScreen aboutScreen = new AboutScreen();
              aboutScreen.setVisible(true);
        	}
        });
        
    
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(sanadImageLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(textLabel1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(textLabel2);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(chooseButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(aboutButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomeScreen());
 
       
    }
}


