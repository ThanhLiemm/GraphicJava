/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_liem;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
        // ve  toa do 
                    int x1 = Math.round(a / 15);
                    int y1 = Math.round(b / 15);
                    int x2 = Math.round(c / 15);
                    int y2 = Math.round(d / 15); 
                    x1=x1-25;
                    x2=x2-25;
                    y1=25-y1;
                    y2=25-y2;
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font("", Font.BOLD, 20));
                     g2d.drawString("A("+ x1 + "," + y1 + ")", a, b+30);
                     g2d.drawString("A("+ x2 + "," + y2 + ")", c, d+30);
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
                    for(int i=0;i<6;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    
                    }
                    //khoang trang
                   for(int i=0;i<4;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc; 
                    }
                    //net cham
                    for(int i=0;i<1;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);// vẽ nét chấm   
                    }
                    
                }else{
                    //khoang trang
                  for(int i=0;i<4;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    }
                }
               xet++;  
             } 
            // ve  toa do 
        int x1 = Math.round(a / 15);
                    int y1 = Math.round(b / 15);
                    int x2 = Math.round(c / 15);
                    int y2 = Math.round(d / 15); 
                    x1=x1-25;
                    x2=x2-25;
                    y1=25-y1;
                    y2=25-y2;
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font("", Font.BOLD, 20));
                     g2d.drawString("A("+ x1 + "," + y1 + ")", a, b+30);
                     g2d.drawString("A("+ x2 + "," + y2 + ")", c, d+30);
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
            // ve  toa do 
        int x1 = Math.round(a / 15);
                    int y1 = Math.round(b / 15);
                    int x2 = Math.round(c / 15);
                    int y2 = Math.round(d / 15); 
                    x1=x1-25;
                    x2=x2-25;
                    y1=25-y1;
                    y2=25-y2;
                     
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font("", Font.BOLD, 20));
                     g2d.drawString("A("+ x1 + "," + y1 + ")", a, b+30);
                     g2d.drawString("A("+ x2 + "," + y2 + ")", c, d+30);
    }
    
    public void muiTen(Graphics2D g2d)
    {
        //Truong hop 0<m<1 && x1<x2 && y1<y2
          //ve doan thang 
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int tamx,tamy;
            //MidpointLine(g2d,c,d,c-45,d+30);
            if(a<c){
            
            dy=d-b;
            dx=c-a;
            
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
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
            if(b == d){// mui ten nam ngang huong ve ra xa truc oy  -------->
            muiten1(g2d,c,d,c,d);
            muiten2(g2d,c,d,c,d);
            muiten3(g2d,c,d,c,d);
            }
         }
            else if(a>c){
                dy=b-d;
                dx=a-c;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x=c;
            y=d;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
            if(b == d){// mui ten nam ngang huong ve phhia truc oy <-----------
            muiten4(g2d,c,d,c,d);
            muiten5(g2d,c,d,c,d);
            muiten6(g2d,c,d,c,d);
            }
            }
            else if(b < d){
            dy=d-b;
            dx=a-c;
            
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
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
            if(a == c){
            muiten7(g2d,c,d,c,d);
            muiten8(g2d,c,d,c,d);
            muiten9(g2d,c,d,c,d);
            }
            }
            else if(b > d){
            dy=b-d;
            dx=c-a;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x=c;
            y=d;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
            if(a == c){
            muiten10(g2d,c,d,c,d);
            muiten11(g2d,c,d,c,d);
            muiten12(g2d,c,d,c,d); 
            }
            }
            // ve  toa do 
        int x1 = Math.round(a / 15);
                    int y1 = Math.round(b / 15);
                    int x2 = Math.round(c / 15);
                    int y2 = Math.round(d / 15); 
                    x1=x1-25;
                    x2=x2-25;
                    y1=25-y1;
                    y2=25-y2;
                     
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font("", Font.BOLD, 20));
                     g2d.drawString("A("+ x1 + "," + y1 + ")", a, b+30);
                     g2d.drawString("A("+ x2 + "," + y2 + ")", c, d+30);
    }
    public void hinhChuNhat(Graphics2D g2d)
    {
            duongthang((Graphics2D) g2d,a,b,c,b);
            duongthang((Graphics2D) g2d,a,b,a,d);
            duongthang((Graphics2D) g2d,c,d,a,d);
            duongthang((Graphics2D) g2d,c,d,c,b);
            //to mau
            int dy=Math.abs(d-b);
            int dx= Math.abs(c-a);
            int x,y;
            if(a>=c) x=c;
            else x=a;
            
            if(b>=d) y =d;
            else y =b;
           g2d.fillRect(x, y, dx, dy);
           // ve  toa do 
        int x1 = Math.round(a / 15);
                    int y1 = Math.round(b / 15);
                    int x2 = Math.round(c / 15);
                    int y2 = Math.round(d / 15); 
                    x1=x1-25;
                    x2=x2-25;
                    y1=25-y1;
                    y2=25-y2;
                     g2d.setColor(Color.BLUE);
                     g2d.setFont(new Font("", Font.BOLD, 20));
                     g2d.drawString("A("+ x1 + "," + y1 + ")", a, b+30);
                     g2d.drawString("A("+ x2 + "," + y2 + ")", c, d+30);
            
//                g2d.drawLine(x1,y1,x2,y1);
//                g2d.drawLine(x1,y1,x1,y2);
//                g2d.drawLine(x2,y2,x1,y2);
//                g2d.drawLine(x2,y2,x2,y1);
    }
    public void duongthang(Graphics2D g2d,int x1,int y1,int x2,int y2){
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int tamx,tamy;
            //MidpointLine(g2d,c,d,c-45,d+30);
           
            if(x1>x2||y1>y2){
            tamx=x1;
            x1=x2;
            x2=tamx;       
            tamy=y1;
            y1=y2;
            y2=tamy;          
            }         
            
            
            dy=y2-y1;
            dx=x2-x1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x=x1;
            y=y1;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
            
        
        }
    public void muiten1(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
           
            
            // ve canh tren 
           
            q3 = q3 - h;
            q4 = q4 - a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
        
        }
        
        public void muiten2(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
         
            
            // ve canh tren 
           
            q3 = q3 - h;
            q4 = q4 + a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
       
        }
        
        public void muiten3(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
            
            
            // ve canh tren 
            q1 = q1 - h;
            q2 = q2 - a;
            q3 = q3 - h;
            q4 = q4 + a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
           }
        
        }
        
        public void muiten4(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
  
            
            // ve canh tren 
           
            q3 = q3 + h;
            q4 = q4 - a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
        
        }
        
        public void muiten5(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
            
            
            // ve canh tren 
           
            q3 = q3 + h;
            q4 = q4 + a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
        
        }
        
        public void muiten6(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
          
            
            // ve canh tren 
            q1 = q1 + h;
            q2 = q2 - a;
            q3 = q3 + h;
            q4 = q4 + a;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
        
        }
