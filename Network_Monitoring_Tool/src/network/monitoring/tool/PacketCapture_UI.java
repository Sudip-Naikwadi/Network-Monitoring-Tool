package network.monitoring.tool;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.Thread.State;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class PacketCapture_UI extends javax.swing.JFrame {
  Athread rc;
 Thread t ;
 public static ArrayList pklist;
 public static String TState; 
 public static int DevIndex;
 public Date date;
 
    public PacketCapture_UI()throws Exception {
        initComponents();
          pklist = new ArrayList<Packet>();
         GetInterfaceList();
        rc = new Athread();
        date=new Date();
        this.TState="NEW";         
    }
 public void startCapture()throws Exception
    {
           t = new Thread(rc);
          if(TState.equals("NEW"))
         {
       CapStatus.setForeground(Color.green);
              CapStatus.setText("Capturing Started...");
      this.t.start();
         }
         else{
              JOptionPane.showMessageDialog(null,"Packet Capturing Already Started");
         }
      
             
    }
     public void stopCapture()throws Exception
     {
         CapStatus.setForeground(Color.red);
              CapStatus.setText("Capturing Stopped...");
      // this.t.suspend();
      t.stop();
          }
    
     public String getFileName()
     {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        return dateFormat.format(date)+"_Capture.txt";
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLeb = new javax.swing.JLabel();
        InterfaceLeb = new javax.swing.JLabel();
        InterfaceList = new javax.swing.JComboBox<>();
        StartCapBtn = new javax.swing.JButton();
        StopCapBtn = new javax.swing.JButton();
        StatusLeb = new javax.swing.JLabel();
        CapturedPacLeb = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        TCPPacLeb = new javax.swing.JLabel();
        TotalPacLeb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UdpPacLeb = new javax.swing.JLabel();
        ARPPacLeb = new javax.swing.JLabel();
        OtherPacLeb = new javax.swing.JLabel();
        TotalPacCount = new javax.swing.JTextField();
        TCPPacCount = new javax.swing.JTextField();
        UDPPacCount = new javax.swing.JTextField();
        ARPPacCount = new javax.swing.JTextField();
        OtherPacCount = new javax.swing.JTextField();
        SavePacBtn = new javax.swing.JButton();
        CapStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PacketDetails = new javax.swing.JTextArea(100*100,100*100);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Packet Capture");
        setBounds(new java.awt.Rectangle(250, 50, 0, 0));

        TitleLeb.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TitleLeb.setForeground(new java.awt.Color(0, 0, 255));
        TitleLeb.setText("Packet Capture...");
        TitleLeb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        InterfaceLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        InterfaceLeb.setText("Select Interface:");

        InterfaceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceListActionPerformed(evt);
            }
        });

        StartCapBtn.setText("Start Capture");
        StartCapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartCapBtnActionPerformed(evt);
            }
        });

        StopCapBtn.setText("Stop Capture");
        StopCapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopCapBtnActionPerformed(evt);
            }
        });

        StatusLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        StatusLeb.setText("Status:");

        CapturedPacLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        CapturedPacLeb.setText("Captured Packets:");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        TCPPacLeb.setText("TCP(Transmission Control Protocol) Packets");

        TotalPacLeb.setText("Total Packets");

        UdpPacLeb.setText("UDP(User Datagram Protocol)Packets");

        ARPPacLeb.setText("ARP(Address Resolution Protocol) Packets");

        OtherPacLeb.setText("Other Packets");

        TotalPacCount.setEditable(false);
        TotalPacCount.setText("0");
        TotalPacCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPacCountActionPerformed(evt);
            }
        });

        TCPPacCount.setEditable(false);
        TCPPacCount.setText("0");
        TCPPacCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCPPacCountActionPerformed(evt);
            }
        });

        UDPPacCount.setEditable(false);
        UDPPacCount.setText("0");
        UDPPacCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UDPPacCountActionPerformed(evt);
            }
        });

        ARPPacCount.setEditable(false);
        ARPPacCount.setText("0");
        ARPPacCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARPPacCountActionPerformed(evt);
            }
        });

        OtherPacCount.setEditable(false);
        OtherPacCount.setText("0");
        OtherPacCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherPacCountActionPerformed(evt);
            }
        });

        SavePacBtn.setText("Save Packet");
        SavePacBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePacBtnActionPerformed(evt);
            }
        });

        CapStatus.setText(" ");

        PacketDetails.setEditable(false);
        PacketDetails.setColumns(20);
        PacketDetails.setRows(5);
        jScrollPane1.setViewportView(PacketDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackBtn)
                        .addGap(389, 389, 389))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TitleLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(InterfaceLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(StatusLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CapStatus))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(InterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(StartCapBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(StopCapBtn))))
                            .addComponent(CapturedPacLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(UdpPacLeb)
                                        .addGap(32, 32, 32))
                                    .addComponent(TCPPacLeb, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(UDPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ARPPacLeb)
                                        .addGap(3, 3, 3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(OtherPacLeb)
                                        .addGap(94, 94, 94))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ARPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(124, 124, 124))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(OtherPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(120, 120, 120))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TCPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(126, 126, 126))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TotalPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TotalPacLeb)
                                        .addGap(104, 104, 104)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SavePacBtn)
                                .addGap(91, 91, 91))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TitleLeb)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InterfaceLeb)
                            .addComponent(InterfaceList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StartCapBtn)
                            .addComponent(StopCapBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StatusLeb)
                            .addComponent(CapStatus))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CapturedPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TotalPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TCPPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TCPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(UdpPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UDPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ARPPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ARPPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(OtherPacLeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OtherPacCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SavePacBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(347, 347, 347)
                        .addComponent(jLabel3)))
                .addGap(16, 16, 16)
                .addComponent(BackBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TotalPacCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPacCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPacCountActionPerformed

    private void TCPPacCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCPPacCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCPPacCountActionPerformed

    private void UDPPacCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UDPPacCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UDPPacCountActionPerformed

    private void ARPPacCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARPPacCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ARPPacCountActionPerformed

    private void OtherPacCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherPacCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtherPacCountActionPerformed

    private void SavePacBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePacBtnActionPerformed
      
      try {
          //this.t.suspend();
          //t=null;
          //System.gc();
          this.savePackets();
      } catch (Exception ex) {
          Logger.getLogger(PacketCapture_UI.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        
    }//GEN-LAST:event_SavePacBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
       t.suspend();
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void InterfaceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterfaceListActionPerformed
          DevIndex=InterfaceList.getSelectedIndex();
    }//GEN-LAST:event_InterfaceListActionPerformed

    private void StartCapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartCapBtnActionPerformed
       try{
       this.startCapture();
       this.TState="RUNNING";
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_StartCapBtnActionPerformed

    private void StopCapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopCapBtnActionPerformed
        try{
       this.stopCapture();
       this.TState="NEW";
       }catch(Exception e){}
    }//GEN-LAST:event_StopCapBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ARPPacCount;
    private javax.swing.JLabel ARPPacLeb;
    public javax.swing.JButton BackBtn;
    public static javax.swing.JLabel CapStatus;
    public javax.swing.JLabel CapturedPacLeb;
    public javax.swing.JLabel InterfaceLeb;
    public javax.swing.JComboBox<String> InterfaceList;
    public static javax.swing.JTextField OtherPacCount;
    private javax.swing.JLabel OtherPacLeb;
    public static javax.swing.JTextArea PacketDetails;
    public javax.swing.JButton SavePacBtn;
    public javax.swing.JButton StartCapBtn;
    public javax.swing.JLabel StatusLeb;
    public javax.swing.JButton StopCapBtn;
    public static javax.swing.JTextField TCPPacCount;
    private javax.swing.JLabel TCPPacLeb;
    public javax.swing.JLabel TitleLeb;
    public static javax.swing.JTextField TotalPacCount;
    private javax.swing.JLabel TotalPacLeb;
    public static javax.swing.JTextField UDPPacCount;
    private javax.swing.JLabel UdpPacLeb;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

     public void savePackets()throws Exception
     {
         
         if(this.TState.equals("RUNNING"))
         {
         t.stop();       
     JOptionPane.showMessageDialog(null,"Saving Packets Will Stop Packet Capture.");
     this.TState="NEW";
         }
         String path="/home/sudip/Desktop/"+getFileName();
          File f=new File(path);
         Iterator itr = PacketCapture_UI.pklist.iterator();
        if(PacketCapture_UI.pklist.isEmpty())
        {
              JOptionPane.showMessageDialog(null,"Nothing To Save!");
        }
        else
        {
        PrintWriter pr=new PrintWriter(f);
        while(itr.hasNext())
        {
        pr.write(itr.next().toString()+"\n");
        }
          pr.close();
          JOptionPane.showMessageDialog(null,"Saved in:"+path);
         
        }
     }   
     
    
    public void GetInterfaceList() {

        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        String[] str = new String[devices.length];
        for (int i = 0; i < devices.length; i++) {
            str[i] = devices[i].name;
        }
        for (int i = 0; i < devices.length; i++) {
            InterfaceList.addItem(devices[i].name + "(" + devices[i].datalink_description + ")");
        }
    }
}

