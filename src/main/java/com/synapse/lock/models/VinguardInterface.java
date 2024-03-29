/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.synapse.lock.models;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.synapse.lock.payload.GenericPayload;

/**
 *
 * @author Kabugi
 */
public class VinguardInterface {
    
   public interface vinguardDLL extends Library {
        vinguardDLL INSTANCE = (vinguardDLL) Native.loadLibrary(
            (Platform.isWindows() ? "win32-x86-64pmsif.dll" : "simpleDLLLinuxPort"), vinguardDLL.class);
        
          int PMSifRegister(String license ,String appName);
          void PMSifEncodeKcdLcl(String commandCode,String pmsData,boolean debugMode,String user,String userFirstName,String userLastName);
          boolean PMSifShutdownVision();
       
   }  
   
   public static void main(String[] args)
   {
        vinguardDLL vDLL = vinguardDLL.INSTANCE;
       boolean checkin = true;
       
       if(checkin)
       {
      
       
        GenericPayload payLoadSample = new GenericPayload();
        payLoadSample.setRoom_Name("101");
        payLoadSample.setRoom_List("101");
        payLoadSample.setUser_Type("SingleStandard");
        payLoadSample.setUser_Group("RegularGuest");
        payLoadSample.setCheck_In_time("");
        payLoadSample.setCheck_Out_Time("");
        payLoadSample.setFamily_Name("Matu");
        payLoadSample.setFirst_Name("ZACHARY");
        payLoadSample.setpMS_ID("121212");
        payLoadSample.setCheck_In_time("201804301000");
         payLoadSample.setCheck_Out_Time("201805061100");
        
       
        String data = getPayloadToSend(payLoadSample);
        
        System.out.println("Encode Data >> " + data);
        
        StringByReference byReference = new StringByReference(data);
        System.out.println("Reeference >> " + byReference.getValue());
        
        vDLL.PMSifEncodeKcdLcl("I", byReference.getValue(), true, "zkmatu", "Zachary", "Matu");
       }
       else{
           boolean shutdownsTatus = true;
            System.out.println("Shutting down >> ");
            shutdownsTatus = vDLL.PMSifShutdownVision();
           System.out.println("sTATUS SHUT down >> " +shutdownsTatus);
       }
       
       
   }
   
   public static String getPayloadToSend(GenericPayload thisPayload) {
        String payload = "*";
        String fieldSeparator = "*";

        if (thisPayload.room_Name != null && !thisPayload.room_Name.equals("string")  && thisPayload.room_Name.length() > 0) {
            payload += "R" + thisPayload.room_Name + fieldSeparator;
        }
        if (thisPayload.room_List != null && !thisPayload.room_List.equals("string") && thisPayload.room_List.length() > 0) {
            payload += "L" + thisPayload.room_List + fieldSeparator;
        }
        if (thisPayload.user_Type != null && !thisPayload.user_Type.equals("string") && thisPayload.user_Type.length() > 0) {
            payload += "T" + thisPayload.user_Type + fieldSeparator;
        }
        if (thisPayload.user_Group != null && !thisPayload.user_Group.equals("string") && thisPayload.user_Group.length() > 0) {
            payload += "U" + thisPayload.user_Group + fieldSeparator;
        }
        if (thisPayload.first_Name != null && !thisPayload.first_Name.equals("string") && thisPayload.first_Name.length() > 0) {
            payload += "F" + thisPayload.first_Name + fieldSeparator;
        }
        if (thisPayload.family_Name != null && !thisPayload.family_Name.equals("string") && thisPayload.family_Name.length() > 0) {
            payload += "N" + thisPayload.family_Name + fieldSeparator;
        }
        if (thisPayload.access_Points != null && !thisPayload.access_Points.equals("string") && thisPayload.access_Points.length() > 0) {
            payload += "A" + thisPayload.access_Points + fieldSeparator;
        }
        if (thisPayload.card_Copy != null && !thisPayload.card_Copy.equals("string") && thisPayload.card_Copy.length() > 0) {
            payload += "C" + thisPayload.card_Copy + fieldSeparator;
        }
        if (thisPayload.pMS_ID != null && !thisPayload.pMS_ID.equals("string") && thisPayload.pMS_ID.length() > 0) {
            payload += "P" + thisPayload.pMS_ID + fieldSeparator;
        }
        if (thisPayload.track_1_data != null && !thisPayload.track_1_data.equals("string") && thisPayload.track_1_data.length() > 0) {
            payload += "1" + thisPayload.track_1_data + fieldSeparator;
        }
        if (thisPayload.track_2_data != null && !thisPayload.track_2_data.equals("string") && thisPayload.track_2_data.length() > 0) {
            payload += "2" + thisPayload.track_2_data + fieldSeparator;
        }
        if (thisPayload.track_3_data != null && !thisPayload.track_3_data.equals("string") && thisPayload.track_3_data.length() > 0) {
            payload += "3" + thisPayload.track_3_data + fieldSeparator;
        }
        if (thisPayload.print_Information != null && !thisPayload.print_Information.equals("string") && thisPayload.print_Information.length() > 0) {
            payload += "I" + thisPayload.print_Information + fieldSeparator;
        }
        if (thisPayload.generic_Field != null && !thisPayload.generic_Field.equals("string") && thisPayload.generic_Field.length() > 0) {
            payload += "?" + thisPayload.generic_Field + fieldSeparator;
        }
        if (thisPayload.database != null && !thisPayload.database.equals("string") && thisPayload.database.length() > 0) {
            payload += "B" + thisPayload.database + fieldSeparator;
        }
        if (thisPayload.rFID_card_sub_type != null && !thisPayload.rFID_card_sub_type.equals("string") && thisPayload.rFID_card_sub_type.length() > 0) {
            payload += "J" + thisPayload.rFID_card_sub_type + fieldSeparator;
        }
        if (thisPayload.card_Serial_Number != null && !thisPayload.card_Serial_Number.equals("string") && thisPayload.card_Serial_Number.length() > 0) {
            payload += "S" + thisPayload.card_Serial_Number + fieldSeparator;
        }
        if (thisPayload.vingCard_Code != null && !thisPayload.vingCard_Code.equals("string") && thisPayload.vingCard_Code.length() > 0) {
            payload += "V" + thisPayload.vingCard_Code + fieldSeparator;
        }
        if (thisPayload.check_In_time != null && !thisPayload.check_In_time.equals("string") && thisPayload.check_In_time.length() > 0) {
            payload += "D" + thisPayload.check_In_time + fieldSeparator;
        }
        if (thisPayload.check_Out_Time != null && !thisPayload.check_Out_Time.equals("string") && thisPayload.check_Out_Time.length() > 0) {
            payload += "O" + thisPayload.check_Out_Time + fieldSeparator;
        }
       
        return payload.substring(0, payload.length() - 1);
    }

}
