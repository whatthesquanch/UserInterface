import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class UserInterface extends JFrame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;

	
	public UserInterface() {
		setTitle("User Interface I");
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem item1 = new JMenuItem("Print Date and Time");
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateTime = sdf.format(new Date());
				textArea.append(dateTime + "\n");
			}
		});
		menu.add(item1);
		
		JMenuItem item2 = new JMenuItem("Write to File");
		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter writer = new FileWriter("log.txt", true);
					writer.write(textArea.getText());
					writer.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		menu.add(item2);
		
		JMenuItem item3 = new JMenuItem("Change Background Color");
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout(new FlowLayout());
				getContentPane().setBackground(Color.green);
				setVisible(true);
				
			}
			
		});
		menu.add(item3);
		
		JMenuItem item4 = new JMenuItem("Exit");
		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		menu.add(item4);
		
		JPanel panel = new JPanel(new BorderLayout());
		getContentPane().add(panel);
		
		textArea = new JTextArea();
		panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
		
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UserInterface ui = new UserInterface();
				ui.setVisible(true);
			}
		});

	}

}
