/*  @author Ashikul Hosen
*   email: sagor.ashikul@gmail.com
*/

import java.net.*;
import java.io.*;


public class MainFrame extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        super("GUI Chat Application"); //add a name to the frame
        initComponents(); //initialize the GUI (this method was created automatically by the Netbeans IDE)
        this.setVisible(true); // make the frame (window) visible
        this.sendButton.setEnabled(false); // disable the send button as long util two users are connected. You don't want to send a message if nobody is connected
        this.isClosed = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        receiveTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        sendTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        usernameTextArea = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        enableServer = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        serverIpAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        receiveTextArea.setColumns(20);
        receiveTextArea.setRows(5);
        jScrollPane1.setViewportView(receiveTextArea);

        sendTextArea.setColumns(20);
        sendTextArea.setRows(5);
        jScrollPane2.setViewportView(sendTextArea);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("                    Username:");

        enableServer.setText("Enable Server");
        enableServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableServerActionPerformed(evt);
            }
        });

        serverIpAddress.setText("192.168.0.100");

        jLabel2.setText("Server IP Address:");

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextArea)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(enableServer)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverIpAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enableServer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(serverIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(connectButton)
                        .addGap(132, 132, 132))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    *    Method will be executed when the enableButton is clicked (action event)
    */
    private void enableServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableServerActionPerformed
        // TODO add your handling code here:
        if(enableServer.isSelected()) //verify if the enableServer radio button is selected. Use isSelected method to find out that the button is selected or not. The fuction returns true if the radio button is selected.
        {
            //if the radio button is selected -> enter in the server mode
            receiveTextArea.setText("Waiting for remote user..."); //inform user that you are in the server mode and you are waiting another person to connect
            serverIpAddress.setEditable(false); //make serverIpAddress text area non editable (if you are in the server mode you must not be able to enter the server ip address)
            connectButton.setEnabled(false); //disable connectButton (if you are in the server mode you must not be able to connect to a server, the application runs as a server)
            this.isServer = true;  //set isServer to true, this global variable will be used in the run method to start the server mode.
        }
        else //if you are in the client mode or if you want to connect to the server
        {
            receiveTextArea.setText("");  //clear any message from the receiveTextArea
            serverIpAddress.setEditable(true); //enable client mode, make serverIpAddress text area editable in order to enter the server ip address
            connectButton.setEnabled(true); //enable the connectButton in order to connect to the server
            this.isServer = false; //set isServer to false, this global variable will be used in the run method to start the server mode or the client mode
        }
    }//GEN-LAST:event_enableServerActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        connectToServer = true; //set the connectToServer to true in order to enter in initializaClientMode
    }//GEN-LAST:event_connectButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        String message = sendTextArea.getText(); //get the written message
        message = localUsername + ": " + message; //append the username 
        try
        {
            out.write(message); // write the message
            out.newLine(); //write a new line, on the other side the reading is done using readLine method, so you must add a new line. 
            out.flush(); //flush the stream
            sendTextArea.setText(""); //clear sendTextArea after the message was sent
            String allText = receiveTextArea.getText(); 
            allText = allText + "\n" + message;
            receiveTextArea.setText(allText); //add the message to your receiveTextArea, you want to see what have you sent.
        }
        catch(Exception e)
        {
            disconnect(); //if the message cannot be send, execute disconnect
        }
    }//GEN-LAST:event_sendButtonActionPerformed

        
    public void run()
    {
        while(!isClosed) //run application until the user closes it.
        {
            sleep(100); //add a small timeout to free up the processor to do other things.
            if(isServer) //if server mode (variable is set in the enableServerActionPerformed method, when the enableServer radio button is selected)
            {
                initializeServerMode(); //initialize the server mode
            }
            if(connectToServer) //if the connect button was pressed, then the application is trying to connect to the server
            {
                initializeClientMode(); //initialize the client mode
                //readIncomingMessages(); //read all incoming messages
            }
        }
    }
    
    /*
    * Method used to initialize the server mode
    */
    private void initializeServerMode()
    {
        try
        {
            server = new ServerSocket(portNumber); //create the scoket object
            client = server.accept(); //wait for a connection
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); //create the outputstream
            in = new BufferedReader(new InputStreamReader(client.getInputStream())); //create the inputstream
     
            //the first thing the application will do after the client is connected is to exchange the user names.
            //1. server will wait for the client username
            remoteUsername = in.readLine(); // read the remote username and store it in the remoteUsername global variable
       
            //2. server will send his username;
            localUsername = usernameTextArea.getText(); //get the username from the text area
            localUsername = localUsername.trim(); //remove white spaces from the username String
            if(localUsername.length() == 0) //if no username was entered in the text area, create a default username
            {
                localUsername = "Server"; //the default username is "Server"
            }
            out.write(localUsername); // send the username
            out.newLine(); // add a new line (in the file transfer application we have used PrintWriter.println() method which enters automatically a new line character)
                           // on the client side and also for the server side we have used readLine() method to read the username String, so the method is waiting for a line (text + new line character))
            out.flush();

            //after exchanging the names
            //1. Inform user that the romote user is connected and print its name in the receive text area;
            receiveTextArea.setText("User: " + remoteUsername + " is connected! You can start the chat conversation");
            //2. Enable send button in order to send a new messages
            sendButton.setEnabled(true);
            //3. deactivate enable server radio button. User should not be able to change the connection mode after the connection was established
            enableServer.setEnabled(false);
            
            readIncomingMessages(); //read all incoming messages
        }
        catch(BindException e1)
        {
            receiveTextArea.setText("Port " + portNumber + " is used by another application!");
        }
        catch(Exception e)
        {
            System.out.println("server error!" + e.toString());
            //System.exit(1);
            disconnect();
        }
    }
    
    private void initializeClientMode()
    {
        try
        {
            String ip = serverIpAddress.getText(); //get the server ip address from the serverIpAddress text area
            client = new Socket(ip, portNumber); //try to connect to the server
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream())); //create the outputstream
            in = new BufferedReader(new InputStreamReader(client.getInputStream())); //create the inputstream
     
            //the first thing the application will do after the client is connected is to exchange the user names.
            //1. sent the local username to the server
            localUsername = usernameTextArea.getText(); //get the username from the text area
            if(localUsername.length() == 0) //if no username was entered in the text area, create a default username
            {
                localUsername = "Client"; //the default username is "Server"
            }

            localUsername = localUsername.trim(); //remove white spaces from the username String
            out.write(localUsername); //send the username
            out.newLine(); //add a new line
            out.flush(); //flush
      
            //2. client is waiting to receive the server username
            remoteUsername = in.readLine(); // read the remote username and store it in the remoteUsername global variable
                  
            
            //after exchanging the names:
            
            //1. Inform user that the romote user is connected and print it's name in the receive text area;
            receiveTextArea.setText("User: " + remoteUsername + " is connected! You can start the chat conversation");
            //2. Enable send button in order to send a new messages
            sendButton.setEnabled(true);
            //3. deactivate enableServer radio button, User should not be able to change the connection mode after the connection was established.
            // you have to close the connection in order to change the mode.
            enableServer.setEnabled(false);
            //4. deactivate the connect button
            connectButton.setEnabled(false);
            
            readIncomingMessages(); //read all incoming messages
        }
        catch(UnknownHostException e2)
        {
            receiveTextArea.setText("the IP address of the host could not be determined!");
        }
        catch(ConnectException e1)
        {
            receiveTextArea.setText("Server is unreachable!");
        }
        catch(Exception e)
        {
            //if the ip address is not correct please 
            System.out.println("client error!" + e.toString());
            disconnect();
        }
    }
    
    
    public void readIncomingMessages()
    {
        try
        {
            while(true)
            {
                String message = in.readLine(); //read a message from the connection
                String allText = receiveTextArea.getText(); //get all the text 
                allText = allText + "\n" + message; //append the new message
                receiveTextArea.setText(allText); //add all text
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString() + "in readIncomingMessages");
            disconnect(); //if an error occurs, close the connection
        }
    }
    
    public void disconnect()
    {
        try
        {
            String allText = receiveTextArea.getText(); //get all the text 
            allText = allText + "\n" + this.remoteUsername + " has been disconected! \nThe connection is closed."; //info message
            receiveTextArea.setText(allText);
            if(isServer) //if server mode (variable is set in the enableServerActionPerformed server method, when the enableServer radio button is selected)
            {
                /*
                    verify the inputstream is not null. There are some cases when InputStream could be null.
                    Eg: In the server mode if the application is closed when it is waiting for a connection, the accept method will not
                    return a socket object and the inputstream could not be created because we don't have a socket object.]
                    In this case we have a null inputestream object and if we try to close a null inputstream an error is thrown.
                */
                if(in != null) 
                {
                    in.close(); //close the inputstream
                }
                if(out != null)
                {
                    out.close(); //close the outputstream
                }
                if(client != null) 
                {
                    client.close();
                }
                if(server != null)
                {
                    server.close();
                }
                enableServer.setEnabled(true); // enable connection mode button
                enableServer.setSelected(false);
                serverIpAddress.setEditable(true); 
                connectButton.setEnabled(true); 
                sendButton.setEnabled(false); // disable send button
                isServer = false; //no more in the server mode
            }
            if(connectToServer)
            {
                if(in != null)
                {
                    in.close(); //close the inputstream
                }
                if(out != null)
                {
                    out.close(); //close the outputstream
                }
                if(client != null)
                {
                    client.close(); //close the client socket
                }
                enableServer.setEnabled(true);
                enableServer.setSelected(false);
                serverIpAddress.setEditable(true); 
                connectButton.setEnabled(true); 
                sendButton.setEnabled(false);
                connectToServer = false;  //no more in the client mode
            }
        }
        catch(Exception e)
        {
            System.out.println("in disconnect" + e.toString());
        }
    }
    
    private void sleep(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch(Exception e)
        {
            System.exit(1);
        }
    }
        
    private boolean isServer = false; 
    private boolean connectToServer = false;
    private ServerSocket server;
    private Socket client;
    private final int portNumber = 9090;
    private BufferedWriter out;
    private BufferedReader in;
    private String localUsername;
    private String remoteUsername;
    private boolean isClosed = true; //used to close the thread (the application)
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JRadioButton enableServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea receiveTextArea;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea sendTextArea;
    private javax.swing.JTextField serverIpAddress;
    private javax.swing.JTextField usernameTextArea;
    // End of variables declaration//GEN-END:variables
}
