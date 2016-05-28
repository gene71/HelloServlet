package com.example.dataaccess;

public class Main {

	public static void main(String[] args) {
		Daobject dao;
		try {
			dao = new Daobject();
			for(int i = 0; i < dao.getAllUsers().size(); i++){
				System.out.println(dao.getAllUsers().get(i).toString());
			}
			for(int k = 0; k < dao.getAllMax("gene moore", "bench press").size(); k++){
				System.out.println(dao.getAllMax("gene moore", "bench press").get(k).getWeight() + "," +
						dao.getAllMax("gene moore", "bench press").get(k).getLastupdate());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
