package com.uum.projectdownload;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Download implements Runnable {

    
    AccountList url = new AccountList();
    public String[] link = url.accountlist;
    public String[] name = url.foldername;

    public void klon() throws IOException, GitAPIException {
        // prepare a new folder for the cloned repository
        
        String workingDirectory = System.getProperty("user.dir");
        String folder = workingDirectory + File.separator + "STIW3054-A171";
        String absolutePath = "";
        for(int i = 0; i < link.length; i++) {
            
             absolutePath = folder + File.separator + name[i];
             File localPath = new File(absolutePath);
            //File localPath = File.createTempFile(name[i], new File("C:\\Users\\Owner\\Desktop\\STIW3054-A171"));
            //if (!localPath.delete()) {
              //  throw new IOException("Could not delete temporary file " + localPath);
            //}

            // then clonefor(int i = 0; i < link. 
            System.out.println("Cloning from " + link + " to " + localPath);
            try (Git result = Git.cloneRepository()
                    .setURI(link[i])
                    .setDirectory(localPath)
                    .call()) {
                // Note: the call() returns an opened repository already which needs to be closed to avoid file handle leaks!
                System.out.println("Having repository: " + result.getRepository().getDirectory());
                System.out.print("File path: " + localPath.getAbsolutePath());
            }
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
