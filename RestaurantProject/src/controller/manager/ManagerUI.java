package controller.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuUI;
import dao.impl.MemberDaoImpl;
import model.Member;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField username;
	private JTextField nname;
	private JTextField npassword;
	private JTextField naddress;
	private JTextField nphone;
	private JTextField id;
	private JTextField did;
	private Boolean manager = false;
	private Boolean managerEdit = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI frame = new ManagerUI();
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
	public ManagerUI() {
		setBackground(new Color(115, 185, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 686);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員管理後台");
		lblNewLabel.setBounds(21, 10, 235, 50);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setBounds(10, 66, 61, 50);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號");
		lblNewLabel_1_1.setBounds(132, 66, 61, 50);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼");
		lblNewLabel_1_2.setBounds(258, 67, 61, 50);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址");
		lblNewLabel_1_3.setBounds(10, 117, 61, 50);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話");
		lblNewLabel_1_4.setBounds(391, 66, 61, 50);
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_4.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(51, 86, 71, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(294, 86, 71, 21);
		password.setColumns(10);
		contentPane.add(password);
		
		address = new JTextField();
		address.setBounds(51, 136, 314, 21);
		address.setColumns(10);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()>57 || e.getKeyChar()<48) {
					e.consume();
				}
			}
		});
		phone.setBounds(443, 85, 71, 21);
		phone.setColumns(10);
		contentPane.add(phone);
		
		username = new JTextField();
		username.setBounds(173, 86, 71, 21);
		username.setColumns(10);
		contentPane.add(username);
		
		
		
		
		JTextArea showAll = new JTextArea();
		showAll.setBounds(10, 171, 658, 294);
		contentPane.add(showAll);
		
		JLabel lblNewLabel_1_5 = new JLabel("姓名");
		lblNewLabel_1_5.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_5.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_5.setBounds(132, 484, 61, 50);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("密碼");
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_2_1.setBounds(247, 484, 61, 50);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("地址");
		lblNewLabel_1_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_3_1.setBounds(10, 531, 61, 50);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("電話");
		lblNewLabel_1_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_4_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_4_1.setBounds(391, 484, 61, 50);
		contentPane.add(lblNewLabel_1_4_1);
		
	
		
		
		nname = new JTextField();
		nname.setColumns(10);
		nname.setBounds(173, 500, 71, 21);
		contentPane.add(nname);
		
		npassword = new JTextField();
		npassword.setColumns(10);
		npassword.setBounds(294, 500, 71, 21);
		contentPane.add(npassword);
		
		naddress = new JTextField();
		naddress.setColumns(10);
		naddress.setBounds(51, 544, 298, 21);
		contentPane.add(naddress);
		
		nphone = new JTextField();
		nphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()>57 || e.getKeyChar()<48) {
					e.consume();
				}
			}
		});
		nphone.setColumns(10);
		nphone.setBounds(443, 500, 96, 21);
		contentPane.add(nphone);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("ID");
		lblNewLabel_1_5_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_5_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_1_5_1.setBounds(10, 484, 61, 50);
		contentPane.add(lblNewLabel_1_5_1);
		
		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()>57 || e.getKeyChar()<48) {
					e.consume();
				}
			}
		});
		id.setColumns(10);
		id.setBounds(51, 500, 61, 21);
		contentPane.add(id);
		
		
		//查詢
				JButton btnNewButton_1 = new JButton("查詢會員");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					
					public void mouseClicked(MouseEvent e) {
						//showAll.setText(new MemberDaoImpl().queryAll2());
						List<Member> l=new MemberDaoImpl().queryAll();
						String show="";
						for(Member m:l)
						{
							show=show+"id"+m.getId()+"姓名:"+m.getName()+"\n";
						}
						
						String count="共:"+l.size()+"個";
						showAll.setText(new MemberDaoImpl().queryAll2()+
								"\n========================================\n"+count);
						
					}
				});
				btnNewButton_1.setBounds(583, 144, 85, 23);
				btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1);
				
				//addmember
				JButton btnNewButton = new JButton("新增會員");
				btnNewButton.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						Member m=new Member(
								name.getText(),
								username.getText(),
								password.getText(),
								address.getText(),
								phone.getText(),
								manager?"admin":"client");
						
						
						new MemberDaoImpl().addMember(m);
						
						name.setText("");
						username.setText("");
						password.setText("");
						address.setText("");
						phone.setText("");
					}
				});
				btnNewButton.setBounds(583, 111, 85, 23);
				btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				contentPane.add(btnNewButton);
					
				//修改
				JButton btnNewButton_1_1 = new JButton("修改會員");
				btnNewButton_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				
				btnNewButton_1_1.setBounds(548, 544, 85, 23);
				btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1_1);
				
				
				//刪除
				
				JButton btnNewButton_1_2 = new JButton("刪除會員");
				btnNewButton_1_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int ID=Integer.parseInt(did.getText());
						new MemberDaoImpl().deleteMember(ID);
						did.setText("");
						
					}
				});
				btnNewButton_1_2.setBounds(548, 583, 85, 23);
				btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1_2);
				
				JLabel lblNewLabel_1_5_1_1 = new JLabel("刪除ID");
				lblNewLabel_1_5_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_5_1_1.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_5_1_1.setBounds(375, 572, 61, 50);
				contentPane.add(lblNewLabel_1_5_1_1);
				
				did = new JTextField();
				did.setColumns(10);
				did.setBounds(443, 586, 96, 21);
				contentPane.add(did);
				
				JLabel lblNewLabel_1_6 = new JLabel("是否為管理員");
				lblNewLabel_1_6.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_6.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_6.setBounds(385, 111, 112, 50);
				contentPane.add(lblNewLabel_1_6);
				
				JCheckBox chckbxNewCheckBox = new JCheckBox("");
				chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!manager) {
							manager = true;
						}
						else {
							manager = false;
						}
						
					}
				});
				chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxNewCheckBox.setBackground(SystemColor.activeCaption);
				chckbxNewCheckBox.setBounds(485, 118, 36, 36);
				contentPane.add(chckbxNewCheckBox);
				
				JLabel lblNewLabel_1_6_1 = new JLabel("是否為管理員");
				lblNewLabel_1_6_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_6_1.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_6_1.setBounds(375, 528, 112, 50);
				contentPane.add(lblNewLabel_1_6_1);
				
				JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
				chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!managerEdit) {
							managerEdit = true;
						}
						else {
							managerEdit = false;
						}
					}
				});
				chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
				chckbxNewCheckBox_1.setBackground(SystemColor.activeCaption);
				chckbxNewCheckBox_1.setBounds(479, 535, 36, 36);
				contentPane.add(chckbxNewCheckBox_1);
				
				JButton btnNewButton_1_1_1 = new JButton("登出");
				btnNewButton_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MenuUI l=new MenuUI();
						l.setVisible(true);
						dispose();
					}
				});
				btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
				btnNewButton_1_1_1.setBounds(583, 23, 85, 36);
				contentPane.add(btnNewButton_1_1_1);
				
				JLabel time = new JLabel("");
				time.setBounds(-20, 632, 224, 15);
				contentPane.add(time);
				time.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				time.setHorizontalAlignment(SwingConstants.CENTER);
				time.setHorizontalAlignment(JLabel.CENTER);
				Timer timer = new Timer(1000, e -> {
					SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		            String formattedTime = dateFormat.format(new Date());
		            time.setText("現在時間: " + formattedTime);
		        });
		        timer.start();
				
				
				btnNewButton_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int ID=Integer.parseInt(id.getText());
						String Name=nname.getText();
						String Password=npassword.getText();
						String Address=naddress.getText();
						String Phone=nphone.getText();
						
						
						Member m=new MemberDaoImpl().queryMemberById(ID);
						if(!Name.equals(""))
							m.setName(Name);
						if(!Password.equals(""))
							m.setPassword(Password);
						if(!Address.equals(""))
							m.setAddress(Address);
						if(!Phone.equals(""))
							m.setPhone(Phone);
						m.setPermission(managerEdit?"admin":"client");
						
						
						new MemberDaoImpl().updateMember(m);
						
						
						id.setText("");
						nname.setText("");
						npassword.setText("");
						naddress.setText("");
						nphone.setText("");
						
					}
				});
	}
}
