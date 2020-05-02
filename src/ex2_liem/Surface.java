/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_liem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import javax.swing.JPanel;

/**
 *
 * @author thanhliem
 */
public class Surface extends JPanel{
    public int a;
    public int b;
    public int c;
    public int d;
    public int index;
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        this.setBounds(200, 0, 750, 750);
        Graphics2D g2d = (Graphics2D) g;
        Axis(g2d);
        doDrawing(g2d);
    }
    // ham ve thi ta ve vao day
    public void doDrawing(Graphics2D g2d)
    {
        // ham ke o
        Axis(g2d);
        if(index==0)
        {
            dDA1(g2d);
        }else if(index == 1)
        {
            dDA2(g2d);
        }
        else if(index==2)
        {
            dDA3(g2d);
        }
        else if(index==3)
        {
            muiTen(g2d);
        }
        else if(index==4)
        {
            hinhChuNhat(g2d);
        }
    }
    // ham ve toa do
    public void Axis(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 80; i++) {
			g2d.drawLine(15 * i, 0, 15 * i, 750);// moi don vi la 15pixel
			g2d.drawLine(0, 15 * i, 750, 15 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, 375, 750, 375);
		g2d.drawLine(375, 0, 375,750 );
        }
    //ham ve dda1
    public void dDA1(Graphics2D g2d)
    {
        {   int temp;
           
            if(abs(c-a) > abs(d-b))
            {
                
                if(a>c)
            {
                temp=a;
                a=c;
                c=temp;
                temp=b;
                b=d;
                d=temp;
            }
                int x =a;
                float y = b;
                float m = (float)(d-b)/(float)(c-a);
                int count=0;
                while(x <=c)
            {
                
                y=y+m;
                if(count>=8 && count<=14)
                {   
                    x++;
                    if(count==14)
                    {
                        count=0;
                        continue;
                    }
                    
                    count++;
                    continue;
                }
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(x,Math.round(y),x,Math.round(y));
                x++;
                count++;
                
            }
            }
            if(a == c && b == d)
            {
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(a,b,a,b);
            }
            else{
                
                if(b>d)
            {
                temp=a;
                a=c;
                c=temp;
                temp=b;
                b=d;
                d=temp;
            }
                float x =a;
                int y = b;
                float m = (float)(c-a)/(float)(d-b);
                int count=0;
                while(y <= d)
            {   
                
                x=x+m;
                if(count>=8 && count <=14)
                {
                    y++;
                    if(count==14)
                    {
                        count =0;
                    
                        continue;
                    }
                    count++;
                    continue;
                }
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(Math.round(x),y,Math.round(x),y);
                y++;
                count++;
                
            }
            }
            
    }
 }
    public void dDA2(Graphics2D g2d)
    {
        int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int tamx,tamy;
            
            if(a>c||b>d){
            tamx=a;
            a=c;
            c=tamx;       
            tamy=b;
            b=d;
            d=tamy;          
            }            
           
            dy=d-b;
            dx=c-a;
            
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(a, b, a, b);
            
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x=a;
            y=b;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<7;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(5));
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    
                    }
                    //khoang trang
                   for(int i=0;i<6;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc; 
                    }
                    //net cham
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.RED);
                    g2d.fillOval(Math.round(x),Math.round(y),5,5);// vẽ nét chấm   
                        
                    
                }else{
                    //khoang trang
                  for(int i=0;i<6;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc; 
                    }
                }
               xet++;  
             }      
    }
    public void dDA3(Graphics2D g2d)
    {
        int temp;
           
            if(abs(c-a) > abs(d-b))
            {
                
                if(a>c)
            {
                temp=a;
                a=c;
                c=temp;
                temp=b;
                b=d;
                d=temp;
            }
                int x =a;
                float y = b;
                float m = (float)(d-b)/(float)(c-a);
                int count=0;
                while(x <=c)
            {
                
                y=y+m;
                if((count>=8 && count<14)|| (count>=16 && count<22) || (count>=24 && count<30))
                {   
                    x++;
                    
                    if(count==29)
                    {
                        count=0;
                        continue;
                    }
                    
                    count++;
                    continue;
                }
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(x,Math.round(y),x,Math.round(y));
                
                x++;
                count++;
                
            }
            }
            if(a == c && b == d)
            {
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(a,b,a,b);
            }
            else{
                
                if(b>d)
            {
                temp=a;
                a=c;
                c=temp;
                temp=b;
                b=d;
                d=temp;
            }
                float x =a;
                int y = b;
                float m = (float)(c-a)/(float)(d-b);
                int count=0;
                while(y <= d)
            {   
                
                x=x+m;
                if((count>=8 && count<14)|| (count>=16 && count<22) || (count>=24 && count<30))
                {
                    y++;
                    
                    if(count==29)
                    {
                        count =0;
                    
                        continue;
                    }
                    count++;
                    continue;
                }
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawLine(Math.round(x),y,Math.round(x),y);
                y++;
                count++;
                
            }
            }
    }
    public void muiTen(Graphics2D g2d)
    {
        
    }
    public void hinhChuNhat(Graphics2D g2d)
    {
        
    }
}
