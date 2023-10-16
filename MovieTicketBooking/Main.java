import javax.swing.JPanel;
import javax.swing.JFrame; 
import java.awt.Color; 
import javax.swing.JLabel; 
import javax.swing.DefaultComboBoxModel; 
import javax.swing.ImageIcon; 
import javax.swing.JTextField; 
import javax.swing.SwingConstants; 
import javax.swing.JComboBox; 
import java.awt.Font; 
import javax.swing.JButton; 
import java.awt.event.ActionListener; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.awt.event.ActionEvent; 
import java.sql.ResultSet; 
import java.awt.*; 
import java.sql.Statement; 
import javax.swing.JPasswordField; 
 
class frontPage extends JFrame implements ActionListener 

{
    private JPanel panel; 
    private JTextField txtUsername;
    private JPasswordField passwordField; 
    private JLabel lblUsername,lblPassword; 
    private JButton btnSignin,btnLogin; 

    public void front() 
    { 
        panel=new JPanel(null); 
 
        JLabel pic=new JLabel("");         
        pic.setBounds(20,11,1236,688); 
        pic.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\uk-movie.jpg"));         
        pic.setHorizontalAlignment(SwingConstants.CENTER); 
 
        JLabel MovTic =new JLabel("Movie Ticket Booking"); 
        MovTic.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,60));         
        MovTic.setBounds(78,65,560,81); 
 
        lblUsername=new JLabel("Username"); 
        lblUsername.setFont(new Font("Times New Roman",Font.BOLD,25));         
        lblUsername.setForeground(Color.BLACK); 
        lblUsername.setBounds(609,318,135,43); 
 
        lblPassword=new JLabel("Password"); 
        lblPassword.setFont(new Font("Times New Roman",Font.BOLD,25));         
        lblPassword.setForeground(Color.BLACK); 
        lblPassword.setBounds(609,389,135,43); 
 
        txtUsername=new JTextField(); 
        txtUsername.setBounds(804, 324, 391, 43); 
 
        passwordField =new JPasswordField(); 
        passwordField.setBounds(801, 395, 394, 43); 
 
        btnLogin=new JButton("Login"); 
        btnLogin.setFont(new Font("Times New Roman",Font.BOLD,25));         
        btnLogin.setBounds(829, 490, 149, 43); 
 
        btnSignin=new JButton("Sign in"); 
        btnSignin.setFont(new Font("Times New Roman",Font.BOLD,25));         
        btnSignin.setBounds(1020, 490, 149, 43); 
 
        panel.setBackground(Color.WHITE); 
        panel.add(MovTic);         
        panel.add(lblUsername);         
        panel.add(lblPassword);         
        panel.add(txtUsername);        
        panel.add(passwordField);        
        panel.add(btnLogin);     
        panel.add(btnSignin);     
        panel.add(pic);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        btnLogin.addActionListener(this);     
        btnSignin.addActionListener(this); 
        add(panel,BorderLayout.CENTER);        
        setTitle("Movie Ticket Booking");        
        setSize(1000,1000); 
        setVisible(true); 
        setLocationRelativeTo(null); 
    } 
 
    public void actionPerformed(ActionEvent e)  
    { 
        String str; 
        str=e.getActionCommand();         
        System.out.println(str); 
        if(str.equalsIgnoreCase("Sign in")) 
        { 
            new signin(); 
        } 
        else if(str.equalsIgnoreCase("Login")) 
        {             
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root" , "");
                Statement stmt = con.createStatement();
                
                String user = txtUsername.getText();
                String pass = passwordField.getText();

                String sql = "Select * from signin";
                ResultSet rs = stmt.executeQuery(sql);
                int count = 0; 
                while(rs.next()) 
                { 
                    String user1 = rs.getString("Username");                     
                    String pass1 = rs.getString("Password"); 
                    if(user1.equals(user) && pass1.equals(pass)) 
                    { 
                        System.out.println("Matched"); 
                        count++;                         
                        new home(); 
                        break; 
                    } 
                } 
                if(count == 0) 
                { 
                    new login1(); 
                } 
            }  
            catch(Exception ae)  
            { 
               System.out.println(ae); 
            } 
        } 
         
    } 
} 
 
