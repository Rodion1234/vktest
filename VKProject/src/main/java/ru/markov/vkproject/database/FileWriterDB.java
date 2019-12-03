package ru.markov.vkproject.database;

import java.io.File;
import java.util.List;
import ru.markov.vkproject.entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriterDB {

    private File file;

    public FileWriterDB(String fileName) {
        this.file = new File(fileName);
    }

    public void writeUsers(List<User> users, String group) {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(file);

            for (User user : users) {
                nFile.write(user.getId() + "\t" + group + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (nFile != null) {
                    nFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeFriends(List<User> friends) {
        FileWriter nFile = null;
        try {
            nFile = new FileWriter(file);

            for (User user : friends) {
                if (user.getFriendsInComunity() != null) {
                    for (User user1 : user.getFriendsInComunity()) {
                        {
                            if (!user.getFriendsInComunity().isEmpty()) {
                                nFile.write(user.getId() + "\t" + user1.getId() + "\n");
                            }
                        }
                    }

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (nFile != null) {
                    nFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
