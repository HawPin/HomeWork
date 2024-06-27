package controller.order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import controller.MenuUI;
import dao.impl.FoodDaoImpl;
import model.Food;
import model.Member;
import model.Order;
import util.cal;

import java.awt.Color;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListModel;

public class RestaurantUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Food selectionFood;
	private List<Food> orderFood;
	private List<Integer> orderCount;
	private Order myOrder;
	private boolean memberOrnot = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantUI frame = new RestaurantUI(false);
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
	public RestaurantUI(boolean memberorNOt) {
		orderFood = new ArrayList();
		orderCount = new ArrayList();
		myOrder = new Order();
		myOrder.setAmount(0);
		myOrder.setDetails("");
		memberOrnot = memberorNOt;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 10, 656, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("歡迎光臨北哥餐館");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 192, 33);
		panel.add(lblNewLabel);
		
		
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("微軟正黑體", Font.BOLD, 17));
        textArea.setBackground(SystemColor.info);
        textArea.setEnabled(false);
        textArea.setBounds(24, 313, 316, 83);
        panel.add(textArea);
		
		List<Food> l=new FoodDaoImpl().queryAllOnSale();
		final DefaultListModel food = new DefaultListModel();

		for(Food f : l) {
				food.addElement(f.getFoodName() + "  " + f.getPrice());
		}
		JScrollPane fruitListScrollPane = new JScrollPane(); 
		fruitListScrollPane.setSize(147, 169);
		fruitListScrollPane.setLocation(36, 99);
		panel.add(fruitListScrollPane);
		
				JList list = new JList(food);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						Object x = list.getSelectedValue();
						for(Food f : l) {
							if((f.getFoodName() + "  " + f.getPrice()).equals(x.toString())){
								selectionFood = f;
								textArea.setText(f.getIntroduction());
							}
						}
					}
				});
				fruitListScrollPane.setViewportView(list);
				
						list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						list.setSelectedIndex(0);
						list.setVisibleRowCount(8);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(217, 192, 45, 22);
		panel.add(spinner);
		
		JButton btnNewButton = new JButton("放入");

		btnNewButton.setBounds(291, 180, 64, 45);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("菜單");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1.setBounds(70, 53, 64, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("已選擇的餐點");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(391, 53, 179, 36);
		panel.add(lblNewLabel_1_1);
		
		JLabel time = new JLabel("");
		time.setBounds(-22, 406, 224, 15);
		panel.add(time);
		time.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setHorizontalAlignment(JLabel.CENTER);

        
        JLabel lblNewLabel_1_2 = new JLabel("菜品介紹");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 24));
        lblNewLabel_1_2.setBounds(24, 278, 110, 36);
        panel.add(lblNewLabel_1_2);
        
        JButton btnNewButton_1 = new JButton("下單");

        btnNewButton_1.setBounds(504, 292, 104, 45);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("登出");
        btnNewButton_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MenuUI l=new MenuUI();
				l.setVisible(true);
				dispose();
        	}
        });
        btnNewButton_1_1.setBounds(504, 351, 104, 45);
        panel.add(btnNewButton_1_1);
        
        JScrollPane fruitListScrollPane_1 = new JScrollPane();
        fruitListScrollPane_1.setBounds(406, 99, 147, 169);
        panel.add(fruitListScrollPane_1);
        DefaultListModel order = new DefaultListModel();
        JList list_1 = new JList(order);
        list_1.setVisibleRowCount(8);
        list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_1.setSelectedIndex(0);
        fruitListScrollPane_1.setViewportView(list_1);
        
        JLabel notify = new JLabel("");
        notify.setHorizontalAlignment(SwingConstants.CENTER);
        notify.setFont(new Font("微軟正黑體", Font.BOLD, 18));
        notify.setBounds(217, 115, 138, 22);
        panel.add(notify);
        
       

        
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Integer.parseInt(spinner.getValue().toString()) > selectionFood.getInventory()) {
					notify.setText("庫存不夠!");
				}
				else if(Integer.parseInt(spinner.getValue().toString()) < 0|| Integer.parseInt(spinner.getValue().toString()) == 0) {
					notify.setText("不能點0份!");
				}
				else {
					order.addElement(selectionFood.getFoodName() + " * " + spinner.getValue());
    				orderFood.add(selectionFood);
    				orderCount.add(Integer.parseInt(spinner.getValue().toString()));
    				notify.setText("添加成功!");
				}
			}
		});
		
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Food[] f=orderFood.toArray(new Food[orderFood.size()]);
        		Integer[] fc=orderCount.toArray(new Integer[orderCount.size()]);
        		for(int i=0 ; i<f.length;i++) {
        			myOrder.setAmount(myOrder.getAmount() + (f[i].getPrice() * fc[i]));
        			myOrder.setDetails(myOrder.getDetails()+ f[i].getFoodName() + " * " + fc[i] + " = " + (f[i].getPrice() * fc[i]) + "元\n");
        		}
        		if(memberOrnot) {
        			Member m=(Member)(cal.readFile("member.txt"));
            		myOrder.setName(m.getName());
            		myOrder.setAmount(myOrder.getAmount() / 10 * 9 );
            		myOrder.setDetails(myOrder.getDetails()+"會員價打九折。\n");
        		}
        		else {
            		myOrder.setName("非會員訪客");
        			
        		}
        		
        	
				
				cal.saveFile("Order.txt", myOrder);
				
				RestaurantconfirmUI c=new RestaurantconfirmUI(memberOrnot);
				c.setVisible(true);
				dispose();
        	}
        });
		
		Timer timer = new Timer(1000, e -> {
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            String formattedTime = dateFormat.format(new Date());
            time.setText("現在時間: " + formattedTime);
            

        });
        timer.start();
        
        
	}
}
