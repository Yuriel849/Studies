package textTool;

import java.awt.*;
import java.awt.event.*; 
import java.util.*;

// 작업 이전 상태로 되돌리는 Undo기능을 구현
// 	  ex) "짝수줄삭제" 누른 후 Undo 누르면 TextArea의 내용이 "짝수줄삭제" 누르기 이전의 상태로 되돌아가야 한다.

class Ex02_TextTool02 extends Frame implements WindowListener { 
	TextArea ta;
    TextField tfParam1, tfParam2; 
    Panel pNorth, pSouth; 
    Label lb1, lb2;

    // btnName[0] --> Undo 기능
    // btnName[1] --> 짝수줄 삭제하는 기능
    // 	>> 생성자에서 btnName의 데이터를 btn으로 옮긴다.
    String[] btnName = {
    		"Undo",    // 작업이전 상태로 되돌림 
            "짝수줄삭제", // 짝수줄을 삭제하는 기능 
    };

    Button[] btn = new Button[btnName.length]; 

    private final String CR_LF = System.getProperty("line.separator"); // 개행문자(줄바꿈문자)

    // 작업을 하기 전 TextArea ta의 내용을 저장하기 위한 변수
    private String prevText = "";

    private void registerEventHandler() {
    	addWindowListener(this);

        btn[0].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림 
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(prevText.length());

        		Scanner scan = new Scanner(prevText);
        		
        		for(int i = 0; scan.hasNextLine(); i++) {
        			String line = scan.nextLine();
        			sb.append(line + CR_LF);
        		}
        		ta.setText(sb.toString());
        		prevText = curText;
        	}
        });

		// 아래 () 속 코드는 익명클래스 --> ActionListener 인터페이스 구현
        btn[1].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능 
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length()); 

                prevText = curText;

                Scanner scan = new Scanner(curText); 

                for(int i = 0; scan.hasNextLine(); i++) { 
                	String line = scan.nextLine();
                    if(i%2==0) {
                    	sb.append(line).append(CR_LF);
                        // sb.append(line+CR_LF); 와 동일
                    }
                }
                ta.setText(sb.toString()); 
                
                System.out.println(curText);
        	}
        });
    } // registerEventHandler() 끝.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) { 
    	Ex02_TextTool02 win = new Ex02_TextTool02("Text Tool"); 
        win.show();
    } // main() 끝.

    // 생성자!!
    public Ex02_TextTool02(String title) { 
    	super(title);
        lb1 = new Label("param1:", Label.RIGHT); 
        lb2 = new Label("param2:", Label.RIGHT); 
        tfParam1 = new TextField(15);
        tfParam2 = new TextField(15);

        ta = new TextArea();
        pNorth = new Panel(); 
        pSouth = new Panel();

        for(int i=0;i < btn.length;i++) {
        	btn[i] = new Button(btnName[i]); 
        }

        pNorth.setLayout(new FlowLayout()); 
        pNorth.add(lb1);
        pNorth.add(tfParam1); 
        pNorth.add(lb2);
        pNorth.add(tfParam2); 

        pSouth.setLayout(new GridLayout(2,10)); 

        for(int i=0;i < btn.length;i++) { // 버튼배열을 하단 Panel에 넣는다. 
        	pSouth.add(btn[i]);
        }

        add(pNorth,"North"); 
        add(ta,"Center");
        add(pSouth,"South"); 

        setBounds(100, 100, 600, 300); 
        ta.requestFocus();
        registerEventHandler(); 
        setVisible(true);
	} // 생성자 public TextToolEx1(String title) 끝.

	// WindowsListener의 추상메서드들 구현
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) { 
    	e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
} // 클래스 끝.