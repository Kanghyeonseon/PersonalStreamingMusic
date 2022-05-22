package KHS.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class PlayMusic extends Thread{
		private Player player; //jlayer 라이브러리 중 하나
		private boolean isLoop; //현재 곡이 무한반복인가요?
		private File file;
		private FileInputStream fis;
		private BufferedInputStream bis;
		
		public PlayMusic (String name, boolean isLoop) {
			try {
				this.isLoop = isLoop;
				file = new File(KHS.main.Main.class.getResource("../music/" + name).toURI()); //toURI로 해당파일의 위치를 가져온다.
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis); //버퍼에 파일을 담아서 불러온다.
				player = new Player(bis); //플레이어는 해당 파일을 담아올 수 있도록 해준다.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public int getTime() {
					//현재재생중인 음악이 어떤 위치에 실행되고 있는지를 알려주는 메소드
			if(player == null) {
				return 0;
			}	return player.getPosition();
		}
		
		public void close() {
					//음악이 언제 실행되고 있던간에 종료할 수 있게 해주는 메소드
			isLoop = false;
			player.close();
			this.interrupt(); //곡을실행하는 스레드를 종료한다.
		}
		@Override
		public void run() { //쓰레드를 상속받으면 무조건 사용해야하는 함수
			try {
				do {
					player.play();
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					player = new Player(bis);
				} while(isLoop);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
