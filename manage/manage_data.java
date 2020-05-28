package manage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/* �� ������ ������ ������ ���Ͽ� �����ϱ������ ��ƾ (���� ���������� �ݺ�)
 * 1. read_score() �Լ��� ȣ���Ͽ� ���� ���Ͽ� �ִ� ������� ����Ʈ�� ����
 * 2. store_list() �Լ��� ȣ���Ͽ� ���ο� ������ ����Ʈ�� ����
 * 3. arrage_score() �Լ��� ȣ���Ͽ� ������ ����ִ� ����Ʈ�� ������������ ����
 * 4. store_score() �Լ��� ���� ����Ʈ�� �ִ� �������� ���Ͽ� ����
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
	
	public void store_list(int score) { // ����Ʈ�� ���� ���� �ִ� 10��
		
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
	
	
	public void store_score() { // ���Ͽ� ���� ����
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
	
	public void read_score( ) { // ������ ���� �о�鿩�� list�� ����
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
	public void arrange_score() { // list ����
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
	
	public String get_grade(int score) { // ������ ���� grade �ο�
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
	
	public String[] get_score() { // ���� �׷��̵� ���ھ ���Ͽ��� �о �迭�� ���� �� ����
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
	
	public void delete_all_score() { // ���� ���� �ʱ�ȭ
		try {
			outputStream = new PrintWriter(fileName);
		}
		
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
		}
		
		outputStream.close();
	}
}