class Athread  implements Runnable {

     boolean flag;
    Thread t1;
    Packet pk;
   public ArrayList UDPlist, TCPlist, ICMPlist, ARPlist;
    int TCPc, UDPc, ARPc, ICMPc, Packetc, OtherPac;
     JpcapCaptor cap;
     NetworkInterface[] devices;
      
     Athread() throws IOException {
          UDPlist = new ArrayList<UDPPacket>();
        ICMPlist = new ArrayList<ICMPPacket>();
        ARPlist = new ArrayList<ARPPacket>();
        TCPlist = new ArrayList<TCPPacket>();
      
      t1 = new Thread(this);
      flag=true;
      TCPc = UDPc =  ARPc =  ICMPc =  Packetc =  OtherPac = 0;
      
      }
     public void run() {
       
        try{
            devices = JpcapCaptor.getDeviceList();
            cap = JpcapCaptor.openDevice(devices[PacketCapture_UI.DevIndex], 65535, true, 20);
        }catch(Exception E)
        {
        JOptionPane.showMessageDialog(null,"Error In Getting Devices\n OR Your Are Not Connected To Network!\n(Check your Network Setting)");
        }
   try {
            
            while (flag) {
                                 
                pk = cap.getPacket();
               // System.out.println("Thread running ");
                 /*System.out.println("packet count:"+Packetc);
                  System.out.println("arp count:"+ARPc);
                   System.out.println("tcp count:"+TCPc);
                    System.out.println("udp count:"+UDPc);*/
                 if (pk != null) {
                       
                        PacketCapture_UI.PacketDetails.append(pk + "\r\n");
                         PacketCapture_UI.pklist.add(pk);
                         Packetc++;
                         
                           if (pk instanceof UDPPacket) {
                    UDPPacket udp = (UDPPacket) (pk);
                    UDPlist.add(udp);
                    UDPc++;
                    
                } else if (pk instanceof ICMPPacket) {
                    ICMPPacket icmp = (ICMPPacket) (pk);
                    ICMPlist.add(icmp);
                    ICMPc++;
                   

                } else if (pk instanceof ARPPacket) {
                    ARPPacket arp = (ARPPacket) (pk);
                    ARPlist.add(arp);
                    ARPc++;
                    

                } else if (pk instanceof TCPPacket) {
                    TCPPacket tcp = (TCPPacket) (pk);
                    TCPlist.add(tcp);
                    TCPc++;
                   
                } else {
                    OtherPac++;
                }
                         
                         
                 }
               
              
                /* if(pklist.size()==1000)
                        {
                            TCPlist.clear();
                            UDPlist.clear();
                            ICMPlist.clear();
                            ARPlist.clear();
                            pklist.clear();
                            
                        }*/
              //  super.TotalPacCount.setText(String.valueOf(Packetc));
                  
              
                    
               PacketCapture_UI.ARPPacCount.setText(ARPc+" ");
                PacketCapture_UI.OtherPacCount.setText(OtherPac+" ");
               PacketCapture_UI.TotalPacCount.setText(Packetc+" ");
               PacketCapture_UI.TCPPacCount.setText(TCPc+" ");
               PacketCapture_UI.UDPPacCount.setText(UDPc+" ");    
            }
            }catch (Exception ex)
        { 
             JOptionPane.showMessageDialog(null,"You are not connected to network!");
              PacketCapture_UI.CapStatus.setForeground(Color.blue);
             PacketCapture_UI.CapStatus.setText("Error...");          
        }
    }
}

