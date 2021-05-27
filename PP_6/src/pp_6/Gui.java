package pp_6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;


public class Gui implements ActionListener {

	private JFrame frame;
	private JTextField threadText;
	private JTextField sampleText;
	private JTextField piText;
	private JButton solveBtn;
	private JButton resetBtn;
	MainClass outer = new MainClass();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setBounds(100, 100, 303, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		solveBtn = new JButton("Oblicz");
		solveBtn.addActionListener(this);
		solveBtn.setBounds(108, 70, 163, 74);
		frame.getContentPane().add(solveBtn);
		
		threadText = new JTextField();
		threadText.setBounds(125, 8, 86, 20);
		frame.getContentPane().add(threadText);
		threadText.setColumns(10);
		
		sampleText = new JTextField();
		sampleText.setBounds(185, 39, 86, 20);
		frame.getContentPane().add(sampleText);
		sampleText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Podaj ilo\u015B\u0107 w\u0105tk\u00F3w: ");
		lblNewLabel.setBounds(10, 11, 163, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Podaj ilo\u015B\u0107 punkt\u00F3w na w\u0105tek:");
		lblNewLabel_1.setBounds(10, 42, 180, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Obliczone PI: ");
		lblNewLabel_2.setBounds(10, 165, 180, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		piText = new JTextField();
		piText.setEditable(false);
		piText.setBounds(84, 162, 193, 20);
		frame.getContentPane().add(piText);
		piText.setColumns(10);
		
		resetBtn = new JButton("Wyczy\u015B\u0107");
		resetBtn.addActionListener(this);
		resetBtn.setBounds(10, 70, 88, 74);
		frame.getContentPane().add(resetBtn);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==solveBtn)
		{
			if((threadText.getText().length() == 0 || sampleText.getText().length() == 0))
			{
				System.out.print("B³¹d! - brak podanych argumentów\n");
			}
			else
			{
				try
				{
			        int threads = Integer.parseInt(threadText.getText());
			        int samples= Integer.parseInt(sampleText.getText());
			        try 
			        {
			        	if (threads > 0 && samples > 0) 
			        	{
			        	double result = outer.calculatePi(threads, samples);
			        	piText.setText(String.valueOf(result));
			        	}
			        	else
			        	{
			        	System.out.print("Podane wartoœci nie s¹ dodatnie!\n");
			        	}
			        } 
			        catch (InterruptedException e1) {System.out.print("B³¹d spowodowany prac¹ w¹tków!\n");}
				}
			    catch(Exception e2) {System.out.print("Podane parametry nie s¹ liczbami!\n");}
			}
		}
		if(e.getSource()==resetBtn)
		{
			threadText.setText("");
			sampleText.setText("");
			piText.setText("");
		}
	}
}
