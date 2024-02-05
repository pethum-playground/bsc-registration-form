import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;

public class RegistrationForm extends JFrame implements ActionListener {
    private final JLabel titleup;
    private final JLabel titlein;
    private final JLabel name;
    private final JTextField tname;
    private final JLabel email;
    private final JTextField temail;
    private final JLabel gender;
    private final JRadioButton male;
    private final JRadioButton female;
    private final ButtonGroup gendergp;
    private final JComboBox<String> date;
    private final JComboBox<String> month;
    private final JComboBox<String> year;
    private final JLabel password;
    private final JTextField tpassword;
    private final JCheckBox terms;
    private final JButton signup;
    private final JButton signin;
    private final JLabel emailin;
    private final JTextField temailin;
    private final JLabel passwordin;
    private final JTextField tpasswordin;

    private final String[] dates = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31"};
    private final String[] months = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug", "Sup", "Oct", "Nov", "Dec"};
    private final String[] years = {"1995", "1996", "1997",
            "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
            "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
            "2014", "2015", "2016", "2017", "2018", "2019"};

    public RegistrationForm() {
        setTitle("SignIn/Up Window");
        setBounds(300, 90, 500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(null);

        titleup = new JLabel("Sign Up");
        titleup.setFont(new Font("Arial", Font.BOLD, 30));
        titleup.setForeground(Color.BLUE);
        titleup.setSize(300, 30);
        titleup.setLocation(200, 30);
        container.add(titleup);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(50, 100);
        container.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 20));
        tname.setSize(300, 25);
        tname.setLocation(150, 100);
        container.add(tname);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(50, 150);
        container.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 20));
        temail.setSize(300, 25);
        temail.setLocation(150, 150);
        container.add(temail);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(50, 200);
        container.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 20));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(150, 200);
        container.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 20));
        female.setSize(100, 20);
        female.setSelected(false);
        female.setLocation(250, 200);
        container.add(female);

        gendergp = new ButtonGroup();
        gendergp.add(male);
        gendergp.add(female);

        JLabel dob = new JLabel("Birthday");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(50, 250);
        container.add(dob);

        date = new JComboBox<String>(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 20));
        date.setSize(90, 25);
        date.setLocation(150, 250);
        container.add(date);

        month = new JComboBox<String>(months);
        month.setFont(new Font("Arial", Font.PLAIN, 20));
        month.setSize(100, 25);
        month.setLocation(230, 250);
        container.add(month);

        year = new JComboBox<String>(years);
        year.setFont(new Font("Arial", Font.PLAIN, 20));
        year.setSize(120, 25);
        year.setLocation(320, 250);
        container.add(year);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(50, 300);
        container.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 20));
        tpassword.setSize(300, 25);
        tpassword.setLocation(150, 300);
        container.add(tpassword);

        terms = new JCheckBox("Accept Terms & Conditions.");
        terms.setFont(new Font("Arial", Font.PLAIN, 20));
        terms.setSize(300, 20);
        terms.setLocation(50, 350);
        container.add(terms);

        signup = new JButton("Sign Up");
        signup.setFont(new Font("Arial", Font.PLAIN, 20));
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.setSize(400, 30);
        signup.setLocation(50, 400);
        signup.addActionListener(this);
        container.add(signup);

        titlein = new JLabel("Sign In");
        titlein.setFont(new Font("Arial", Font.BOLD, 30));
        titlein.setForeground(Color.BLUE);
        titlein.setSize(300, 35);
        titlein.setLocation(200, 450);
        container.add(titlein);

        emailin = new JLabel("Email");
        emailin.setFont(new Font("Arial", Font.PLAIN, 20));
        emailin.setSize(100, 20);
        emailin.setLocation(50, 500);
        container.add(emailin);

        temailin = new JTextField();
        temailin.setFont(new Font("Arial", Font.PLAIN, 25));
        temailin.setSize(300, 25);
        temailin.setLocation(150, 500);
        container.add(temailin);

        passwordin = new JLabel("Password");
        passwordin.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordin.setSize(100, 20);
        passwordin.setLocation(50, 550);
        container.add(passwordin);

        tpasswordin = new JPasswordField();
        tpasswordin.setFont(new Font("Arial", Font.PLAIN, 25));
        tpasswordin.setSize(300, 25);
        tpasswordin.setLocation(150, 550);
        container.add(tpasswordin);

        signin = new JButton("Sign In");
        signin.setFont(new Font("Arial", Font.PLAIN, 20));
        signin.setBackground(Color.BLUE);
        signin.setForeground(Color.WHITE);
        signin.setOpaque(true);
        signin.setBorderPainted(false);
        signin.setSize(400, 30);
        signin.setLocation(50, 600);
        signin.addActionListener(this);
        container.add(signin);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            if (terms.isSelected()) {
                String nameq = tname.getText();
                String emailq = temail.getText();
                String genderq;
                if (male.isSelected()) genderq = "Male";
                else genderq = "Female";
                String dobq = year.getSelectedItem() + "-" + month.getSelectedItem() + "-" + date.getSelectedItem();
                String passwordq = tpassword.getText();

                try {
                    Connection connection = DatabaseConnection.getInstance().getConnection();
                    String sql = "INSERT INTO user (`Name`, `Email`, `Gender`, `Birthday`, `Password`) VALUES(?, ?, ?, ?, ?)";

                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, nameq);
                    pstmt.setString(2, emailq);
                    pstmt.setString(3, genderq);
                    pstmt.setString(4, dobq);
                    pstmt.setString(5, passwordq);

                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Registration Successfully..");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Registration Failed..");
                    ex.printStackTrace();
                }
                cleanElements();
            } else {
                JOptionPane.showMessageDialog(null, "Please accept the" + " terms & conditions!!");
            }
        } else if (e.getSource() == signin) {
            try {
                String email = temailin.getText();
                String password = tpasswordin.getText();

                Connection connection = DatabaseConnection.getInstance().getConnection();
                String str = "SELECT * FROM user WHERE Email = '" + email + "' AND Password = '" + password + "'";

                ResultSet rs = connection.createStatement().executeQuery(str);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Valid Accounts");
                    cleanElements();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login... \n Try Again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void cleanElements() {
        tname.setText("");
        temail.setText("");
        tpassword.setText("");
        terms.setSelected(false);
        date.setSelectedIndex(0);
        month.setSelectedIndex(0);
        year.setSelectedIndex(0);
        temailin.setText("");
        tpasswordin.setText("");
    }
}
