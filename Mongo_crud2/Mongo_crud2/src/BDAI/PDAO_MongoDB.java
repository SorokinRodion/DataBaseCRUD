package BDAI;


import com.google.gson.Gson;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;


public class PDAO_MongoDB
{
	public void create(Person p) 
	{
		    DBObject doc = createDBObject(p);
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("Person2");
			DBCollection col = db.getCollection("users");
			col.insert(doc);
			mongo.close();
	}
	public List<Person> read() 
	{
        ArrayList<Person> pp = new ArrayList<Person>();
        MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("Person2");
		DBCollection col = db.getCollection("users");

		DBCursor cursor = col.find();
		System.out.println(cursor.toString());
          Gson gg = new Gson();
		while(cursor.hasNext())
		{
		    Person p = gg.fromJson(String.valueOf(cursor.next()), Person.class);
            pp.add(p);

		}
		mongo.close();
		return pp;

		}
	
	public void update(Person p) 
	{
		DBObject doc = createDBObject(p);

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("Person2");

		DBObject query = BasicDBObjectBuilder.start().add("_id", p._id).get();
		db.getCollection("users").update(query, doc);
		mongo.close();
	}
	
	public void delete(Person p) 
	{
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("Person2");

		DBObject query = BasicDBObjectBuilder.start().add("_id", p._id).get();
		db.getCollection("users").remove(query);
		mongo.close();
	}

	private static DBObject createDBObject(Person user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

		docBuilder.append("_id", user._id);
		docBuilder.append("fname", user.fname);
		docBuilder.append("lname", user.lname);
		docBuilder.append("age", user.age);
		return docBuilder.get();
	}


}
