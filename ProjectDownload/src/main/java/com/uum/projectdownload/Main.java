/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;

/**
 *
 * @author Owner
 */
public class Main {
    
    public static void main (String args[]) throws IOException, GitAPIException {
         Download downld = new Download();
         downld.klon();
    
}  
    
}
