
package network.monitoring.tool;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.table.DefaultTableModel;
public class Get_Devices_UI extends javax.swing.JFrame {
 Sthread thread;
    public Get_Devices_UI() {
        initComponents();
        thread=new Sthread();
    }
    class Sthread extends Thread{
         int i;
         DefaultTableModel model;
        Sthread()
        {           
           model = (DefaultTableModel) DevTable.getModel();
        }
    public void run()
    {
       String s,s1,temp[];
              Process p;
        try {
           for(int i=1;i<150;i++){
               int j=0;
            p = Runtime.getRuntime().exec("nbtscan 192.168.3."+i);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
            {
                if(s.startsWith("192.168.3."+i))
                 {
                  temp=s.split(" +");
                  String[] row = {temp[0],temp[1],temp[4]};
              model.addRow(row);
                   }
              System.out.println("line: " + s);
            }
            p.waitFor();
            p.destroy();
           }
        } catch (Exception e) {}
    
    }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLeb = new javax.swing.JLabel();
        GetDevBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DevTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Get Connected Devices");
        setBounds(new java.awt.Rectangle(500, 50, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TitleLeb.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TitleLeb.setForeground(new java.awt.Color(0, 0, 255));
        TitleLeb.setText("Connected Devices...");
        TitleLeb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        GetDevBtn.setText("Get Devices");
        GetDevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetDevBtnActionPerformed(evt);
            }
        });

        DevTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device Name", "Device IP", "Device MAC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DevTable);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(BackBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(TitleLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(GetDevBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLeb)
                .addGap(33, 33, 33)
                .addComponent(GetDevBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackBtn)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetDevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetDevBtnActionPerformed
        thread.start();
        GetDevBtn.setText("Scanning...");
        GetDevBtn.setEnabled(false);
    }//GEN-LAST:event_GetDevBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        thread.suspend();
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackBtn;
    public javax.swing.JTable DevTable;
    public javax.swing.JButton GetDevBtn;
    public javax.swing.JLabel TitleLeb;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
