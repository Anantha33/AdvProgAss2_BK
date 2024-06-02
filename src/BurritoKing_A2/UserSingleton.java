package BurritoKing_A2;


//Singleton class to store all the data of the current user
class UserSingleton 
{
	private static UserSingleton single_instance = null;
	
	private String currentUsername;
	private String currentFName;
	private String currentLName;
	private boolean currentIsVIP;
	private double currentCredits;
	
	//Setter method to set attributes
	public void setCurrentUserDetails(String username, String fName, String lName, boolean vipStatus, double credits)
	{
		currentUsername = username;
		currentFName = fName;
		currentLName = lName;
		currentIsVIP = vipStatus;
		currentCredits = credits;
	}
	
	//Getter methods to get all the attributes of the user
	
	public String getCurrentUsername()
	{
		return currentUsername;
	}
	
	public String getCurrentFName()
	{
		return currentFName;
	}
	
	public String getCurrentLName()
	{
		return currentLName;
	}
	
	public boolean getCurrentVIPStatus()
	{
		return currentIsVIP;
	}
	
	public double getCurrentCredits()
	{
		return currentCredits;
	}
	
	//Checking if the class has only one instance
	public static synchronized UserSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new UserSingleton();
 
        return single_instance;
    }
}
