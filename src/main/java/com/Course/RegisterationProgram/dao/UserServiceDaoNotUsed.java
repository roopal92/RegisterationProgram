package com.Course.RegisterationProgram.dao;
/*package com.Course.RegisterationProgram.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Course.RegisterationProgram.entity.User;
//This is not required bcz we are using SpringData
@Component
public class UserServiceDao {

	private static int userCount = 3;
	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Adam", "23"));
		users.add(new User(2, "Eve", "qew"));
		users.add(new User(3, "Rahul", "wqe"));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User deleteById(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
*/