package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("Add");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(117, 52, 192, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 124, 192, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 198, 192, 26);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		comboBox.setBounds(117, 267, 72, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setBackground(Color.BLACK);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBox_1.setBounds(117, 325, 56, 23);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_interface f2 = new Main_interface();
			    f2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(329, 397, 93, 23);
		contentPane.add(btnNewButton);
		//文本为空的话提示输入相应信息，先试图打开member文本检查是否有相同的用户编号，有的话会有消息框提示错误，打不开会创建一个member文本将信息保存
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else if(textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Name cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else if(textField_2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Mobile Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					String number = textField.getText();
					String name = textField_1.getText();
					String mobile = textField_2.getText();
					String sex = comboBox.getSelectedItem().toString();
					String level = comboBox_1.getSelectedItem().toString();
					String str = null;
					int flag = 0;
				    File file = new File("Member.txt"); 
				    BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
						
						while( (str=br.readLine()) != null )
						{
							String[] strArr = str.split(" ");
							if(strArr[0].equals(number))
								flag = 1;
						} 
						}catch (IOException e2) {
						}
					if(flag == 0)
						{
						try {   
							FileOutputStream text = new FileOutputStream (new File("Member.txt"), true) ; 
							text.write((number+" ").getBytes());
							text.write((name+" ").getBytes());
							text.write((sex+" ").getBytes());	
							text.write((level+" ").getBytes()); 
							text.write((mobile).getBytes()); 
							text.write("\r\n".getBytes());
							text.close ();  
							JOptionPane.showMessageDialog(null, "Successful Add");
							} catch (IOException a) {   
								JOptionPane.showMessageDialog(null, "Write failure", "Title",JOptionPane.WARNING_MESSAGE);  
							} 
						}
					else
						JOptionPane.showMessageDialog(null, "Number cannot be the same", "Title",JOptionPane.WARNING_MESSAGE);
					textField.setText(""); 
					textField_1.setText(""); 
					textField_2.setText("");
				}
		}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(329, 357, 93, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel = new JLabel("Number");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(10, 56, 72, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 128, 72, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile Number");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 203, 104, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("宋体", Font.PLAIN, 16));
		lblSex.setBackground(Color.BLACK);
		lblSex.setForeground(Color.WHITE);
		lblSex.setBounds(10, 270, 65, 15);
		contentPane.add(lblSex);
		
		JLabel lblVipLevel = new JLabel("VIP level");
		lblVipLevel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblVipLevel.setForeground(Color.WHITE);
		lblVipLevel.setBackground(Color.BLACK);
		lblVipLevel.setBounds(10, 329, 84, 15);
		contentPane.add(lblVipLevel);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(182, 27, 54, 15);
		contentPane.add(label_2);
	}
}
