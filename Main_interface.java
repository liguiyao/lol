package system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main_interface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_interface frame = new Main_interface();
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
	public Main_interface() {
		setFont(new Font("宋体", Font.BOLD, 16));
		setTitle("Barber Customer Registration System");
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 519);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane =  new JScrollPane();
		scrollPane.setBounds(10, 137, 864, 333);
		contentPane.add(scrollPane);
		
		table= new JTable();
		scrollPane.setViewportView(table);
		
		
		textField = new JTextField();
		textField.setBounds(607, 105, 143, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add f2 = new Add();
			    f2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(68, 48, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete f2 = new Delete();
			    f2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(262, 48, 93, 23);
		contentPane.add(btnNewButton_1);
		//每次search前会先清空Jtable里数据，通过split(" ")分割字符串，将用户相应信息显示在相应位置
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					tableModel.setRowCount(0);
					Vector vData = new Vector();
					Vector vName = new Vector();
					vName.add("Number");
					vName.add("Name");
					vName.add("Sex");
					vName.add("Level");
					vName.add("Mobile Number");
					File file = new File("Member.txt"); 
					String str = null;
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
							while( (str=br.readLine()) != null )
							{
								Vector vRow = new Vector();
								String[] strArr = str.split(" ");
								for(int x = 0; x < 5; x++)
								{
									vRow.add(strArr[x]);
									
								}
								vData.add(vRow.clone());
							} 
							}catch (IOException e2) {
								JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
					}
					DefaultTableModel model = new DefaultTableModel(vData, vName);
					table.setModel(model);
			    }
				else
				{
					DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
					tableModel.setRowCount(0);
					Vector vData = new Vector();
					Vector vName = new Vector();
					vName.add("Number");
					vName.add("Name");
					vName.add("Sex");
					vName.add("Level");
					vName.add("Mobile Number");
					File file = new File("Member.txt"); 
					int flag = 0;
					String str = null;
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(file.getAbsolutePath()));
							while( (str=br.readLine()) != null )
							{
								String[] strArr = str.split(" ");
								if(strArr[0].equals(textField.getText()))
								{
									flag = 1;
									Vector vRow = new Vector();
								
									for(int x = 0; x < 5; x++)
									{
										vRow.add(strArr[x]);
									}
									vData.add(vRow.clone());
								}
							} 
							if(flag == 0)
								JOptionPane.showMessageDialog(null, "There is no such person.", "Title",JOptionPane.WARNING_MESSAGE);
							}catch (IOException e2) {
								JOptionPane.showMessageDialog(null, "File not found,Please Add", "Title",JOptionPane.WARNING_MESSAGE);
					}
					DefaultTableModel model = new DefaultTableModel(vData, vName);
					table.setModel(model);
				}	
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(760, 104, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update f2 = new Update();
			    f2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(463, 48, 93, 23);
		contentPane.add(btnNewButton_3);       
		
		JLabel lblNewLabel = new JLabel("Number");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(537, 108, 63, 15);
		contentPane.add(lblNewLabel);
		//清空Jtable里数据
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0);
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(657, 48, 93, 23);
		contentPane.add(btnClear);
 
	}
}
