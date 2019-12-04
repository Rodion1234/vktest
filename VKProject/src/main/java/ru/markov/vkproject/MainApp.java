package ru.markov.vkproject;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.util.ArrayList;

import java.util.List;
import ru.markov.vkproject.database.FileReaderDB;
import ru.markov.vkproject.database.FileWriterDB;
import ru.markov.vkproject.entity.User;
import ru.markov.vkproject.vkapi.VKAPI;

public class MainApp {

    public static void main(String[] args) throws ApiException, ClientException {
//        try {
//            WorkDB dB = new WorkDB();
        VKAPI vkapi = new VKAPI();
        FileWriterDB fileWriterDB = new FileWriterDB("C:\\Users\\rodion\\Desktop\\vk home\\vktest\\БД\\first try\\friends.csv");

        List<User> users1 = vkapi.getMembersExecute("142989213", 0, vkapi.getCountMembers("142989213"));
        fileWriterDB.writeUsers(users1, "142989213");

        List<User> users2 = vkapi.getMembersExecute("140293827", 0, vkapi.getCountMembers("140293827"));
        fileWriterDB.writeUsers(users2, "140293827");

        List<User> users3 = vkapi.getMembersExecute("142970331", 0, vkapi.getCountMembers("142970331"));
        fileWriterDB.writeUsers(users3, "142970331");

        List<User> allUsers = new ArrayList<>();
        allUsers.addAll(users1);
        allUsers.addAll(users2);
        allUsers.addAll(users3);
        
        List<User> friends = vkapi.getFriends(allUsers);
        List<User> userfriends = vkapi.getFriendsIsMember(allUsers, friends);
        fileWriterDB.writeFriends(userfriends);
//        List<Integer> list = vkapi.getFriends(232964357);
//        
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
//            int i = 0;
//            i = dB.setEmployFriends(user, "142989213", i);
//142989213
//140293827
//142970331
//            List<User> users = vkapi.getFriendsIsMember("36528739", user);
//
//            dB.setEmployFriends(users, "36528739", i);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