class login1 extends JFrame  
{ 
    private JPanel LPanel; 
    private JLabel lblLabel,lblLabel1,lblLabel2; 
 
    login1() 
    { 
        LPanel=new JPanel(null); 
         
        lblLabel = new JLabel("You are not yet SIGN IN ..........");         
        lblLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));        
        lblLabel.setBounds(25, 63, 467, 63); 
 
        lblLabel1 = new JLabel("Please...Go and SIGN IN first");         
        lblLabel1.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));         
        lblLabel1.setBounds(25, 153, 411, 40); 
 
        lblLabel2=new JLabel(""); 
        lblLabel2.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\sadmovie.png"));         
        lblLabel2.setBounds(403, 153, 338, 208); 
         
        LPanel.setBackground(Color.WHITE); 
        LPanel.add(lblLabel); 
        LPanel.add(lblLabel1); 
        LPanel.add(lblLabel2); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        add(LPanel,BorderLayout.CENTER);         
        setTitle("Login");         
        setSize(800,500);         
        setVisible(true); 
        setLocationRelativeTo(null); 
    } 
} 
 
class signin extends JFrame implements ActionListener 
{ 
    private JPanel SPanel; 
    private JLabel lbl_username,lbl_email,lbl_MobileNo,lbl_password,lbl_repassword; 
    private JTextField txt_username,txt_email,txt_mobNo; 
    private JPasswordField jpassword,jrepassword; 
    private JButton btnsign_in; 
    signin() 
    { 
        SPanel =new JPanel(null); 
 
        JLabel hSignin=new JLabel("Sign in");         
        hSignin.setForeground(new Color(178, 34, 34)); 
        hSignin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));         
        hSignin.setBounds(502, 11, 201, 71); 
 
        JLabel dev=new JLabel("@Developed by We_R_Bears");         
        dev.setFont(new Font("Tahoma", Font.ITALIC, 15)); 
        dev.setBounds(482, 667, 221, 22); 
 
        JLabel pic2=new JLabel(""); 
        pic2.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\signin.jpeg"));         
        pic2.setBounds(10, 263, 507, 285); 
 
        lbl_username=new JLabel("UserName"); 
        lbl_username.setFont(new Font("Tahoma", Font.BOLD, 25));         
        lbl_username.setBounds(567, 145, 155, 36); 
 
        lbl_email=new JLabel("Email"); 
        lbl_email.setFont(new Font("Tahoma", Font.BOLD, 25));         
        lbl_email.setBounds(567, 220, 155, 36); 
 
        lbl_MobileNo=new JLabel("Mobile Number");         
        lbl_MobileNo.setFont(new Font("Tahoma", Font.BOLD, 25));         
        lbl_MobileNo.setBounds(567, 302, 216, 36); 
 
        lbl_password=new JLabel("Password"); 
        lbl_password.setFont(new Font("Tahoma", Font.BOLD, 25));         
        lbl_password.setBounds(567, 376, 155, 36); 
 
        lbl_repassword=new JLabel("Re-Password"); 
        lbl_repassword.setFont(new Font("Tahoma", Font.BOLD, 25));         
        lbl_repassword.setBounds(567, 454, 227, 36); 
 
        txt_username=new JTextField(); 
        txt_username.setBounds(816, 145, 328, 34); 
 
        txt_email=new JTextField(); 
        txt_email.setBounds(816, 222, 328, 34); 
        txt_mobNo=new JTextField(); 
        txt_mobNo.setBounds(816, 302, 328, 34); 
        jpassword=new JPasswordField(); 
        jpassword.setBounds(816, 376, 328, 34); 
        jrepassword=new JPasswordField();     
        jrepassword.setBounds(816, 456, 328, 34); 
        btnsign_in=new JButton("SIGN IN");         
        btnsign_in.setBackground(new Color(255, 99, 71));         
        btnsign_in.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        btnsign_in.setBounds(878, 543, 201, 45); 
 
         
        SPanel.setBackground(Color.WHITE); 
        SPanel.add(hSignin); 
        SPanel.add(dev); 
        SPanel.add(pic2); 
        SPanel.add(lbl_username); 
        SPanel.add(lbl_email); 
        SPanel.add(lbl_MobileNo); 
        SPanel.add(lbl_password); 
        SPanel.add(lbl_repassword); 
        SPanel.add(txt_username); 
        SPanel.add(txt_email); 
        SPanel.add(txt_mobNo); 
        SPanel.add(jpassword); 
        SPanel.add(jrepassword);         
        SPanel.add(btnsign_in); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        btnsign_in.addActionListener(this); 
        add(SPanel,BorderLayout.CENTER);         
        setTitle("Sign in");         
        setSize(1000,1000);         
        setVisible(true);         
        setLocationRelativeTo(null); 
 
    } 
 
    public void actionPerformed(ActionEvent ae)  
    { 
        String Username=txt_username.getText(); 
        String Email=txt_email.getText(); 
        String Mobile_no=txt_mobNo.getText(); 
        String Password=jpassword.getText(); 
        String Repassword=jrepassword.getText();

        try 
        { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
	  	  	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root",""); 
            System.out.println("Connected"); 
            Statement st=con.createStatement(); 
  	  	  	st.executeUpdate("insert into signin values('"+Username+"','"+Email+"','"+Mobile_no+"','"+Password+"','"+Repassword+"')");          
        } 
        catch(Exception error) 
        { 
            System.out.println("Not connected...."); 
        } 
        new signin1(); 
         
    } 
 
} 
 
