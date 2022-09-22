package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.CarDao;
import com.ssmp.pojo.Car;
import com.ssmp.service.ICarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements ICarService {
}
