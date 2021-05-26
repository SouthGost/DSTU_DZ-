package Lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task4 extends JFrame {
    private int pogx = 8, pogy = 30;
    private Curve[] curve;
    private JComboBox<String> choosFunc;
    private Color clr = Color.BLACK;
    private int start=-30, end=30;

    public task4(Curve[] curve,String[] strFunc){
        super("Grafics");
        this.curve = curve;
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(0, 70));
        
        JTextArea inStart = new JTextArea("-30",1,2);
        inStart.addKeyListener(new KeyListener(){
        		@Override
            public void keyTyped(KeyEvent ke) {

        	}
        		
        		@Override
        		public void keyPressed(KeyEvent ke) {

        		}
        		
        		@Override
        		public void keyReleased(KeyEvent ke) {
        			try {
        				start = Integer.parseInt(inStart.getText());
        				if(start <= end) {
        					for(Curve crv: curve) {
        						crv.setBorder(start, -100, end, 100);
        						repaint();
        					}
        				}
        			}catch(Exception e) {}
        		}
        });
        panel1.add(inStart);
        
        JTextArea inEnd = new JTextArea("30",1,2);
        inEnd.addKeyListener(new KeyListener(){
    		@Override
        public void keyTyped(KeyEvent ke) {

    	}
    		
    		@Override
    		public void keyPressed(KeyEvent ke) {

    		}
    		
    		@Override
    		public void keyReleased(KeyEvent ke) {
    			try {
    				end = Integer.parseInt(inEnd.getText());
    				if(start <= end) {
    					for(Curve crv: curve) {
    						crv.setBorder(start, -100, end, 100);
    						repaint();
    					}
    				}
    			}catch(Exception e) {}
    		}
    });
        panel1.add(inEnd);

        choosFunc = new JComboBox<>(strFunc);
        choosFunc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }

        });
        panel1.add(choosFunc);
        
        JButton bRed = new JButton("red");
        bRed.addActionListener(new ActionListener(){
        		@Override
            public void actionPerformed(ActionEvent ae) {
        			if(clr != Color.red) {
        				clr = Color.red;	
        				repaint();
        			}
        	}
        });
        panel1.add(bRed);
        
        JButton bBlue = new JButton("blue");
        bBlue.addActionListener(new ActionListener(){
        		@Override
            public void actionPerformed(ActionEvent ae) {
        			if(clr != Color.BLUE) {
        				clr = Color.BLUE;	
        				repaint();
        			}
        	}
        });
        panel1.add(bBlue);
        
        JButton bBlack = new JButton("black");
        bBlack.addActionListener(new ActionListener(){
        		@Override
            public void actionPerformed(ActionEvent ae) {
        			if(clr != Color.BLACK) {
        					clr = Color.BLACK;	
        					repaint();
        			}
        	}
        });
        panel1.add(bBlack);

        add(panel1,BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int w = getWidth(), h = getHeight();
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2)); // толщина линий - 3 пикселя
        int x0=w/2;
        int y0=h/2;
        g.setColor(Color.BLACK);
        g.drawLine(x0, 0, x0, h);
        g.drawLine(0, y0, w, y0);
        int scale = 20;
        for (int x = x0 - (x0/scale) * scale; x <= x0 + (x0/scale) * scale; x += scale) {
            g.drawLine(x, y0 + 2,  x, y0 - 2);
        }
        for (int y = y0 - (y0/scale) * scale; y <= y0 + (y0/scale) * scale; y += scale) {
            g.drawLine(x0 + 2, y, x0 - 2, y);
        }
        g.setColor(clr);
        curve[choosFunc.getSelectedIndex()].Curvepaint(g,w,h,scale);
    }

    public static void main(String[] args) {

        Curve[] crv = new Curve[3];
        double[] xs = new double[201];
        double[] ys = new double[201];
        double x= -5*Math.PI;
        for(int i = 0; i<xs.length;i++) {
            xs[i] = x;
            ys[i] = Math.sin(x);
            x+=10*Math.PI/(xs.length-1);
        }
        crv[0] = new Curve(xs,ys);

        x= -5*Math.PI;
        for(int i = 0; i<xs.length;i++) {
            xs[i] = x;
            ys[i] = Math.sin(x*x)+Math.cos(x*x);
            x+=10*Math.PI/(xs.length-1);
        }
        crv[1] = new Curve(xs,ys);

        x= -5*Math.PI;
        for(int i = 0; i<xs.length;i++) {
            xs[i] = x;
            ys[i] = 2*Math.sin(x)+Math.cos(2*x);
            x+=10*Math.PI/(xs.length-1);
        }
        crv[2] = new Curve(xs,ys);

        new task4(crv,new String[]{"sin(x)", "sin(x*x) + cos(x*x)", "2*sin(x)+cos(2*x)"});
    }


}