class signin1 extends JFrame implements ActionListener {     
    private JPanel S1Panel;     
    private JLabel S1Label,S1Label1; 
    private JButton btn; 
     
    signin1() 
    { 
        S1Panel=new JPanel(null); 
 
        S1Label = new JLabel("You are SIGN IN Successfully"); 
        S1Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));         
        S1Label.setBounds(338, 64, 431, 88); 
 
        S1Label1=new JLabel(""); 
        S1Label1.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\dogmovie.jpg"));         
        S1Label1.setBounds(31, 41, 250, 250); 
 
        btn = new JButton("OK"); 
        btn.setFont(new Font("Tahoma", Font.BOLD, 30));         
        btn.setBackground(Color.RED); 
        btn.setBounds(488, 205, 101, 50); 
         
        S1Panel.setBackground(Color.WHITE); 
        S1Panel.add(S1Label); 
        S1Panel.add(S1Label1); 
        S1Panel.add(btn); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        btn.addActionListener(this); 
        add(S1Panel,BorderLayout.CENTER); 
        setTitle("Sign in"); 
        setSize(700,350); 
        setVisible(true); 
        setLocationRelativeTo(null); 
 
 	}
 	public void actionPerformed(ActionEvent e) {         
        frontPage f=new frontPage(); 
        f.front(); 
         
    } 
} 
 
class home extends JFrame implements ActionListener 
{     
    private JPanel mPanel;     
    private JButton btnMov; 
    private JLabel kidmov,kidmov2,kidmov3,kidmov4; 
     
