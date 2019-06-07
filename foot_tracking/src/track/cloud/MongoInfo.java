package track.cloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoInfo {
	public String[] MongoInfo1(String userid) {
	//public static void main(String[] args) throws IOException{
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("mostvisit");
		BasicDBObject searchQuery = new BasicDBObject();
		//BasicDBObject findinfo = new BasicDBObject("latitude",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchla = tdbcol.findOne(searchQuery);
		Object la = searchla.get("latitude");
		//ArrayList<String> list = new ArrayList<>();
		String latitude = null;
		if (la instanceof String){
			latitude = (String)la;
	    }
		
		DBObject searchlo = tdbcol.findOne(searchQuery);
		Object lo = searchla.get("longitude");
		String longitude = null;
		if (lo instanceof String){
			longitude = (String)lo;
	    }
		
		String[] location = new String[2];
		location[0] = latitude;
		location[1] = longitude;
		
		//System.out.println(location[0]+" "+location[1]);
		return location;
	}
	
	public ArrayList<String> MongoInfo2(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("foott");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
	
	public ArrayList<String> MongoInfo3(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("RecFriend");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
	
	public ArrayList<String> MongoInfo4(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("RecPlace");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
	
	public ArrayList<String> MongoInfo5(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("hotplace");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
	
	public ArrayList<String> MongoInfo6(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("GoodFriend");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
	
	public ArrayList<String> MongoInfo7(String userid){
		Mongo mongo = new Mongo("localhost", 27017);
		DB tdb = mongo.getDB("test");
		DBCollection tdbcol = tdb.getCollection("friend");
		BasicDBObject searchQuery = new BasicDBObject();
		BasicDBObject findinfo = new BasicDBObject("info",1);
		searchQuery.put("id", userid);
		//DBCursor cursor = tdbcol.find(searchQuery,findinfo);
		DBObject searchinfo = tdbcol.findOne(searchQuery);
		Object info = searchinfo.get("info");
		ArrayList<String> list = new ArrayList<>();
		if (info instanceof ArrayList<?>){
			list = (ArrayList<String>)info;
	    }
		return list;
	}
}
