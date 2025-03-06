package ch10;

import java.util.Scanner;

public class ch06ex {

	//5개의 정수값을 입력받아 int형 배열에 저장하고
		//최대값,최소값,전체합을 출력합니다.
		
		//5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
		//각 학생의 국영수 점수의 합/평균 구하고
		//각 과목당 합 /평균 구해보세요
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int score[][] = new int[5][3];
			
			for(int i=0;i<score.length;i++) {
				System.out.printf("%d 번째 학생 국영수 입력 : ",i+1);
				score[i][0] = sc.nextInt(); //i번째학생의 국어점수입력
				score[i][1] = sc.nextInt(); //i번째학생의 영어점수입력
				score[i][2] = sc.nextInt(); //i번째학생의 수학점수입력
			}
			
			//학생별 점수 총점 / 평균
			for(int i=0;i<score.length;i++) {
				int sum = score[i][0] +score[i][1]+score[i][2];
				double avg = (double)sum/3;
				System.out.printf("%d 번째 학생 총점 : %d 평균 : %f\n",i+1,sum,avg);
			}
			
			//과목별 점수 총점 / 평균
			int subject_sum[] = new int[3];
			for(int i=0;i<score[i].length;i++) //국어 , 영어 , 수학 
			{	
				for(int j=0;j<score.length;j++) {			
					subject_sum[i] +=score[j][i];	
				}
			}
			System.out.printf("국어 총점 : %d 국어 평균 : %f\n",subject_sum[0],(double)subject_sum[0]/score.length);
			System.out.printf("영어 총점 : %d 영어 평균 : %f\n",subject_sum[0],(double)subject_sum[1]/score.length);
			System.out.printf("수학 총점 : %d 수학 평균 : %f\n",subject_sum[0],(double)subject_sum[2]/score.length);
			
		}
}
