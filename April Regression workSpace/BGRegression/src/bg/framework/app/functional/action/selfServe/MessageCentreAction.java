package bg.framework.app.functional.action.selfServe;

import bg.framework.app.functional.action.common.HomePageAction;
import bg.framework.app.functional.action.common.LoginAction;
import bg.framework.app.functional.entities.UserProfile;
import bg.framework.app.functional.page.selfServe.MessageCentrePage;

public class MessageCentreAction {
	
	public Object navigateToAdhoc1Message;

	public MessageCentreAction navigateToLogin()
	{
		new HomePageAction().navigateToLogin();
		return this;
	}
	
	public MessageCentreAction logout()
	{
		new AccountOverviewAction().logout();
		return this;
	}
	
	public MessageCentreAction loginUser(UserProfile userProfile)
	{
		new LoginAction().login(userProfile);
		return this;
	}
	
	public MessageCentreAction navigateToMessages()
	{
		new MessageCentrePage().navigateToMessages();
		return this;
	}
	public MessageCentreAction navigateToDefault1Message()
	{
		new MessageCentrePage().navigateToDefault1Message();
		return this;
	}
	public MessageCentreAction navigateToDefault3Message()
	{
		new MessageCentrePage().navigateToDefault3Message();
		return this;
	}
	public MessageCentreAction navigateToDefault2Message()
	{
		new MessageCentrePage().navigateToDefault2Message();
		return this;
	}
	public MessageCentreAction navigateToDelete()
	{
		new MessageCentrePage().navigateToDelete();
		return this;
	}
	public MessageCentreAction chkUnreadMessages(UserProfile userProfile,String accType)
	{
		new MessageCentrePage().chkUnreadMessages(userProfile,accType);
		return this;
	}
	
	public MessageCentreAction readUnreadMessages(UserProfile userProfile,String accType,String MessageType)
	{
		new MessageCentrePage().readUnreadMessages(userProfile,accType,MessageType);
		return this;
	}
	
	public MessageCentreAction deleteMessages(UserProfile userProfile)
	{
		new MessageCentrePage().deleteMessage(userProfile);
		return this;
	}
	

}
