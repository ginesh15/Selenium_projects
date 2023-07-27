package Utilities;


import com.twilio.Twilio;
import java.net.URI;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Call;

public class SmsUtil {                 
    private static final String ACCOUNT_SID = "AC6615f55bc279ee2046f60819de1a1a55";
    private static final String AUTH_TOKEN = "1d33e348c5cc36c2aecb6d4af590a73b";
    private static final String TWILIO_PHONE_NUMBER = "+14067408444";
    private static final String Whatsapp_TWILIO_PHONE_NUMBER = "+14155238886";
    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    } 

    public static void sendSMS(String toPhoneNumber, String messageBody) {
        Message message = Message.creator( 
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
                messageBody
        ).create();

        System.out.println("SMS Sent. Message SID: " + message.getSid());
    }
    
    public static void makePhoneCall(String toPhoneNumber, String callMessage) {

          	Call call = Call.creator(
                new com.twilio.type.PhoneNumber(toPhoneNumber),
                new com.twilio.type.PhoneNumber(TWILIO_PHONE_NUMBER),
                URI.create("https://handler.twilio.com/twiml/EH0877ef097a331a27f1611a2f97b161eb"))
            .create();
    
    	System.out.println("Call is outgoing. Call SID: " +call.getSid());
    } 
    
    public static void sendWhatsAppMessage(String toPhoneNumber, String messageBody) {
    	 Message message = Message.creator(
                 new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                 new com.twilio.type.PhoneNumber("whatsapp:" + Whatsapp_TWILIO_PHONE_NUMBER),
    			 messageBody) 
                            .create();

         System.out.println("whatsup msg sent Message SID: "+ message.getSid());
    }
}

