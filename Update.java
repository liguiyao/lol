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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

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
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String oldnumber = "";
	/**
	 * Create the frame.
	 */
	public Update() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setTitle("Update");
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
		comboBox.setBounds(117, 267, 84, 23);
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
		//文本为空的话提示输入相应信息，打开文本检查有编号与oldnumber相同的编号，将其他用户信息存入ArrayList数组，将与oldnumber相同信息修改后存入ArrayList数组，将ArrayList数组里的数据覆盖原来文本
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oldnumber.equals(""))
				{
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					JOptionPane.showMessageDialog(null, "Please start first", "Title",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String number = textField.getText();
					String name = textField_1.getText();
					String mobile = textField_2.getText();
					String sex = comboBox.getSelectedItem().toString();
					String level = comboBox_1.getSelectedItem().toString();
					String str = null;
					int flag = 0;
				    File file = new File("Member.txt"); 
				    List list = new ArrayList();
				    BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
						
						while( (str=br.readLine()) != null )
						{
							String[] strArr = str.split(" ");
							{
								if(strArr[0].equals(oldnumber))
								{
									if(number.equals(""))
										number = strArr[0];
									if(name.equals(""))
										name = strArr[1];
									if(mobile.equals(""))
										mobile = strArr[4];
									str =number+" "+name+" "+sex+" "+level+" "+mobile ;   
									list.add(str);
								}
								else
									list.add(str);
							}
						} 
						}catch (IOException e2) {
					}
					BufferedWriter bw ;
					try {
						bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
						for( int i=0;i<list.size();i++ ){
							bw.write(list.get(i).toString());
							bw.newLine();
							}
						bw.flush();
						bw.close();
						textField.setText("");
						JOptionPane.showMessageDialog(null, "Successful Update");
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Write failure", "Title",JOptionPane.WARNING_MESSAGE);
					}
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					oldnumber = "";
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
		//文本为空的话提示输入相应信息，如果输入了错误编号，会提醒文本里没有此人，输入正确编号，将编号存入oldnumber。
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				else {
					int flag = 0;
					String str = null;
					File file = new File("Member.txt");
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
						while( (str=br.readLine()) != null )
						{
							String[] strArr = str.split(" ");
							if(strArr[0].equals(textField.getText()))
								flag = 1;			
						} 
						if(flag == 0)
						{
							JOptionPane.showMessageDialog(null, "There is no such person, Please restart", "Title",JOptionPane.WARNING_MESSAGE);
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
						}
						else
						{
						oldnumber = textField.getText();
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						JOptionPane.showMessageDialog(null, "Successful Start");	
						}
						}catch (IOException e2){
							JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
						}
				}
			}
		});
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("宋体", Font.PLAIN, 14));
		btnStart.setBackground(Color.BLACK);
		btnStart.setBounds(329, 53, 93, 23);
		contentPane.add(btnStart);
	}
}
