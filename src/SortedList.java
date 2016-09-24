import java.util.Arrays;
import java.util.Scanner;
public class SortedList {
	public static void main(String[] args) {
		new SortedList().init();
	}
	public void init(){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String [] vals = str.split(",");
		int [] data = toData(vals[0]);
		int k = Integer.parseInt(vals[1]);
		CNode h = createCNode(data);
		h = insertSortedList(h, k);
		h.print();
		scanner.close();
	} 
	public CNode createCNode(int [] nums){
		Arrays.sort(nums);
		if(nums==null||nums.length==0)
			return null;
		CNode head = null;
		if(nums.length>=1){
			head = new CNode(nums[0]);
			head.right = head;
			head.left = head;
		}
		for(int i =1;i<nums.length;i++){
			CNode p = new CNode(nums[i]);
			p.right = head;
			p.left = head.left;
			head.left.right = p;
			head.left = p;
		}
		return head;
	}
	public int [] toData(String values){
		String []strs = values.split("->");
		int [] data = new int[strs.length-1];
		for(int i=0;i<data.length;i++)
			data[i] = Integer.parseInt(strs[i]);
		return data;
	}
	public CNode insertSortedList(CNode start,int k){
		CNode p = start.right;
		while(p!=start){
			if(p.val<k){
				p = p.right;
			}else
				break;
		}
		CNode q = new CNode(k);
		q.right = p;
		q.left = p.right;
		p.left.right = q;
		p.left = q;
		return q;
	}
	static class CNode {
		public int val;
		public CNode left;
		public CNode right;
		public CNode(int x) {
			this.val = x;
		}
		public void print(){
			StringBuffer sb = new StringBuffer();
			if(this!=null){
				sb.append(this.val+"->");
			}
			CNode p =this.right;
			while(p!=this){
				sb.append(p.val+"->");
				p = p.right;
			}
			sb.append("^");
			System.out.println(sb);
		}
	}
}
