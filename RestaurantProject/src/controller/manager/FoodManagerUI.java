package controller.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuUI;
import dao.impl.FoodDaoImpl;
import dao.impl.MemberDaoImpl;
import model.Food;
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

public class FoodManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JTextField did;
	private Boolean onSale = false;
	private Boolean onSaleEdit = false;
	private JTextField price;
	private JTextField inventory;
	private JTextField nameEdit;
	private JTextField priceEdit;
	private JTextField inventoryEdit;

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
	public FoodManagerUI() {
		setBackground(new Color(115, 185, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 686);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("菜單管理後台");
		lblNewLabel.setBounds(21, 10, 235, 50);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("品名");
		lblNewLabel_1.setBounds(10, 51, 61, 45);
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(51, 65, 71, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		
		
		
		JTextArea showAll = new JTextArea();
		showAll.setBounds(10, 171, 658, 294);
		contentPane.add(showAll);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("ID");
		lblNewLabel_1_5_1.setBounds(10, 484, 61, 50);
		lblNewLabel_1_5_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_5_1.setBackground(UIManager.getColor("Button.background"));
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
		id.setBounds(51, 500, 61, 21);
		id.setColumns(10);
		contentPane.add(id);
		
		
		//查詢
				JButton btnNewButton_1 = new JButton("查詢品項");
				btnNewButton_1.setBounds(583, 138, 85, 23);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					
					public void mouseClicked(MouseEvent e) {
						//showAll.setText(new MemberDaoImpl().queryAll2());
						List<Food> l=new FoodDaoImpl().queryAll();
						String show="";
						for(Food m:l)
						{
							show=show+"id"+m.getId()+"\tname:"+m.getFoodName()+"\n";
						}
						
						String count="共:"+l.size()+"個";
						showAll.setText(new FoodDaoImpl().queryAll2()+
								"\n========================================\n"+count);
						
					}
				});
				btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1);
				
				//addmember
				JButton btnNewButton = new JButton("新增品項");
				btnNewButton.setBounds(583, 105, 85, 23);

				btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				contentPane.add(btnNewButton);
					
				//修改
				JButton btnNewButton_1_1 = new JButton("修改品項");
				btnNewButton_1_1.setBounds(556, 573, 85, 23);
				btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1_1);
				
				
				//刪除
				
				JButton btnNewButton_1_2 = new JButton("刪除品項");
				btnNewButton_1_2.setBounds(556, 615, 85, 23);
				btnNewButton_1_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int ID=Integer.parseInt(did.getText());
						new FoodDaoImpl().deleteFood(ID);
						did.setText("");
						
					}
				});
				btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
				contentPane.add(btnNewButton_1_2);
				
				JLabel lblNewLabel_1_5_1_1 = new JLabel("刪除ID");
				lblNewLabel_1_5_1_1.setBounds(371, 599, 61, 50);
				lblNewLabel_1_5_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_5_1_1.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_5_1_1);
				
				did = new JTextField();
				did.setBounds(436, 615, 96, 21);
				did.setColumns(10);
				contentPane.add(did);
				
				JLabel lblNewLabel_1_6 = new JLabel("商品介紹");
				lblNewLabel_1_6.setBounds(10, 99, 112, 50);
				lblNewLabel_1_6.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_6.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_6);
				
				JLabel lblNewLabel_1_6_1 = new JLabel("是否上架");
				lblNewLabel_1_6_1.setBounds(480, 484, 79, 50);
				lblNewLabel_1_6_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_6_1.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_6_1);
				
				JCheckBox onSaleEditBox = new JCheckBox("");
				onSaleEditBox.setBounds(551, 492, 36, 36);
				onSaleEditBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!onSaleEdit) {
							onSaleEdit = true;
						}
						else {
							onSaleEdit = false;
						}
					}
				});
				onSaleEditBox.setHorizontalAlignment(SwingConstants.CENTER);
				onSaleEditBox.setBackground(SystemColor.activeCaption);
				contentPane.add(onSaleEditBox);
				
				JButton btnNewButton_1_1_1 = new JButton("登出");
				btnNewButton_1_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1_1_1.setBounds(583, 23, 85, 36);
				btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						MenuUI l=new MenuUI();
						l.setVisible(true);
						dispose();
					}
				});
				btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
				contentPane.add(btnNewButton_1_1_1);
				
				JLabel lblNewLabel_1_1 = new JLabel("價格");
				lblNewLabel_1_1.setBounds(142, 51, 61, 45);
				lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_1.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_1);
				
				price = new JTextField();
				price.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(e.getKeyChar()>57 || e.getKeyChar()<48) {
							e.consume();
						}
					}
				});
				price.setBounds(189, 65, 71, 21);
				price.setColumns(10);
				contentPane.add(price);
				
				JLabel lblNewLabel_1_1_1 = new JLabel("庫存");
				lblNewLabel_1_1_1.setBounds(282, 51, 61, 45);
				lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_1_1.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_1_1);
				
				inventory = new JTextField();
				inventory.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(e.getKeyChar()>57 || e.getKeyChar()<48) {
							e.consume();
						}
					}
				});
				inventory.setBounds(333, 65, 71, 21);
				inventory.setColumns(10);
				contentPane.add(inventory);
				
				JLabel lblNewLabel_1_1_1_1 = new JLabel("是否上架");
				lblNewLabel_1_1_1_1.setBounds(426, 51, 85, 45);
				lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_1_1_1.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_1_1_1);
				
				JCheckBox onSaleBox = new JCheckBox("");
				onSaleBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!onSale) {
							onSale = true;
						}
						else {
							onSale = false;
						}
					}
				});
				onSaleBox.setBounds(496, 55, 36, 36);
				onSaleBox.setHorizontalAlignment(SwingConstants.CENTER);
				onSaleBox.setBackground(SystemColor.activeCaption);
				contentPane.add(onSaleBox);
				
				JTextArea introduction = new JTextArea();
				introduction.setBounds(89, 96, 443, 65);
				contentPane.add(introduction);
				
				JLabel lblNewLabel_1_5_1_2 = new JLabel("品名");
				lblNewLabel_1_5_1_2.setBounds(122, 484, 61, 50);
				lblNewLabel_1_5_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_5_1_2.setBackground(UIManager.getColor("Button.background"));
				contentPane.add(lblNewLabel_1_5_1_2);
				
				nameEdit = new JTextField();
				nameEdit.setBounds(170, 500, 61, 21);
				nameEdit.setColumns(10);
				contentPane.add(nameEdit);
				
				JLabel lblNewLabel_1_5_1_2_1 = new JLabel("價格");
				lblNewLabel_1_5_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_5_1_2_1.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_5_1_2_1.setBounds(241, 484, 61, 50);
				contentPane.add(lblNewLabel_1_5_1_2_1);
				
				priceEdit = new JTextField();
				priceEdit.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(e.getKeyChar()>57 || e.getKeyChar()<48) {
							e.consume();
						}
					}
				});
				priceEdit.setColumns(10);
				priceEdit.setBounds(282, 500, 61, 21);
				contentPane.add(priceEdit);
				
				JLabel lblNewLabel_1_5_1_2_1_1 = new JLabel("庫存");
				lblNewLabel_1_5_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_5_1_2_1_1.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_5_1_2_1_1.setBounds(358, 484, 61, 50);
				contentPane.add(lblNewLabel_1_5_1_2_1_1);
				
				inventoryEdit = new JTextField();
				inventoryEdit.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						if(e.getKeyChar()>57 || e.getKeyChar()<48) {
							e.consume();
						}
					}
				});
				inventoryEdit.setColumns(10);
				inventoryEdit.setBounds(404, 500, 61, 21);
				contentPane.add(inventoryEdit);
				
				JLabel lblNewLabel_1_6_2 = new JLabel("商品介紹");
				lblNewLabel_1_6_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				lblNewLabel_1_6_2.setBackground(UIManager.getColor("Button.background"));
				lblNewLabel_1_6_2.setBounds(10, 531, 112, 50);
				contentPane.add(lblNewLabel_1_6_2);
				
				JTextArea introductionEdit = new JTextArea();
				introductionEdit.setBounds(89, 531, 443, 65);
				contentPane.add(introductionEdit);
				
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
				
				btnNewButton.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						Food m=new Food(
								name.getText(),
								Integer.parseInt(price.getText()),
								introduction.getText(),
								Integer.parseInt(inventory.getText()),
								onSale?1:0);
						
						
						new FoodDaoImpl().addFood(m);
						
						name.setText("");
						price.setText("");
						inventory.setText("");
						introduction.setText("");
					}
				});
				
				btnNewButton_1_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int ID=Integer.parseInt(id.getText());
						String foodName=nameEdit.getText();
						String price=priceEdit.getText();
						String inventory=inventoryEdit.getText();
						String introduction=introductionEdit.getText();
						
						
						Food m=new FoodDaoImpl().queryFoodById(ID);
						if(!foodName.equals(""))
							m.setFoodName(foodName);
						if(!price.equals(""))
							m.setPrice(Integer.parseInt(price));
						if(!inventory.equals(""))
							m.setInventory(Integer.parseInt(inventory));
						if(!introduction.equals(""))
							m.setIntroduction(introduction);
						m.setOnSale(onSaleEdit?1:0);
						
						
						new FoodDaoImpl().updateFood(m);
						
						
						id.setText("");
						nameEdit.setText("");
						priceEdit.setText("");
						inventoryEdit.setText("");
						introductionEdit.setText("");
						
					}
				});
	}
}
