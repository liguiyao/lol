package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setTitle("Delete");
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(118, 76, 224, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		//文本为空的话提示输入相应信息，先打开member文本，将不删除的信息保存到ArrayList数组里，删除的信息不动，然后再打开member文本，将ArrayList数组里的数据覆盖原来文本，完成删除。
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Number cannot be empty", "Title",JOptionPane.WARNING_MESSAGE);
				else
				{
					String number = textField.getText();
					String str = null;			
					File file = new File("Member.txt"); 
					int flag = 0;
					int m = 0;
					List list = new ArrayList();
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
						while( (str=br.readLine()) != null )
						{
							m++;
							String[] strArr = str.split(" ");
							if(!strArr[0].equals(number))
							{
								list.add(str);
								flag++;
							}
						}
						if(flag == m)
						{
							JOptionPane.showMessageDialog(null, "There is no such person.", "Title",JOptionPane.WARNING_MESSAGE);
							textField.setText("");
						}
						else {
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
								JOptionPane.showMessageDialog(null, "Successful Delete");
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "Delete failure", "Title",JOptionPane.WARNING_MESSAGE);
							}	
						}
						}catch (IOException e2) {
							JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
						}
					
				}
				}
			}
		);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(170, 164, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_interface f2 = new Main_interface();
			    f2.setVisible(true);
				dispose();
			}
		});
		btnReturn.setForeground(Color.WHITE);
		btnReturn.setBackground(Color.BLACK);
		btnReturn.setBounds(170, 214, 93, 23);
		contentPane.add(btnReturn);
		
		
		
		JLabel lblNewLabel = new JLabel("Number");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(54, 79, 54, 15);
		contentPane.add(lblNewLabel);
	}

}
