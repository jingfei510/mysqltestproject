package com.xx.service.impl;

import com.xx.entity.Grade;
import com.xx.entity.Sc;
import com.xx.mapper.ScMapper;
import com.xx.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ScServiceImpl implements ScService {
@Autowired
    ScMapper scMapper;

    @Override
    public List<Grade> selectScBySnum(String snum) {
        return scMapper.selectScBySnum(snum);
    }
}
