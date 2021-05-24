package com.example.a9_patterncheckerexam.helper;

import java.util.regex.Pattern;

public class Regexhelper {
    //싱글톤 패턴 시작
    private static Regexhelper instance = null;

    public static Regexhelper getInstance() {
        if (instance == null) instance = new Regexhelper();

        return instance;
    }

    //생성자를 private으로 지정하면, new에 의한 객체 생성이 불가능하다.
    private Regexhelper() {

    }
    //싱글톤 패턴 종료

    //주어진 문자열이 공백이거나 null인지 검사
    public boolean isValue(String str) {
        boolean result = false;
        if (str != null) {
            result = !str.trim().equals("");
        }
        return result;
    }

    //숫자 모양에 대한 형식 검사
    public boolean isNumber(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[0-9]*$", str);

        }
        return result;
    }

    //영문만으로 구성되어 있는지에 대한 형식 검사
    public boolean isEng(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[a-zA-Z]*$", str);

        }
        return result;
    }

    //힌글로만 구성되어 있는지에 대한 형식 검사
    public boolean isKor(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", str);
        }
        return result;
    }
    //영어와 숫자로 된 형식검사
    public boolean isEngAndNumber(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[a-zA-Z0-9]*$", str);
        }
        return result;
    }
    //한글과 숫자로 된 형식 검사
    public boolean isKorAndNumber(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str);
        }
        return result;
    }

    //이메일 형식검사
    public boolean isEmail(String str) {
        boolean result = false;
        if (isValue(str)) {
            //result = Pattern.matches("^[0-9a-zA-z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str);
            result = str.matches("^[0-9a-zA-z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
        }
        return result;
    }
    //핸드폰번호인지 형식검사
    public boolean isPhone(String str) {
        boolean result = false;
        if (isValue(str)) {
            result = Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
        }
        return result;
    }
}
