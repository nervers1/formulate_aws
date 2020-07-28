package kr.or.formulate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Mapper
public interface MainMapper {
    LocalDateTime current();
}
