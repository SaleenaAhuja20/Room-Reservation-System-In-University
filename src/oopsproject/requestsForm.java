/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oopsproject;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fahad
 */
public class requestsForm extends javax.swing.JFrame {

       ArrayList<Room> allRooms = new ArrayList<Room>(); // Create an ArrayList object
       ArrayList<MakeUpClassRequest> requests = new ArrayList<MakeUpClassRequest>(); // Create an ArrayList object
       
      public requestsForm() {

       
        initComponents();
        
        Database db = new Database();
        // fetch the all rooms from the table
        String queryRooms  = "select * from Room";
        java.sql.ResultSet resultSetRooms = db.fetchData(queryRooms);
        
        ArrayList<String> rooms = new ArrayList<String>(); // Create an ArrayList object

     

         int roomIndex = 0;
         try {
         
           while (resultSetRooms.next()) {
            
            int roomId = resultSetRooms.getInt("roomId");
            int RoomNo =  resultSetRooms.getInt("RoomNo");
            int Capacity = resultSetRooms.getInt("Capacity");
            String BuildingName = resultSetRooms.getString("BuildingName");
            rooms.add(String.valueOf(RoomNo));
            
            Room room = new Room();
            room.roomId = roomId;
            room.roomNumber = RoomNo;
            room.capacity = Capacity;
            room.buildName = BuildingName;
            allRooms.add(room);
            
             this.jComboBoxRooms.addItem(String.valueOf(RoomNo));
                 
         }
         }  catch (Exception ex) {
                System.out.println(ex);
         }
        
        this.loadRequests();
        
   
    }
       
