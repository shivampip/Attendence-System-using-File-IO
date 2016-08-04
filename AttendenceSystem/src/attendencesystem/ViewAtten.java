package attendencesystem;

import java.awt.Font;
import java.awt.Label;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import javafx.scene.paint.Color;

public class ViewAtten extends java.awt.Frame {
    public ViewAtten() {
        initComponents();
        starting();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rnnm = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        tat = new java.awt.Label();
        tab = new java.awt.Label();
        pp = new java.awt.Panel();

        setBackground(new java.awt.Color(184, 183, 244));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        rnnm.setBackground(new java.awt.Color(153, 255, 255));
        rnnm.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        label2.setBackground(new java.awt.Color(189, 187, 245));
        label2.setFont(new java.awt.Font("DialogInput", 1, 22)); // NOI18N
        label2.setText("Total Present");

        label3.setBackground(new java.awt.Color(189, 187, 245));
        label3.setFont(new java.awt.Font("DialogInput", 1, 22)); // NOI18N
        label3.setText("Total Absent");

        tat.setAlignment(java.awt.Label.CENTER);
        tat.setBackground(new java.awt.Color(102, 255, 0));
        tat.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        tab.setAlignment(java.awt.Label.CENTER);
        tab.setBackground(new java.awt.Color(255, 153, 153));
        tab.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        pp.setBackground(new java.awt.Color(189, 187, 245));

        javax.swing.GroupLayout ppLayout = new javax.swing.GroupLayout(pp);
        pp.setLayout(ppLayout);
        ppLayout.setHorizontalGroup(
            ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ppLayout.setVerticalGroup(
            ppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rnnm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tat, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rnnm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    int rr=View.rol;
    String name=View.naam;
    void starting()
    {
        setLocation(250,100);
        try{
            rnnm.setText("  "+rr+"     "+name);
            FileInputStream fin=new FileInputStream("Days.txt");
            int i;
            String data="";
            while((i=fin.read())!=-1)
                data=data+(char)i;
            fin.close();
            StringTokenizer st=new StringTokenizer(data,"@");
            int totat=0;
            int totab=0;
            while(st.hasMoreTokens())
            {
                String s=st.nextToken();
                FileInputStream finn=new FileInputStream(s+".txt");
                int j;
                String data1="";
                while((j=finn.read())!=-1)
                    data1=data1+(char)j;
                int index=data1.indexOf(rr+"");
                System.out.println("The index of "+rr+" is "+index);
                index+=4;
                char c=data1.charAt(index);
                if(c=='P')
                    totat++;
                else if(c=='A')
                    totab++;
                else
                    c='-';
                String ld=s+"                    "+c;
                writeLabel(ld);
                
            }
            tat.setText(totat+"");
            tab.setText(totab+"");
         }catch(Exception e){System.out.println(e);}
    }
    
    Font ff=new Font("Arial",1,17);
    Label ll[]=new Label[100];
    int i=0;
    void writeLabel(String s)
    {
        ll[i]=new Label(s);
        pp.add(ll[i]);
        ll[i].setBounds(20,10+i*40,250,30);
        ll[i].setFont(ff);
        ll[i].setBackground(java.awt.Color.YELLOW);
        setSize(340,200+(i+1)*40);
        i++;
    }
    
    
    
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
    }//GEN-LAST:event_exitForm
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAtten().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Panel pp;
    private java.awt.Label rnnm;
    private java.awt.Label tab;
    private java.awt.Label tat;
    // End of variables declaration//GEN-END:variables
}
