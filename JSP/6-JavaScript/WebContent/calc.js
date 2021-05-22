// 빈 객체 선언
// => var 객체명 = {}
var calc = {};
// 멤버변수 추가
// => 객체명.변수명 = 데이터
calc.x = 0;
calc.y = 0;

// 멤버함수 추가
// => 객체명.함수명 = function() {
//		  명령문;
//    }
calc.setValue = function(p1, p2) {
	this.x = p1;
	this.y = p2;
}
calc.plus = function() {
	return this.x + this.y;
}
calc.minus = function() {
	return this.x - this.y;
}
calc.result = function() {
	// 메소드안에서 같은 객체안의 다른 메소드를 호출하는 경우에도 "this."을 사용해야함
	// => 메소드 : 객체안에 있는 함수를 나타냄
	var value1 = this.plus();
	var value2 = this.minus();
	document.write("<p>덧셈결과 : " + value1 + "</p>");
	document.write("<p>뺄셈결과 : " + value2 + "</p>");
}










