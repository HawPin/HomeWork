package controller.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.Member;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogInSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogInSuccess frame = new ManagerLogInSuccess();
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
	public ManagerLogInSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(201, 55, 143, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("進入會員管理後台");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerUI a=new ManagerUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(114, 104, 187, 48);
		panel.add(btnNewButton);
		
		JLabel memberShow = new JLabel("登入成功");
		memberShow.setHorizontalAlignment(SwingConstants.CENTER);
		memberShow.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		memberShow.setBounds(54, 55, 143, 39);
		panel.add(memberShow);
		
		/*讀取物件檔*/
		try {
			FileInputStream fis=new FileInputStream("member.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			//System.out.println(ois.readObject());
			Member m=(Member)(ois.readObject());
			
			memberShow.setText(m.getName());
			
			JButton btnNewButton_1 = new JButton("進入菜單管理後台");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FoodManagerUI a=new FoodManagerUI();
					a.setVisible(true);
					dispose();
				}
			});
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
			btnNewButton_1.setBounds(114, 166, 187, 48);
			panel.add(btnNewButton_1);
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
