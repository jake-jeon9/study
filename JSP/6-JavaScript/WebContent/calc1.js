var calc = {
	x : 0,
	y : 0,
	setValue : function(p1, p2) {
		this.x = p1;
		this.y = p2;
	},
	plus : function() {
		return this.x + this.y;
	},
	minus : function() {
		return this.x - this.y;
	},
	result : function() {
		// 메소드안에서 같은 객체안의 다른 메소드를 호출하는 경우에도 "this."을 사용해야함
		// => 메소드 : 객체안에 있는 함수를 나타냄
		var value1 = this.plus();
		var value2 = this.minus();
		document.write("<p>calc1 객체</p>");
		document.write("<p>덧셈결과 : " + value1 + "</p>");
		document.write("<p>뺄셈결과 : " + value2 + "</p>");
	}
}



