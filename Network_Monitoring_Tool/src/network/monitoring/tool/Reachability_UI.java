
package network.monitoring.tool;

import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Reachability_UI extends javax.swing.JFrame {
    public Reachability_UI() {
       
        initComponents();
    }
 public void WebAddressReach(String url,String name)
    {
        try{
    InetAddress address = InetAddress.getByName(url);
   if((name.isEmpty())){
        String res="Web Address:"+address.getHostName()+"\nIP(Internet Protocol):"
            +address.getHostAddress()+"\nReachabiliy Status:"+address.isReachable(3000);
     JOptionPane.showMessageDialog(null,res);
   }
   else
   {
       String res="Name:"+name+"\nWeb Address:"+address.getHostName()+"\nIP(Internet Protocol):"
            +address.getHostAddress()+"\nReachabiliy Status:"+address.isReachable(3000);
     JOptionPane.showMessageDialog(null,res);
   }
      }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Entered Web address is not reachable!");
      System.out.println(e);  
    }
    }
   public void IPAddressReach(String ip,String name)
    {
        try{
    InetAddress address = InetAddress.getByName(ip);
   if((name.isEmpty())){
       String res="Web Address:"+address.getHostName()+"\nIP(Internet Protocol):"
            +address.getHostAddress()+"\nReachabiliy Status:"+address.isReachable(3000);
     JOptionPane.showMessageDialog(null,res);
   }
   else
   {
       String res="Name:"+name+"\nWeb Address:"+address.getHostName()+"\nIP(Internet Protocol):"
            +address.getHostAddress()+"\nReachabiliy Status:"+address.isReachable(3000);
     JOptionPane.showMessageDialog(null,res);
   }
    
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Entered IP address is not reachable!");
      System.out.println(e);  
    }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DispNameLeb = new javax.swing.JLabel();
        HelpText = new javax.swing.JLabel();
        IPHnameText = new javax.swing.JTextField();
        DispNameText = new javax.swing.JTextField();
        CheckBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        TitleLeb = new javax.swing.JLabel();
        IPHnameLeb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IP/Web Address Reachability");
        setBounds(new java.awt.Rectangle(500, 50, 0, 0));

        DispNameLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DispNameLeb.setText("Display Name:");

        HelpText.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        HelpText.setText("(Example:192.168.1.4/www.google.com)");

        IPHnameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPHnameTextActionPerformed(evt);
            }
        });

        DispNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispNameTextActionPerformed(evt);
            }
        });

        CheckBtn.setText("Check");
        CheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        TitleLeb.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TitleLeb.setForeground(new java.awt.Color(0, 0, 255));
        TitleLeb.setText("IP/Web Address Reachability...");
        TitleLeb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        IPHnameLeb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        IPHnameLeb.setText("IP/Web Address:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(CheckBtn)
                                .addGap(73, 73, 73)
                                .addComponent(BackBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DispNameLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DispNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(IPHnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(IPHnameLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(HelpText)
                        .addGap(80, 80, 80))))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(TitleLeb, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TitleLeb)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DispNameLeb)
                    .addComponent(DispNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(IPHnameLeb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IPHnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HelpText)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBtn)
                    .addComponent(BackBtn))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IPHnameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPHnameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPHnameTextActionPerformed

    private void DispNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DispNameTextActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void CheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtnActionPerformed
        String input=IPHnameText.getText();
       String  name=DispNameText.getText();
        String IPregx="^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$)";
        String URLregx="(www.)?([a-zA-Z0-9]+)." +"[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
        
        String Hostregx="([a-zA-Z0-9]+)-PC";
        
        Pattern ip = Pattern.compile(IPregx);
	Matcher ipm = ip.matcher(input);
        
        Pattern urlp = Pattern.compile(URLregx);
	Matcher urlm = urlp.matcher(input);
                if(ipm.matches() )
                {
                         this.IPAddressReach(input, name);
                }
                else if(urlm.matches() )
                {    
                        this.WebAddressReach(input, name);                                          
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect IP Address Or Web Address");
                }
        
        
    }//GEN-LAST:event_CheckBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackBtn;
    public javax.swing.JButton CheckBtn;
    public javax.swing.JLabel DispNameLeb;
    public javax.swing.JTextField DispNameText;
    public javax.swing.JLabel HelpText;
    public javax.swing.JLabel IPHnameLeb;
    public javax.swing.JTextField IPHnameText;
    public javax.swing.JLabel TitleLeb;
    // End of variables declaration//GEN-END:variables
}
