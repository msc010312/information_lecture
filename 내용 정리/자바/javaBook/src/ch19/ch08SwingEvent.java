package ch19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C08GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
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
	Writer out;

	C08GUI(String title) {
		super(title);
		setBounds(100, 100, 370, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 20, 200, 300);

		btn1 = new JButton("저장하기");
		btn2 = new JButton("불러오기");
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
			String contents = area1.getText();
			
			// 파일탐색기 열기
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("파일 저장 위치를 선택하세요");
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File defDirPath = new File("C:\\IOtest");
			if(defDirPath.exists()) {
				fc.setCurrentDirectory(defDirPath);
			}
			int selVal = fc.showSaveDialog(null);
			System.out.println(selVal);
			
			if(selVal == JFileChooser.APPROVE_OPTION) {
				File selFile = fc.getSelectedFile();
				System.out.println(selFile);
				String filePath = selFile.toString();
				// 파일 확장자 추가
				if(!selFile.toString().endsWith(".txt")) {
					filePath = selFile.toString()+".txt";
				}
//				DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//				String filename = LocalDateTime.now().format(fm);
				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				} catch (Exception el) {
					el.printStackTrace();
				} finally {
					try {
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		} else if (e.getSource() == btn2) {
			System.out.println("불러오기");
			
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("파일을 선택하세요");
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			File defDirPath = new File("C:\\IOtest");
			if(defDirPath.exists()) {
				fc.setCurrentDirectory(defDirPath);
			}
			int selVal = fc.showSaveDialog(null);
			
			if(selVal == JFileChooser.APPROVE_OPTION) {
				File selFile = fc.getSelectedFile();
				System.out.println(selFile);
				
				try {
					Reader fin = new FileReader(selFile.toString());
					StringBuffer buffer = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data == -1) {
							break;
						}
						buffer.append((char)data);
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} else if (e.getSource() == btn3) {
			System.out.println("대화기록보기");
		} else if (e.getSource() == input) {
			String chat = txt1.getText();
			area1.append(chat + "\n");
			txt1.setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			int offset = area1.viewToModel(e.getPoint());
			int row = area1.getLineOfOffset(offset);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);

			String str = area1.getText(startOffset, endOffset - startOffset);
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

public class ch08SwingEvent {

	public static void main(String[] args) {
		new C08GUI("Chatting Server");
	}
}
