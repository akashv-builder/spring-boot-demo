package com.example.main.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListService {

	private List<DataList> al = 
			new ArrayList<>(Arrays.asList(new DataList("1", "hey", "ok"), new DataList("2", "hey", "not ok")));
			
	
	public List<DataList>returnList(){
		return al;
	}
	
	public DataList getTopic(String id) {
		return al.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(DataList dl) {
		al.add(dl);
		
	}

	public void updateTopic(DataList dl, String id) {
		for(int i=0;i<al.size();i++) {
			DataList t=al.get(i);
			if(t.getId().equals(id)) {
				al.set(i, dl);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		al.removeIf(t->t.getId().equals(id));
	}
	
}
