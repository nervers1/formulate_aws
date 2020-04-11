package kr.or.formulate.repository;

import kr.or.formulate.mapper.MainMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MainServiceImpl implements MainService {

    private final MainMapper mapper;

    public MainServiceImpl(MainMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public LocalDateTime getCurrent() {
        return mapper.current();
    }

}
