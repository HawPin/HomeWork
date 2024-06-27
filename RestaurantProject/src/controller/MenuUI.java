package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.manager.ManagerLogInUI;
import controller.member.RestaurantLogIn;
import controller.order.RestaurantUI;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

public class MenuUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUI frame = new MenuUI();
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
	public MenuUI() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 415, 51);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("歡迎使用北哥餐廳系統");
		lblNewLabel.setForeground(SystemColor.info);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(66, 10, 282, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 71, 415, 221);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton managerBtn = new JButton("管理後台");
		managerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerLogInUI l=new ManagerLogInUI();
				l.setVisible(true);
				dispose();
			}
		});
		managerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		managerBtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		managerBtn.setForeground(SystemColor.desktop);
		managerBtn.setBackground(SystemColor.info);
		managerBtn.setBounds(102, 10, 210, 44);
		panel_1.add(managerBtn);
		
		JButton noMemberBtn = new JButton("非會員進入餐廳");
		noMemberBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RestaurantUI l=new RestaurantUI(false);
				l.setVisible(true);
				dispose();
			}
		});
		noMemberBtn.setForeground(SystemColor.desktop);
		noMemberBtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		noMemberBtn.setBackground(SystemColor.info);
		noMemberBtn.setBounds(102, 73, 210, 44);
		panel_1.add(noMemberBtn);
		
		JButton logInBtn = new JButton("會員登入");
		logInBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RestaurantLogIn l=new RestaurantLogIn();
				l.setVisible(true);
				dispose();
			}
		});
		logInBtn.setForeground(SystemColor.desktop);
		logInBtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		logInBtn.setBackground(SystemColor.info);
		logInBtn.setBounds(102, 127, 210, 44);
		panel_1.add(logInBtn);
		
		JLabel time = new JLabel("");
		time.setBounds(70, 206, 257, 15);
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
		
		
	}
}
