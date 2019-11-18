public class Keygen {

	private JFrame frmBackdooredLicenseKeygen;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Keygen window = new Keygen();
					window.frmBackdooredLicenseKeygen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Keygen() {
		initialize();
	}

	private static String hwid() {
        return Hashing.sha512().hashString(System.getenv("os") + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS"), StandardCharsets.UTF_8).toString();
    }
    
    private static String key(final String s) {
        final String string = Hashing.sha1().hashString(s, StandardCharsets.UTF_8).toString();
        return Hashing.sha512().hashString(string + s + string, StandardCharsets.UTF_8).toString();
    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBackdooredLicenseKeygen = new JFrame();
		frmBackdooredLicenseKeygen.setTitle("Backdoored License Keygen");
		frmBackdooredLicenseKeygen.setBounds(100, 100, 400, 150);
		frmBackdooredLicenseKeygen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ClassLoader cl = this.getClass().getClassLoader();
	     ImageIcon programIcon = new ImageIcon(cl.getResource("backdoored-standard-client.png"));
	     frmBackdooredLicenseKeygen.setIconImage(programIcon.getImage());
	     
	     JPanel panel = new JPanel();
	     frmBackdooredLicenseKeygen.getContentPane().add(panel, BorderLayout.CENTER);
	     panel.setLayout(null);
	     
	     JLabel label = new JLabel();
	     label.setText("Your License Key");
	     label.setBounds(frmBackdooredLicenseKeygen.getWidth()/2 - 150 - 2, 25 - 22, 200, 20);
	     panel.add(label);
	     
	     textField = new JTextField();
	     textField.setBounds(frmBackdooredLicenseKeygen.getWidth()/2 - 150 - 2, 25, 300, 20);
	     panel.add(textField);
	     textField.setColumns(10);
	     
	     JLabel label2 = new JLabel();
	     label2.setText("Put this in .minecraft/Backdoored/license.txt");
	     label2.setBounds(frmBackdooredLicenseKeygen.getWidth()/2 - 150 - 2, 65 - 22, 300, 20);
	     panel.add(label2);
	     
	     JLabel label3 = new JLabel();
	     label3.setText("Create this file if it doesn't exist");
	     label3.setBounds(frmBackdooredLicenseKeygen.getWidth()/2 - 150 - 2, 85 - 22, 300, 20);
	     panel.add(label3);
	     
	     JLabel label4 = new JLabel();
	     label4.setText("This license generator only works on 64-bit Java");
	     label4.setBounds(frmBackdooredLicenseKeygen.getWidth()/2 - 150 - 2, 105 - 22, 300, 20);
	     panel.add(label4);
	     textField.setText(key(hwid()));
	}
}