import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class SQLDB {
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rset = null;

    // Connect to SQLite Database
    public static void connect(String dbpath) {
        try {
            // Loading SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            // Establishing connection with the database
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbpath);
            // Creating a statement for executing queries
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Execute query
    public static void execute(String query) {
        try {
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Execute update (INSERT, UPDATE, DELETE)
    public static void update(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AP22110010310_meenarashi_university_module {
    Frame f = new Frame("University Module");

    // Labels and TextFields
    Label l1 = new Label("University Code");
    Label l2 = new Label("University Name");
    Label l3 = new Label("University Address");
    Label l4 = new Label("University Email");
    Label l5 = new Label("University Website");

    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();
    TextField t5 = new TextField();

    // Buttons
    Button b1 = new Button("Create");
    Button b2 = new Button("Retrieve");
    Button b3 = new Button("Update");
    Button b4 = new Button("Delete");
    Button b5 = new Button("Minimize");
    Button b6 = new Button("Close");

    // Constructor to configure the UI
    AP22110010310_meenarashi_university_module() {
        // Setting up the layout and font
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Adding spacing between components

        // Set frame size and visibility
        f.setSize(500, 350);
        f.setVisible(true);

        // Set the window background color and button styles
        f.setBackground(new Color(255, 255, 255));
        b1.setBackground(new Color(100, 149, 237));  // Light Blue
        b2.setBackground(new Color(100, 149, 237));
        b3.setBackground(new Color(100, 149, 237));
        b4.setBackground(new Color(100, 149, 237));
        b5.setBackground(new Color(255, 69, 0));  // Red for minimize
        b6.setBackground(new Color(255, 69, 0));  // Red for close
        b1.setFont(new Font("Arial", Font.PLAIN, 12));
        b2.setFont(new Font("Arial", Font.PLAIN, 12));
        b3.setFont(new Font("Arial", Font.PLAIN, 12));
        b4.setFont(new Font("Arial", Font.PLAIN, 12));
        b5.setFont(new Font("Arial", Font.PLAIN, 12));
        b6.setFont(new Font("Arial", Font.PLAIN, 12));

        // Adjusting components to be more aligned and giving more space for textboxes
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        f.add(l1, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        f.add(t1, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        f.add(l2, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        f.add(t2, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        f.add(l3, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        f.add(t3, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        f.add(l4, gbc);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        f.add(t4, gbc);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        f.add(l5, gbc);

        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2;
        f.add(t5, gbc);

        // Aligning buttons better and keeping enough space
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 1;
        f.add(b1, gbc);

        gbc.gridx = 1; gbc.gridy = 10; gbc.gridwidth = 1;
        f.add(b2, gbc);

        gbc.gridx = 0; gbc.gridy = 11; gbc.gridwidth = 1;
        f.add(b3, gbc);

        gbc.gridx = 1; gbc.gridy = 11; gbc.gridwidth = 1;
        f.add(b4, gbc);

        gbc.gridx = 0; gbc.gridy = 12; gbc.gridwidth = 1;
        f.add(b5, gbc);

        gbc.gridx = 1; gbc.gridy = 12; gbc.gridwidth = 1;
        f.add(b6, gbc);

        // Button listeners
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AP22110010310_meenarashi_university_create();
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AP22110010310_meenarashi_university_retrieve();
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AP22110010310_meenarashi_university_update();
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AP22110010310_meenarashi_university_delete();
            }
        });

        // Minimize button listener
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.setState(Frame.ICONIFIED); // Minimize the window
            }
        });

        // Close button listener
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose(); // Close the window
            }
        });

        // Adding WindowListener to handle the close button
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose(); // Close the window when the native close button is clicked
            }
        });
    }

    // Create functionality (Insert)
    public void AP22110010310_meenarashi_university_create() {
        String code = t1.getText();
        String name = t2.getText();
        String address = t3.getText();
        String email = t4.getText();
        String website = t5.getText();

        String query = "INSERT INTO university (univ_code, univ_name, univ_address, univ_email, univ_website) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = SQLDB.conn.prepareStatement(query);
            pst.setString(1, code);
            pst.setString(2, name);
            pst.setString(3, address);
            pst.setString(4, email);
            pst.setString(5, website);
            pst.executeUpdate();
            showMessage("University created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update functionality (Update)
    public void AP22110010310_meenarashi_university_update() {
        String code = t1.getText();
        String name = t2.getText();
        String address = t3.getText();
        String email = t4.getText();
        String website = t5.getText();

        String query = "UPDATE university SET univ_name = ?, univ_address = ?, univ_email = ?, univ_website = ? WHERE univ_code = ?";
        try {
            PreparedStatement pst = SQLDB.conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, email);
            pst.setString(4, website);
            pst.setString(5, code);
            pst.executeUpdate();
            showMessage("University updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve functionality (Select)
    public void AP22110010310_meenarashi_university_retrieve() {
        String code = t1.getText();
        String query = "SELECT * FROM university WHERE univ_code = ?";
        try {
            PreparedStatement pst = SQLDB.conn.prepareStatement(query);
            pst.setString(1, code);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                t2.setText(rs.getString("univ_name"));
                t3.setText(rs.getString("univ_address"));
                t4.setText(rs.getString("univ_email"));
                t5.setText(rs.getString("univ_website"));
            } else {
                showMessage("University not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete functionality (Delete)
    public void AP22110010310_meenarashi_university_delete() {
        String code = t1.getText();
        String query = "DELETE FROM university WHERE univ_code = ?";
        try {
            PreparedStatement pst = SQLDB.conn.prepareStatement(query);
            pst.setString(1, code);
            pst.executeUpdate();
            showMessage("University deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display a message in a dialog box with an OK button to close
    public void showMessage(String message) {
        Dialog d = new Dialog(f, "Message", true);
        d.setLayout(new FlowLayout());
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                d.dispose();  // Close the dialog when OK is clicked
            }
        });
        d.add(new Label(message));
        d.add(okButton);
        d.setSize(300, 100);
        d.setVisible(true);
    }
}

public class UniversityApp {
    public static void main(String[] args) {
        // Connect to the database
        SQLDB.connect("C:\\Users\\viswa\\OneDrive\\Desktop\\Apps\\javaapp.db");

        // Launch the university module
        new AP22110010310_meenarashi_university_module();
    }
}