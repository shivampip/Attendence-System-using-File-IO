package attendencesystem;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Take extends java.awt.Frame {
    public Take() {
        initComponents();
        starting();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        roll = new java.awt.Label();
        name = new java.awt.Label();
        p = new java.awt.Button();
        a = new java.awt.Button();
        save = new java.awt.Button();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(51, 0, 51));
        label1.setFont(new java.awt.Font("DialogInput", 3, 36)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 255, 255));
        label1.setText("Attendence");

        roll.setAlignment(java.awt.Label.CENTER);
        roll.setBackground(new java.awt.Color(153, 255, 153));
        roll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        roll.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        roll.setName(""); // NOI18N

        name.setAlignment(java.awt.Label.CENTER);
        name.setBackground(new java.awt.Color(102, 255, 204));
        name.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        p.setBackground(new java.awt.Color(200, 159, 244));
        p.setFont(new java.awt.Font("Arial", 1, 90)); // NOI18N
        p.setLabel("P");
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pMouseExited(evt);
            }
        });
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });

        a.setBackground(new java.awt.Color(200, 159, 244));
        a.setFont(new java.awt.Font("Arial", 1, 90)); // NOI18N
        a.setLabel("A");
        a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aMouseExited(evt);
            }
        });
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(0, 255, 204));
        save.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        save.setLabel("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roll, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    String[] starting()
    {
        String s="";
        setLocation(250,100);
        try{
            FileInputStream fin=new FileInputStream("Student_List.txt");
            int a;
            while((a=fin.read())!=-1)
                s=s+(char)a;
        }catch(Exception e){}
        
        StringTokenizer st=new StringTokenizer(s,"@");
        int n=st.countTokens();
        String ss[]=new String[n];
        int i=0;
        while(st.hasMoreElements())
        {
            ss[i]=st.nextToken();
            i++;
        }
        roll.setText(ss[0]);
        name.setText(ss[1]);
        return ss;
     }
    
    
    String[] rollName()
    {
        String s="";
        try{
            FileInputStream fin=new FileInputStream("Student_List.txt");
            int a;
            while((a=fin.read())!=-1)
                s=s+(char)a;
        }catch(Exception e){}
        
        StringTokenizer st=new StringTokenizer(s,"@");
        int n=st.countTokens();
        String ss[]=new String[n];
        int i=0;
        while(st.hasMoreElements())
        {
            ss[i]=st.nextToken();
            i++;
        }
        return ss;
     }
    String ss[]=rollName();
    
    String atten="";
    int count=2;
    void mark(char aa)
    {
        try{
        String ro=roll.getText();
        atten=atten+ro+"@"+aa+"@";
        roll.setText(ss[count]);
        name.setText(ss[count+1]);
        count+=2;
        System.out.println(atten);
        }catch(Exception e){System.out.println("End");
        p.setEnabled(false);
        a.setEnabled(false);}
    }
    
    
    
    
    
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
        save.setEnabled(true);
    }//GEN-LAST:event_exitForm

    private void pMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseEntered
        p.setBackground(Color.green);
    }//GEN-LAST:event_pMouseEntered

    private void aMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseEntered
        a.setBackground(Color.red);
    }//GEN-LAST:event_aMouseEntered

    private void pMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseExited
        p.setBackground(new java.awt.Color(200,156,244));
    }//GEN-LAST:event_pMouseExited

    private void aMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aMouseExited
        a.setBackground(new java.awt.Color(200,156,244));
    }//GEN-LAST:event_aMouseExited

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        mark('P');
    }//GEN-LAST:event_pActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        mark('A');
    }//GEN-LAST:event_aActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{
            FileOutputStream fout=new FileOutputStream(printDate()+".txt");
            byte arr[]=atten.getBytes();
            fout.write(arr);
            save.setEnabled(false);
        }catch(Exception e){System.out.println(e);}
        
    }//GEN-LAST:event_saveActionPerformed

    
    
      String printDate()
    {
        Date d=new Date();
        Format ff=new SimpleDateFormat("dd_MM_yyyy");
        String dat=ff.format(d);
        
        try{
            FileOutputStream fout=new FileOutputStream("Days.txt",true);
            byte arr[]=(dat+"@").getBytes();
            fout.write(arr);
        }catch(Exception e){}
        
        return dat;
    }
   
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Take().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button a;
    private java.awt.Label label1;
    private java.awt.Label name;
    private java.awt.Button p;
    private java.awt.Label roll;
    private java.awt.Button save;
    // End of variables declaration//GEN-END:variables
}
