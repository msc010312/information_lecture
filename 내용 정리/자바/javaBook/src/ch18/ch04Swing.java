package ch18;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame{
	C04GUI(String title){
		// Frame
		super(title);
		setBounds(100,100,250,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		// Panel
		JPanel panel = new JPanel();
//		Color col = new Color(71,144,0);
//		panel.setBackground(col);
		panel.setLayout(null);
		
		// component
		JButton btn1 = new JButton("btn01");
		btn1.setBounds(10,10,100,30);
		
		JButton btn2 = new JButton("btn02");
		btn2.setBounds(120,10,100,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,210,50);
		
		JTextArea area1 = new JTextArea();
//		area1.setBounds(10,110,210,300);
		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,110,210,300);
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(scroll);
		
		// Frame(Panel)
		add(panel);
		
		setVisible(true);
	}
}

public class ch04Swing {

	public static void main(String[] args) {
		
		new C04GUI("네번째 프레임입니다");
	}

}
