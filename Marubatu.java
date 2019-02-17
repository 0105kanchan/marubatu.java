package marubatu2;
import java.util.Scanner;

public class Marubatu{

public static void main(String[] args) {

	String[][] cell = new String [3][3];

	for(int y=0;y<3;y++) {
		for(int x=0;x<3;x++) {
			cell[x][y]= " ";
		}
	}
	for(int j=0;j<3;j++) {
		for(int i=0;i<3;i++) {
			System.out.print(cell[i][j]);
			if(i!=2) {
				System.out.print("|");
			}
		}
		System.out.println(" ");
	}

	boolean repeat = true;
	int m=0;
	System.out.println("丸ばつゲームを始めます。");
	System.out.println("横軸は左から右に0,1,2、縦軸は上から下に0,1,2となってます。 ");
	System.out.println("０〜２の整数を２回入力してもらいます。");

	while(repeat) {
		String a;
		if(m%2==0) {
			a="○";
		}else {
			a="✖︎";
		}
		System.out.println(a+"の番です。");
		Scanner scanner = new Scanner(System.in);
		System.out.println("横軸の数字0~2を入力してください。");
		int number1 = scanner.nextInt();
		if(number1<0 | number1>2) {
			System.out.println("横軸の数字0~2を入力してくださいね。やり直し！");
			continue;
		}
		System.out.println("縦軸の数字0~2を入力してください。");
		int number2 = scanner.nextInt();
		if(number2<0 | number2>2) {
			System.out.println("縦軸の数字0~2を入力してくださいね。やり直し！");
			continue;
		}
		if(cell[number1][number2] != " ") {
			System.out.println("そこはすでにOかXがつけられています。違うところを選択して下さい。︎︎やり直し！");
			continue;
		}
		cell[number1][number2] = a;

		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				System.out.print(cell[i][j]);
				if(i==2) {
					continue;
				}
				System.out.print("|");
			}
			System.out.println(" ");
		}

		if( (cell[0][0] == a && cell[0][1] == a && cell[0][2] == a ) |
			(cell[1][0] == a && cell[1][1] == a && cell[1][2] == a ) |
			(cell[2][0] == a && cell[2][1] == a && cell[2][2] == a ) ){
			System.out.println(a+"の勝利！");
			break;
		}
		if( (cell[0][0] == a && cell[1][0] == a && cell[2][0] == a ) |
			(cell[0][1] == a && cell[1][1] == a && cell[2][1] == a ) |
			(cell[0][2] == a && cell[1][2] == a && cell[2][2] == a ) ){
			System.out.println(a+"の勝利！");
			break;
			}
		if((cell[0][0] == a && cell[1][1] == a && cell[2][2] == a) |
			(cell[2][0] == a && cell[1][1] == a && cell[0][2] == a)) {
			System.out.println(a+"の勝利！");
			break;
		}
		repeat = false;
		for(int j=0;j<3;j++) {
			for(int i=0;i<3;i++) {
				if(cell[i][j]==" ") {
					repeat = true;
				}
			}
		}
		if(!repeat){
			System.out.println("引き分け！");
		}
		m++;
	}
	}
}
