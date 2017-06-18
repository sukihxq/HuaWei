package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegPatteern {
	public String regEmail = "^\\w{2,}[.]?(\\w{2,})?{2,}@\\w+[.]((com)|(cn)|(com.cn)|(edu.cn))";
	public String regPhone = "^1[3578]\\d{9}$";
	public Pattern pEmail = Pattern.compile(regEmail);
	public Pattern pPhone = Pattern.compile(regPhone);
	public Matcher mEmail;
	public Matcher mPhone;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new RegPatteern().init();
	}

	public void init() throws Exception {
		String path = "./data/string.data";
		String tarFile = "./data/tarString.data";
		List<String> lines = new ArrayList<>();
		lines = readFile(path);
		lines = checked(lines);
		writeFile(lines, tarFile);
	}

	public List<String> readFile(String path) throws Exception {
		List<String> lines = new ArrayList<>();
		FileReader fReader = new FileReader(path);
		BufferedReader br = new BufferedReader(fReader);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				lines.add(line.trim());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		br.close();
		fReader.close();
		return lines;
	}
	public void writeFile(List<String>  lines,String path) throws Exception {
		FileWriter fileWriter = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		for(String line:lines){
			bw.write(line);
			bw.newLine();
		}
		bw.close();
		fileWriter.close();
		
	}

	public List<String> checked(List<String> lines) {
		List<String> reStrings = new ArrayList<>();
		for(String line:lines){
			if(checkedEmail(line)){
				line+="\t"+"email";
			}else if(checkedPhone(line)){
				line+="\t"+"phone";
			}else{
				line+="\t"+"false";
			}
			reStrings.add(line);
		}
		return reStrings;
	}

	public boolean checkedEmail(String email) {
		mEmail = pEmail.matcher(email);
		return mEmail.matches();
	}

	public boolean checkedPhone(String phone) {
		mPhone = pPhone.matcher(phone);
		return mPhone.matches();
	}

}
