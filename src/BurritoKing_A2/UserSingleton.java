package BurritoKing_A2;

class UserSingleton 
{
	private static UserSingleton single_instance = null;
	
	public String currentFName;
	public String currentLName;
	
	public void setCurrentUserDetails(String fName, String lName)
	{
		currentFName = fName;
		currentLName = lName;
	}
	
	public String getCurrentFName()
	{
		return currentFName;
	}
	
	public void setCurrentLName(String lName)
	{
		currentFName = lName;
	}
	
	public String getCurrentLName()
	{
		return currentLName;
	}
	
	public static synchronized UserSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new UserSingleton();
 
        return single_instance;
    }
}
