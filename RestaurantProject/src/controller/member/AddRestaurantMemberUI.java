package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class AddRestaurantMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRestaurantMemberUI frame = new AddRestaurantMemberUI();
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
	public AddRestaurantMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 10, 410, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊會員");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 10, 103, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 74, 62, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(22, 130, 62, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼：");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(22, 186, 62, 24);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址：");
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(22, 238, 62, 24);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("手機：");
		lblNewLabel_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(22, 291, 62, 24);
		panel.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(81, 74, 112, 24);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(81, 130, 112, 24);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(81, 186, 112, 24);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(81, 238, 216, 24);
		panel.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(81, 291, 112, 24);
		panel.add(phone);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				
				Member m=new MemberDaoImpl().queryUsername(Username);
				
				if(m!=null)
				{
					AddRestaurantMemberError a=new AddRestaurantMemberError();
					a.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					
					Member m2=new Member(Name,Username,Password,Address,Phone,"client");
					new MemberDaoImpl().addMember(m2);
					
					AddRestaurantMemberSuccess a=new AddRestaurantMemberSuccess();
					a.setVisible(true);
					dispose();
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(261, 315, 95, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RestaurantLogIn l=new RestaurantLogIn();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(261, 368, 95, 34);
		panel.add(btnNewButton_1);
	}

}
