package com.uum.projectdownload;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Download implements Runnable {

    AccountList url = new AccountList();
    public String[] link = url.accountlist;
    public String[] name = url.foldername;

    public void klon() throws IOException, GitAPIException {

        String workingDirectory = System.getProperty("user.dir");
        String folder = workingDirectory + File.separator + "STIW3054-A171";
        String absolutePath = "";
        for (int i = 0; i < link.length; i++) {

            absolutePath = folder + File.separator + name[i];
            File localPath = new File(absolutePath);
            System.out.println("Cloning from " + link[i] + " to " + localPath);
            try (Git result = Git.cloneRepository()
                    .setURI(link[i])
                    .setDirectory(localPath)
                    .call()) {
                // Note: the call() returns an opened repository already which needs to be closed to avoid file handle leaks!
                System.out.println("Having repository: " + result.getRepository().getDirectory());
                System.out.print("File path: " + localPath.getAbsolutePath());

            } catch (GitAPIException ex) {
                //ex.printStackTrace();
                //ex.getMessage();

                String folder1 = workingDirectory + File.separator + "LOG";
                PrintStream log = new PrintStream(new File(folder1));
                System.setOut(log);
                log.print(ex);
            }
        }

    }  

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