    home() 
    { 
        mPanel=new JPanel(null); 
 
        JLabel head=new JLabel("RAM THEATER"); 
        head.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));         
        head.setBounds(347, 39, 397, 52); 
 
        kidmov=new JLabel(""); 
        kidmov.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\kidmovie.jpg"));         
        kidmov.setHorizontalAlignment(SwingConstants.CENTER);         
        kidmov.setBounds(33, 128, 215, 281); 
 
        kidmov2=new JLabel(""); 
        kidmov2.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\kidmovie2.jpg"));         
        kidmov2.setHorizontalAlignment(SwingConstants.CENTER);        
        kidmov2.setBounds(309, 128, 215, 281); 
 
        kidmov3=new JLabel("");         
        kidmov3.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\kidmovie3.jpg"));         
        kidmov3.setHorizontalAlignment(SwingConstants.CENTER);         
        kidmov3.setBounds(576, 128, 215, 281); 
 
        kidmov4=new JLabel(""); 
        kidmov4.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\kidmovie4.jpg"));         
        kidmov4.setHorizontalAlignment(SwingConstants.CENTER);         
        kidmov4.setBounds(849, 128, 215, 281); 

        JLabel kidMov1Detail1 = new JLabel("Kai, a young boy, is kidnapped by the Show\r\n"); 
        kidMov1Detail1.setBounds(33, 444, 213, 14); 
        JLabel kidMov1Detail2 = new JLabel("Queen who takes him to her palace.Gerda, his "); 
        kidMov1Detail2.setBounds(33, 469, 232, 14); 
        JLabel kidMov1Detail3 = new JLabel("sister, goes serach of him along with her pet ");
        kidMov1Detail3.setBounds(33, 494, 224, 14); 
        JLabel kidMov1Detail4 = new JLabel("ferret and a troll."); 
        kidMov1Detail4.setBounds(33, 519, 84, 14); 

        JLabel director1 = new JLabel("Directors:"); 
        director1.setFont(new Font("Tahoma", Font.BOLD, 15)); 
        director1.setBounds(33, 564, 76, 19); 
        JLabel dir1Mov1 = new JLabel("Vladlen Barbe");         
        dir1Mov1.setFont(new Font("Tahoma", Font.ITALIC, 13));         
        dir1Mov1.setBounds(78, 591, 94, 16); 
        JLabel dir2Mov1 = new JLabel("Maksim Sveshnikov");         
        dir2Mov1.setFont(new Font("Tahoma", Font.ITALIC, 13));        
        dir2Mov1.setBounds(78, 612, 131, 16); 
         
        JLabel kidMov2detail1 = new JLabel("A sea turtle travels around the world\r\n\r\n");         
        kidMov2detail1.setBounds(309, 444, 182, 14); 
        JLabel kidMov2detail2 = new JLabel("for fifty years and sees the repercussions ");         
        kidMov2detail2.setBounds(309, 469, 215, 14); 
        JLabel kidMov2detail3 = new JLabel("of global warming and other environment");         
        kidMov2detail3.setBounds(309, 494, 215, 14); 
        JLabel kidMov2detail4 = new JLabel("threats as they take their toll.");         
        kidMov2detail4.setBounds(309, 519, 215, 14); 
 
        JLabel director2 = new JLabel("Director:");         
        director2.setFont(new Font("Tahoma", Font.BOLD, 15)); 
        director2.setBounds(309, 566, 68, 19);    
        JLabel dir1Mov2 = new JLabel("Ben Stassen");         
        dir1Mov2.setFont(new Font("Tahoma", Font.ITALIC, 13));         
        dir1Mov2.setBounds(347, 593, 84, 16); 
         
        JLabel kidMov3detail1 = new JLabel("Ralph and his best friend, Vanellope,face various");         
        kidMov3detail1.setBounds(576, 444, 240, 14); 
        JLabel kidMov3detail2 = new JLabel("challenges as they visit the uncharted land of the");        
        kidMov3detail2.setBounds(576, 469, 243, 14); 
        JLabel kidMov3detail3 = new JLabel("Internet through a WI-FI router at the arcade to");         
        kidMov3detail3.setBounds(576, 494, 238, 14); 
        JLabel kidMov3detail4 = new JLabel("save the game,Sugar Rush.");         
        kidMov3detail4.setBounds(576, 519, 215, 14); 
         
        JLabel director3 = new JLabel("Directors:");         
        director3.setFont(new Font("Tahoma", Font.BOLD, 15)); 
        director3.setBounds(576, 566, 76, 19);         
        JLabel dir1Mov3 = new JLabel("Rich Moore");         
        dir1Mov3.setFont(new Font("Tahoma", Font.ITALIC, 13));        
        dir1Mov3.setBounds(619, 593, 84, 16); 
        JLabel dir2Mov3 = new JLabel("Phil Johnston"); 
        dir2Mov3.setFont(new Font("Tahoma", Font.ITALIC, 13)); 
        dir2Mov3.setBounds(619, 612, 84, 16); 

        JLabel kidMov4detail1 = new JLabel("When Judy Hopps, a rookie officer in the"); 
        kidMov4detail1.setBounds(849, 444, 950, 14); 
        JLabel kidMov4detail2 = new JLabel("Zootopia Police Department, sniffs out a sinister");
    	kidMov4detail2.setBounds(849, 469, 242, 14); 
        JLabel kidMov4detail3 = new JLabel("plot, she enlists the help of the con artist to solve");     
        kidMov4detail3.setBounds(849, 494, 245, 14); 
        JLabel kidMov4detail4 = new JLabel("the case in order to prove her abilities to Chief Bogo."); 
        kidMov4detail4.setBounds(849, 519, 261, 14); 
         
        JLabel director4 = new JLabel("Directors:");         
        director4.setFont(new Font("Tahoma", Font.BOLD, 15)); 
        director4.setBounds(849, 566, 76, 19);         
        JLabel dir1Mov4 = new JLabel("Rich Moore");         
        dir1Mov4.setFont(new Font("Tahoma", Font.ITALIC, 13)); 
        dir1Mov4.setBounds(901, 593, 76, 16); 
        JLabel dir2Mov4 = new JLabel("Byron Howard");         
        dir2Mov4.setFont(new Font("Tahoma", Font.ITALIC, 13));         
        dir2Mov4.setBounds(901, 612, 94, 16); 
 
        btnMov= new JButton("Booking"); 
        btnMov.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));         
        btnMov.setBounds(1048, 637, 182, 52); 
 
        mPanel.setBackground(new Color(153, 50, 204));         
        mPanel.add(head);         
        mPanel.add(kidmov);         
        mPanel.add(kidmov2);        
        mPanel.add(kidmov3);         
        mPanel.add(kidmov4);         
        mPanel.add(kidMov1Detail1);         
        mPanel.add(kidMov1Detail2);         
        mPanel.add(kidMov1Detail3);         
        mPanel.add(kidMov1Detail4);         
        mPanel.add(director1);         
        mPanel.add(dir1Mov1);         
        mPanel.add(dir2Mov1);         
        mPanel.add(kidMov2detail1);         
        mPanel.add(kidMov2detail2);         
        mPanel.add(kidMov2detail3);         
        mPanel.add(kidMov2detail4);         
        mPanel.add(director2);         
        mPanel.add(dir1Mov2);         
        mPanel.add(kidMov3detail1);         
        mPanel.add(kidMov3detail2); 
        mPanel.add(kidMov3detail3); 
        mPanel.add(kidMov3detail4); 
        mPanel.add(director3); 
        mPanel.add(dir1Mov3); 
        mPanel.add(dir2Mov3); 
        mPanel.add(kidMov4detail1); 
        mPanel.add(kidMov4detail2); 
        mPanel.add(kidMov4detail3); 
        mPanel.add(kidMov4detail4); 
        mPanel.add(director4); 
        mPanel.add(dir1Mov4);        
        mPanel.add(dir2Mov4);         
        mPanel.add(btnMov); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        btnMov.addActionListener(this); 
        add(mPanel,BorderLayout.CENTER); 
        setTitle("Sign in");         
        setSize(700,350);         
        setVisible(true); 
        setLocationRelativeTo(null); 
 
    } 
    public void actionPerformed(ActionEvent e) { 
        new ticbook(); 
        System.out.println("Next");         
    }
 
} 
 
