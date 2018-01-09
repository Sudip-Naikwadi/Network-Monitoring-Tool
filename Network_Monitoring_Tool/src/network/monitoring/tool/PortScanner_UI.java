
package network.monitoring.tool;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
public class PortScanner_UI extends javax.swing.JFrame {
    public PortScanner_UI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        TitleLeb = new javax.swing.JLabel();
        HIPnameLeb = new javax.swing.JLabel();
        HIPnameText = new javax.swing.JTextField();
        StartPortText = new javax.swing.JTextField();
        StartPortLeb = new javax.swing.JLabel();
        EndPortLeb = new javax.swing.JLabel();
        EndPortText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        OpenPortsText = new javax.swing.JTextArea();
        ScanBtn = new javax.swing.JButton();
        OpenPortsLeb = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        HelpText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Port Scanner");
        setBounds(new java.awt.Rectangle(500, 50, 0, 0));

        TitleLeb.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TitleLeb.setForeground(new java.awt.Color(0, 0, 255));
        TitleLeb.setText("Port Scanner...");
        TitleLeb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        HIPnameLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HIPnameLeb.setText("IP/Hostname:");

        HIPnameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HIPnameTextActionPerformed(evt);
            }
        });

        StartPortText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartPortTextActionPerformed(evt);
            }
        });

        StartPortLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        StartPortLeb.setText("Start Port: ");

        EndPortLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        EndPortLeb.setText("End Port: ");

        EndPortText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndPortTextActionPerformed(evt);
            }
        });

        OpenPortsText.setColumns(20);
        OpenPortsText.setRows(5);
        jScrollPane1.setViewportView(OpenPortsText);

        ScanBtn.setText("Scan");
        ScanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanBtnActionPerformed(evt);
            }
        });

        OpenPortsLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        OpenPortsLeb.setText("Open Ports are...");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        HelpText.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        HelpText.setText("(Ports range must be from 1 to 65535)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(HelpText)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ScanBtn)
                        .addGap(164, 164, 164))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(TitleLeb))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(StartPortLeb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(StartPortText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(EndPortLeb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EndPortText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(HIPnameLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HIPnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(OpenPortsLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(BackBtn)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitleLeb)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HIPnameLeb)
                    .addComponent(HIPnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartPortLeb)
                    .addComponent(StartPortText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndPortLeb)
                    .addComponent(EndPortText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HelpText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScanBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OpenPortsLeb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackBtn)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HIPnameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HIPnameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HIPnameTextActionPerformed

    private void StartPortTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartPortTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartPortTextActionPerformed

    private void EndPortTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndPortTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndPortTextActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
                this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void ScanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanBtnActionPerformed
        boolean flag=true;
        int start=0,end=0;
        String host;
        try{
            host=HIPnameText.getText();
            start=Integer.parseInt(StartPortText.getText());
             end=Integer.parseInt(EndPortText.getText());
		//IP validation Regx
             String regx="^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$)";
        Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(host);
                if(!m.matches())
                {
                    JOptionPane.showMessageDialog(null,"Incorrect IP or Host name!");
                    flag=false;
                }
            
            if(start<1 || end>65535 || start==end || start>end)
            {
                JOptionPane.showMessageDialog(null,"Invalid Port Range !");
                flag=false;
            }
        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Invalid Input Format !");
             flag=false;
        }
        if(flag==true)
        {
           
            host=HIPnameText.getText();
            for(int k=start;k<=end;k++)
            {
                    (new scan(host,k)).start();
            }
        }
       
    }//GEN-LAST:event_ScanBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackBtn;
    public javax.swing.JLabel EndPortLeb;
    public javax.swing.JTextField EndPortText;
    public javax.swing.JLabel HIPnameLeb;
    public javax.swing.JTextField HIPnameText;
    public javax.swing.JLabel HelpText;
    public javax.swing.JLabel OpenPortsLeb;
    public static javax.swing.JTextArea OpenPortsText;
    public javax.swing.JButton ScanBtn;
    public javax.swing.JLabel StartPortLeb;
    public javax.swing.JTextField StartPortText;
    public javax.swing.JLabel TitleLeb;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

	static class scan extends Thread
    {
        String hn;
        int p;
        public scan(String host,int cp)
        {
               hn=host;
               p=cp;
        }
        public void run()
        {
               try   {
			       Socket s=new Socket(hn,p);
			       OpenPortsText.append("Port "+p+" is open\n");
			 }catch(Exception e){
                         }
         }
    }
}
