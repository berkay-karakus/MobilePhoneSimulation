import java.util.ArrayList;

public class MobilePhone {
	   private String phoneNumber;
	   private ArrayList<Contact> myContacts; 
	   
	public MobilePhone(String phoneNumber) {
		setPhoneNumber(phoneNumber);
		myContacts = new ArrayList<Contact>();
	}

	public static void options() {
		System.out.println("1: Quit\n"
				          +"2: Print list of contacts\n"
				          +"3: Add new contact\n"
				          +"4: Update existing contact\n"
				          +"5: Remove contact\n"
				          +"6: Search/find contact");
	} // end of options              
	 
	public boolean addContact(String phoneNumber) {
		if (isExist(phoneNumber))
			return false;
		addContact("Unknown name", phoneNumber);
		return true;
    	} // end of addContact
	
    public boolean addContact(String name, String phoneNumber) {
    	if(isExist(name))
    		return false;
    	myContacts.add(Contact.createContact(name, phoneNumber));
    	return true;
	} // end of addContact
    
    public boolean deleteContact(String name) {
    	if (!isExist(name))
    		return false;
    		myContacts.remove(findContact(name));
    		return true;
    } // end of deleteContact
    
        
    public boolean updateContactName() {
    	System.out.print("Enter contact name that will be updated: ");
    	String oldName = new java.util.Scanner(System.in).nextLine();
    	
    	  if (!isExist(oldName)) 
    		  return false;
    	  System.out.print("Enter new name for " + oldName + ": ");
    	  String newName = new java.util.Scanner(System.in).nextLine();
    	      findContact(oldName).setName(newName);
    	 return true;
    } //end of updateContactName
    
    public boolean updateContactNumber() {
    	System.out.print("Enter contact name for updating his/her number: ");
    	String oldName = new java.util.Scanner(System.in).nextLine();
  	  if (!isExist(oldName)) 
  		  return false;
  	  System.out.print("Enter new number for " + oldName + ": ");
  	  String newPhoneNumber = new java.util.Scanner(System.in).nextLine();
  	      findContact(oldName).setPhoneNumber(newPhoneNumber);
  	      return true;
  } // end of updateContactNumber
    
    private Contact findContact(String name) {
    	
    	for (int i = 0; i < myContacts.size(); i++) {
    		if (name.equalsIgnoreCase(myContacts.get(i).getName()))
    	            return myContacts.get(i);	
         	}
    	return null;
    }
    
    	
    private boolean isExist(String name) {
            
    	 for (int i = 0; i < myContacts.size(); i++) {
    		   if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
    				return true;
    	    	}
        }
    	 return false;
    } // end of isExist
    
   private boolean isExistByPhoneNumber(String phoneNumber) {
	   for (int i = 0; i < myContacts.size(); i++) {
  		 
  		 if (myContacts.get(i).getPhoneNumber().equals(phoneNumber)) {
  				return true;
  	    	}
      }
  	 return false;
   } // end of isExistByPhoneNumber
    
    private boolean isExist(Contact o) {
    	return myContacts.contains(o);
    } 
    
    public void showContacts() {
    	for (int i = 0; i < myContacts.size(); i++) {
    		System.out.println(myContacts.get(i).getName() + "\t" + myContacts.get(i).getPhoneNumber());
    	}
    } // end of showContacts
    
    public String getPhoneNumber(){
    	return phoneNumber;
    }
    
    private void setPhoneNumber(String phoneNumber) {
    	if (phoneNumber.length() == 11 && phoneNumber.substring(0, 2).equals("05") )
    		this.phoneNumber = phoneNumber;
      }
    
    
}
