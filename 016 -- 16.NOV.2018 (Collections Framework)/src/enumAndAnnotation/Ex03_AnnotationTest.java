package enumAndAnnotation;
@interface MyAnno {
	int value();
	int count() default 1;	
}

//@MyAnno --> 요소의 기본값을 제공하지 않았기에 에러
//@MyAnno(count=1) // MyAnno 애너테이션 정의할 때 count()에게 기본값을 제시하지 않았기에 에러
				   // 애너테이션 정의에서 "int count() default 1;"라고 기본값을 제시했기에 "@MyAnno"만 써도 된다.
// 특별하게 메서드 이름이 value이고, 요소가 value 하나이거나 다른 요소는 있어도 default값이 정의되어 있다면, @MyAnno(1)는 @MyAnno(value=1)과 동일
@MyAnno(5) // @MyAnno(value=5)와 같다.
class Ex03_AnnotationTest {

}
