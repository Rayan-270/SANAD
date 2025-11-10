package SanadUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class InfoScreen extends JFrame {

    public InfoScreen(String categoryArabic) {
        setTitle("معلومات الدعم");
        setSize(900, 600);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        	@Override
        	public void windowClosed(java.awt.event.WindowEvent e) {
        		dispose();
        		new WelcomeScreen().setVisible(true);
        	}
        }); 
        
        setLocationRelativeTo(null);
        
        ///////////////////////
        
        String categoryEnglish = convertCategoryToEnglish(categoryArabic);
        //change the class name
        App a = new App();
        ArrayList<String> orgs = a.getdata(categoryEnglish);
        
        
        
        Color bgColor = new Color(249, 244, 227); 
        Color cardColor = new Color(240, 226, 200); 
        setBackground(bgColor);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(bgColor);
        backgroundPanel.setLayout(new BorderLayout());
        
        JButton backButton = new JButton("رجوع");
        backButton.setBackground(new Color(44, 90, 54));
        backButton.setForeground(new Color(249, 244, 227));
        backButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10,20 , 10, 20));

        backButton.addActionListener(e -> {
            dispose();
            new VictimScreen().setVisible(true);
        });


        JLabel title = new JLabel("معًا لنمد يد العون لنعيد الأمل... فريق سند" + categoryArabic, SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(new Color(44, 90, 54));
        backgroundPanel.add(title, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
        backgroundPanel.add(topPanel, BorderLayout.NORTH);



        // JLabel title = new JLabel(" ننمعاً لنمد يد العون لنعيد الأمل... فريق سند " +categoryArabic, SwingConstants.CENTER);
        // title.setFont(new Font("SansSerif", Font.BOLD, 26));
        // title.setForeground(new Color(44, 90, 54));


        JPanel cardPanel = new JPanel();
        cardPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 20, 100));
        cardPanel.setOpaque(false);
        cardPanel.setLayout(new GridLayout(0, 2, 25, 25));


        for (String org : orgs) {
            JPanel card = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    g2.setColor(new Color(0, 0, 0, 30));
                    g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 25, 25);

                    g2.setColor(cardColor);
                    g2.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 25, 25);
                }
            };

            card.setOpaque(false);
            card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

            String text = "<html>" + org.replace("\n", "<br>") + "</html>";
            JLabel label = new JLabel(text);
            label.setFont(new Font("SansSerif", Font.BOLD, 18));
            label.setForeground(new Color(60, 50, 30));
            card.add(label); 
            cardPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        add(backgroundPanel);
    }

    
    private String convertCategoryToEnglish(String arabicName) {
    	switch (arabicName) {
            case "طعام" :
                return "food";
            case "دعم مادي" :
                return "financialsupport";
            case "إيجاد ضائع" :
                return "wasted";
            case "مسكن" :
                return "housing";
            case "طريقة ترحيل" :
                return "evacuationprocess";
            case "مساعدة طبية" :
                return "medicalassistance";
            case "دعم نفسي" :
                return "";
            case "كفالة الأيتام" :
                return "orphansupport";
            default :
                return "general";
        } 
    }
}
    
    
    