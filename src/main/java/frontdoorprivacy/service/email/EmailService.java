package frontdoorprivacy.service.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final String emailaddress = "@naver.com"; //본인 이메일 입력

    public String mailCheck(String email){
        Random random = new Random(); //난수 생성
        String key=""; // 인증번호

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(emailaddress);

        for(int i = 0;i<3;i++){
            int index = random.nextInt(25)+65;

            key+=(char)index;
        }
        int numIndex = random.nextInt(9999)+1000;

        key +=numIndex;
        message.setSubject("인증번호 입력을 위한 메일 전송");
        message.setText("인증 번호 : " + key);

        javaMailSender.send(message);
        return key;
    }
    public String newPasswd(String email){
        String newpasswd= getRamdomPassword(12);
        
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(emailaddress);
        
        message.setSubject("문앞에: 임시 비밀번호 전송");
        message.setText("임시 비밀번호 : " + newpasswd);
        javaMailSender.send(message);
        return newpasswd;
    }
    public String getRamdomPassword(int size) {
        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '!', '@', '#', '$', '%', '^', '&' };

        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        int idx = 0;
        int len = charSet.length;
        for (int i=0; i<size; i++) {
            // idx = (int) (len * Math.random());
            idx = sr.nextInt(len);    // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.
            sb.append(charSet[idx]);
        }

        return sb.toString();
    }

}
