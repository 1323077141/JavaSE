package com.authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    private static Map<String,User> users ;

    static {
        users = new HashMap<>();
        List<Authority> authorities= new ArrayList<>();
        authorities.add(new Authority("Article-1","/authority/article-1.jsp"));
        authorities.add(new Authority("Article-2","/authority/article-2.jsp"));
        User user1 = new User("AAA",authorities);
        users.put("AAA",user1);

        authorities= new ArrayList<>();
        authorities.add(new Authority("Article-3","/authority/article-3.jsp"));
        authorities.add(new Authority("Article-4","/authority/article-4.jsp"));
        user1 = new User("BBB",authorities);
        users.put("BBB",user1);


    }

    User get(String username){
        return users.get("username");
    }

    /**
     * 修改用户信息
     * @param username
     * @param authorities
     */
    void update(String username, List<Authority> authorities){
        users.get(username).setAuthorities(authorities);

    }

}
