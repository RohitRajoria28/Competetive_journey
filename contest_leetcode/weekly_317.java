class Solution {
 	public class pair{
 		List<Integer> ilist ;
 		int vw ;

 		pair(List<Integer> ilist,int vw){
 			this.ilist=ilist;
 			this.vw=vw;
 		}
 	}
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
     	   
     	   HashMap<String,pair> map=new HashMap<>();
     	   int n=views.length;
        int max=-1;
     	   List<Integer> midx=new ArrayList<>();
     	   for(int i=0;i<n;i++){
     	   	String st=ids[i];
     	   	int vie=views[i];
     	   		 if(map.containsKey(st)){
     	   		 	pair p=map.get(st);
     	   		 	
     	   		 	int cv=p.vw+vie;
     	   		 	List<Integer> clist=p.ilist;
     	   		 	clist.add(i);
     	   		 	map.put(st,new pair(clist,cv));
     	   		 }else{
                     List<Integer> addList=new   ArrayList<>();
                     addList.add(i);
     	   		 	map.put(st,new pair(addList ,vie));
     	   		 }
     	   		max=Math.max(max,map.get(st).vw);
     	   }
     	   List<List<String>> ans=new ArrayList<>();
     	   for(String st: map.keySet()){
     	   	 if(map.get(st).vw==max){
     	   	 	List<String> smallans=new ArrayList<>();

     	   	 	List<String> pos=new ArrayList<>();

     	   	 	pair p=map.get(st);

     	   	 	List<Integer> idxes=p.ilist;

     	   	 	for(int i: idxes){
                    System.out.print(i+" ");
     	   	 		pos.add(ids[i]);
     	   	 	}
                Collections.sort(pos,(a,b)->{
                    return a.compareTo(b);
                } );
     	   	 	smallans.add(st);
     	   	 	smallans.add(pos.get(0));
     	   	 	ans.add(smallans);
     	   	 }
     	   }

     	   return ans;

    }
}


// 

class Solution {
	public class pair{
		String str;
		int num;
		pair(String str, int  num){
			this.str=str;
			this.num=num;
		}
	}
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String ,Integer > map=new HashMap<>();
        HashMap<String, Integer> max_id=new HashMap<>();
        HashMap<String,ArrayList<pair>> stids=new HashMap<>();

        int n=views.length;
        for(int i=0;i<n;i++){
        	String st=creators[i];
        	String ids=id[i];
        	int vw=views[i];
        	if(!map.containsKey(st)) map.put(st,0);
        	if(!max_id.containsKey(ids)) max_id.put(ids,0);
        	if(!stids.containsKey(st))  stids.put(st,new ArrayList<>());

        	map.put(st,map.get(st)+vw);
        	stids.put(st,new pair(ids,vw));
        	max_id(st,Math.max(max_id.get(st),vw));
        }

        int max=-1;
        for(String k: map.keySet()){
        	max=Math.max(map.get(k),max);
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key: map.keySet()){
        	if(map.get(key)==max){
        		Collections.sort(stids,(a,b)->{
        			return a.str.compareTo(b.str);
        		});
        		int maxv=max_id.get(key);
        		for(pair p: stids){
        			if(p.num==maxv){
        				List<String > smallans=new ArrayList<>();
        				smallans.add(key);
        				smallans.add(p.str);

        				ans.add(smallans);
        				break;
        			}
        		}
        	}
        }

        return ans;
    }
}