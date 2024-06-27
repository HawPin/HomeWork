package controller.order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Order;
import util.cal;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class RestaurantFinishUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantFinishUI frame = new RestaurantFinishUI();
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
	public RestaurantFinishUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 10, 416, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBackground(SystemColor.info);
		output.setBounds(41, 25, 343, 170);
		panel.add(output);
		
		JButton btnNewButton = new JButton("列印明細");

		btnNewButton.setBounds(299, 205, 85, 23);
		panel.add(btnNewButton);
		
		Member m=(Member)(cal.readFile("member.txt"));
		Order p=(Order)(cal.readFile("Order.txt"));
		int sum=p.getAmount();
		String outputDetail="訂單號碼:"+p.getOrderNumber()+
				"\n客戶:"+p.getName()+"\t地址:"+m.getAddress()+"\t電話:"+m.getPhone()+
				"\n"+p.getDetails()+
				"\n=================================="+
				"\n小計:"+sum+"元";
		
		
		output.setText(outputDetail);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrinterJob printerJob = PrinterJob.getPrinterJob();
				printerJob.setPrintable(output.getPrintable(null, null));
				if (printerJob.printDialog()) {
					try {
						printerJob.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
	}

}