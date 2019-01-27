package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // -> 스프링의 빈으로 인식되기 위한 설정
@Aspect    // -> 해당 클래스는 AOP 기능을 하는 클래스라고 지정
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	// "@Before" -> 해당 메서드를 실행 후 target메서드 (괄호 속 조건에 부합하는 메서드) 실행
				// 여기는 "org.zerock.service.MessageService"로 시작하는 모든 클래스의 모든 메서드가 target이다!
	@Before("execution(* org.zerock.service.MessageService*.*(..))") // "execution" -> Pointcut 지정, AspectJ 언어의 문법 사용
	public void startLog() {
		logger.info("---------------------------------------------");
		logger.info("---------------------------------------------");
	}
}