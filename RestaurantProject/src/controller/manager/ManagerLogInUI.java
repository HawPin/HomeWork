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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.SystemColor;

public class ManagerLogInUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogInUI frame = new ManagerLogInUI();
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
	public ManagerLogInUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 293);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 407, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("管理後台登入");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_2.setBounds(134, 10, 147, 24);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 64, 407, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 28, 64, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(41, 99, 55, 25);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(106, 28, 135, 32);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(106, 99, 135, 32);
		panel_1.add(password);
		password.setColumns(10);
		
		JLabel time = new JLabel("");
		time.setBounds(73, 164, 257, 15);
		panel_1.add(time);
		time.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setHorizontalAlignment(JLabel.CENTER);
		Timer timer = new Timer(1000, e -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            String formattedTime = dateFormat.format(new Date());
            time.setText("現在時間: " + formattedTime);
        });
        timer.start();
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取-->username,password->getText
				 * 2.判斷-->queryMember(帳號,密碼);
				 * 3.!=null-->LoginSuccessUI
				 * 4.LoginErrorUI
				 */
				
				String Username=username.getText();
				String Password=password.getText();
				Member m=new MemberDaoImpl().queryMember(Username, Password);
				
				if(m!=null && m.getPermission().equals("admin"))
				{
					
					try {
						FileOutputStream fos=new FileOutputStream("member.txt");
						ObjectOutputStream oos=new ObjectOutputStream(fos);
						oos.writeObject(m);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					ManagerLogInSuccess l=new ManagerLogInSuccess();
					l.setVisible(true);
					dispose();
				}
				else
				{
					ManagerLogInError l=new ManagerLogInError();
					l.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(281, 38, 85, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回選單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUI l=new MenuUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(281, 101, 85, 23);
		panel_1.add(btnNewButton_1);
	}
}
