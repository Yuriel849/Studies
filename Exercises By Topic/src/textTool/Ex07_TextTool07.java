package textTool;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

class Ex07_TextTool07 extends Frame implements WindowListener {
	// TextArea의 각 라인에서 param1에 입력된 문자열과 param2에 입력된 문자열을 찾아서 두 문자열 사이의 텍스트만 남기고 삭제하는 기능의 'substring2'버튼을 구현하라. 
	TextArea ta;
    TextField tfParam1, tfParam2;
    Panel pNorth, pSouth;
    Label lb1, lb2;
    
    // 생성자에서 btnName의 데이터를 btn으로 옮긴다.
    String[] btnName = {
    		"Undo", // 작업이전 상태로 되돌림
            "짝수줄삭제", // 짝수줄을 삭제하는 기능
            "문자삭제", // tfParam1에 지정된 문자들을 삭제하는 기능
            "trim", // 라인의 앞뒤 공백을 제거
            "빈줄삭제", // 빈 줄 삭제
            "접두사추가", // tfParam1 & tfParam2의 문자열을 각 라인의 앞 뒤에 붙이는 기능
            "substring", // tfParam1 & tfParam2에 지정된 문자열을 각 라인에서 제거하는 기능
            "substring2", // tfParam1과 tfParam2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능
	};

    Button[] btn = new Button[btnName.length];

    private final String CR_LF = System.getProperty("line.separator"); // 개행문자(줄바꿈문자)

    private String prevText = "";

    private void registerEventHandler() {
    	addWindowListener(this);

        int n = 0; // 버튼순서

        // 1. // Undo --> 작업이전 상태로 되돌림
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();

        		if(!prevText.equals("")) {
        			ta.setText(prevText);
        		}

                prevText = curText;
        	}	        	
        });

        // 2. 짝수줄삭제 --> 짝수줄을 삭제하는 기능
        btn[n++].addActionListener(new ActionListener() {
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

        // 3. 문자삭제 - Param1에 지정된 문자를 삭제하는 기능
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
	        		
        		// 1. TextField tfParam1의 값을 가져온다.(getText()사용)
        		String para = tfParam1.getText();

        		if(para.equals("")) { return; } // tfParam1이 비었다면 종료한다.
	        		
        		// 2. 반복문을 이용해서 curText를 한글자씩 읽어서 Param1에서 가져온 문자열에 포함되어 있는지 확인한다.
        		for(int i = 0; i < curText.length(); i++) {
        			char ch = curText.charAt(i);
        			if(para.indexOf(ch) == -1) // indexOf --> 만일 para에 ch가 없으면 -1이 반환된다.
                        // 3. 만일 포함되어 있지 않으면 sb에 저장하고 포함되어 있으면 sb에 저장하지 않는다.
        				sb.append(ch);
        		}
	        		
        		// 4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
        
        // 4. trim - 라인의 좌우공백을 제거하는 기능
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 2. 읽어온 라인의 왼쪽공백과 오른쪽 공백을 제거한다.(String클래스의 trim()사용)
        			sb.append(line.trim() + CR_LF);
        		}

        		// 3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
        
        // 5. 빈줄삭제 - 빈 줄 삭제 기능
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 2. 읽어온 라인이 내용이 없는 빈 라인이면 sb에 저장하지 않는다.
        			if(!(line.equals(""))) { sb.append(line).append(CR_LF); }
        		}
        		
        		// 3. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
        
        // 6. 접두사추가 --> 각 라인에 접두사, 접미사 붙이기
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. tfParam1과 tfParam2의 값을 가져온다.(getText()사용)
        		String param1 = tfParam1.getText();
        		String param2 = tfParam2.getText();
        		
        		// 2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 3. 읽어온 라인의 앞뒤에 param1과 param2의 값을 붙여서 sb에 담는다.
        			sb.append(param1).append(line).append(param2).append(CR_LF);
        		}

        		// 4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
        
        // 7. substring --> 문자열 자르기
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. tfParam1과 tfParam2의 값을 가져온다.(getText()사용)
        		int from = tfParam1.getText().length();
        		int to = tfParam2.getText().length();
        		
        		// 2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 3. 읽어온 라인을 substring으로 자른다. tfParam1과 tfParam2의 내용에 관계없이 길이만큼 자른다.
        			if(line.length() < (from+to)) { return; }
        			sb.append(line.substring(from, line.length() - to)).append(CR_LF);
        		}

        		// 4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
        
        // 8. substring2 --> 지정된 문자열을 찾아서 그 위치까지 잘라내기
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());

        		prevText = curText;

        		// 1. tfParam1과 tfParam2의 값을 가져온다.(getText()사용)
        		int from = tfParam1.getText().length();
        		int to = tfParam2.getText().length();
        		String para1 = tfParam1.getText();
        		String para2 = tfParam2.getText();

        		// 2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			if(line.length() < (from+to)) { return; }
        			else if(!(line.contains(para1) || line.contains(para2))) { return; }
        			// 3. 각 라인에서 param1, param2과 일치하는 문자열의 위치를 찾는다.
        			// 	 (param1은 라인의 왼쪽끝부터, param2는 라인의 오른쪽끝부터 찾기 시작한다.)
        			//    param1과 param2로 둘러쌓인 부분을 sb에 저장한다.
        			int idx = line.indexOf(para1);
        			int idx2 = line.lastIndexOf(para2);
        			sb.append(line.substring(idx+from, idx2)).append(CR_LF);
        		}
        		
        		// 4. 작업이 끝난 후에 sb에 담긴 내용을 ta에 보여준다.(setText()사용)
        		ta.setText(sb.toString());
        	}
        });
	} // registerEventHandler() 끝.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	Ex07_TextTool07 win = new Ex07_TextTool07("Text Tool");
        win.show();
	} // main() 끝.

    // 생성자!!
    public Ex07_TextTool07(String title) {
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

        for(int i=0; i < btn.length;i++) { // 버튼배열을 하단 Panel에 넣는다.
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
