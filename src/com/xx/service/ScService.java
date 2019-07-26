package com.xx.service;

import com.xx.entity.Grade;
import com.xx.entity.Sc;
import com.xx.mapper.ScMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScService {

    List<Grade> selectScBySnum(String snum);
}
