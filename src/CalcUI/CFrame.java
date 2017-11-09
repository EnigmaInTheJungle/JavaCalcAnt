package CalcUI;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class CFrame extends JFrame 
{
	public CFrame() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("Calculator");
		setBounds(0,0,300,300);
	
		
		CPanel cp=new CPanel();
		cp.setBackground(Color.BLACK);
		add(cp);
		setVisible(true);
	}
}
