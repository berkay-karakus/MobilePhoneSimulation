
public class Contact {
      private String name;
      private String phoneNumber;
      
      public Contact(String phoneNumber) {
    	  this("Unknown name", phoneNumber);
      }
      
      public Contact(String name, String phoneNumber) {
    	  this.name = name;
    	  setPhoneNumber(phoneNumber);
      }
      
      public static Contact createContact(String phoneNumber) {
    	  return createContact("Unknown name", phoneNumber);
      }
      
      public static Contact createContact(String name, String phoneNumber) {
    	  return new Contact(name, phoneNumber);
      }
      
      public String getName() {
    	  return name;
    	    
      }
      
      public String getPhoneNumber() {
    	  return phoneNumber;
    	    
      }
      
      public void setName(String name) {
    	  this.name = name;
      }
           
      public void setPhoneNumber(String phoneNumber) {
    	if (phoneNumber.length() == 11 && phoneNumber.substring(0, 2).equals("05") )
    		this.phoneNumber = phoneNumber;
      }
}