class ticbook extends JFrame implements ActionListener 
{     
    private JPanel bPanel;     
    private JTextField t1;     
    private JButton btnbook,payment;     
    private JComboBox cb1,cb2,cb3; 
    private JLabel showPayment; 
     
    ticbook() 
    { 
        bPanel=new JPanel(null); 
 
        JLabel img = new JLabel(""); 
        img.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\movie2.png"));         
        img.setBounds(494, 161, 770, 525); 
         
        JLabel movie = new JLabel("Movie");         
        movie.setForeground(Color.RED); 
        movie.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        movie.setBounds(31, 76, 91, 31); 
        JLabel booking = new JLabel("Booking"); 
        booking.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        booking.setForeground(Color.RED); 
        booking.setBounds(31, 176, 103, 31); 
        
        JLabel seating = new JLabel("Seating"); 
        seating.setForeground(Color.RED); 
        seating.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        seating.setBounds(31, 266, 97, 31); 
 
 
        JLabel noOfSeat = new JLabel("No of Seates");         
        noOfSeat.setForeground(Color.RED); 
        noOfSeat.setFont(new Font("Tahoma", Font.BOLD, 25));        
        noOfSeat.setBounds(31, 369, 161, 31); 
 
        showPayment=new JLabel("");         
        showPayment.setBounds(223, 468, 281, 37); 
        showPayment.setFont(new Font("Tahoma", Font.BOLD, 35)); 
         
         
        cb1 = new JComboBox(); 
        cb1.setFont(new Font("Tahoma", Font.ITALIC, 25)); 
        cb1.setModel(new DefaultComboBoxModel(new String[] {"The Show Queen", "A Turtles tale", "Ralph Breaks the Internet", "Zootopia"}));         
        cb1.setBounds(223, 73, 281, 37); 
         
        cb2 = new JComboBox(); 
        cb2.setFont(new Font("Tahoma", Font.ITALIC, 25)); 
        cb2.setModel(new DefaultComboBoxModel(new String[] {"VIP", "AC", "Non-AC"}));         
        cb2.setBounds(223, 173, 281, 37); 
         
        cb3 = new JComboBox(); 
        cb3.setFont(new Font("Tahoma", Font.ITALIC, 25)); 
        cb3.setModel(new DefaultComboBoxModel(new String[] {"Left", "Center", "Right"}));         
        cb3.setBounds(223, 263, 281, 37); 
         
        t1 = new JTextField(); 
        t1.setBounds(223, 372, 281, 37); 
         
        JLabel ticRate = new JLabel("Ticket Rate:");         
        ticRate.setFont(new Font("Tahoma", Font.BOLD, 25));         
        ticRate.setBounds(598, 6, 154, 31); 
         
        JLabel movie1 = new JLabel("The Show Queen"); 
        movie1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));         
        movie1.setBounds(753, 11, 179, 25); 
         
        JLabel movie2 = new JLabel("A Turtle's tale"); 
        movie2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20)); 
        movie2.setBounds(753, 45, 150, 25); 
        
        JLabel movie3 = new JLabel("Ralph Break's the Internet"); 
        movie3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20)); 
        movie3.setBounds(753, 81, 281, 25); 
        
        JLabel movie4 = new JLabel("Zootopia"); 
        movie4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20)); 
        movie4.setBounds(753, 117, 103, 25); 
        
        JLabel ticR1 = new JLabel("Rs.150 per Ticket");         
        ticR1.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
        ticR1.setBounds(1071, 11, 133, 21); 
         
        JLabel ticR2 = new JLabel("Rs.200 per Ticket");         
        ticR2.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
        ticR2.setBounds(1071, 48, 133, 21); 
         
        JLabel ticR3 = new JLabel("Rs.100 per Ticket");         
        ticR3.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
        ticR3.setBounds(1071, 84, 133, 21); 
         
        JLabel ticR4 = new JLabel("Rs.250 per Ticket");         
        ticR4.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
        ticR4.setBounds(1071, 120, 133, 21); 
         
        JLabel book = new JLabel("Book Now");         
        book.setForeground(Color.BLUE); 
        book.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));         
        book.setBounds(57, 588, 172, 47); 
         
        btnbook= new JButton("Book"); 
        btnbook.setBackground(new Color(153, 153, 255)); 
        btnbook.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 25));         
        btnbook.setBounds(290, 588, 109, 47); 
 
        payment=new JButton("Payment");         
        payment.setBounds(31, 468, 155, 39);         
        payment.setForeground(Color.RED); 
        payment.setFont(new Font("Tahoma", Font.BOLD, 25)); 
 
        bPanel.add(movie);         
        bPanel.add(booking);         
        bPanel.add(seating);         
        bPanel.add(noOfSeat);        
        bPanel.add(cb1);        
        bPanel.add(cb2);         
        bPanel.add(cb3);         
        bPanel.add(t1); 
        bPanel.add(ticRate); 
        bPanel.add(movie1); 
        bPanel.add(movie2); 
        bPanel.add(movie3); 
        bPanel.add(movie4); 
        bPanel.add(ticR1); 
        bPanel.add(ticR2); 
        bPanel.add(ticR3); 
        bPanel.add(ticR4); 
        bPanel.add(book); 
        bPanel.add(btnbook); 
        bPanel.add(showPayment); 
        bPanel.add(payment); 
        bPanel.add(img); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        btnbook.addActionListener(this);         
        payment.addActionListener(this);         
        add(bPanel,BorderLayout.CENTER); 
        setTitle("Booking");         
        setSize(700,350);         
        setVisible(true);         
        setLocationRelativeTo(null); 
 
    } 
     
    public void actionPerformed(ActionEvent e) {         
        String c1 = (String) cb1.getSelectedItem(); 
        String c2 = (String) cb2.getSelectedItem(); 
        String c3 = (String) cb3.getSelectedItem(); 
        String tf1 = t1.getText(); 
        String tf2 = info.ans; 
        String s=e.getActionCommand();         
        System.out.println(s);         
        if(s.equalsIgnoreCase("Payment")) 
        { 
            if(c1.equalsIgnoreCase("The Show Queen")) 
            {                 
                int price=150;                 
                int n=Integer.parseInt(tf1);                 
                info.ans=String.valueOf(price*n); 
                System.out.println(info.ans); 
            } 
            else if(c1.equalsIgnoreCase("A Turtles tale")) 
            {                 
                int price=200;                 
                int n=Integer.parseInt(tf1);                 
                info.ans=String.valueOf(price*n); 
                System.out.println(info.ans); 
            } 
            else if(c1.equalsIgnoreCase("Ralph Breaks the Internet")) 
            { 
                int price=100;         
                int n=Integer.parseInt(tf1);         
                info.ans=String.valueOf(price*n);
                System.out.println(info.ans); 
            } 
            else if(c1.equalsIgnoreCase("Zootopia")) 
            { 
                int price=250; 
                int n=Integer.parseInt(tf1);         
                info.ans=String.valueOf(price*n);
                System.out.println(info.ans); 
            } 
            System.out.println("payment"); 
            showPayment.setText(info.ans); 
        } 
        else if(s.equalsIgnoreCase("Book")) 
        {             
            try 
            { 
                System.out.println(c1); 
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking","root",""); 
                System.out.println("Connected"); 
                Statement stmt=con.createStatement(); 
                stmt.executeUpdate("insert into bookingticket values('"+c1+"','"+c2+"','"+c3+"','"+tf1+"','"+tf2+"')"); 
                System.out.println("Added"); 
            } 
            catch(Exception ae) 
            { 
                System.out.println(ae); 
            } 
            new ticket(); 
        } 
    } 
} 

