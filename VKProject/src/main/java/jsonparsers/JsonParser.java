package jsonparsers;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.markov.vkproject.entity.User;

public class JsonParser {

    public int getNumberUser(String json) {

        JSONObject obj = new JSONObject(json);
        int count = obj.getJSONObject("response").getInt("count");

//JSONArray arr = obj.getJSONArray("posts");
//for (int i = 0; i < arr.length(); i++)
//{
//    String post_id = arr.getJSONObject(i).getString("post_id");
//    ......
//}
        return count;
    }

//    public List<User> getMembers(String json) {
//
//        List<User> users = new ArrayList<>();
//
//        JSONObject obj = new JSONObject(json);
//        JSONObject response = obj.getJSONObject("response");
//
//        JSONArray arr = response.getJSONArray("items");
//        for (int i = 0; i < arr.length(); i++) {
//            users.add(new User(arr.getString(i)));
//        }
//
//        return users;
//    }
    public List<User> getMembersExsecute(String response) {

        List<User> users = new ArrayList<>();

        response = response.replace("\"", "");
        String[] user = response.split(",");

        for (int i = 0; i < user.length; i++) {
            users.add(new User(user[i]));
        }

        return users;
    }

//    public List<User> getFriendsIsMemberExsecute(String response, List<User> users, String userId) {
//
//        List<User> friends = new ArrayList<>();
//        JSONObject obj = new JSONObject(response);
//        String[] member = obj.getString("member").split(",");
//        String[] user_id = obj.getString("user_id").split(",");
//        
//        for (int i = 0; i < member.length; i++) {
//            if (member[i].equals("1")) {
//                friends.add(new User(user_id[i]));
//            }
//        }
//        User user = new User();
//        user.setId(userId);
//        user.setFriendsInComunity(friends);
//
//        users.add(user);
//        return users;
//    }

    public boolean getError(String json) {

        if (!json.contains("error")) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean membersOrUserIdIsNull(String json) {

        if (!json.contains("null")) {
            return true;
        } else {
            return false;
        }
    }
}
