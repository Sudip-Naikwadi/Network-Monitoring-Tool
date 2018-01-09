package network.monitoring.tool;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import javax.swing.*;

public class Dashboard_GUI extends javax.swing.JFrame {

    String hname, mac, ipadd, ConStatus;
    InetAddress ipobj;
    Status_thread t;

    public Dashboard_GUI() {
            initComponents();
           try {
              ipobj = InetAddress.getLocalHost();
             this.Hname.setText(ipobj.getHostName());
           NetworkInterface ntwrkobj = NetworkInterface.getByInetAddress(ipobj);
            byte[] mc = null;
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    if (i instanceof Inet4Address && i.getHostAddress().charAt(4) == '1') {
                        this.IPadd.setText(i.getHostAddress());
                        mc = n.getHardwareAddress();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mc.length; i++) {
                sb.append(String.format("%02X%s", mc[i], (i < mc.length - 1) ? "-" : " "));
            }
            this.Macadd.setText(sb.toString());
            Status_thread threadobj = new Status_thread();
            threadobj.start();

        } catch (Exception e) {
            Dashboard_GUI.connStatus.setForeground(Color.red);
            Dashboard_GUI.connStatus.setText("Disconnected");
             t=new Status_thread();
             t.start();
        }
        

    }

    @SuppressWarnings("unchecked")
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        HnameLeb = new javax.swing.JLabel();
        HIPLeb = new javax.swing.JLabel();
        HMACLeb = new javax.swing.JLabel();
        ShowConnDevBtn = new javax.swing.JButton();
        ReachBtn = new javax.swing.JButton();
        PortScanBtn = new javax.swing.JButton();
        PacketCapBtn = new javax.swing.JButton();
        ConnStatusLeb = new javax.swing.JLabel();
        connStatus = new javax.swing.JLabel();
        Hname = new javax.swing.JLabel();
        IPadd = new javax.swing.JLabel();
        Macadd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome Network Monitoring Tool");
        setBounds(new java.awt.Rectangle(250, 50, 0, 0));
        setFont(new java.awt.Font("Noto Sans CJK JP Black", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Network Monitoring Tool...");

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("Host Details");

        HnameLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HnameLeb.setText("Host Name:");

        HIPLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HIPLeb.setText("Host IP(Internet Protocol):");

        HMACLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HMACLeb.setText("Host MAC(Media Access Control):");

        ShowConnDevBtn.setText("Show Connected Devices");
        ShowConnDevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowConnDevBtnActionPerformed(evt);
            }
        });

        ReachBtn.setText("IP/Web Address Reachability");
        ReachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReachBtnActionPerformed(evt);
            }
        });

        PortScanBtn.setText("Port Scanner");
        PortScanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortScanBtnActionPerformed(evt);
            }
        });

        PacketCapBtn.setText("Packet Capture");
        PacketCapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PacketCapBtnActionPerformed(evt);
            }
        });

        ConnStatusLeb.setText("Connection Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(HMACLeb)
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ConnStatusLeb)
                            .addComponent(HIPLeb)
                            .addComponent(HnameLeb))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Hname)
                    .addComponent(IPadd)
                    .addComponent(Macadd)
                    .addComponent(connStatus))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReachBtn)
                    .addComponent(ShowConnDevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PacketCapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PortScanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HnameLeb)
                            .addComponent(Hname))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HIPLeb)
                            .addComponent(IPadd))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HMACLeb)
                            .addComponent(Macadd))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConnStatusLeb)
                            .addComponent(connStatus)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowConnDevBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ReachBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PortScanBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PacketCapBtn)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReachBtnActionPerformed
        Reachability_UI reachobj = new Reachability_UI();
        reachobj.setVisible(true);
    }//GEN-LAST:event_ReachBtnActionPerformed

    private void PortScanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortScanBtnActionPerformed
        PortScanner_UI pscanobj = new PortScanner_UI();
        pscanobj.setVisible(true);

    }//GEN-LAST:event_PortScanBtnActionPerformed

    private void ShowConnDevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowConnDevBtnActionPerformed
        Get_Devices_UI getdevobj = new Get_Devices_UI();
        getdevobj.setVisible(true);
    }//GEN-LAST:event_ShowConnDevBtnActionPerformed

    private void PacketCapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PacketCapBtnActionPerformed
        try {
            PacketCapture_UI capture = new PacketCapture_UI();
            capture.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_PacketCapBtnActionPerformed

    public Dashboard_GUI(String hname) {
    }

    public static void main(String args[]) {
        new Dashboard_GUI().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ConnStatusLeb;
    public javax.swing.JLabel HIPLeb;
    public javax.swing.JLabel HMACLeb;
    public static javax.swing.JLabel Hname;
    public javax.swing.JLabel HnameLeb;
    public static javax.swing.JLabel IPadd;
    public static javax.swing.JLabel Macadd;
    public javax.swing.JButton PacketCapBtn;
    public javax.swing.JButton PortScanBtn;
    public javax.swing.JButton ReachBtn;
    public javax.swing.JButton ShowConnDevBtn;
    public static javax.swing.JLabel connStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

class Status_thread extends Thread {
public void SetConnected()
{
Dashboard_GUI.connStatus.setForeground(Color.green);
Dashboard_GUI.connStatus.setText("Connected");
    
}
public void SetDisconnected()
{
      Dashboard_GUI.connStatus.setForeground(Color.red);
      Dashboard_GUI.connStatus.setText("Disconnected");
}

@Override
    public void run() {
          
        Process p;
        String s, temp[], getway = null;
         while(true){
        try {
            p = Runtime.getRuntime().exec("netstat -rn");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
                if (s.startsWith("0.0.0.0")) {
                    temp = s.split(" +");
                    getway = temp[1];
                }
                    }
            p.waitFor();
            p.destroy();
           if(getway==null)
                   {
                     this.SetDisconnected();
                   }
            else if (InetAddress.getByName(getway).isReachable(300)) {
               this.SetConnected();         
            } 
        Status_thread.sleep(3000);

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "You Are Not Connected To Network! ");
        }
        }

    }
}
