package SanadUI;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class AboutScreen extends JFrame {

    private final Color mainColor = new Color(44, 90, 54);
    private final Color backgroundColor = new Color(249, 244, 227);

    private JLabel titleLabel;       
    private JLabel lettersLabel;     
    private JLabel firstLineLabel;   
    private JLabel finalLineLabel;   
    private String displayedTitle = "";
    private final String titleText = "SANAD";

    private final String[] letters = {"S", "A", "N", "A", "D"};
    private final String[] lettersMeanings = {"Support", "Assistance", "Needy", "And", "Displaced"};

    public AboutScreen() {
        setTitle("About SANAD");
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        	@Override
        	public void windowClosed(java.awt.event.WindowEvent e) {
        		dispose();
        		new WelcomeScreen().setVisible(true);
        	}
        });  


        JPanel mainPanel = new JPanel() {
            private Image bgImage = new ImageIcon(getClass().getResource("background.jpg")).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.setBackground(backgroundColor);


        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 70));
        titleLabel.setForeground(mainColor);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        lettersLabel = new JLabel("", SwingConstants.CENTER);
        lettersLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        lettersLabel.setForeground(mainColor);
        lettersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        firstLineLabel = new JLabel("", SwingConstants.CENTER);
        firstLineLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        firstLineLabel.setForeground(mainColor);
        firstLineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        finalLineLabel = new JLabel("", SwingConstants.CENTER);
        finalLineLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        finalLineLabel.setForeground(mainColor);
        finalLineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalStrut(100));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(lettersLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(firstLineLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(finalLineLabel);

        add(mainPanel);


        animateTitle();
    }

    private void animateTitle() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int index = 0;
            @Override
            public void run() {
                if (index < titleText.length()) {
                    displayedTitle += titleText.charAt(index);
                    titleLabel.setText(displayedTitle);
                    index++;
                } else {
                    timer.cancel();
                    animateLetters();
                }
            }
        }, 500, 600);
    }

    private void animateLetters() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int index = 0;
            @Override
            public void run() {
                if (index < letters.length) {
                    lettersLabel.setText(letters[index] + " = " + lettersMeanings[index]);
                    index++;
                } else {
                    timer.cancel();
                    lettersLabel.setText(""); 
                    firstLineLabel.setText("     Support and Assistance for Needy And Displaced");
                    Timer delayFinal = new Timer();
                    delayFinal.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            finalLineLabel.setText("<html><center>SANAD is a humble step from our heart<br>" +
                                    "to stand with every Sudanese soul seeking<br> "
                                    + " support, hope, and home.</center></html>");
                        }
                    }, 1000);
                }
            }
        }, 1000, 1000); 
    }
}
