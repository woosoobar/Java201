package etc;

public class BookMark {

	// jQuery에서의 Deferred와 Promise 
	private String bm1 = "http://blog.naver.com/PostView.nhn?blogId=sef16&logNo=70167177129";
	
	// ANSI
	
	
	//STS 에서 gradle build 오류 처리. (JAVA_HOME 어쩌고저쩌고)
	private String gberr = "http://blog.naver.com/mudice/220091870632";
	
	private String mime = "http://www.emh.co.kr/content.pl?mime";

	/*
	1. jQuery 1.5 이전에는
	$.ajax({
		url : ~~~,
		success : mySucc,
		error : myErr
	});
	이렇게 썼다. ( $.ajax 는 XmlHttpRequest 객체를 리턴한다. )

	1.5 이후는 CommonJS Promise/A 인터페이스를 따르는 객체를 리턴한다.

	Deferred 와 Promise 와는 어떻게 다른가
	Promise 는 비동기함수가 리턴한 객체인데 이런 비동기 함수를 내가 만들어 사용한다면 이때 Deferred를 
	사용하게 되는 것이다.

	deferred는 promise 객체와 같은 일을 할 수 있으며 추가적으로 2개의 함수를 더 갖는다.
	resolve, reject ( done(), fail()을 trigger하기 위한 함수 )
	resolve() : done() 에 등록한 함수를 실행하기 위한 함수. 결과가 성공일 때 호출
	reject() : fail() 에 등록한 함수를 실행하기 위한 함수
	이 2개의 함수에 파라미터를 주면 done, fail에 각각 전달된다.

	promise객체에는 resolve(), reject()가 없다.
	promise객체에 resolve()와 reject()가 없는 것은 실제 비동기함수가 수행을 완료하지 않았는데도 
	promise의 resolve나 reject를 통해 콜백이 미리 수행돼 버리는 상황을 막기 위해서이다.
	*/
	
	// 부동산
	private String transferOwnershipSelf1  = "http://cafe.naver.com/wecando7/69449";
	private String transferOwnershipSelf2  = "http://blog.naver.com/9758887/220476433420";
	
}
