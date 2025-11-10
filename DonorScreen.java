package SanadUI;

import javax.swing.*;
import java.awt.*;

public class DonorScreen extends JFrame {
	DatabaseLoader dataLoader = new DatabaseLoader();
    public DonorScreen() {
        setTitle("Donor - SANAD");
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


        Color backgroundColor = new Color(249, 244, 227);
        Color textColor = new Color(44, 90, 54);
        getContentPane().setBackground(backgroundColor);
        //setLayout(new BorderLayout()); 
        
        JPanel backgroundPanel = new JPanel(new BorderLayout()); 
        backgroundPanel.setBackground(backgroundColor);


        ImageIcon icon = new ImageIcon(getClass().getResource("logo.jpg"));
        Image image = icon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(image));
        logoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 20));
        backgroundPanel.add(logoLabel, BorderLayout.NORTH);


        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(backgroundColor);
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 300, 40, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;


        JTextField nameField = new JTextField(15);
        addText(nameField, "������ ����� �������� ������ ����������");
        JTextField ageField = new JTextField(15);  
        addText(ageField, "������ ����� �������� ������ ����������");
        
        JComboBox<String> typeBox = new JComboBox<>(new String[]{
                "����", "���", "������", "������ ����", "����� ���", "����", "������ �� ����� ���������", "����� �����"
        });
        JComboBox<String> areaBox = new JComboBox<>(new String[]{
                 "������", "�����", "������", "����", "��� �����"
        });
        JTextField phoneField = new JTextField(15);
        addText(phoneField, "������ ����� �������� ������ ����������");
        JTextField twitterField = new JTextField();
        
        addText(twitterField, "�������");
   
        JTextField facebookField = new JTextField();
        addText(facebookField, "�������");
        
        JTextField emailField = new JTextField();
        addText(emailField, "�������");

        JButton submitButton = new JButton("����� ��������");
        submitButton.setBackground(new Color(44, 90, 54));
        submitButton.setForeground(new Color(249, 244, 227));
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 16));


        addField(formPanel, gbc, "�����:", nameField, 0);
        addField(formPanel, gbc, "�����:", ageField, 1);
        addField(formPanel, gbc, "��� ��������:", typeBox, 2);
        addField(formPanel, gbc, "�������:", areaBox, 3);
        addField(formPanel, gbc, "��� �������:", phoneField, 4);
        addField(formPanel, gbc, "���� ����x:", twitterField, 5);
        addField(formPanel, gbc, "���� ������", facebookField, 6);
        addField(formPanel, gbc, "����� ����������", emailField, 7);

        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 100);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.ipadx = 120;
        formPanel.add(submitButton, gbc);

        backgroundPanel.add(formPanel, BorderLayout.CENTER);
        add(backgroundPanel);
        
       
        
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String type = translateTypeToEnglish((String) typeBox.getSelectedItem());
            String area = translateAreaToEnglish((String) areaBox.getSelectedItem());
            String phone = phoneField.getText().trim();
            String twitter = twitterField.getText().trim();
            String facebook = facebookField.getText().trim();
            String email = emailField.getText().trim();
            
            Contribution contribution;
            
            if (facebook.equals("")) 
            		contribution = new Contribution (name , area , phone , type);
            else
            		contribution = new Contribution (name , area , phone , type , facebook);
            dataLoader.establishConnection();
            dataLoader.loadToDatabase(contribution);
            dataLoader.closeConnection();
            

            if (name.isEmpty() || !name.matches("^[a-zA-Z]+$") ) {
                JOptionPane.showMessageDialog(this, "��� �� ����� ����� ��� ���� �������� ���", "���!",  JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            if (!ageText.matches("\\d{2}")) {
                JOptionPane.showMessageDialog(this, "������ ����� ��� ���� ���� �� �����", "���",  JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!phone.matches("^[0-9]{10}$")) {
                JOptionPane.showMessageDialog(this, "������ ����� ��� ���� �� 10 ����� �����", "���",  JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!twitter.isEmpty() && !twitter.equals("�������") && !twitter.startsWith("https://")) {
                JOptionPane.showMessageDialog(this, " ���� ������ ��� ����", "���",  JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!facebook.isEmpty() && !facebook.equals("�������") && !facebook.startsWith("https://")) {
                JOptionPane.showMessageDialog(this, " ���� ������ ��� ����", "���",  JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!email.isEmpty() && !email.equals("�������") && !email.startsWith("https://")) {
                JOptionPane.showMessageDialog(this, " ���� ������ ��� ����" , "���", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
           
            
         if (type.equals("���"))  {
        	 JOptionPane.showMessageDialog(this, " ����� ������:\n\n" +"����: 2159571 ���� ���� ����\n" +"����: 51363291 ���� ���� ����\n" +"��� ������ �������: 249910010077+" , "������� ������" , JOptionPane.INFORMATION_MESSAGE);
             return;
         }
       
            JOptionPane.showMessageDialog(this, "�� ����� ������ ������� �����! ����� �����");
        });
       

        setVisible(true);
    }
        
        private void addText(JTextField field, String text) {
        	field.setText(text);
        	field.setForeground(Color.GRAY);
        	field.addFocusListener(new java.awt.event.FocusAdapter() {
        
        @Override
    	public void focusGained(java.awt.event.FocusEvent ev) {
    		if(field.getText().equals(text)) {
    			field.setText("");
    			field.setForeground(Color.BLACK);
    			
    		}
    	}
    	
    	@Override
    	public void focusLost(java.awt.event.FocusEvent ev) {
    		if(field.getText().isEmpty()) {
    			field.setForeground(Color.GRAY);
    			field.setText(text);
    	        	}
              	}
            });    
        }     
     

    private void addField(JPanel panel, GridBagConstraints gbc, String labelText, JComponent field, int row) {
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;

        
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setForeground(new Color(44, 90, 54));
        panel.add(label, gbc);
        
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.ipadx = 100;
        gbc.ipady = 10;
        panel.add(field, gbc);
    }
    

    private static final java.util.Map<String, String> typeMap = new java.util.HashMap<>();
    static {
        typeMap.put("����", "");
        typeMap.put("���", "");
        typeMap.put("������", "");
        typeMap.put("������ ����", "");
        typeMap.put("����� ���", "");
        typeMap.put("����", "");
        typeMap.put("������ �� ����� ���������", "");
        typeMap.put("����� �����", "");
    }

    private String translateTypeToEnglish(String arabicType) {
        return typeMap.getOrDefault(arabicType, arabicType);
    }
    
    
    private static final java.util.Map<String, String> areaMap = new java.util.HashMap<>();
    static {
        areaMap.put("������", "");
        areaMap.put("�����", "");
        areaMap.put("������", "");
        areaMap.put("����", "");
        areaMap.put("��� �����", "");
    }

    private String translateAreaToEnglish(String arabicArea) {
        return areaMap.getOrDefault(arabicArea, arabicArea);
    }    
    
}