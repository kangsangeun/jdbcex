package org.zerock.jdbcex.domain;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
//@Setter VO의 경우 getter만을 이용해서 읽기 전용으로 구성(필수는 아님)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder //생성자와 new 연산자를 사용한 객체 생성 코드를 간편하게 대체
public class TodoVO {

    private  Long tno;
    private  String title;
    private  LocalDate dueDate;
    private  boolean finished;



}
