package ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	// Component 참조변수명
	// textarea = area1
	// textarea's scroll = scroll1
	// 파일로저장 : btn1
	// 1:1요청 : btn2
	// 대화기록보기 : btn3
	// 입력 : input
	// textfield : txt1
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton input;
	JTextField txt1;
	JTextArea area1;
	JScrollPane scroll1;

	C07GUI(String title) {
		super(title);
		setBounds(100, 100, 370, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 20, 200, 300);

		btn1 = new JButton("파일로 저장");
		btn2 = new JButton("1:1 요청");
		btn3 = new JButton("대화기록보기");
		btn1.setBounds(220, 20, 120, 50);
		btn2.setBounds(220, 80, 120, 50);
		btn3.setBounds(220, 140, 120, 50);

		txt1 = new JTextField();
		txt1.setBounds(10, 340, 200, 50);

		input = new JButton("입력");
		input.setBounds(220, 340, 120, 50);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
		panel.add(input);

		add(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("파일로 저장");
		} else if (e.getSource() == btn2) {
			System.out.println("1:1요청");
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기");
		} else if (e.getSource() == input) {
			System.out.println("입력");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keytype" + e.getKeyCode() + e.getKeyChar());	
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed" + e.getKeyCode() + e.getKeyChar());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message + "\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
//			System.out.println("click" + e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println(offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println(row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n", startOffset, endOffset);
			
			String str = area1.getText(startOffset,endOffset-startOffset);
			System.out.println(str);
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

public class ch07SwingEvent {

	public static void main(String[] args) {
		new C07GUI("Chatting Server");
	}
}
