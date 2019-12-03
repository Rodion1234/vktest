package ru.markov.vkproject;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.markov.vkproject.database.ConnectionDB;
import ru.markov.vkproject.database.FileReaderDB;
import ru.markov.vkproject.database.FileWriterDB;
import ru.markov.vkproject.database.WorkDB;
import ru.markov.vkproject.entity.User;
import ru.markov.vkproject.vkapi.VKAPI;

public class MainApp {

    public static void main(String[] args) throws ApiException, ClientException {
//        try {
//            WorkDB dB = new WorkDB();
        VKAPI vkapi = new VKAPI();
//        List<User> users1 = vkapi.getMembersExecute("142970331", 0, vkapi.getCountMembers("142970331"));
//        FileWriterDB fileWriterDB = new FileWriterDB("C:\\Users\\User\\Desktop\\VKProject\\VKAPI\\БД\\first try\\friends.csv");
//        fileWriterDB.writeUsers(users1, "142970331");

        FileReaderDB fileReaderDB = new FileReaderDB("C:\\\\Users\\\\User\\\\Desktop\\\\VKProject\\\\VKAPI\\\\БД\\\\first try\\\\friends.csv");
        List<User> users = fileReaderDB.getUsers();
        List<User> friends = vkapi.getFriendsIsMember("140293827", users);
        FileWriterDB fileWriterDB = new FileWriterDB("C:\\Users\\User\\Desktop\\VKProject\\VKAPI\\БД\\first try\\users.csv");
        fileWriterDB.writeFriends(friends);
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
