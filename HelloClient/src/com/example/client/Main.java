package com.example.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Main {
	

	public static void main(String[] args) throws Exception{
		System.out.println("Post Test");
        User u = new User();
        u.setfName("Gene");
        u.setlName("Moore");
        u.setTitle("SWE");
        //JSONBuilder jb = new JSONBuilder();


         URL url = new URL("http://localhost:8080/HelloServlet/HelloServlet");
         URLConnection conn = url.openConnection();
         conn.setDoOutput(true);
         OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
         
         //(Dependency) Use the google gson parser located here: https://github.com/google/gson
         Gson gson = new Gson();
         String json = gson.toJson(u);  

         writer.write(json);
         writer.flush();
         System.out.println("posted to server: " + json);

         //read the post back
         String line;
         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
              System.out.println("recieved from server: " + line);
            }
         writer.close();
         reader.close();

	}
	

}


