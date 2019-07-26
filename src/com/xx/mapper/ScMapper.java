package com.xx.mapper;

import com.xx.entity.Grade;
import com.xx.entity.Sc;
import com.xx.entity.ScExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScMapper {
    int countByExample(ScExample example);

    int deleteByExample(ScExample example);

    int insert(Sc record);

    int insertSelective(Sc record);

    List<Sc> selectByExample(ScExample example);

    int updateByExampleSelective(@Param("record") Sc record, @Param("example") ScExample example);

    int updateByExample(@Param("record") Sc record, @Param("example") ScExample example);

    List<Grade> selectScBySnum(String snum);
}