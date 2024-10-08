package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class SungJukImpl implements SungJuk {
	//생성된 빈들 중에서 SungJukDTO를 찾아서 자동으로 매핑해라.
	//생성자인건 Setter이건 상관없이 SungJukDTO를 찾아서 자동으로 매핑해라.
	@Autowired
	private SungJukDTO sungJukDTO = null;
		
	/*필요없다.
	public SungJukImpl(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	*/
	
	@Override
    public void calcTot() {
        int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
        sungJukDTO.setTot(tot);
    }

	@Override
    public void calcAvg() {
        double avg = sungJukDTO.getTot() / 3.0;
        sungJukDTO.setAvg(avg);
    }

	@Override
    public void display() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println(sungJukDTO);
    }

	@Override
	public void modify() {
        Scanner scan = new Scanner(System.in);

        System.out.print("이름 입력: ");
        sungJukDTO.setName(scan.next());

        System.out.print("국어 입력: ");
        sungJukDTO.setKor(scan.nextInt());

        System.out.print("영어 입력: ");
        sungJukDTO.setEng(scan.nextInt());

        System.out.print("수학 입력: ");
        sungJukDTO.setMath(scan.nextInt());

        calcTot();
        calcAvg();
        display();
    }
}
