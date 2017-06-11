package test;
import java.util.*;
public class Main42{
    public static void main(String []args){
        new Main42().init();
    }
	public void init() {
		/*Scanner input = new Scanner(System.in);
		List<String> lines = new ArrayList<>();
		while(input.hasNext()){
			String str = input.nextLine();
			if(check(str))
				lines.add(str);
			else
				break;
		}
		fun(lines);
		input.close();*/
		int x=2;
		switch(x){
		case 1:System.out.println(1);
		case 2:
		case 3:System.out.println(3);
		case 4:System.out.println(4);
		}
	}
    public void fun(List<String> lines){
    	if(lines==null||lines.size()==0){
    		return ;
    	}
    	int[][] dateRangePrices = new int[lines.size()][3];
    	for(int i=0;i<lines.size();i++){
    		String line = lines.get(i);
    		String [] chs = line.split(" ");
    		for(int j=0;j<3;j++){
    			dateRangePrices[i][j] = Integer.parseInt(chs[j]);
    		}
    	}
    	
    	int [][] res = merge(dateRangePrices);
    	if(res==null||res.length==0){
    		return;
    	}
    	StringBuffer sb = new StringBuffer();
    	for(int [] tep:res){
    		sb.append(",["+tep[0]+","+tep[1]+","+tep[2]+"]");
    	}
    	String resString = sb.toString().substring(1);
    	System.out.println(resString);
	}
    public int[][] merge(int[][] dateRangePrices){
    	if(dateRangePrices==null){
    		return null;
    	}
    	if(dateRangePrices.length==1){
    		return dateRangePrices;
    	}
    	//combine the same value
    	List<int[]>resSameDate = new ArrayList<>();
    	int start = dateRangePrices[0][0];
    	int end = dateRangePrices[0][1];
    	int value = dateRangePrices[0][2];
    	for(int i=0;i<dateRangePrices.length;i++){
    		if(value==dateRangePrices[i][2]){
    			if(dateRangePrices[i][0]<=end+1){
        			end  = Math.max(end, dateRangePrices[i][1]);
        		}else{
        			resSameDate.add(new int[]{start,end,value});
	                start = dateRangePrices[i][0];
	                end = dateRangePrices[i][1];
        		}
    		}else{
    			resSameDate.add(new int[]{start,end,value});
    			start = dateRangePrices[i][0];
                end = dateRangePrices[i][1];
                value = dateRangePrices[i][2];
                if(i==dateRangePrices.length-1){
                	resSameDate.add(new int[]{start,end,value});
                }
    		}
    		
    	}
    	
    	/*for(int [] tt:resSameDate){
    		for(int t1:tt){
    			System.out.print(t1+" ");
    		}
    		System.out.println();
    	}*/
    	
    	
    	//delete different value
    	int size = 0;
    	int [] date = resSameDate.get(0);
    	List<int[]>r = new ArrayList<>();
    	for(int i=0;i<resSameDate.size();i++){
    		int [] t3 = resSameDate.get(i);
    		if(t3[2]==date[2]){
    			r.add(t3);
    			date = t3;
    		}else{
    			if(date[1]<t3[1]-1){
    				r.add(new int[]{date[0],t3[0]-1,date[2]});
    				if(t3[1]<date[1]-1){
    					r.add(t3);
    					r.add(new int[]{t3[1]+1,date[1],date[2]});
    				}
    			}else{
    				r.add(new int[]{date[0],t3[1],t3[2]});
    			}
    		}
    		
    		
    		
    	}
    	
    	
    	int [][] result = new int[resSameDate.size()][3];
    	for(int i=0;i<resSameDate.size();i++){
    		int [] t2 = resSameDate.get(i);
    		for(int j=0;j<3;j++){
    			result[i][j] = t2[j];
    		}
    	}
    	
    	return result;
    }
    
    public boolean check(String value){
    	value = value.replace(" ", "");
    	try{
    		Long.parseLong(value);
    		return true;
    	}catch (Exception e) {
    		return false;
		}
    }
}