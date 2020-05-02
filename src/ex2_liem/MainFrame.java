/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_liem;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author thanhliem
 */
public class MainFrame extends JFrame implements ActionListener {

    
    Surface sf = new Surface();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JButton bt1 = new JButton();
    JButton bt2 = new JButton();
    JButton bt3 = new JButton();
    JButton bt4 = new JButton();
    JButton bt0 = new JButton();
    // ham khoi tao
    public MainFrame()
    {
        //ham khoi tao cac gia trido hoa
        initUI();
    }
    public void initUI()
    {
                this.setSize(1520, 1080);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setTitle("Ex2 - NHOM 13");
                
		
                // o trong nhap so lieu
		tf1.setBounds(70, 50, 120, 40);
		tf1.setFocusable(true);
		tf1.setText("");
		tf1.setEditable(true);
		
		tf2.setBounds(70, 110, 120, 40);
		tf2.setFocusable(true);
		tf2.setText("");
		tf2.setEditable(true);
                
                tf3.setBounds(70,170, 120, 40);
		tf3.setFocusable(true);
		tf3.setText("");
		tf3.setEditable(true);
                
                tf4.setBounds(70, 230, 120, 40);
		tf4.setFocusable(true);
		tf4.setText("");
		tf4.setEditable(true);
                
                
		
		label1.setBounds(10, 50, 50, 40);
		label1.setEnabled(false);
		label1.setText("X0: ");
		label1.setFont(new Font("Ink Free", Font.BOLD, 13));

		label2.setBounds(10, 110, 50, 40);
		label2.setEnabled(false);
		label2.setText("Y0: ");
		label2.setFont(new Font("Ink Free", Font.BOLD, 13));
                
                label4.setBounds(10, 170, 50, 40);
		label4.setEnabled(false);
		label4.setText("X1: ");
		label4.setFont(new Font("Ink Free", Font.BOLD, 13));
                
                label5.setBounds(10, 230, 50, 40);
		label5.setEnabled(false);
		label5.setText("Y1: ");
		label5.setFont(new Font("Ink Free", Font.BOLD, 13));
                

		label3.setBounds(45, 290, 200, 30);
		label3.setEnabled(false);
		label3.setText("Limit: (-25,25)");
		label3.setFont(new Font("Ink Free", Font.BOLD, 18));
                // nut thu nhat    
		bt0.setText("Net Dut");
		bt0.setBounds(70,340, 120, 40);
		bt0.setBorder(BorderFactory.createBevelBorder(1));
		bt0.setFocusable(false);
		bt0.setFont(new Font("Ink Free", Font.BOLD, 16));
                // nut thu 2 
                bt1.setText("Cham Gach");
		bt1.setBounds(70,400, 120, 40);
		bt1.setBorder(BorderFactory.createBevelBorder(1));
		bt1.setFocusable(false);
		bt1.setFont(new Font("Ink Free", Font.BOLD, 16));
                // nhut 3
                bt2.setText("Hai Cham Gach");
		bt2.setBounds(70,460, 120, 40);
		bt2.setBorder(BorderFactory.createBevelBorder(1));
		bt2.setFocusable(false);
		bt2.setFont(new Font("Ink Free", Font.BOLD, 16));
                // nut 4
                bt3.setText("Mui Ten");
		bt3.setBounds(70,520, 120, 40);
		bt3.setBorder(BorderFactory.createBevelBorder(1));
		bt3.setFocusable(false);
		bt3.setFont(new Font("Ink Free", Font.BOLD, 16));
                // nut 5
                bt4.setText("Hình CN");
		bt4.setBounds(70,580, 120, 40);
		bt4.setBorder(BorderFactory.createBevelBorder(1));
		bt4.setFocusable(false);
		bt4.setFont(new Font("Ink Free", Font.BOLD, 16));
                
		this.add(label3);
		this.add(label2);
		this.add(label1);
                this.add(label4);
                this.add(label5);
                this.add(tf3);
                this.add(tf4);
		this.add(tf2);
		this.add(tf1);
                // nut0
		this.add(bt0);
                bt0.setActionCommand("gach noi");
                bt0.addActionListener(this);
                
                // nut 1
                this.add(bt1);
                bt1.setActionCommand("gach cham");
                bt1.addActionListener(this);
                // nut 2
                this.add(bt2);
                bt2.setActionCommand("hai cham gach");
                bt2.addActionListener(this);
                // nut 3
                this.add(bt3);
                bt3.setActionCommand("mui ten");
                bt3.addActionListener(this);
                // nut 4
                this.add(bt4);
                bt4.setActionCommand("hinh chu nhat");
                    this.add(sf);
		bt4.addActionListener(this);
    }
public void xuLy()
{
                                       try {
					
					int a = Integer.parseInt(tf1.getText()) * 15;
					int b = Integer.parseInt(tf2.getText()) * 15;
                                        int c = Integer.parseInt(tf3.getText()) * 15;
                                        int d = Integer.parseInt(tf4.getText()) * 15;
                                        
					if (a >= -375 && a <= 375 && b >= -375 && b <= 375 && c >= -375 && c <= 375 && d >= -375 && d <= 375) {
						if (a <= 0)
							a = 375 + a;
						else
							a = 375 + a;
						if (b <= 0)
							b = 375 - b;
						else
							b = 375 - b;
                                                if (c <= 0)
							c = 375 + c;
						else
							c = 375 + c;
                                                if (d <= 0)
							d = 375 - d;
						else
							d = 375 - d;
						sf.a = a;
						sf.b = b;
                                                sf.c = c;
                                                sf.d = d;
						System.out.println(sf.a);
						System.out.println(sf.b);
                                                System.out.println(sf.c);
						System.out.println(sf.d);
						sf.repaint();
					} 
						else {
						String message = "Vui long nhap dung dinh dang! ";
						JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception q) {
					String message = "Vui long nhap dung dinh dang! ";
					JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
				}
			}

    @Override
    public void actionPerformed(ActionEvent e) {
        if("gach noi".equals(e.getActionCommand()))
        {
            sf.index=0;
            xuLy();
        }  if("gach cham".equals(e.getActionCommand()))
        {
            sf.index=1;
            xuLy();
        }
         if("hai cham gach".equals(e.getActionCommand()))
        {
            System.out.println("ex2_liem.MainFrame.actionPerformed()");
            sf.index=2;
            xuLy();
        }
         if("mui ten".equals(e.getActionCommand()))
        {
            sf.index=3;
            xuLy();
        } if("hinh chu nhat".equals(e.getActionCommand()))
        {
            sf.index=4;
            xuLy();
        }
            
    }
    
  public static void main(String []args) {
            EventQueue.invokeLater(new Runnable() {
         
            @Override
            public void run() {
                MainFrame mainframe = new MainFrame();
                mainframe.setVisible(true);
                }
});
                    }
}