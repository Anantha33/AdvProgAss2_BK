package BurritoKing_A2;

class UserSingleton 
{
	private static UserSingleton single_instance = null;
	
	private String currentUsername;
	private String currentFName;
	private String currentLName;
	private boolean currentIsVIP;
	private int currentCredits;
	
	public void setCurrentUserDetails(String username, String fName, String lName, boolean vipStatus)
	{
		currentUsername = username;
		currentFName = fName;
		currentLName = lName;
		currentIsVIP = vipStatus;
	}
	
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
	
	public static synchronized UserSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new UserSingleton();
 
        return single_instance;
    }
}
