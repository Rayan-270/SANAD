package SanadUI;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class VictimScreen extends JFrame {

    public VictimScreen() {
        setTitle("Victim - SANAD");
        setSize(900, 600);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        	@Override
        	public void windowClosing(java.awt.event.WindowEvent e) {
        		dispose();
        		new WelcomeScreen().setVisible(true);
        	}
        });  


        Color backgroundColor = new Color(249, 244, 227);
        Color buttonColor = new Color(44, 90, 54);
        Color textColor = new Color(249, 244, 227);


        getContentPane().setBackground(backgroundColor);
        setLayout(new BorderLayout());


        JLabel logoLabel = new JLabel(new ImageIcon(getClass().getResource("sanad.jpg")));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        add(logoLabel, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));


        String[] buttonNames = {
            "طعام",
            "دعم مادي",
            "إيجاد ضائع",
            "مسكن",
            "طريقة ترحيل",
            "مساعدة طبية" ,
            "دعم نفسي",
            "كفالة الأيتام"
        };
        
        for (String name : buttonNames) {
        	
        //	final String buttonName = name;       	
            JButton btn = createButton(name, buttonColor, textColor);
            btn.addActionListener(e -> {
            	new InfoScreen(name).setVisible(true);
            	dispose();
            	});
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
            
    }  

            
            private JButton createButton(String text, Color buttonColor, Color textColor) {
            	JButton bt = new JButton(text) {
            		@Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        g2.setColor(getModel().isPressed() ? buttonColor.darker() : buttonColor);
                        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                        g2.setColor(textColor);
                        g2.setFont(getFont());
                        FontMetrics fm = g2.getFontMetrics();
                        int x = (getWidth() - fm.stringWidth(getText())) / 2;
                        int y = (getHeight() + fm.getAscent()) / 2 - 3;
                        g2.drawString(getText(), x, y);

                        g2.dispose();
                    }

                    @Override
                    public void updateUI() {
                        super.updateUI();
                    }
                };	
            	
                bt.setFont(new Font("SansSerif", Font.BOLD, 18));
                bt.setFocusPainted(false);
                bt.setContentAreaFilled(false);
                bt.setBorderPainted(false);
                bt.setOpaque(false);
                bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            		return bt;
            	
            	}
            
            
            
           /* btn.addActionListener(e -> {
                List<InfoScreen.Organization> orgs = new ArrayList<>();

                switch (buttonName) {
                    case "طعام" :
                        orgs.add(new InfoScreen.Organization("الوكالة الألمانية لمكافحة الجوع", "0923862907", "facebook.com/wfp", "", "", ""));
                        orgs.add(new InfoScreen.Organization("sadagat", "0923345566", "منظمة صدقات الخيرية", "facebook.com/wfp", "ksjcnk","kjd"));
                        orgs.add(new InfoScreen.Organization("مهاد عصام ميمي", "0923862907", "facebook.com/wfp", "", "", "kdkjdkmc"));
                       // orgs.add(new InfoScreen.Organization("اعسل تيم طبعا", "0923345566", "منظمة صدقات الخيرية", "jsdkfnkd", "ksjcnk","kjd"));
                        //orgs.add(new InfoScreen.Organization("وفاء ريان ترتيل فاطمة في الخدمة دائما", "0923862907", "facebook.com/wfp", "jcnsdjkhdkc", "kjdskdk", "kdkjdkmc"));
                       // orgs.add(new InfoScreen.Organization("اعسل تيم طبعا", "0923345566", "منظمة صدقات الخيرية", "jsdkfnkd", "ksjcnk","kjd"));
                      //  orgs.add(new InfoScreen.Organization("وفاء ريان ترتيل فاطمة في الخدمة دائما", "0923862907", "facebook.com/wfp", "jcnsdjkhdkc", "kjdskdk", "kdkjdkmc"));
                      //  orgs.add(new InfoScreen.Organization("اعسل تيم طبعا", "0923345566", "منظمة صدقات الخيرية", "jsdkfnkd", "ksjcnk","kjd"));
                        break;

                    case "دعم مادي":
                        orgs.add(new InfoScreen.Organization("", "0923862907", "instagram.com/help_life","","",""));
                        break;

                    case "إيجاد ضائع":
                        orgs.add(new InfoScreen.Organization("ط¬ظ…ط¹ظٹط© ط§ظ„ظ…ط£ظˆظ‰", "0911002233", "facebook.com/shelter","","",""));
                        break;

                    case "مسكن":
                        orgs.add(new InfoScreen.Organization("ط§ظ„ظ‡ظ„ط§ظ„ ط§ظ„ط£ط­ظ…ط±", "0909988776", "twitter.com/redcrescent","","",""));
                        break;

                    case "طريقة ترحيل":
                        orgs.add(new InfoScreen.Organization("ظ…ظ†ط¸ظ…ط© ط§ظ„ط¨ط­ط« ظˆط§ظ„ط¥ظ†ظ‚ط§ط°", "0991234567", "facebook.com/rescue","","",""));
                        break;

                    case "مساعدة طبية":
                        orgs.add(new InfoScreen.Organization("ظ‡ظٹط¦ط© ط§ظ„ظ†ظ‚ظ„ ط§ظ„ط·ط§ط±ط¦", "0921122334", "","","",""));
                        break;

                    case "دعم نفسي":
                        orgs.add(new InfoScreen.Organization("ط¯ط§ط± ط§ظ„ط£ظٹطھط§ظ… ط§ظ„ظƒط¨ط±ظ‰", "0912333444", "","","",""));
                        break;
                        
                    case "دعم الأيتام":
                        orgs.add(new InfoScreen.Organization("ط¯ط§ط± ط§ظ„ط£ظٹطھط§ظ… ط§ظ„ظƒط¨ط±ظ‰", "0912333444", "","","",""));
                        break;
                }

                new InfoScreen("").setVisible(true);
                dispose(); 
            });
    
        
            
    }*/


 
}