     public void loadRequests(){
         
         
              // load schedule data
        
         // Column names
        String[] columnNames = {"TeacherName", "Course", "Section", "Day", "Capacity", "Status"};
        
      
        Database db = new Database();
        String query  = "SELECT * FROM teacher";
        
        // this is one teacher r
        
        java.sql.ResultSet resultSet = db.fetchData(query);
        HashMap<Integer, String> teacherRecords = new HashMap<Integer, String>();

        
        
         //String query = "select * from TimeTable where emailAddress  = '"+ emailAddress +"'";
        String requestFormQuery  = "select * from makeupform where request_status = 'Pending'";
       
         int index = 0;
         try {
         
           while (resultSet.next()) {            
                int teacherId = resultSet.getInt("Teacher_id");
                String teacherName = resultSet.getString("Teacher_Name");
                teacherRecords.put(teacherId,teacherName);
                index++;                 
            }
         }  catch (Exception ex) {
                System.out.println(ex);
         }
       
        
        java.sql.ResultSet resutlSetMakeUpForm = db.fetchData(requestFormQuery);
        
        
        
          // Data for the table
          
        Object[][] data = new Object[15][6];
        
        int i = 0;
         try {
         
           while (resutlSetMakeUpForm.next()) {
            
            int id = resutlSetMakeUpForm.getInt("Id");
            int teacherId = resutlSetMakeUpForm.getInt("TeacherId");
            String teacherName = teacherRecords.get(teacherId);
 
            String course = resutlSetMakeUpForm.getString("Course");
            String section = resutlSetMakeUpForm.getString("section");
            String day = resutlSetMakeUpForm.getString("day");
            String slot = resutlSetMakeUpForm.getString("slot");
            int capacity_of_students = resutlSetMakeUpForm.getInt("capacity_of_students");
            String request_status = resutlSetMakeUpForm.getString("request_status");
            
            MakeUpClassRequest request = new MakeUpClassRequest();
            request.Id = id;
            request.teacherId = teacherId;
            request.capacity = capacity_of_students;
            request.request_status = request_status;
            request.section =  section;
            request.slot =  slot;
            request.Course = course;
            request.day = day;
            this.requests.add(request);
      

            data[i][0] = teacherName;
            data[i][1] = course;
            data[i][2] = section;
            data[i][3] = day;
            data[i][4] = capacity_of_students;
            data[i][5] = request_status;
            i++;
                 
         }
         }  catch (Exception ex) {
                System.out.println(ex);
         }
       
        DefaultTableModel dataModel = new DefaultTableModel(data, columnNames);

        
       
      
        
       
      
        this.jTable1.setModel(dataModel);
         
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
        jTable1 = new javax.swing.JTable();
        roomRequestApproveBtn = new javax.swing.JButton();
        jComboBoxRooms = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TeacherName", "Course", "Section", "Day", "Capacity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        roomRequestApproveBtn.setText("Assign Room");
        roomRequestApproveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomRequestApproveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jComboBoxRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roomRequestApproveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomRequestApproveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomRequestApproveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomRequestApproveBtnActionPerformed
       
        try {
        
        int selectedRequestIndex = this.jTable1.getSelectedRow();
       int selectedRoomIndex = this.jComboBoxRooms.getSelectedIndex();
       
       if (selectedRequestIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select the request");
       }
       
         if (selectedRoomIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select the room");
         }
         
         int roomNo =  this.allRooms.get(selectedRoomIndex).roomNumber;
         int selectedRoomId  = this.allRooms.get(selectedRoomIndex).roomId;
         
         int startTime = Integer.parseInt(this.requests.get(selectedRequestIndex).slot.split("-")[0].trim());
         int endTime = Integer.parseInt(this.requests.get(selectedRequestIndex).slot.split("-")[1].trim());
         int room_capacity = this.allRooms.get(selectedRoomIndex).capacity;
     
        
       
         if (room_capacity < this.requests.get(selectedRequestIndex).capacity ){
              JOptionPane.showMessageDialog(this, "Selected Room Capacity is less than required capacity");
         }
         
        // check if the room is available on the given day
        // fetch the all rooms from the table
        Database db = new Database();
        String queryRooms  = "select * from RoomBooking where roomId =" + selectedRoomId;
        java.sql.ResultSet roomBookingResultSet = db.fetchData(queryRooms);
        boolean roomAvailable = true;
        
      
         int roomIndex = 0;
         try {
         
           while (roomBookingResultSet.next()) {
            
            int _roomId = roomBookingResultSet.getInt("roomId");
            String slot =  roomBookingResultSet.getString("slot");
            String day = roomBookingResultSet.getString("day");
         
           if (day.equals(this.requests.get(selectedRequestIndex).day)){
                int startTimeBooking = Integer.parseInt(slot.split("-")[0].trim());
                int endTimeBooking = Integer.parseInt(slot.split("-")[1].trim());
                
                if (startTime >= startTimeBooking && startTime <= endTimeBooking  ){
                      JOptionPane.showMessageDialog(this, "Room already booked not available");
                      roomAvailable = false;
                      break;
                }
                
                  if (endTime >= startTimeBooking && endTime <= endTimeBooking  ){
                      JOptionPane.showMessageDialog(this, "Room already booked not available");
                      roomAvailable = false;
                      break;
                }
           }
         // update the request status
                 
         }
         }  catch (Exception ex) {
                System.out.println(ex);
         }
         
                // room is avialble then add the entry in the room booking
         if (roomAvailable == true){
             
         // update the record in the room booking
        String sql = "INSERT INTO RoomBooking (teacherId, roomId,slot ,day) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = db.prepareStatement(sql)) {
            statement.setInt(1, this.requests.get(selectedRequestIndex).teacherId);
            statement.setInt(2, this.allRooms.get(selectedRoomIndex).roomId);
            statement.setString(3, this.requests.get(selectedRequestIndex).slot);
            statement.setString(4, this.requests.get(selectedRequestIndex).day);

            statement.executeUpdate();
           
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
          
        
     
             
         // update the teacher schdule
        sql = "INSERT INTO schedule (Teacher_id, Teacher_Name,Day, Slot, Room, Section) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = db.prepareStatement(sql)) {
            statement.setInt(1, this.requests.get(selectedRequestIndex).teacherId);
            statement.setString(2, " ");
            statement.setString(3, this.requests.get(selectedRequestIndex).day);
            statement.setString(4, this.requests.get(selectedRequestIndex).slot);
            statement.setInt(5, this.allRooms.get(selectedRoomIndex).roomNumber);
            statement.setString(6, this.requests.get(selectedRequestIndex).section);

            statement.executeUpdate();
          
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        // update the request status
        sql = "update makeupform set request_status = 'Completed' where Id =" +  this.requests.get(selectedRequestIndex).Id;

        try (PreparedStatement statement = db.prepareStatement(sql)) {
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Request has been updated successfully");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
     }  
      this.loadRequests();
        }
        catch(Exception ex){
             JOptionPane.showMessageDialog(this, "Please select the room");
        }
       
         
       
       
    }//GEN-LAST:event_roomRequestApproveBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(requestsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(requestsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(requestsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(requestsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new requestsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxRooms;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton roomRequestApproveBtn;
    // End of variables declaration//GEN-END:variables
}
