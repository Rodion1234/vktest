package ru.markov.vkproject.database;

import java.io.BufferedWriter;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void writeUsers(List<User> users, String group) {
        FileWriter nFile = null;
        BufferedWriter bufferWriter = null;
        try {
            nFile = new FileWriter(file,true);
            bufferWriter = new BufferedWriter(nFile);
            for (User user : users) {
                bufferWriter.write(user.getId() + "\t" + group + "\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
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
        BufferedWriter bufferWriter = null;
        try {
            nFile = new FileWriter(file,true);
            bufferWriter = new BufferedWriter(nFile);
            for (User user : friends) {
                if (user.getUsers() != null) {
                    for (Integer user1 : user.getUsers()) {
                        {
                            if (!user.getUsers().isEmpty()) {
                                bufferWriter.write(user.getId() + "\t" + user1 + "\n");
                            }
                        }
                    }

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bufferWriter != null) {
                    bufferWriter.close();
                }
                if (nFile != null) {
                    nFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileWriterDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
