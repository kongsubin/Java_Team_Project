
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/* 한 게임이 끝나고 점수를 파일에 저장하기까지의 루틴 (게임 끝날때마다 반복)
 * 1. read_score() 함수를 호출하여 기존 파일에 있던 내용들을 리스트에 저장
 * 2. store_list() 함수를 호출하여 새로운 점수를 리스트에 저장
 * 3. arrage_score() 함수를 호출하여 점수가 들어있는 리스트를 내림차순으로 정렬
 * 4. store_score() 함수를 통해 리스트에 있는 점수들을 파일에 저장
 */
public class manage_data {
	private String fileName;
	private PrintWriter outputStream;
	private Scanner inputStream;
	private int[] score_list = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	private int index;
	
	
	public manage_data() { // Constructor
		fileName = "score.txt";
		outputStream = null;
		inputStream = null;
		index = 0;
		
	}
	
	public void store_list(int score) { // 리스트에 점수 저장 최대 10개
		
		if(index < 10) {
			score_list[index] = score;
			index++;
		}
		else {
			if(score_list[9] < score) {
				score_list[9] = score;
			}
		}
	}
	
	
	public void store_score() { // 파일에 점수 저장
		int i;
		String grade;
		
		try {
			outputStream = new PrintWriter(fileName);
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
		}
		
		for(i = 0; i < 10 && score_list[i] != -1; i++) {
			grade = get_grade(score_list[i]);
			outputStream.println(i+1+"                    "+grade+"                    "+score_list[i]);
		}
		outputStream.close();
	}
	
	public void read_score( ) { // 파일의 점수 읽어들여서 list에 저장
		int i, k = 0;
		String[] file_score = new String[3];
		
		try {
			inputStream = new Scanner(new File(fileName));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file "+fileName);
		}
		
		while(inputStream.hasNextLine()) {
			i = 0;
			String line = inputStream.nextLine();
			while(i < 3) {
				file_score = line.split("                    ");
				i++;
			}
			score_list[k++] = Integer.parseInt(file_score[2]);
		}
		index = k;
		inputStream.close();
		
		
	}
	public void arrange_score() { // list 정렬
		int i, j,temp;
		
		for(i = 0; i < index; i++) {
			for(j = 0; j < index; j++) {
				if(score_list[i] > score_list[j]) {
					temp = score_list[i];
					score_list[i] = score_list[j];
					score_list[j] = temp;
				}
			}
		}
	}
	
	public String get_grade(int score) { // 점수에 따른 grade 부여
		if(score >= 10000) {
			return "A+";
		}
		else if (score >= 9000) {
			return "A";
		}
		else if (score >= 8000) {
			return "B";
		}
		else if (score >= 7000) {
			return "C";
		}
		else if (score >= 6000) {
			return "D";
		}
		else {
			return "F";
		}
	}
	
	public String[] get_score() { // 순위 그레이드 스코어를 파일에서 읽어서 배열에 저장 후 리턴
		String line[] = new String[10];
		int i = 0;
		try {
			inputStream = new Scanner(new File(fileName));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file "+fileName);
		}
		
		while(inputStream.hasNextLine()) {
			line[i] = inputStream.nextLine();
			i++;
			
		}
		inputStream.close();
		return line;
		
		
	}
	
	public void delete_all_score() { // 파일 내용 초기화
		try {
			outputStream = new PrintWriter(fileName);
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
		}
		
		outputStream.close();
	}
}
