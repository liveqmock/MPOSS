package dwz.framework.log.services.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dwz.framework.exception.ObjectDuplicateException;
import dwz.framework.junit.BaseJunitCase;
import dwz.framework.log.User;
import dwz.framework.log.services.UserServiceMgr;

public class UserServiceMgrImplTest extends BaseJunitCase
{
	@Autowired
	private UserServiceMgr userServiceMgr;
	
	public UserServiceMgr getUserServiceMgr()
	{
		return userServiceMgr;
	}

	public void setUserServiceMgr(UserServiceMgr userServiceMgr)
	{
		this.userServiceMgr = userServiceMgr;
	}

	@Test
	public void testGetAcirsUserMapper()
	{
		List<User> users = userServiceMgr.getUsers();
		for (User user : users) {
			System.out.println("Username: "+user.getUserName());
		}
	}

	@Test
	public void testSetAcirsUserMapper()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser()
	{
		User user = this.getUserServiceMgr().createUser("ACIRS-TEST-000001", "ACIRS-TEST-000001");
		try
		{
			this.getUserServiceMgr().addUser(user);
		} catch (ObjectDuplicateException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateUser()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsers()
	{
		fail("Not yet implemented");
	}

}