class ticket extends JFrame 
{ 
    private JPanel tPanel; 
    private JLabel tLabel,tLabel1,tLpic,tLpic1;     
    ticket() 
    { 
        tPanel=new JPanel(null); 
 
        tLpic =  new JLabel(""); 
        tLpic.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\ticket.jpg"));         
        tLpic.setBounds(22, 49, 250, 201);
        tLpic1 = new JLabel(""); 
        tLpic1.setIcon(new ImageIcon("D:\\MyProjects\\MovieTicketBooking\\laughemoji.jpg"));
        tLpic1.setBounds(536, 217, 150, 150); 
        tLabel=new JLabel("Your Ticket is Booked"); 
        tLabel.setForeground(new Color(186, 85, 211));
        tLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 50)); 
        tLabel.setBounds(311, 63, 498, 66); 
        tLabel1= new JLabel("Successfully....."); 
        tLabel1.setForeground(new Color(186, 85, 211)); 
        tLabel1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 50));         
        tLabel1.setBounds(526, 140, 333, 66); 
 
        tPanel.setBackground(Color.WHITE); 
        tPanel.add(tLpic);         
        tPanel.add(tLabel);         
        tPanel.add(tLabel1); 
        tPanel.add(tLpic1); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        add(tPanel,BorderLayout.CENTER);         
        setTitle("Ticket");         
        setSize(950,500);         
        setVisible(true); 
        setLocationRelativeTo(null); 
 
    } 
}

class Main { 
    public static void main(String[] args)  
    { 
        frontPage fp = new frontPage();         
        fp.front(); 
        System.out.println("Hi"); 
    } 
 
} 