//     void MidpointLine(Graphics2D g2d, int x1, int y1, int x2, int y2)
//{
//	int Dx = x2 - x1;
//	int Dy = y2 - y1;
//	int x = x1;
//	int y = y1;
//        
//	float D = Dy - Dx/2;
//	while(x <= x2)
//	{
//		x++;
//		if (D < 0 )
//		{
//			D = D + Dy;
//		}
//		else 
//		{
//			D = D + (Dy - Dx);
//			y++;
//		}
//                g2d.setColor(Color.red);
//		g2d.fillOval(x, y, 5, 5);
//	}
//}           
     public void muiten7(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
           
            
            // ve canh tren 
           
            q3 = q3 + a;
            q4 = q4 - h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
}
            public void muiten8(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
         
            
            // ve canh tren 
           
            q3 = q3 - a;
            q4 = q4 - h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
       
        }
        
        public void muiten9(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
            
            
            // ve canh tren 
            q1 = q1 + a;
            q2 = q2 - h;
            q3 = q3 - a;
            q4 = q4 - h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
           }
        
        }
        
        public void muiten10(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
           
            
            // ve canh tren 
           
            q3 = q3 - a;
            q4 = q4 + h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
        
        }
        
        public void muiten11(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
         
            
            // ve canh tren 
           
            q3 = q3 + a;
            q4 = q4 + h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
            }
       
        }
        
        public void muiten12(Graphics2D g2d,int q1,int q2,int q3,int q4){
          
            int dx,dy;
            int xet=1;
            float Xinc,Yinc,x,y,steps;
            int h = 30;
            int a = 15;
            
            
            // ve canh tren 
            q1 = q1 + a;
            q2 = q2 + h;
            q3 = q3 - a;
            q4 = q4 + h;
                    
            dy=q4-q2;
            dx=q3-q1;
            
            if(dy>dx){
                steps=Math.abs(dy);
            }
            else{
                steps=Math.abs(dx);
            }
            x = q1;
            y = q2;
            Yinc=dy/steps;
            Xinc=dx/steps;
            
            while(steps!=0){
                if(xet %2 != 0){
                    //net gach
                    for(int i=0;i<15;i++){
                    steps--;
                    x=x+Xinc;
                    y=y+Yinc;
                    g2d.setColor(Color.BLUE);
                    g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
                    }   
                }
                xet++;
           }
        
        }
}
