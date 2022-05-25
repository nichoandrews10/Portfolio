/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class LoginPage
/*     */ {
/*     */   private JPanel contentPane;
/*  22 */   private Image img_logo = new ImageIcon(LoginPage.class.getResource("resources/Pizzania.png")).getImage().getScaledInstance(242, 330, 4);
/*     */   private JFrame frmMainframe;
/*     */   private JPasswordField passwordField;
/*     */   private JTextField USN2;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  31 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/*     */         try {
/*  34 */           LoginPage window = new LoginPage();
/*  35 */           window.frmMainframe.setVisible(true);
/*     */         } catch (Exception e) {
/*  37 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public LoginPage()
/*     */   {
/*  47 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*  54 */     this.frmMainframe = new JFrame();
/*  55 */     this.frmMainframe.getContentPane().setBackground(new Color(255, 255, 240));
/*  56 */     this.frmMainframe.setBackground(new Color(255, 255, 255));
/*  57 */     this.frmMainframe.setTitle("PizzaniaPOS");
/*  58 */     this.frmMainframe.setBounds(100, 100, 529, 391);
/*  59 */     this.frmMainframe.setDefaultCloseOperation(3);
/*  60 */     this.frmMainframe.getContentPane().setLayout(null);
/*     */ 
/*  62 */     JLabel lblNewLabel = new JLabel("Username");
/*  63 */     lblNewLabel.setFont(new Font("Calibri", 1, 30));
/*  64 */     lblNewLabel.setBounds(295, 88, 138, 31);
/*  65 */     this.frmMainframe.getContentPane().add(lblNewLabel);
/*     */ 
/*  67 */     JLabel lblPassword = new JLabel("Password");
/*  68 */     lblPassword.setFont(new Font("Calibri", 1, 30));
/*  69 */     lblPassword.setBounds(295, 157, 152, 31);
/*  70 */     this.frmMainframe.getContentPane().add(lblPassword);
/*     */ 
/*  72 */     final JTextField username22 = new JTextField();
/*  73 */     username22.setBounds(295, 115, 178, 31);
/*  74 */     this.frmMainframe.getContentPane().add(username22);
/*  75 */     username22.setColumns(10);
/*     */ 
/*  77 */     final JPasswordField password22 = new JPasswordField();
/*  78 */     password22.setFont(new Font("Calibri", 0, 20));
/*  79 */     password22.setBounds(295, 182, 178, 31);
/*  80 */     this.frmMainframe.getContentPane().add(password22);
/*     */ 
/*  84 */     JLabel lblNewLabel_1 = new JLabel("");
/*  85 */     lblNewLabel_1.setBackground(new Color(248, 248, 255));
/*  86 */     lblNewLabel_1.setBounds(12, 37, 226, 270);
/*  87 */     lblNewLabel_1.setIcon(new ImageIcon(this.img_logo));
/*  88 */     this.frmMainframe.getContentPane().add(lblNewLabel_1);
/*     */ 
/*  90 */     JButton btnLogin = new JButton("Login");
/*  91 */     btnLogin.setFont(new Font("Calibri", 0, 15));
/*     */ 
/*  93 */     btnLogin.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 101 */         String usn = username22.getText();
/* 102 */         String psd = password22.getText();
/*     */ 
/* 104 */         if ((usn.equals("Admin")) && (psd.equals("password")))
/*     */         {
/* 106 */           JOptionPane.showMessageDialog(LoginPage.this.frmMainframe, "Succesfull");
/*     */ 
/* 108 */           MenuPage Menu1 = new MenuPage();
/* 109 */           LoginPage.this.frmMainframe.setVisible(false);
/* 110 */           Menu1.setVisible(true);
/*     */         }
/*     */         else {
/* 113 */           JOptionPane.showMessageDialog(LoginPage.this.frmMainframe, "Wrong Password/Username");
/*     */         }
/*     */       }
/*     */     });
/* 119 */     btnLogin.setBounds(340, 224, 89, 23);
/* 120 */     this.frmMainframe.getContentPane().add(btnLogin);
/*     */   }
/*     */ }

/* Location:           D:\School binus\Semester 3\BAD\Assignment\Pizzania VER 5\PizzaniaPOS GROUP 2 BAD\dist\PizzaniaPOS_GROUP_2_BAD.jar
 * Qualified Name:     LoginPage
 * JD-Core Version:    0.6.2
 */