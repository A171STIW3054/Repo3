/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

/**
 *
 * @author Owner
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Filter {

    public String[] listJavaFile;

    public Filter() {
        Collection<File> all = new ArrayList<>();
        //addTree(new File("C:\\Users\\Badrul\\Documents\\NetBeansProjects\\Assignment1\\test"), all);
        addTree(new File(System.getProperty("user.dir") + File.separator + "STIW3054-A171"), all);
        //System.out.println(System.getProperty("user.dir") + File.separator + "test");
        //Change File Directory Here
        Collection<File> a = all;
        listJavaFile = filterJava(a);
    }

    static void addTree(File file, Collection<File> all) {
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                all.add(child);
                addTree(child, all);
            }
        }
    }

    static String[] filterJava(Collection<File> listAllFileName) {
        LinkedList<String> fb = new LinkedList();
        Iterator<File> a = listAllFileName.iterator();
        File c;
        while (a.hasNext()) {
            c = a.next();
            if (c.getName().endsWith(".java")) {
                fb.add(c.getAbsolutePath());
            }
        }
        String[] listJavaFile = new String[fb.size()];
        for (int i = 0; i < fb.size(); i++) {
            listJavaFile[i] = fb.get(i);
            System.out.println(listJavaFile[i]);
        }
        //System.out.println(listJavaFile.toString());
        return listJavaFile;
    }

}
