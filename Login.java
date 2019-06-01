package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String username;
	String user="admin",password="123123";
	/**
	 * Create the frame.
	 */
	public Login() {
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Login");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 306);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(216, 102, 246, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 158, 247, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("User name:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(114, 102, 88, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(114, 158, 80, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Barber Customer Registration System");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(80, 10, 477, 63);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username=textField.getText();
				String password1 = String.valueOf(passwordField.getPassword());
				if(user.equals(username)&&password.equals(password1))
				{
				Main_interface f2 = new Main_interface();
			    f2.setVisible(true);
				dispose();
				}
				else {
					passwordField.setText("");
					JOptionPane.showMessageDialog(null, "The account number or password is incorrect. Please re-enter", "Title",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(280, 217, 93, 23);
		contentPane.add(btnNewButton);
	}
}
