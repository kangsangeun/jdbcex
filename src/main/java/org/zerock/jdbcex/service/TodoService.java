package org.zerock.jdbcex.service;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public enum TodoService {

    INSTANCE; //

    private TodoDAO dao;
    private ModelMapper modelMapper;


    TodoService() {
        dao = new TodoDAO();
        modelMapper= MapperUtil.INSTANCE.get();
    }

    //새로운 TodoDTO를 등록하는 기능
    public void register(TodoDTO todoDTO) throws Exception{
        //map() 괄호안에 object와 class 타입을 입력
        //DTO -> VO로 변환
       TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info("DTO에서 변환된 VO: " + todoVO);

        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll()throws Exception {

        List<TodoVO> voList = dao.selectAll();

        log.info("voList.................");
        log.info("서비스층에서의 voList 객체: " +voList);
        //DTO로 변환
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());
        //DTO 목록 반환
        return dtoList;
    }

    public TodoDTO get(long tno)throws Exception {

        log.info("tno: " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void remove(Long tno)throws Exception {

        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO)throws Exception {

//        log.info("todoDTO: " + todoDTO );

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);

    }
}
