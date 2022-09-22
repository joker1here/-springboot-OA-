package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.CarApplicationDao;
import com.ssmp.pojo.CarApplication;
import com.ssmp.service.ICarApplicationService;
import org.springframework.stereotype.Service;

@Service
public class CarApplicationServiceImpl extends ServiceImpl<CarApplicationDao, CarApplication> implements ICarApplicationService {
}
