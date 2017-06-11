package test;

public class Main56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 0;
		int size = 100000000;
		while (true) {
			i++;
			if (i % size == 0)
				System.out.println("test= " + i / size);
			if (i >= Long.MAX_VALUE - 1)
				i = 0;

		}
	}

}
