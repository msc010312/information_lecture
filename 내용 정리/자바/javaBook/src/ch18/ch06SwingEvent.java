package ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener {
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

    C06GUI(String title) {
        super(title);
        setBounds(100, 100, 370, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextArea area1 = new JTextArea();
        JScrollPane scroll1 = new JScrollPane(area1);
        scroll1.setBounds(10, 20, 200, 300);

        btn1 = new JButton("파일로 저장");
        btn2 = new JButton("1:1 요청");    
        btn3 = new JButton("대화기록보기");  
        btn1.setBounds(220, 20, 120, 50);
        btn2.setBounds(220, 80, 120, 50);
        btn3.setBounds(220, 140, 120, 50);

        JTextField txt1 = new JTextField();
        txt1.setBounds(10, 340, 200, 50);

        input = new JButton("입력");
        input.setBounds(220, 340, 120, 50);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        input.addActionListener(this);

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
}

public class ch06SwingEvent {

    public static void main(String[] args) {
        new C06GUI("Chatting Server");
    }
}

