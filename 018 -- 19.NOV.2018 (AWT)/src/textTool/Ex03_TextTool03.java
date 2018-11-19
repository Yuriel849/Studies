package textTool;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

// INCOMPLETE!

// TextArea 데이터 중에서 tfParam1에 입력된 문자 또는 문자들을 제거하는 기능의 '문자삭제'버튼을 완성하라.

class Ex03_TextTool03 extends Frame implements WindowListener { 
	TextArea ta;
    TextField tfParam1, tfParam2;
    Panel pNorth, pSouth;
    Label lb1, lb2;

    // btnName[0] --> Undo 기능
    // btnName[1] --> 짝수줄 삭제하는 기능
    // btnName[2] --> 문자 삭제하는 기능
    // 	>> 생성자에서 btnName의 데이터를 btn으로 옮긴다.
    String[] btnName = {
    		"Undo",         // 작업이전 상태로 되돌림
            "짝수줄삭제", // 짝수줄을 삭제하는 기능
            "문자삭제",    // param1에 지정된 문자들을 삭제하는 기능
	};

    Button[] btn = new Button[btnName.length];

    private final String CR_LF = System.getProperty("line.separator"); // 개행문자(줄바꿈문자)

    private String prevText = "";

    private void registerEventHandler() {
    	addWindowListener(this);

        int n = 0; // 버튼순서

        btn[n++].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();

        		if(!prevText.equals("")) {
        			ta.setText(prevText);
        		}

                prevText = curText;

                // 이미 "짝수줄 삭제" 기능을 통해 prevText에 저장된 문자열은  개행문자까지 포함하여 완성되어 있는 상태! 굳이 아래와 같이 다시 처리할 필요가 없다!
//    			String curText = ta.getText();
//    			StringBuffer sb = new StringBuffer(prevText.length());
//
//    			Scanner scan = new Scanner(prevText);
//    		
//    			for(int i = 0; scan.hasNextLine(); i++) {
//    				String line = scan.nextLine();
//    				sb.append(line + CR_LF);
//    			}
//    			ta.setText(sb.toString());
//    			prevText = curText;
        	}
        	
        });

        btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                prevText = curText;

                Scanner scan = new Scanner(curText);

                for(int i = 0; scan.hasNextLine(); i++) {
                	String line = scan.nextLine();

                    if(i%2==0) {
                    	sb.append(line).append(CR_LF);
                    }
                }

                ta.setText(sb.toString());
        	}
        });

        btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
        		
        		prevText = curText;
        		
        		// 1. TextField tfParam1의 값을 가져온다.(getText()사용)
        		String para = tfParam1.getText();
        		
        		// 2. 반복문을 이용해서 curText를 한글자씩 읽어서 Param1에서 가져온 문자열에 포함되어 있는지 확인한다.
        		boolean flag = false;
        		for(int i = 0; i < curText.length(); i++) {
        			for(int j = 0; j < para.length(); j++) {
        				// 2.1 만일 포함되어 있지 않으면 sb에 저장하고 포함되어 있으면 sb에 저장하지 않는다.
        				if(curText.charAt(i) == para.charAt(j)) {
        					flag = true;
        				};
        			}
        			if(!flag) {
        				sb.append(curText.charAt(i));
        				System.out.println("appending");
        			}
        		}

        		// 3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
	} // registerEventHandler() 끝.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	Ex03_TextTool03 win = new Ex03_TextTool03("Text Tool");
        win.show();
	} // main() 끝.

    // 생성자!!
    public Ex03_TextTool03(String title) {
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

        for(int i=0; i < btn.length;i++) {             // 버튼배열을 하단 Panel에 넣는다.
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