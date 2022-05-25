 import java.awt.*;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
 import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 import java.util.Vector;
 /*     */ import java.sql.SQLException;

 /*     */
 /*     */ public class MenuPage extends JFrame implements ActionListener
/*     */ {
	Connection conn= null;
    ResultSet rs=null;
    PreparedStatement pst=null;
/*     */   private JPanel contentPane;
/*     */   private JFrame frmFrame;
/*     */   private JTextField txtqty;
/*     */   private JTable table;
/*     */   private JTextField total;
			private JOptionPane optionPane;
/*     */   

			private JButton confirmOrder;
			private int tableTotalPrice, tableTotalQuantity, tablePrice;
			private String tableOrderName;
/*     */   String item;
/*     */   String ind;
/*  33 */   int i = 0;
/*     */ 
/*     */   public MenuPage()
/*     */   {
	
/*  53 */     initialize2();
try {
    conn = Connect.fungsiKoneksi();
    
} catch (SQLException ex) {
    System.out.println("Form tidak tersambung");
}
/*     */   }
/*     */ 
/*     */   private void initialize2()
/*     */   {
/*  63 */     setDefaultCloseOperation(3);
/*  64 */     setBounds(100, 100, 988, 613);
/*  65 */     this.contentPane = new JPanel();
/*  66 */     this.contentPane.setBackground(new Color(255, 235, 205));
/*  67 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  68 */     setContentPane(this.contentPane);
/*  69 */     this.contentPane.setLayout(null);
/*     */ 
/*  71 */     this.txtqty = new JTextField();
/*  72 */     this.txtqty.setBounds(145, 446, 122, 29);
/*  73 */     this.contentPane.add(this.txtqty);
/*  74 */     this.txtqty.setColumns(10);
/*     */ 
/*  76 */     JPanel panel_2 = new JPanel();
/*  77 */     panel_2.setBounds(26, 490, 292, 82);
/*  78 */     panel_2.setBackground(new Color(255, 235, 205));
/*  79 */     this.contentPane.add(panel_2);
/*     */ 
/*  81 */     JPanel panel = new JPanel();
/*  82 */     panel.setBackground(new Color(255, 204, 153));
/*  83 */     panel.setBounds(0, 0, 972, 64);
/*  84 */     this.contentPane.add(panel);
/*  85 */     panel.setLayout(null);
/*     */ 
/*  87 */     JLabel lblNewLabel = new JLabel("Pizzania Cashier");
/*  88 */     lblNewLabel.setBounds(224, 5, 429, 73);
/*  89 */     panel.add(lblNewLabel);
/*  90 */     lblNewLabel.setForeground(new Color(0, 0, 0));
/*  91 */     lblNewLabel.setHorizontalAlignment(0);
/*  92 */     lblNewLabel.setFont(new Font("Segoe Script", 3, 45));
/*     */ 
/*  94 */     JButton btnNewButton_2 = new JButton("History");
/*  95 */     btnNewButton_2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent arg0) {
/*  97 */         History test1 = new History();
/*  98 */         MenuPage.this.contentPane.setVisible(false);
/*  99 */         test1.setVisible(true);
/*     */       }
/*     */     });
/* 107 */     btnNewButton_2.setBounds(837, 11, 89, 23);
/* 108 */     panel.add(btnNewButton_2);
/*     */ 
/* 110 */     JPanel foodMenu = new JPanel();
/* 111 */     foodMenu.setBorder(new BevelBorder(1, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
/* 112 */     foodMenu.setBackground(new Color(255, 99, 71));
/* 113 */     foodMenu.setBounds(10, 76, 271, 320);
/* 114 */     this.contentPane.add(foodMenu);
/* 115 */     foodMenu.setLayout(null);
/*     */ 
/* 117 */     JLabel lblNewLabel_1 = new JLabel("Food");
/* 118 */     lblNewLabel_1.setForeground(Color.BLACK);
/* 119 */     lblNewLabel_1.setFont(new Font("Segoe Script", 1, 18));
/* 120 */     lblNewLabel_1.setBounds(10, 11, 46, 23);
/* 121 */     foodMenu.add(lblNewLabel_1);
/*     */ 
/* 123 */     final JRadioButton btnMeatLovers = new JRadioButton("Meat Lovers");
/* 124 */     btnMeatLovers.setFont(new Font("Tahoma", 3, 13));
/* 125 */     btnMeatLovers.setForeground(new Color(102, 0, 0));
/* 126 */     btnMeatLovers.setBackground(new Color(255, 99, 71));
/* 127 */     btnMeatLovers.setBounds(10, 44, 109, 23);
/* 128 */     foodMenu.add(btnMeatLovers);
/*     */ 
/* 130 */     final JRadioButton btnMargherita = new JRadioButton("Margherita");
/* 131 */     btnMargherita.setFont(new Font("Tahoma", 3, 13));
/* 132 */     btnMargherita.setForeground(new Color(102, 0, 0));
/* 133 */     btnMargherita.setBackground(new Color(255, 99, 71));
/* 134 */     btnMargherita.setBounds(10, 124, 109, 23);
/* 135 */     foodMenu.add(btnMargherita);
/*     */ 
/* 137 */     final JRadioButton btnPepperoni = new JRadioButton("Pepperoni");
/* 138 */     btnPepperoni.setFont(new Font("Tahoma", 3, 13));
/* 139 */     btnPepperoni.setForeground(new Color(102, 0, 0));
/* 140 */     btnPepperoni.setBackground(new Color(255, 99, 71));
/* 141 */     btnPepperoni.setBounds(10, 70, 109, 23);
/* 142 */     foodMenu.add(btnPepperoni);
/*     */ 
/* 144 */     final JRadioButton btnTuna = new JRadioButton("Tuna Melt");
/* 145 */     btnTuna.setFont(new Font("Tahoma", 3, 13));
/* 146 */     btnTuna.setForeground(new Color(102, 0, 0));
/* 147 */     btnTuna.setBackground(new Color(255, 99, 71));
/* 148 */     btnTuna.setBounds(10, 150, 109, 23);
/* 149 */     foodMenu.add(btnTuna);
/*     */ 
/* 151 */     final JRadioButton btnCarbonara = new JRadioButton("Pasta Carbonara");
/* 152 */     btnCarbonara.setFont(new Font("Tahoma", 3, 13));
/* 153 */     btnCarbonara.setForeground(new Color(102, 0, 0));
/* 154 */     btnCarbonara.setBackground(new Color(255, 99, 71));
/* 155 */     btnCarbonara.setBounds(10, 96, 148, 23);
/* 156 */     foodMenu.add(btnCarbonara);
/*     */ 
/* 158 */     final JRadioButton btnChicken = new JRadioButton("Chicken Wings");
/* 159 */     btnChicken.setFont(new Font("Tahoma", 3, 13));
/* 160 */     btnChicken.setForeground(new Color(102, 0, 0));
/* 161 */     btnChicken.setBackground(new Color(255, 99, 71));
/* 162 */     btnChicken.setBounds(10, 176, 148, 23);
/* 163 */     foodMenu.add(btnChicken);
/*     */ 
/* 165 */     JPanel panel_1 = new JPanel();
/* 166 */     panel_1.setBorder(new BevelBorder(1, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
/* 167 */     panel_1.setBackground(new Color(46, 139, 87));
/* 168 */     panel_1.setBounds(291, 76, 215, 320);
/* 169 */     this.contentPane.add(panel_1);
/* 170 */     panel_1.setLayout(null);
/*     */ 
/* 172 */     JLabel lblNewLabel_2 = new JLabel("Beverages");
/* 173 */     lblNewLabel_2.setFont(new Font("Segoe Script", 1, 18));
/* 174 */     lblNewLabel_2.setBounds(10, 11, 124, 23);
/* 175 */     panel_1.add(lblNewLabel_2);
/*     */ 
/* 177 */     final JRadioButton btnWater = new JRadioButton("Mineral Water");
/* 178 */     btnWater.setFont(new Font("Tahoma", 3, 13));
/* 179 */     btnWater.setForeground(new Color(139, 0, 0));
/* 180 */     btnWater.setBackground(new Color(46, 139, 87));
/* 181 */     btnWater.setBounds(6, 43, 138, 23);
/* 182 */     panel_1.add(btnWater);
/*     */ 
/* 184 */     final JRadioButton btnCocaCola = new JRadioButton("Coca Cola");
/* 185 */     btnCocaCola.setFont(new Font("Tahoma", 3, 13));
/* 186 */     btnCocaCola.setForeground(new Color(139, 0, 0));
/* 187 */     btnCocaCola.setBackground(new Color(46, 139, 87));
/* 188 */     btnCocaCola.setBounds(6, 97, 136, 23);
/* 189 */     panel_1.add(btnCocaCola);
/*     */ 
/* 191 */     final JRadioButton btnFanta = new JRadioButton("Fanta");
/* 192 */     btnFanta.setFont(new Font("Tahoma", 3, 13));
/* 193 */     btnFanta.setForeground(new Color(139, 0, 0));
/* 194 */     btnFanta.setBackground(new Color(46, 139, 87));
/* 195 */     btnFanta.setBounds(6, 69, 138, 23);
/* 196 */     panel_1.add(btnFanta);
/*     */ 
/* 198 */     final JRadioButton btnSprite = new JRadioButton("Sprite");
/* 199 */     btnSprite.setFont(new Font("Tahoma", 3, 13));
/* 200 */     btnSprite.setForeground(new Color(139, 0, 0));
/* 201 */     btnSprite.setBackground(new Color(46, 139, 87));
/* 202 */     btnSprite.setBounds(6, 123, 136, 23);
/* 203 */     panel_1.add(btnSprite);
/*     */ 
/* 205 */     JLabel lblNewLabel_3 = new JLabel("Qty");
/* 206 */     lblNewLabel_3.setFont(new Font("Calibri", 1, 20));
/* 207 */     lblNewLabel_3.setBounds(55, 441, 70, 38);
/* 208 */     this.contentPane.add(lblNewLabel_3);
/*     */ 
/* 211 */     this.table = new JTable();
/* 212 */     this.table.setModel(new DefaultTableModel(new Object[0][], new String[] { "Order Name", "Price", "qty", "Total" }));
/*     */ 
/* 219 */     this.table.getColumnModel().getColumn(1).setPreferredWidth(225);
/* 220 */     this.table.getColumnModel().getColumn(2).setPreferredWidth(46);
/* 221 */     this.table.getColumnModel().getColumn(3).setPreferredWidth(110);
/*     */ 
/* 226 */     JScrollPane scrollPane = new JScrollPane();
/* 227 */     scrollPane.setViewportBorder(new BevelBorder(0, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
/* 228 */     scrollPane.setBounds(516, 75, 446, 413);
/* 229 */     this.contentPane.add(scrollPane);
/* 230 */     scrollPane.setViewportView(this.table);
/*     */

   
    confirmOrder = new JButton("Confirm Order");
    
/* 233 */
/* 234 */     confirmOrder.setFont(new Font("Tahoma", 1, 15));
/* 235 */     confirmOrder.setBounds(517, 506, 162, 47);
/* 236 */     this.contentPane.add(confirmOrder);

			confirmOrder.addActionListener(new ActionListener(){
	
	
					public void actionPerformed(ActionEvent e) {
							
						String orderName , price , qty , total;
			        	DefaultTableModel model;
			        	model = (DefaultTableModel) table.getModel();
			        	if(model.getRowCount()==0) {
			        		JOptionPane.showMessageDialog(optionPane, "Data Kosong");
			        	}else {
			        		try {
			        			for(int i = 0; i < model.getRowCount();i++) {
			        				orderName = model.getValueAt(i, 0).toString();
			        				price = model.getValueAt(i,1).toString();
			        				qty = model.getValueAt(i, 2).toString();
			        				total = model.getValueAt(i, 3).toString();
			        				
			        				String query = "insert into invoice(orderName,price,qty,total)Values(?,?,?,?)";
			        				
			        				pst = conn.prepareStatement(query);
			        				pst.setString(1, orderName);
			        				pst.setString(2, price);
			        				pst.setString(3, qty);
			        				pst.setString(4, total);
			        				pst.execute();
			        			}
			        		}catch(Exception x) {
			        			
			        		}
			        		JOptionPane.showMessageDialog(optionPane, "Transaksi sukses");
			        		model.setRowCount(0);
			        	}
				}
	
	
});
/*     */ 
/* 240 */     JButton btnAdd = new JButton("Add");
/* 241 */     btnAdd.setFont(new Font("Tahoma", 1, 15));
/* 242 */     btnAdd.setBounds(372, 437, 101, 47);
/* 243 */     this.contentPane.add(btnAdd);
/*     */ 
/* 245 */     JButton btnNewButton = new JButton("Delete");
/* 246 */     btnNewButton.setFont(new Font("Tahoma", 1, 15));
/* 247 */     btnNewButton.setBackground(new Color(255, 255, 255));
/* 248 */     btnNewButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 251 */         DefaultTableModel model = (DefaultTableModel)MenuPage.this.table.getModel();
/*     */         try
/*     */         {
/* 256 */           int SelectedRowIndex = MenuPage.this.table.getSelectedRow();
/* 257 */           model.removeRow(SelectedRowIndex);
/*     */         }
/*     */         catch (Exception ex) {
/* 260 */           JOptionPane.showMessageDialog(null, ex);
/*     */         }
/*     */       }
/*     */     });
/* 266 */     btnNewButton.setBounds(372, 498, 101, 47);
/* 267 */     this.contentPane.add(btnNewButton);
/*     */ 
/* 269 */     JLabel lblNewLabel_4 = new JLabel("Total");
/* 270 */     lblNewLabel_4.setFont(new Font("Tahoma", 1, 19));
/* 271 */     lblNewLabel_4.setBounds(740, 511, 60, 33);
/* 272 */     this.contentPane.add(lblNewLabel_4);
/*     */ 
/* 274 */     final JLabel totalUpdate = new JLabel(" ");
/* 275 */     totalUpdate.setForeground(Color.RED);
/* 276 */     totalUpdate.setFont(new Font("Tahoma", 1, 20));
/* 277 */     totalUpdate.setBounds(823, 512, 138, 37);
/* 278 */     this.contentPane.add(totalUpdate);
/*     */ 
/* 280 */     JLabel lblNewLabel_5 = new JLabel("Total");
/* 281 */     lblNewLabel_5.setFont(new Font("Calibri", 1, 20));
/* 282 */     lblNewLabel_5.setBounds(55, 512, 46, 14);
/* 283 */     this.contentPane.add(lblNewLabel_5);
/*     */ 
/* 285 */     this.total = new JTextField();
/* 286 */     this.total.setBounds(145, 445, 122, 29);
/* 287 */     this.contentPane.add(this.total);
/* 288 */     this.total.setColumns(10);
/* 289 */     btnAdd.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 292 */         if (MenuPage.this.txtqty.getText().isEmpty())
/*     */         {
/* 294 */           JOptionPane.showMessageDialog(MenuPage.this.frmFrame, "Tolong masukan jumlah produk!");
/*     */         }
/*     */         else
/*     */         {
/* 298 */           if (btnMeatLovers.isSelected() == true)
/*     */           {
/* 300 */             MenuPage.this.item = "Meat Lovers";
/*     */ 
/* 302 */             if (btnMargherita.isSelected() == true)
/*     */             {
/* 304 */               MenuPage.this.i = 50000;
/* 305 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 307 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 309 */               MenuPage.this.i = 65000;
/* 310 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 312 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 314 */               MenuPage.this.i = 65000;
/* 315 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 317 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 319 */               MenuPage.this.i = 30000;
/* 320 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 322 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 324 */               MenuPage.this.i = 25000;
/* 325 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 327 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 329 */               MenuPage.this.i = 7500;
/* 330 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 332 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 334 */               MenuPage.this.i = 5000;
/* 335 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 337 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 339 */               MenuPage.this.i = 5000;
/* 340 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 342 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 344 */               MenuPage.this.i = 5000;
/* 345 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 348 */           else if (btnMargherita.isSelected() == true)
/*     */           {
/* 351 */             MenuPage.this.item = "Margherita";
/*     */ 
/* 353 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 355 */               MenuPage.this.i = 70000;
/* 356 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 358 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 360 */               MenuPage.this.i = 65000;
/* 361 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 363 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 365 */               MenuPage.this.i = 65000;
/* 366 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 368 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 370 */               MenuPage.this.i = 30000;
/* 371 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 373 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 375 */               MenuPage.this.i = 25000;
/* 376 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 378 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 380 */               MenuPage.this.i = 7500;
/* 381 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 383 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 385 */               MenuPage.this.i = 5000;
/* 386 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 388 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 390 */               MenuPage.this.i = 5000;
/* 391 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 393 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 395 */               MenuPage.this.i = 5000;
/* 396 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 399 */           else if (btnPepperoni.isSelected() == true)
/*     */           {
/* 402 */             MenuPage.this.item = "Pepperoni";
/*     */ 
/* 404 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 406 */               MenuPage.this.i = 70000;
/* 407 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 409 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 411 */               MenuPage.this.i = 50000;
/* 412 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 414 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 416 */               MenuPage.this.i = 65000;
/* 417 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 419 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 421 */               MenuPage.this.i = 30000;
/* 422 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 424 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 426 */               MenuPage.this.i = 25000;
/* 427 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 429 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 431 */               MenuPage.this.i = 7500;
/* 432 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 434 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 436 */               MenuPage.this.i = 5000;
/* 437 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 439 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 441 */               MenuPage.this.i = 5000;
/* 442 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 444 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 446 */               MenuPage.this.i = 5000;
/* 447 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 450 */           else if (btnTuna.isSelected() == true)
/*     */           {
/* 453 */             MenuPage.this.item = "Tuna Melt";
/*     */ 
/* 455 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 457 */               MenuPage.this.i = 70000;
/* 458 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 460 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 462 */               MenuPage.this.i = 50000;
/* 463 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 465 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 467 */               MenuPage.this.i = 65000;
/* 468 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 470 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 472 */               MenuPage.this.i = 30000;
/* 473 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 475 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 477 */               MenuPage.this.i = 25000;
/* 478 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 480 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 482 */               MenuPage.this.i = 7500;
/* 483 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 485 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 487 */               MenuPage.this.i = 5000;
/* 488 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 490 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 492 */               MenuPage.this.i = 5000;
/* 493 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 495 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 497 */               MenuPage.this.i = 5000;
/* 498 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 501 */           else if (btnCarbonara.isSelected() == true)
/*     */           {
/* 504 */             MenuPage.this.item = "Pasta Carbonara";
/*     */ 
/* 506 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 508 */               MenuPage.this.i = 70000;
/* 509 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 511 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 513 */               MenuPage.this.i = 50000;
/* 514 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 516 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 518 */               MenuPage.this.i = 65000;
/* 519 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 521 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 523 */               MenuPage.this.i = 65000;
/* 524 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 526 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 528 */               MenuPage.this.i = 25000;
/* 529 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 531 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 533 */               MenuPage.this.i = 7500;
/* 534 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 536 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 538 */               MenuPage.this.i = 5000;
/* 539 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 541 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 543 */               MenuPage.this.i = 5000;
/* 544 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 546 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 548 */               MenuPage.this.i = 5000;
/* 549 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 552 */           else if (btnChicken.isSelected() == true)
/*     */           {
/* 555 */             MenuPage.this.item = "Chicken Wings";
/*     */ 
/* 557 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 559 */               MenuPage.this.i = 70000;
/* 560 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 562 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 564 */               MenuPage.this.i = 50000;
/* 565 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 567 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 569 */               MenuPage.this.i = 65000;
/* 570 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 572 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 574 */               MenuPage.this.i = 65000;
/* 575 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 577 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 579 */               MenuPage.this.i = 30000;
/* 580 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 582 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 584 */               MenuPage.this.i = 7500;
/* 585 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 587 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 589 */               MenuPage.this.i = 5000;
/* 590 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 592 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 594 */               MenuPage.this.i = 5000;
/* 595 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 597 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 599 */               MenuPage.this.i = 5000;
/* 600 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 603 */           else if (btnWater.isSelected() == true)
/*     */           {
/* 606 */             MenuPage.this.item = "Mineral Water";
/*     */ 
/* 608 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 610 */               MenuPage.this.i = 70000;
/* 611 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 613 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 615 */               MenuPage.this.i = 50000;
/* 616 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 618 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 620 */               MenuPage.this.i = 65000;
/* 621 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 623 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 625 */               MenuPage.this.i = 65000;
/* 626 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 628 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 630 */               MenuPage.this.i = 30000;
/* 631 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 633 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 635 */               MenuPage.this.i = 25000;
/* 636 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 638 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 640 */               MenuPage.this.i = 5000;
/* 641 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 643 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 645 */               MenuPage.this.i = 5000;
/* 646 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 648 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 650 */               MenuPage.this.i = 5000;
/* 651 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 654 */           else if (btnCocaCola.isSelected() == true)
/*     */           {
/* 657 */             MenuPage.this.item = "Coca Cola";
/*     */ 
/* 659 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 661 */               MenuPage.this.i = 70000;
/* 662 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 664 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 666 */               MenuPage.this.i = 50000;
/* 667 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 669 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 671 */               MenuPage.this.i = 65000;
/* 672 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 674 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 676 */               MenuPage.this.i = 65000;
/* 677 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 679 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 681 */               MenuPage.this.i = 30000;
/* 682 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 684 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 686 */               MenuPage.this.i = 25000;
/* 687 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 689 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 691 */               MenuPage.this.i = 7500;
/* 692 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 694 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 696 */               MenuPage.this.i = 5000;
/* 697 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/* 699 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 701 */               MenuPage.this.i = 5000;
/* 702 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 705 */           else if (btnFanta.isSelected() == true)
/*     */           {
/* 708 */             MenuPage.this.item = "Fanta";
/*     */ 
/* 710 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 712 */               MenuPage.this.i = 70000;
/* 713 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 715 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 717 */               MenuPage.this.i = 50000;
/* 718 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 720 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 722 */               MenuPage.this.i = 65000;
/* 723 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 725 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 727 */               MenuPage.this.i = 65000;
/* 728 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 730 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 732 */               MenuPage.this.i = 30000;
/* 733 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 735 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 737 */               MenuPage.this.i = 25000;
/* 738 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 740 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 742 */               MenuPage.this.i = 7500;
/* 743 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 745 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 747 */               MenuPage.this.i = 5000;
/* 748 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 750 */             else if (btnSprite.isSelected() == true)
/*     */             {
/* 752 */               MenuPage.this.i = 5000;
/* 753 */               MenuPage.this.ind = btnSprite.getText();
/*     */             }
/*     */           }
/* 756 */           else if (btnSprite.isSelected() == true)
/*     */           {
/* 759 */             MenuPage.this.item = "Sprite";
/*     */ 
/* 761 */             if (btnMeatLovers.isSelected() == true)
/*     */             {
/* 763 */               MenuPage.this.i = 70000;
/* 764 */               MenuPage.this.ind = btnMeatLovers.getText();
/*     */             }
/* 766 */             else if (btnMargherita.isSelected() == true)
/*     */             {
/* 768 */               MenuPage.this.i = 50000;
/* 769 */               MenuPage.this.ind = btnMargherita.getText();
/*     */             }
/* 771 */             else if (btnPepperoni.isSelected() == true)
/*     */             {
/* 773 */               MenuPage.this.i = 65000;
/* 774 */               MenuPage.this.ind = btnPepperoni.getText();
/*     */             }
/* 776 */             else if (btnTuna.isSelected() == true)
/*     */             {
/* 778 */               MenuPage.this.i = 65000;
/* 779 */               MenuPage.this.ind = btnTuna.getText();
/*     */             }
/* 781 */             else if (btnCarbonara.isSelected() == true)
/*     */             {
/* 783 */               MenuPage.this.i = 30000;
/* 784 */               MenuPage.this.ind = btnCarbonara.getText();
/*     */             }
/* 786 */             else if (btnChicken.isSelected() == true)
/*     */             {
/* 788 */               MenuPage.this.i = 25000;
/* 789 */               MenuPage.this.ind = btnChicken.getText();
/*     */             }
/* 791 */             else if (btnWater.isSelected() == true)
/*     */             {
/* 793 */               MenuPage.this.i = 7500;
/* 794 */               MenuPage.this.ind = btnWater.getText();
/*     */             }
/* 796 */             else if (btnCocaCola.isSelected() == true)
/*     */             {
/* 798 */               MenuPage.this.i = 5000;
/* 799 */               MenuPage.this.ind = btnCocaCola.getText();
/*     */             }
/* 801 */             else if (btnFanta.isSelected() == true)
/*     */             {
/* 803 */               MenuPage.this.i = 5000;
/* 804 */               MenuPage.this.ind = btnFanta.getText();
/*     */             }
/*     */           }
/*     */ 
/* 808 */           int qty = Integer.parseInt(MenuPage.this.txtqty.getText());
/* 809 */           int tot = qty * MenuPage.this.i;
/* 810 */           MenuPage.this.total.setText(String.valueOf(tot));
/* 811 */           DefaultTableModel model = (DefaultTableModel)MenuPage.this.table.getModel();
/* 812 */           model.addRow(new Object[] { MenuPage.this.item + " " + MenuPage.this.ind, 
/* 815 */             Integer.valueOf(MenuPage.this.i), 
/* 815 */             MenuPage.this.txtqty
/* 816 */             .getText(), MenuPage.this.total
/* 817 */             .getText() });
/*     */ 
/* 821 */           int sum = 0;
/* 822 */           for (int a = 0; a < MenuPage.this.table.getRowCount(); a++)
/*     */           {
/* 824 */             sum += Integer.parseInt(MenuPage.this.table.getValueAt(a, 3).toString());
/*     */           }
/* 826 */           totalUpdate.setText(Integer.toString(sum));
/* 827 */           btnMeatLovers.setSelected(false);
/* 828 */           btnMargherita.setSelected(false);
/* 829 */           btnPepperoni.setSelected(false);
/* 830 */           btnTuna.setSelected(false);
/* 831 */           btnCarbonara.setSelected(false);
/* 832 */           btnWater.setSelected(false);
/* 833 */           btnCocaCola.setSelected(false);
/* 834 */           btnFanta.setSelected(false);
/* 835 */           btnSprite.setSelected(false);
/* 836 */           MenuPage.this.txtqty.setText("");
/* 837 */           MenuPage.this.total.setText("");
/*     */         }
/*     */       }
/*     */     });
/*     */   }

    

    
    /*     */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == confirmOrder) {
			
        	

        }
		
	} }

/* Location:           D:\School binus\Semester 3\BAD\Assignment\Pizzania VER 5\PizzaniaPOS GROUP 2 BAD\dist\PizzaniaPOS_GROUP_2_BAD.jar
 * Qualified Name:     MenuPage
 * JD-Core Version:    0.6.2
 */