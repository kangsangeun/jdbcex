package org.zerock.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @Test
    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
        System.out.println("TodoDao 객체 생성");
    }

    @Test
    public void testTime() throws Exception{
        System.out.println("todoDAO객체의 getTime() 메서드 실행 : " + todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        //주로 테스트 용도로 임의의 데이터를 객체에 넣어 데이터를 만들어주는(builder) 어노테이션
        //TodoVO 클래스의 빌더 패턴을 사용하여 TodoVO 인스턴스를 생성
        //TodoVO.builder()를 호출하여 빌더 객체를 얻은 후
        //마지막에 build() 메서드를 호출하여 최종적인 TodoVO 객체를 생성
        TodoVO vo = TodoVO.builder().title("제목테스트1").dueDate(LocalDate.of(2023,11,10)).build();

        todoDAO.insert(vo);
    }


    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach((vo)->{System.out.println(vo);});
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 3L; //반드시 존재하는 번호를 이용 (3L의 L은 long 타입)
        TodoVO vo = todoDAO.selectOne(tno);

        System.out.println("해당 글 번호 조회한 결과 : " +vo);
    }


    @Test
    public void testDeleteOne() throws  Exception {

    }
    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO= TodoVO.builder()
                .tno(3L)
                .title("todo 프로젝트 DB세팅 3일차")
                .dueDate(LocalDate.of(2023,11,10))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }

}
