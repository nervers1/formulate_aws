package kr.or.formulate.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface MainMapper {
    LocalDateTime current();
}
