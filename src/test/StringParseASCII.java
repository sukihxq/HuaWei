package test;

public class StringParseASCII {
/*
  程序实现目标： 输入一个字符串，将其各个字符对应的ASCII值加5后，输出结果。 
  程序要求：该字符串只包含小写字母，若其值加5后的字符值大于'z',将其转换成从a开始的字符。 
 */
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		
		StringParseASCII spa=new StringParseASCII();
		String str = "abcdxyz";
//		spa.stringParseASCII(str);
		System.out.print(stringParseASCII(str));

	}
	public static  String stringParseASCII(String str){
		StringBuffer s=new StringBuffer();
		char tmp;
		for(int i=0;i<str.length();i++){
			tmp = (char)(str.charAt(i)+5);
			if(tmp>'z'){
//				s.append('a');
				char c = (char) (tmp - 'z'+'a' -1);
				s.append(c);
			}
			else{
				s.append(tmp);
			}
		}
		return s.toString();
	}
}
