package controller.order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.FoodDaoImpl;
import dao.impl.OrderDaoImpl;
import model.Food;
import model.Order;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurantconfirmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean memberOrnot = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantconfirmUI frame = new RestaurantconfirmUI(false);
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
	public RestaurantconfirmUI(boolean memberorNOt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberOrnot = memberorNOt;
		setBounds(100, 100, 493, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 10, 456, 454);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("北哥餐館");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(94, 10, 245, 33);
		panel.add(lblNewLabel);
		
		JLabel custom = new JLabel("XXX。");
		custom.setHorizontalAlignment(SwingConstants.LEFT);
		custom.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		custom.setBounds(40, 20, 356, 72);
		panel.add(custom);
		
		
		
		JButton btnNewButton = new JButton("確定出餐");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.setBounds(337, 267, 97, 51);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("再想一下");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RestaurantUI f=new RestaurantUI(memberOrnot);
				f.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(337, 348, 97, 51);
		panel.add(btnNewButton_1);
		
		JTextArea output = new JTextArea();
		output.setBounds(40, 116, 266, 285);
		panel.add(output);
		
		Order p=(Order)(cal.readFile("Order.txt"));
		
		custom.setText(p.getName());
		
		JLabel lblNewLabel_1_1 = new JLabel("這是您點的菜。");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(40, 56, 356, 72);
		panel.add(lblNewLabel_1_1);
		
		JLabel time = new JLabel("");
		time.setBounds(-20, 429, 224, 15);
		panel.add(time);
		time.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setHorizontalAlignment(JLabel.CENTER);
		
		int sum=p.getAmount();
		
		String outputDetail= p.getDetails()+
				"\n共:"+sum+" 元";
		
		output.setText(outputDetail);
		

		
		Timer timer = new Timer(1000, e -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            String formattedTime = dateFormat.format(new Date());
            time.setText("現在時間: " + formattedTime);
        });
        timer.start();
        
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
	            String formattedTime = dateFormat.format(new Date());
	            List<Order> l=new OrderDaoImpl().queryAll();
        		p.setOrderNumber("ODE000"+l.size());
				p.setTime(formattedTime);
				new OrderDaoImpl().add(p);
				cal.saveFile("Order.txt", p);
				RestaurantFinishUI f=new RestaurantFinishUI();
				f.setVisible(true);
				dispose();
			}
		});
	}
}
